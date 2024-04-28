package com.lhvsofteng.java.sandbox.sortalgorithm;

import static java.lang.System.arraycopy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = new int[] { 23, 45, 65, 6, 7, 19, 10 };
        QuickSort2 qs2 = new QuickSort2();
        System.out.println("arr => " + Arrays.stream(qs2.quicksort(arr))
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));

    }

    public int[] quicksort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }

        int pivot = arr[0];
        int[] arrLeft = new int[arr.length];
        int[] arrRight = new int[arr.length];

        int arrLeftSize = 0;
        int arrRightSize = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= pivot) {
                arrLeft[arrLeftSize++] = arr[i];
            } else {
                arrRight[arrRightSize++] = arr[i];
            }
        }

        arrLeft = arrayTrunc(arrLeft, 0, arrLeftSize);
        arrRight = arrayTrunc(arrRight, 0, arrRightSize);

        int[] qSortedArrayLeft = quicksort(arrLeft);
        int[] qSortedArrayRight = quicksort(arrRight);

        int[] retArray = new int[arrLeft.length + arrRight.length + 1];

        arraycopy(qSortedArrayLeft, 0, retArray, 0, qSortedArrayLeft.length);
        arraycopy(new int[] { pivot }, 0, retArray, qSortedArrayLeft.length, 1);
        arraycopy(qSortedArrayRight, 0, retArray, qSortedArrayLeft.length + 1, qSortedArrayRight.length);

        return retArray;
    }

    private int[] arrayTrunc(int[] arr, int start, int length) {
        int[] newArr = new int[length];
        for (int i = start, j = 0; i < length; i++) newArr[j++] = arr[i];
        return newArr;
    }
}
