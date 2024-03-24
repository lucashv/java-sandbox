package com.lhvsofteng.java.sandbox;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Fibonacci {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(in);
        long time = 0;
        int result = 0;

        out.println("Calculate com.lhvsofteng.java.sandbox.Fibonacci");
        do {
            out.println("Insert a number: ");
            
            int inputNumber = Integer.parseInt(scanner.nextLine());

            // time = System.currentTimeMillis();
            // result = fibonacciRecursive(inputNumber);
            // out.println("com.lhvsofteng.java.sandbox.Fibonacci: " + result);
            // out.println("Recursive Time: " + (System.currentTimeMillis() - time));

            // time = System.currentTimeMillis();
            // result = fibonacciIterative(inputNumber);
            // out.println("com.lhvsofteng.java.sandbox.Fibonacci: " + result);
            // out.println("Iteractive Time: " + (System.currentTimeMillis() - time));

            int[] memo = new int[inputNumber];
            time = System.currentTimeMillis();
            result = fibonacciRecursiveWithMemoaization(inputNumber, memo);
            out.println("com.lhvsofteng.java.sandbox.Fibonacci: " + result);
            out.println("Recursive with Memo Time: " + (System.currentTimeMillis() - time));


            out.println("Digit q+enter para sair ou enter para continuar");
        } while(!scanner.nextLine().equals("q"));

    }

    private static int fibonacciRecursive(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        return fibonacciRecursive(n-2) + fibonacciRecursive(n-1);
    }

    private static int fibonacciRecursiveWithMemoaization(int n, int[] memo) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        if (memo[n - 1] > 0) {
            return memo[n - 1];
        }

        memo[n-3] = fibonacciRecursiveWithMemoaization(n-2, memo);
        memo[n-2] = fibonacciRecursiveWithMemoaization(n-1, memo);

        return memo[n-3] + memo[n-2];
    }

    private static int fibonacciIterative(int n) {
        if (n <= 0) {
            return 0;
        }

        if (n == 1 || n == 2) {
            return 1;
        }

        int a = 1;
        int b = 1;
        int fibonacci = 0;

        for (int i = 3; i <= n; i++) {
            fibonacci = a + b;
            a = b;
            b = fibonacci;
        }

        return fibonacci;
    }
}
