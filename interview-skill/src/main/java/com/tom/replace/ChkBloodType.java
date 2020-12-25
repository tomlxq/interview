package com.tom.replace;

/**
 * * O与O	O	A,B,AB
 * * A与O	A,O	B,AB
 * * A与A	A,O	B,AB
 * * A与B	A,B,AB,O	——
 * * A与AB	A,B,AB	O
 * * B与O	B,O	A,AB
 * * B与B	B,O	A,AB
 * * B与AB	A,B,AB	O
 * * AB与O	A,B	O,AB
 * * AB与AB	A,B,AB	O
 *
 * @author TomLuo
 * @date 2020/3/4
 */

import java.util.HashMap;
import java.util.Map;

public class ChkBloodType {

    public String[] chkBlood(String father, String mother) {
        Map<String, String[]> map = new HashMap<>();
        map.put("O_O", new String[]{"O"});
        map.put("A_O", new String[]{"A", "O"});
        map.put("A_A", new String[]{"A", "O"});
        map.put("A_B", new String[]{"A", "AB", "B", "O"});
        map.put("A_AB", new String[]{"A", "AB", "B"});
        map.put("B_O", new String[]{"B", "O"});
        map.put("B_B", new String[]{"B", "O"});
        map.put("B_AB", new String[]{"A", "AB", "B"});
        map.put("AB_O", new String[]{"A", "B"});
        map.put("AB_AB", new String[]{"A", "AB", "B"});
        Map<String, String[]> map2 = new HashMap<>();
        map.forEach((k, v) -> {
            final String[] s = k.split("_");
            map2.put(s[1] + "_" + s[0], v);
        });
        map2.putAll(map);
        String key = father + "_" + mother;
        if (map2.containsKey(key)) {
            return map2.get(key);
        }
        return null;
    }
}
