package com.tom.three.refactor;

import com.tom.one.java.base.alibaba.guide.cnt.Man;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * 卫语句、枚举、状态模式、策略+工厂模式
 *
 * @author TomLuo
 * @date 2020/12/6
 */
public class ManyIfElseDemoTest {
    static Map<String, Function<Man, Man>> actionMappings = new HashMap<>(); // 这里泛型 ? 是为方便演示，实际可替换为你需要的类型

    @Before
    public void setUp() throws Exception {
        // When init
        actionMappings.put("UGLY", (someParams) -> {
            System.out.println("本姑娘是外貌协会的资深会员");
            return someParams;
        });
        actionMappings.put("POOR", (someParams) -> {
            System.out.println("贫贱夫妻百事哀");
            return someParams;
        });
        actionMappings.put("BAD_TEMPER", (someParams) -> {
            System.out.println("银河有多远，你就给我滚多远");
            return someParams;
        });

    }

    @Test
    public void findBoyfriend() {
        Man man = new Man();
        man.setBadTemper(true);
// 省略 null 判断
        actionMappings.get(man.isBadTemper()?"BAD_TEMPER":null).apply(man);
        actionMappings.get(man.isUgly()?"UGLY":null).apply(man);
        actionMappings.get(man.isPoor()?"POOR":null).apply(man);
    }
    @Test
    public void findBoyfriend3() {
        Man man = new Man();
        man.setBadTemper(true);
        Optional<Man> strOptional = Optional.of(man);
        strOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Null"));
    }
}