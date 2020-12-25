package com.tom.one.java.base.alibaba.guide;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class CollectionExampleTest {
    @Before
    public void setUp() throws Exception {

    }

    /**
     * 【强制】在无泛型限制定义的集合赋值给泛型限制的集合时，在使用集合元素时，需要进行
     * instanceof 判断，避免抛出 ClassCastException 异常。
     * 说明：毕竟泛型是在 JDK5 后才出现，考虑到向前兼容，编译器是允许非泛型集合与泛型集合互相赋值。
     *
     * @throws Exception
     */
    @Test(expected = ClassCastException.class)
    public void test() throws Exception {
        List<String> generics = null;
        List notGenerics = new ArrayList(10);
        notGenerics.add(new Object());
        notGenerics.add(new Integer(1));
        generics = notGenerics;
        // 此处抛出 ClassCastException 异常
        String string = generics.get(0);
    }

    /**
     * 强制】使用工具类 Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
     * 它的 add/remove/clear 方法会抛出 UnsupportedOperationException 异常。
     * 说明：asList 的返回对象是一个 Arrays 内部类，并没有实现集合的修改方法。Arrays.asList 体现的是适配
     * 器模式，只是转换接口，后台的数据仍是数组。
     *
     * @throws Exception
     */
    @Test(expected = UnsupportedOperationException.class)
    public void testArrays() throws Exception {
        String[] str = new String[]{"chen", "yang", "hao"};
        List list = Arrays.asList(str);
        str[0] = "change";
        list.add("yangguanbao");
        //第一种情况：list.add("yangguanbao"); 运行时异常。
        //第二种情况：str[0] = "change"; 也会随之修改，反之亦然。
    }

    /**
     * 【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
     * 方式，如果并发操作，需要对 Iterator 对象加锁。
     * 说明：以上代码的执行结果肯定会出乎大家的意料，那么试一下把“1”换成“2”，会是同样的结果吗？
     */
    @Test(expected = ConcurrentModificationException.class)
    public void testFor() throws Exception {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }
        for (String item : list) {
            if ("1".equals(item)) {
                list.remove(item);
            }
        }
    }

    /**
     * 【强制】在 JDK 7 版本及以上， Comparator 实现类要满足如下三个条件，不然 Arrays . sort ，
     * Collections . sort 会抛 IllegalArgumentException 异常。
     * 说明：三个条件如下
     * 1） x，y 的比较结果和 y，x 的比较结果相反。
     * 2） x>y，y>z，则 x>z。
     * 3） x=y，则 x，z 比较结果和 y，z 比较结果相同。
     * @throws Exception
     */
    @Test
    public void testCompare() throws Exception {
        final Comparator<Student> comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId() > o2.getId() ? 1 : -1;
            }
        };
        Student stu1=new Student(1);
        Student stu2=new Student(2);
        Student stu3=new Student(3);
        Student stu4=new Student(2);
        List<Student> list= Lists.newArrayList(stu1,stu2,stu3,stu4);
        Collections.sort(list,comparator);


    }

    /**
     * 【推荐】集合泛型定义时，在 JDK7 及以上，使用 diamond 语法或全省略。
     * 说明：菱形泛型，即 diamond，直接使用<>来指代前边已经指定的类型。
     * 【推荐】集合初始化时，指定集合初始值大小。
     * 说明：HashMap 使用 HashMap(int initialCapacity) 初始化，如果暂时无法确定集合大小，那么指定默
     * 认值（16）即可。
     * 正例：initialCapacity = (需要存储的元素个数 / 负载因子) + 1。注意负载因子（即 loader factor）默认
     * 为 0.75，如果暂时无法确定初始值大小，请设置为 16（即默认值）。
     * 反例： HashMap 需要放置 1024 个元素，由于没有设置容量初始大小，随着元素增加而被迫不断扩容，
     * resize()方法总共会调用 8 次，反复重建哈希表和数据迁移。当放置的集合元素个数达千万级时会影响程序
     * 性能。
     * @throws Exception
     */
    @Test
    public void testHashMap() throws Exception {
        // diamond 方式，即<>
        HashMap<String, String> userCache = new HashMap<>(16);
        // 全省略方式
        ArrayList<User> users = new ArrayList(10);
        System.out.printf("initialCapacity = (需要存储的元素个数 / 负载因子) + 1=%5.2f", (16-1)*0.75);
    }
    /**
     * 【推荐】使用 entrySet 遍历 Map 类集合 KV ，而不是 keySet 方式进行遍历。
     * 说明：keySet 其实是遍历了 2 次，一次是转为 Iterator 对象，另一次是从 hashMap 中取出 key 所对应的
     * value。而 entrySet 只是遍历了一次就把 key 和 value 都放到了 entry 中，效率更高。如果是 JDK8，使用
     * Map.forEach 方法。
     * 正例：values()返回的是 V 值集合，是一个 list 集合对象；keySet()返回的是 K 值集合，是一个 Set 集合对
     * 象；entrySet()返回的是 K-V 值组合集合。
     */
    @Test
    public void testEntrySet() throws Exception {
        Map<String, Integer> map = ImmutableMap.of("key", 1, "key2", 2);
        final Set<Map.Entry<String, Integer>> entries = map.entrySet();
        entries.stream().forEach(v->{
            System.out.println(v.getKey()+":"+v.getValue());
        });
    }

    /**
     * 【推荐】高度注意 Map 类集合 K/V 能不能存储 null 值的情况，如下表格：
     * 集合类  Key  Value  Super  说明
     * Hashtable  不允许为 null  不允许为 null  Dictionary  线程安全
     * ConcurrentHashMap  不允许为 null  不允许为 null  AbstractMap  锁分段技术（JDK8:CAS）
     * TreeMap  不允许为 null  允许为 null  AbstractMap  线程不安全
     * HashMap  允许为 null  允许为 null  AbstractMap  线程不安全
     * 反例：由于 HashMap 的干扰，很多人认为 ConcurrentHashMap 是可以置入 null 值，而事实上，存储 null 值时会抛出 NPE 异常。
     *
     * 【参考】合理利用好集合的有序性(sort)和稳定性(order)，避免集合的无序性(unsort)和不稳
     * 定性(unorder)带来的负面影响。
     * 说明：有序性是指遍历的结果是按某种比较规则依次排列的。稳定性指集合每次遍历的元素次序是一定的。
     * 如：ArrayList 是 order/unsort；HashMap 是 unorder/unsort；TreeSet 是 order/sort。
     * 【参考】利用 Set 元素唯一的特性，可以快速对一个集合进行去重操作，避免使用 List 的
     * contains()进行遍历去重或者判断包含操作。
     * @throws Exception
     */
    @Test(expected = NullPointerException.class)
    public void testMap() throws Exception {
        final Hashtable hashtable = new Hashtable();
        hashtable.put(null,null);
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put(null,null);
        final TreeMap treeMap = new TreeMap<>();
        treeMap.put(null,null);
        final HashMap hashMap = new HashMap<>();
        treeMap.put(null,null);
    }
}