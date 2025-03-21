package com.lhvsofteng.java.sandbox.sortalgorithm;

public class MergeSort2 {
  public static void main(String[] args) {
    int[] nums1 = new int[] {4, 3, 6, 0, 0, 0};
    int[] nums2 = new int[] {2, 1, 10};

    merge(nums1, 3, nums2, 3);

    for (int i : nums1) System.out.print(i + " ");
    System.out.println();
  }

  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }

    int endIdx = nums1.length - 1;

    while (n > 0 && m > 0) {
      if (nums2[n - 1] >= nums1[m - 1]) {
        nums1[endIdx] = nums2[n - 1];
        n--;
      } else {
        nums1[endIdx] = nums1[m - 1];
        m--;
      }
      endIdx--;
    }

    while (n > 0) {
      nums1[endIdx] = nums2[n - 1];
      n--;
      endIdx--;
    }

    // for (int i = m, j = 0; i < nums1.length; i++, j++) {
    //     nums1[i] = nums2[j];
    // }

    // for (int i = 0; i < nums1.length; i++) {
    //     for (int j = 0; j < nums1.length; j++) {
    //         if (nums1[i] <= nums1[j]) {
    //             int tmp = nums1[j];
    //             nums1[j] = nums1[i];
    //             nums1[i] = tmp;
    //         }
    //     }
    // }
  }
}
