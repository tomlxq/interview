package com.tom.huawei;

public class StringDemo {
    public int findString(String search, String str) {
        int idx = str.lastIndexOf(search);
        if (idx == -1) {
            return idx;
        } else {
            return idx + search.length();
        }
    }

    public int findString2(String search, String str) {
        int fast = str.length() - 1, slow = search.length() - 1;
        while (fast >= 0 && slow >= 0) {
            while (search.charAt(slow) == str.charAt(fast)) {
                if (slow == 0) {
                    return fast;
                }
                slow--;
            }
            fast--;
        }
        return -1;
    }
}
