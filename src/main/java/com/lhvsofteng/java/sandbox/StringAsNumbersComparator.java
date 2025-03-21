package com.lhvsofteng.java.sandbox;

public class StringAsNumbersComparator {
  public static void main(String[] args) {
    System.out.println(isLargerThan2("0", "0"));
    System.out.println(isLargerThan2("1", "0"));
    System.out.println(isLargerThan2("0", "1"));
    System.out.println(isLargerThan2("10", "5"));
    System.out.println(isLargerThan2("5", "15"));
    System.out.println(isLargerThan2("2434", "243"));
  }

  public static boolean isLargerThan2(String a, String b) {
    if (a.length() < b.length()) {
      return false;
    }
    if (a.length() > b.length()) {
      return true;
    }
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) == b.charAt(i)) {
        continue;
      }
      if (a.charAt(i) > b.charAt(i)) {
        return true;
      }
    }

    return false;
  }

  public static boolean isLargerThan(String a, String b) {
    int sumA = 0;
    int sumB = 0;

    for (byte aB : a.getBytes()) {
      sumA += aB;
    }

    for (byte bB : b.getBytes()) {
      sumB += bB;
    }

    return sumA > sumB;
  }
}
