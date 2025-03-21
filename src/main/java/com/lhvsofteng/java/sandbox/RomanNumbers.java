package com.lhvsofteng.java.sandbox;

import java.util.HashMap;
import java.util.Map;

public class RomanNumbers {
  public static void main(String[] args) {
    System.out.println(romanToInt("III"));
    System.out.println(romanToInt("LVIII"));
    System.out.println(romanToInt("MCMXCIV"));
    System.out.println(romanToInt("MDLXX"));
  }

  public static int romanToInt(String s) {
    Map<Integer, Integer> romans = new HashMap<>();
    romans.put((int) 'I', 1);
    romans.put((int) 'V', 5);
    romans.put((int) 'X', 10);
    romans.put((int) 'L', 50);
    romans.put((int) 'C', 100);
    romans.put((int) 'D', 500);
    romans.put((int) 'M', 1000);
    romans.put((int) 'I' + (int) 'V', 4);
    romans.put((int) 'I' + (int) 'X', 9);
    romans.put((int) 'X' + (int) 'L', 40);
    romans.put((int) 'X' + (int) 'C', 90);
    romans.put((int) 'C' + (int) 'D', 400);
    romans.put((int) 'C' + (int) 'M', 900);

    // System.out.println("s.length() - 1 = " + (s.length() - 1));
    int sum = 0;
    for (int i = 0; i < s.length(); ) {
      if (i < s.length() - 1
          && ((s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X'))
              || (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C'))
              || (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')))) {
        // System.out.println("i = " + i + "; i + 1 = " + (i + 1));
        // System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + " = " + romans.get(s.charAt(i)
        // + "" + s.charAt(i + 1)));
        sum += romans.get(s.charAt(i) + s.charAt(i + 1));
        i += 2;
      } else {
        sum += romans.get((int) s.charAt(i));
        i++;
      }
    }

    return sum;
  }
}
