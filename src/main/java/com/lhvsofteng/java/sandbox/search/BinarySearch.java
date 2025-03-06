package com.lhvsofteng.java.sandbox.search;

public class BinarySearch {

  public static void main(String[] args) {
    int[] ints = new int[] {3, 6, 18, 45, 53, 100, 115, 245, 345, 456, 676};
    long start = 0;

    System.out.println("Binary search ....");
    start = System.currentTimeMillis();
    System.out.println("Found " + binarySearch(ints, 245, 0, ints.length - 1));
    System.out.println("Time taken: " + (System.currentTimeMillis() - start));

    System.out.println("Linear search ....");
    start = System.currentTimeMillis();
    System.out.println("Found " + linearSearch(ints, 245));
    System.out.println("Time taken: " + (System.currentTimeMillis() - start));
  }

  public static boolean linearSearch(int[] ints, int k) {
    for (int i : ints) {
      if (i == k) {
        return true;
      }
    }
    return false;
  }

  public static boolean binarySearch(int[] ints, int k, int low, int high) {
    if (k == ints[0] || k == ints[ints.length - 1]) {
      return true;
    }

    if (low > high) {
      return false;
    }

    int mid = (high - low) / 2;
    // System.err.println("mid = " + mid);

    int pos = mid + low;

    if (k < ints[pos]) {
      return binarySearch(ints, k, low, (high - mid - 1));
    } else if (k > ints[pos]) {
      return binarySearch(ints, k, (low + mid + 1), high);
    } else return k == ints[pos];
  }
}
