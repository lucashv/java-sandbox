package com.lhvsofteng.java.sandbox;

public class InverseStringChecker {
  public static void main(String[] args) {
    System.out.println(isInverse("ABC", "CBA"));
    System.out.println(isInverse("ABC", "CBAA"));
    System.out.println(isInverse("ABC", ""));
    System.out.println(isInverse("abacate", "etacaba"));
  }

  public static boolean isInverse(String word1, String word2) {
    if (word1.length() != word2.length()) {
      return false;
    }

    for (int i = 0, j = word2.length() - 1; i < word1.length(); i++, j--) {
      if (word1.charAt(i) != word2.charAt(j)) {
        return false;
      }
    }

    //    int idx1 = 0;
    //    int idx2 = word2.length() - 1;
    //    while (idx1 < word1.length()) {
    //      if (word1.charAt(idx1) != word2.charAt(idx2)) {
    //        return false;
    //      }
    //      idx1++;
    //      idx2--;
    //    }

    return true;
  }
}
