package com.lhvsofteng.java.sandbox;

public class MissingDigitX {

  public static void main(String[] args) {
    // keep this function call here
    // Scanner s = new Scanner(System.in);
    String[] inputs =
        new String[] {
          "4 - 2 = x",
          "1x0 * 12 = 1200",
          "3x + 12 = 46",
          "x - 20 = 30",
          "24 / 1x = 2",
          "1x * 3 = 30",
          "1x * 2 = 30",
        };

    System.out.println("====");
    for (String s : inputs) {
      var x = MissingDigit(s);
      System.out.println(x);
      System.out.println(s.replace("x", x));
      System.out.println("====");
    }
  }

  public static String MissingDigit(String str) {
    var operation = findOperation(str);
    var terms = findTerms(str);
    var rightSide = findRightSide(str);
    var valueOfX = 0;
    var a = "";

    if (rightSide.contains("x")) {
      a = rightSide;
      valueOfX = executeOperation(terms[0], terms[1], operation);
    }
    if (terms[0].contains("x")) {
      a = terms[0];
      valueOfX = executeOperation(rightSide, terms[1], getOppositeOperation(operation));
    }
    if (terms[1].contains("x")) {
      a = terms[1];
      if (operation.equals("/")) {
        valueOfX = executeOperation(terms[0], rightSide, operation);
      } else {
        valueOfX = executeOperation(rightSide, terms[0], getOppositeOperation(operation));
      }
    }

    return String.valueOf(
        a.length() == 1
            ? valueOfX
            : Character.toString(Integer.toString(valueOfX).charAt(a.indexOf("x"))));
  }

  private static String getOppositeOperation(String operation) {
    return switch (operation) {
      case "*" -> "/";
      case "/" -> "*";
      case "+" -> "-";
      case "-" -> "+";
      default -> throw new RuntimeException("No operation");
    };
  }

  private static int executeOperation(String sterm1, String sterm2, String operation) {
    int term1 = Integer.parseInt(sterm1);
    int term2 = Integer.parseInt(sterm2);
    return switch (operation) {
      case "-" -> term1 - term2;
      case "+" -> term1 + term2;
      case "*" -> term1 * term2;
      case "/" -> term1 / term2;
      default -> throw new RuntimeException("No operation");
    };
  }

  private static String[] findTerms(String str) {
    String[] signs = new String[] {"+", "-", "*", "/"};
    for (String sign : signs) {
      if (str.contains(sign)) {
        String[] terms = str.split("\\" + sign);
        terms[0] = terms[0].trim();
        terms[1] = terms[1].split("=")[0].trim();
        return terms;
      }
    }
    throw new RuntimeException("Math sign is missing in str: " + str);
  }

  private static String findOperation(String str) {
    String[] signs = new String[] {"+", "-", "*", "/"};
    for (String sign : signs) {
      if (str.contains(sign)) {
        return sign;
      }
    }
    throw new RuntimeException("No operation specified in str: " + str);
  }

  private static String findRightSide(String str) {
    return str.split("=")[1].trim();
  }
}
