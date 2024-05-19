package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для выхода нажать Enter или ввести \"exit\"");
        while (true) {
            String input = scanner.nextLine().replace(" ", "");
            if ("".equals(input) || "exit".equals(input)) {
                return;
            }
            String[] exps = input.split(";");
            List<String> results = new ArrayList<>(exps.length);
            for (String exp : exps) {

            }
        }
    }
}
