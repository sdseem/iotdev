package org.example;


import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String exp = scanner.nextLine();
                if ("exit".equals(exp) || "".equals(exp)) break;
                System.out.println("Result: " + resolve(exp));
            } catch (Exception e) {
                System.out.println("Invalid expression");
            }
        }
    }

    private static double resolve(String expressionToResolve) {
        Expression expression = new  ExpressionBuilder(expressionToResolve)
                .variable("x").build();
        return expression.setVariable("x", 3.5).evaluate();
    }
}