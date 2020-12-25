package com.tom;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * aaabbbbbccccccccczzzzzzzzz
 * ccccccccc
 */
public class HuaweiMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final String nextLine = in.next();
            final List<char[]> chars = Arrays.asList(nextLine.toCharArray());
            final int length = nextLine.length();
            char preChar = nextLine.charAt(0);
            //计算重复次数

            Map<String, List<String>> map=new HashMap<>();
            for (int i = 0; i < length; i++) {
                char current = nextLine.charAt(i);
                final String key = String.valueOf(current);
                if (i == 0 || current != preChar) {
                    preChar = current;
                    map.put(key, new ArrayList<>(Arrays.asList(key)));
                }else{
                    List<String> strings = map.get(key);
                    strings.add(key);
                    map.put(key, strings);
                }
            }
            //寻找最大的字符串
            final List<Integer> collect = map.values().stream().map(v -> v.size()).collect(Collectors.toList());
            final int sum = collect.stream().mapToInt(v -> v).max().getAsInt();
            System.out.println(sum);
            //比较ASCII码
            List<String> list=new ArrayList<>();
            map.values().stream().filter(v->{return v.size()==sum;}).forEach(value->{
                if(list.isEmpty()) {
                    list.addAll(value);
                }else{
                    if((int)list.get(0).toCharArray()[0]>value.get(0).toCharArray()[0]){
                        list.clear();
                        list.addAll(value);
                    }
                }
            });
            final StringBuffer stringBuffer = new StringBuffer();
            list.forEach(line->{
                stringBuffer.append(line);
            });
            System.out.println(stringBuffer.toString());;
        }

    }
}