package com.lhvsofteng.java.sandbox;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci2 {
  private Map<Long, Long> memo;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Fibonacci2 fib = new Fibonacci2();

    String term = scanner.next();
    while (!term.equals("exit")) {
      long number = Long.parseLong(term);
      System.out.println("Fibonacci of " + number + " is " + fib.calculateFibonacci(number));
      term = scanner.next();
    }

    System.out.println("Bye Bye!");
  }

  public Fibonacci2() {
    this.memo = new HashMap<>();
  }

  public long calculateFibonacci(long number) {
    if (number == 0) {
      return 0;
    }
    if (number == 1 || number == 2) {
      return 1;
    }

    if (!memo.containsKey(number - 1)) memo.put(number - 1, calculateFibonacci(number - 1));
    if (!memo.containsKey(number - 2)) memo.put(number - 2, calculateFibonacci(number - 2));

    return memo.get(number - 1) + memo.get(number - 2);
  }
}
