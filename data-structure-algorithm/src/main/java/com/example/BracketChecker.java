package com.example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BracketChecker {
    String str;

    public BracketChecker(String str) {
        this.str = str;
    }

    public void checkBracket() {
        StackCharDemo stackCharDemo = new StackCharDemo(100);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stackCharDemo.push(c);
                    break;
                case '}':
                case ']':
                case ')':
                    if (!stackCharDemo.isEmpty()) {
                        char tmp = stackCharDemo.pop();
                        if (c == '}' && tmp != '{' || c == ')' && tmp != '(' || c == ']' && tmp != '[') {
                            log.info("pos {} char {} not march", i, c);
                            return;
                        }
                    } else {
                        log.info("pos {} char {} not march", i, c);
                        return;
                    }
                default:
                    break;
            }
        }
        if (!stackCharDemo.isEmpty()) {
            log.info("not march");
            return;
        }
        log.info("march");
    }
}
