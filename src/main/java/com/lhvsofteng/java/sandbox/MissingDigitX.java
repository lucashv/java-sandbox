package com.lhvsofteng.java.sandbox;

import java.util.*; 
import java.io.*;

public class MissingDigitX {

  public static String MissingDigit(String str) {
    String operation = findOperation(str);
    String[] terms = findTerms(str);
    String rightSide = findRightSide(str);
    Integer valueOfX = 0;
    String a = "";

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
      valueOfX = executeOperation(rightSide, terms[0], getOppositeOperation(operation));
    }

    String result = String.valueOf(a.length() == 1 ? valueOfX.toString() : valueOfX.toString().charAt(a.indexOf("x")));

    return result;
  }
  
  private static String getOppositeOperation(String operation) {
    if (operation.equals("*")) {
      return "/";
    }
    if (operation.equals("/")) {
      return "*";
    }
    if (operation.equals("+")) {
      return "-";
    }
    if (operation.equals("-")) {
      return "+";
    }
    throw new RuntimeException("No operation");
  }

  private static Integer executeOperation(String sterm1, String sterm2, String operation) {
    Integer term1 = Integer.parseInt(sterm1);
    Integer term2 = Integer.parseInt(sterm2);

    if (operation.equals("-")) {
      return term1 - term2;
    }
    if (operation.equals("+")) {
      return term1 + term2;
    }
    if (operation.equals("*")) {
      return term1 * term2;
    }
    if (operation.equals("/")) {
      return term1 / term2;
    }
    throw new RuntimeException("No operation");
  }

  private static String[] findTerms(String str) {
    String[] signs = new String[] { "+", "-", "*", "/" };
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
    String[] signs = new String[] { "+", "-", "*", "/" };
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

  public static void main (String[] args) {  
    // keep this function call here     
    // Scanner s = new Scanner(System.in);
    String[] inputs = new String[] {
      "4 - 2 = x",
      "1x0 * 12 = 1200",
      "3x + 12 = 46",
      "x - 20 = 30"
    };

    System.out.println("====");
    for (String s : inputs) {
      System.out.println(MissingDigit(s)); 
    }
  }

}