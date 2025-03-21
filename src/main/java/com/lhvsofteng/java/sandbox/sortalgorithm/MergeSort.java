package com.lhvsofteng.java.sandbox.sortalgorithm;

public class MergeSort {
  public static void main(String[] args) {
    final int size = 15;
    final int threshold = 60;
    int[] ints = new int[size];
    for (int i = 0; i < size; i++) ints[i] = (int) (Math.random() * threshold);

    System.out.println("Unsorted array: ");
    for (int i = 0; i < size; i++) System.out.print(ints[i] + " ");
    System.out.println();

    sort(ints, 0, ints.length - 1);

    System.out.println("Sorted array: ");
    for (int i = 0; i < size; i++) System.out.print(ints[i] + " ");
    System.out.println();
  }

  public static void sort(int[] ints, int low, int high) {
    if (low < high) {
      int middle = (high + low) / 2;
      sort(ints, low, middle);
      sort(ints, middle + 1, high);
      merge(ints, low, middle, high);
    }
  }

  public static void merge(int[] ints, int low, int middle, int high) {
    int n1 = middle - low + 1;
    int n2 = high - middle;

    int[] left = new int[n1];
    int[] right = new int[n2];

    for (int i = 0; i < n1; i++) left[i] = ints[low + i];
    for (int i = 0; i < n2; i++) right[i] = ints[middle + 1 + i];

    int i = 0;
    int j = 0;
    int k = low;

    while (i < n1 && j < n2) {
      if (left[i] <= right[j]) {
        ints[k] = left[i];
        i++;
      } else {
        ints[k] = right[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      ints[k] = left[i];
      i++;
      k++;
    }

    while (j < n2) {
      ints[k] = right[j];
      j++;
      k++;
    }
  }
}
