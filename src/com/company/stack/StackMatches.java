package com.company.stack;

import java.util.Stack;

public class StackMatches {
    public static void main(String[] args) {
        String correct = "()(()){([()])}";
        String correct2 = "((()(()){([()])}))";
        String correct3 = "({})";
        String incorrect = ")(()){([()])}";
        String incorrect2 = "({[])}";
        String incorrect3 = "(";
        String incorrect4 = "({)}";
        System.out.println(isCorrect(correct));
        System.out.println(isCorrect(correct3));
        System.out.println(isCorrect(incorrect4));
    }

    private static boolean isCorrect(String correct) {
        final String opening = "({[";
        final String closing = ")}]";
        Stack<Character> buffer = new Stack<>();
        for (char c : correct.toCharArray()) {
            if (opening.indexOf(c) != -1) {
                buffer.push(c);
            } else if (closing.indexOf(c) != -1) {
                if (buffer.isEmpty())
                    return false;
                if (closing.indexOf(c) != opening.indexOf(buffer.pop()))
                    return false;
            }
        }
        return buffer.isEmpty();
    }
}
