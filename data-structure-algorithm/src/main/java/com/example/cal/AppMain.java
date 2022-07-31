package com.example.cal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppMain {
    public static void main(String[] args) throws IOException {
        String input, output;
        while (true) {
            System.out.println("Enter infix:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            InToPost trans = new InToPost(input);
            output = trans.doTrans();
            System.out.println("PostFix is " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
