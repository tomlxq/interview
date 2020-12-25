package com.tom.one.java.base.alibaba.guide.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 7. 【强制】高并发时，同步调用应该去考量锁的性能损耗。
 * 能用无锁数据结构，就不要用锁 ；
 * 能锁区块，就不要锁整个方法体 ；
 * 能用对象锁，就不要用类锁。
 * 说明：尽可能使加锁的代码块工作量尽可能的小，避免在锁代码块中调用 RPC 方法。
 * 8. 【强制】对多个资源、数据库表、对象同时加锁时，需要保持一致的加锁顺序，否则可能会造
 * 成死锁。
 * 说明：线程一需要对表 A、B、C 依次全部加锁后才可以进行更新操作，那么线程二的加锁顺序也必须是 A、B、C，否则可能出现死锁。
 * 9. 【强制】在使用阻塞等待获取锁的方式中，必须在 try 代码块之外，并且在加锁方法与 try 代
 * 码块之间没有任何可能抛出异常的方法调用，避免加锁成功后，在 finally 中无法解锁。
 * 说明一：如果在 lock 方法与 try 代码块之间的方法调用抛出异常，那么无法解锁，造成其它线程无法成功获取锁。
 * 说明二：如果 lock 方法在 try 代码块之内，可能由于其它方法抛出异常，导致在 finally 代码块中，unlock对未加锁的对象解锁，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），抛出
 * IllegalMonitorStateException 异常。
 * 说明三：在 Lock 对象的 lock 方法实现中可能抛出 unchecked 异常，产生的后果与说明二相同。
 * 正例：
 * Lock lock = new XxxLock();
 * // ...
 * lock.lock();
 * try {
 * doSomething();
 * doOthers();
 * } finally {
 * lock.unlock();
 * }
 * 反例：
 * Lock lock = new XxxLock();
 * // ...
 * try {
 * // 如果此处抛出异常，则直接执行 finally 代码块
 * doSomething();
 * // 无论加锁是否成功，finally 代码块都会执行
 * lock.lock();
 * doOthers();
 * } finally {
 * lock.unlock();
 * }
 * 10. 【强制】在使用尝试机制来获取锁的方式中，进入业务代码块之前，必须先判断当前线程是否
 * 持有锁。锁的释放规则与锁的阻塞等待方式相同。
 * 说明：Lock 对象的 unlock 方法在执行时，它会调用 AQS 的 tryRelease 方法（取决于具体实现类），如果
 * 当前线程不持有锁，则抛出 IllegalMonitorStateException 异常。
 * 正例：
 * Lock lock = new XxxLock();
 * // ...
 * boolean isLocked = lock.tryLock();
 * if (isLocked) {
 * try {
 * doSomething();
 * doOthers();
 * } finally {
 * lock.unlock();
 * }
 * }
 * 11. 【强制】并发修改同一记录时，避免更新丢失，需要加锁。要么在应用层加锁，要么在缓存加
 * 锁，要么在数据库层使用乐观锁，使用 version 作为更新依据。
 * 说明：如果每次访问冲突概率小于 20%，推荐使用乐观锁，否则使用悲观锁。乐观锁的重试次数不得小于
 * 3 次。
 * 12. 【强制】多线程并行处理定时任务时， Timer 运行多个 TimeTask 时，只要其中之一没有捕获抛
 * 出的异常，其它任务便会自动终止运行，使用 ScheduledExecutorService 则没有这个问题。
 * 13. 【推荐】资金相关的金融敏感信息，使用悲观锁策略。
 * 说明：乐观锁在获得锁的同时已经完成了更新操作，校验逻辑容易出现漏洞，另外，乐观锁对冲突的解决策
 * 略有较复杂的要求，处理不当容易造成系统压力或数据异常，所以资金相关的金融敏感信息不建议使用乐观
 * 锁更新。
 * 正例：悲观锁遵循一锁、二判、三更新、四释放的原则。
 * 14. 【推荐】使用 CountDownLatch 进行异步转同步操作，每个线程退出前必须调用 countDown 方
 * 法，线程执行代码注意 catch 异常，确保 countDown 方法被执行到，避免主线程无法执行至
 * await 方法，直到超时才返回结果。
 * 说明：注意，子线程抛出异常堆栈，不能在主线程 try-catch 到。
 * Java 开发手册
 * 20/59
 * 15. 【推荐】避免 Random 实例被多线程使用，虽然共享该实例是线程安全的，但会因竞争同一 seed
 * 导致的性能下降。
 * 说明：Random 实例包括 java.util.Random 的实例或者 Math.random()的方式。
 * 正例：在 JDK7 之后，可以直接使用 API ThreadLocalRandom，而在 JDK7 之前，需要编码保证每个线
 * 程持有一个单独的 Random 实例。
 * 16. 【推荐】通过双重检查锁 （double - checked locking）（ 在并发场景下 ） 存在延迟初始化的优化
 * 问题隐患 （ 可参考  The " Double - Checked Locking is Broken "  Declaration） ，推荐解决方案中较
 * 为简单一种 （ 适用于 JDK 5 及以上版本 ） ，将目标属性声明为  volatile 型，比如将 helper 的属
 * 性声明修改为`private volatile Helper helper = null;` 。
 * 正例：
 * public class LazyInitDemo {
 * private volatile Helper helper = null;
 * public Helper getHelper() {
 * if (helper == null) {
 * synchronized (this) {
 * if (helper == null) { helper = new Helper(); }
 * }
 * }
 * return helper;
 * }
 * // other methods and fields...
 * }
 * 17. 【参考】 volatile 解决多线程内存不可见问题。对于一写多读，是可以解决变量同步问题，但
 * 是如果多写，同样无法解决线程安全问题。
 * 说明：如果是 count++操作，使用如下类实现：AtomicInteger count = new AtomicInteger();
 * count.addAndGet(1); 如果是 JDK8，推荐使用 LongAdder 对象，比 AtomicLong 性能更好（减少乐观
 * 锁的重试次数）。
 * 18. 【参考】HashMap 在容量不够进行 resize 时由于高并发可能出现死链，导致 CPU 飙升，在
 * 开发过程中注意规避此风险。
 * 19. 【参考】ThreadLocal 对象使用 static 修饰，ThreadLocal 无法解决共享对象的更新问题。
 * 说明：这个变量是针对一个线程内所有操作共享的，所以设置为静态变量，所有此类实例共享此静态变量，
 * 也就是说在类第一次被使用时装载，只分配一块存储空间，所有此类的对象(只要是这个线程内定义的)都可
 * 以操控这个变量。
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class LockExample {

}
