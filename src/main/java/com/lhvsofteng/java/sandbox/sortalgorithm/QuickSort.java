package com.lhvsofteng.java.sandbox.sortalgorithm;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[] { 123, 45, 3, 23, 56, 435, 343, 78, 99, 245 };

        QuickSort qs = new QuickSort();
        qs.quickSort(array, 0, array.length - 1);

        System.out.println("array => " +
                Arrays.stream(array)
                        .boxed()
                        .map(Object::toString)
                        .collect(Collectors.joining(", ")));
    }

    public void quickSort(int[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = partition(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int pivotIndex = (startIndex + endIndex) / 2;
        int pivotValue = array[pivotIndex];

        startIndex--;
        endIndex++;

        while (true) {
            do startIndex++; while(array[startIndex] < pivotValue);
            do endIndex--; while(array[endIndex] > pivotValue);

            if (startIndex >= endIndex)
                return endIndex;

            int temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
        }
    }
}
