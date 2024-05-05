package com.lhvsofteng.java.sandbox.sortalgorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        int[] arr = new int[] { 56, 1, 7, 10, 43, 5, 9, 23 };
        doInsertionSort(arr);
        System.out.println("arr = " + Arrays.stream(arr)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public static void doInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                int temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
                j--;
            }
        }
    }
}
