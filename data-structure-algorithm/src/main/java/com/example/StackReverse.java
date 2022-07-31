package com.example;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
public class StackReverse {
    String input;

    public StackReverse(String string) {
        input = string;
    }

    public static void main(String[] args) throws IOException {
        String string;
        while (true) {
            log.info("Please input a clause");
            System.out.flush();
            string = getString();
            if (string.equals("")) {
                break;
            }
            StackReverse stackReverse = new StackReverse(string);
            log.info("{}", stackReverse.reverse());
        }
    }

    private static String getString() throws IOException {
        // Scanner scanner = new Scanner(System.in);
        //return scanner.nextLine();
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);
        return bufferedReader.readLine();
    }

    public String reverse() {
        StackCharDemo demo = new StackCharDemo(input.length());
        for (int i = 0; i < input.length(); i++) {
            demo.push(input.charAt(i));
        }
        StringBuffer sb = new StringBuffer();
        while (!demo.isEmpty()) {
            sb.append(demo.pop());
        }
        return sb.toString();
    }
}
