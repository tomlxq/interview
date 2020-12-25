package com.tom;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            final String nextLine = in.next();
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
            int sum=0;
            int i=0;
            for(Map.Entry<String, List<String>> k:map.entrySet()){
                final List<String> value = k.getValue();
                final int curSize = value.size();
                if(i==0){
                    sum= curSize;
                    i++;
                    continue;
                }else if(sum<curSize){
                    sum=curSize;
                    i++;
                    continue;
                }
            }
            //比较ASCII码
            List<String> list=new ArrayList<>();
            for(Map.Entry<String, List<String>> k:map.entrySet()) {
                final List<String> value = k.getValue();
                if(value.size()==sum){
                    if(list.isEmpty()) {
                        list.addAll(value);
                    }else{
                        if((int)list.get(0).toCharArray()[0]>value.get(0).toCharArray()[0]){
                            list.clear();
                            list.addAll(value);
                        }
                    }
                }
            }
            final StringBuffer stringBuffer = new StringBuffer();
            list.forEach(line->{
                stringBuffer.append(line);
            });
            System.out.println(stringBuffer.toString());;
        }

    }
}