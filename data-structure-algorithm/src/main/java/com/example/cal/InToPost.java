package com.example.cal;

public class InToPost {
    private StackX stackX;
    private String input, output = "";

    public InToPost(String in) {
        stackX = new StackX(in.length());
        this.input = in;
    }

    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            stackX.display("" + ch + " ");

            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '(':
                    stackX.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!stackX.isEmpty()) {
            stackX.display("While ");
            output = output + stackX.pop();
        }
        stackX.display("End ");
        return output;
    }

    private void gotParen(char ch) {
        while (!stackX.isEmpty()) {
            char opTop = stackX.pop();
            if (opTop == '(') {
                break;
            } else {
                output = output + opTop;
            }
        }
    }

    private void gotOper(char ch, int prec1) {
        while (!stackX.isEmpty()) {
            char opTop = stackX.pop();
            if (opTop == '(') {
                stackX.push(opTop);
                break;
            } else {
                int prec2 = opTop == '-' || opTop == '+' ? 1 : 2;
                if (prec2 < prec1) {
                    stackX.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        stackX.push(ch);
    }
}
