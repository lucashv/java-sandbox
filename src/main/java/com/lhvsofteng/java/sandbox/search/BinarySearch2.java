package com.lhvsofteng.java.sandbox.search;

import static java.lang.System.out;
import static java.lang.System.err;

public class BinarySearch2 {
  public static void main(String[] args) {
    int[] input = new int[] {3, 5, 6, 9, 10, 14, 16, 45, 56, 76};
    // out.println("Found? " + binarySearch(input, 90, 0, input.length - 1));
    out.println("Found? " + binarySearch2(input, 6));
  }

  public static int binarySearch2(int[] input, int k) {
    if (input == null || input.length == 0) {
      return -1;
    }

    int low = 0;
    int high = input.length -1;

    while (low < high) {
      int mid = ((high - low) / 2) + low;

      if (k == input[mid]) {
        return mid;
      }

      if (k < input[mid]) {
        low = 0;
        high = mid - 1;
      } else if (k > input[mid]) {
        low = mid + 1;
        high = input.length - 1;
      }
    }

    return -1;
  }

  public static int binarySearch(int[] input, int k, int low, int high) {
    if (input == null || input.length == 0) {
      return -1;
    }

    if (low > high) {
      err.println("low > high = " + low + " - " + high);
      return -1;
    }

    if (low == 0 && high == 0 && k != input[0]) {
      err.println("zero index not found");
      return -1;
    }
    
    int mid = ((high - low) / 2) + low;
    
    err.println("Mid = " + mid);
    if (k == input[mid]) {
      return mid;
    }

    if (k < input[mid]) {
      return binarySearch(input, k, low, mid - 1);
    } else if (k > input[mid]) {
      return binarySearch(input, k, mid + 1, high);
    }
    
    return -1;
  }
}
