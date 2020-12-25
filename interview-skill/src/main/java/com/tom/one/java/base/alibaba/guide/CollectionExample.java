package com.tom.one.java.base.alibaba.guide;







import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 功能描述
 *
 * @author TomLuo
 * @date 2020/12/5
 */
public class CollectionExample {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>(16);
        if(map.isEmpty()) {
            System.out.println("no element in this map.");
        }
        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
        pairArrayList.add(new Pair<>("version", 12.10));
        pairArrayList.add(new Pair<>("version", 12.19));
        pairArrayList.add(new Pair<>("version", 6.28));
        Map<String, Double> map2 = pairArrayList.stream().collect(
// 生成的 map 集合中只有一个键值对：{version=6.28}
                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));

        //反例：
        String[] departments = new String[] {"iERP", "iERP", "EIBU"};
// 抛出 IllegalStateException 异常
        Map<Integer, String> map3 = Arrays.stream(departments)
                .collect(Collectors.toMap(String::hashCode, str -> str));
    }
}
