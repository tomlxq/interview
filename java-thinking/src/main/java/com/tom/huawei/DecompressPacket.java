package com.tom.huawei;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * test
 */
public class DecompressPacket {

    public String func(String line) {
        if (line.equals("") || !line.contains("[")) {
            if (line.equals("]")) {
                return "";
            }
            return line;
        }
        int openIdx = line.indexOf('[');
        int closeIdx = line.indexOf(']');
        int num = Integer.parseInt(line.substring(0, openIdx));
        String str = line.substring(openIdx + 1, closeIdx);
        StringBuffer sb = new StringBuffer();
        if (!str.contains("[")) {
            String collect = IntStream.range(0, num).mapToObj(i -> func(str)).collect(Collectors.joining());
            sb.append(collect);
            sb.append(func(line.substring(closeIdx + 1)));
        } else {
            int len = str.length() - str.replaceAll("\\[", "").length() + 1;
            int lastIdx = closeIdx;
            while (len > 0) {
                if ((lastIdx = line.indexOf(']')) != -1) {
                    len--;
                }
            }
            num = Integer.parseInt(line.substring(0, openIdx));
            String str2 = line.substring(openIdx + 1, lastIdx + 1);
            int k = 0;
            while (Character.isAlphabetic(str2.charAt(k))) {
                k++;
            }
            String preStr = str2.substring(0, k);
            String suffixStr = str2.substring(k);
            String collect = IntStream.range(0, num).mapToObj(i -> preStr + func(suffixStr)).collect(Collectors.joining());
            sb.append(collect);
            sb.append(func(line.substring(closeIdx + 1)));
        }
        return sb.toString();
    }
}
