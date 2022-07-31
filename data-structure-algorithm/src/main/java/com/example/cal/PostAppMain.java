package com.example.cal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PostAppMain {
    public static void main(String[] args) throws IOException {
        String input;
        int output;
        while (true) {
            System.out.println("Enter infix:");
            System.out.flush();
            input = getString();
            if (input.equals("")) {
                break;
            }
            InToPost inToPost = new InToPost(input);
            String input1 = inToPost.doTrans();
            System.out.println("InToPost is " + input1);
            ParsePost trans = new ParsePost(input1);
            output = trans.doParse();
            System.out.println("ParsePost is " + output);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
