package com.tom.huawei;

import java.util.Scanner;

public class DelLetterGame {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (sc.hasNext()) {
                DelLetterGame dlg = new DelLetterGame();
                System.out.println(dlg.fun(sc.nextLine()));
            }
        }
    }

    public int fun(String input) {
        int i = 0;
        while (i < input.length()) {
            String repeat = input.substring(i, i + 1).concat(input.substring(i, i + 1));
            if (input.contains(repeat)) {
                input = input.replace(repeat, "");
                i = Math.max(0, i - 1);
            } else {
                i++;
            }
        }
        return input.length();
    }
}
