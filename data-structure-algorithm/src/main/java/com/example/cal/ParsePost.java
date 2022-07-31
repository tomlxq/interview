package com.example.cal;

public class ParsePost {
    String input, output;
    private StackY stackY;

    public ParsePost(String input) {
        this.input = input;
    }

    public int doParse() {
        stackY = new StackY(20);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            stackY.display(" " + c + " ");
            if (c >= '0' && c <= '9') {
                stackY.push(c - '0');
            } else {
                int y = stackY.pop();
                int x = stackY.pop();
                int answerRet;
                switch (c) {
                    case '+':
                        answerRet = x + y;
                        break;
                    case '-':
                        answerRet = x - y;
                        break;
                    case '*':
                        answerRet = x * y;
                        break;
                    case '/':
                        answerRet = x / y;
                        break;
                    default:
                        answerRet = 0;
                        break;
                }
                stackY.push(answerRet);
            }
        }
        return stackY.pop();
    }
}
