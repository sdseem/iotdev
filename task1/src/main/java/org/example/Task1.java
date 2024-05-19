package org.example;

import java.util.Scanner;


public class Task1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода нажать Enter или ввести \"exit\"");
        while (true) {
            String expression = scanner.nextLine().replace(" ", "");
            if ("".equals(expression) || "exit".equals(expression)) {
                return;
            }
            StringBuilder left = new StringBuilder();
            StringBuilder right = new StringBuilder();
            StringBuilder operator = new StringBuilder();
            int i = 0;
            for (; i < expression.length(); ++i) {
                char ch = expression.charAt(i);
                if (ch == '-' || ch == '.' || (ch >= '0' && ch <= '9')) {
                    if (ch == '-' && left.length() > 0) {
                        break;
                    }
                    left.append(ch);
                } else {
                    break;
                }
            }
            for (; i < expression.length(); ++i) {
                char ch = expression.charAt(i);
                if ("-+*/=><!".contains(Character.toString(ch))) {
                    if (ch == '-' && operator.length() > 0) {
                        break;
                    }
                    operator.append(ch);
                } else {
                    break;
                }
            }
            for (; i < expression.length(); ++i) {
                char ch = expression.charAt(i);
                if (ch == '-' || ch == '.' || (ch >= '0' && ch <= '9')) {
                    right.append(ch);
                } else {
                    break;
                }
            }
            double leftNum = Double.parseDouble(left.toString());
            double rightNum = Double.parseDouble(right.toString());
            switch (operator.toString()) {
                case "+" -> System.out.println(leftNum + rightNum);
                case "-" -> System.out.println(leftNum - rightNum);
                case "*" -> System.out.println(leftNum * rightNum);
                case "/" -> System.out.println(leftNum / rightNum);
                case ">" -> System.out.println(leftNum > rightNum);
                case "<" -> System.out.println(leftNum < rightNum);
                case ">=" -> System.out.println(leftNum >= rightNum);
                case "<=" -> System.out.println(leftNum <= rightNum);
                case "==" -> System.out.println(leftNum == rightNum);
            }
        }
    }
}
