package com.tom.one.java.base.alibaba.guide.thread;

/**
 * 【推荐】通过双重检查锁 （double - checked locking）（ 在并发场景下 ） 存在延迟初始化的优化
 * 问题隐患 （ 可参考  The " Double - Checked Locking is Broken "  Declaration） ，推荐解决方案中较
 * 为简单一种 （ 适用于 JDK 5 及以上版本 ） ，将目标属性声明为  volatile 型，比如将 helper 的属
 * 性声明修改为`private volatile Helper helper = null;` 。
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class LazyInitDemo {
    private volatile Helper helper = null;
    public Helper getHelper() {
        if (helper == null) {
            synchronized (this) {
                if (helper == null) { helper = new Helper(); }
            }
        }
        return helper;
    }
// other methods and fields...
}
