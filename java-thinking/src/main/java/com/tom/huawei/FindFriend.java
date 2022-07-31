package com.tom.huawei;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class FindFriend {
    public String findFriend(String line1, String line2) {
        int size = Integer.parseInt(line1);
        List<Integer> list = Arrays.stream(line2.split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        log.info("{}", list);
        List<Integer> friends = new ArrayList<>(size);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) < list.get(j)) {
                    friends.add(j);
                    break;
                }
            }
        }
        while (friends.size() < size) {
            friends.add(0);
        }
        log.info("{}", friends);
        return friends.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
