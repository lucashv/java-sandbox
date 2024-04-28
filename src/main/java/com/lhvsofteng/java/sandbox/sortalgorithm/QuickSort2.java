package com.lhvsofteng.java.sandbox.sortalgorithm;

import static java.lang.System.arraycopy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort2 {
    public static void main(String[] args) {
        int[] arr = new int[] { 23, 45, 65, 6, 0, 0, 3, 2, 7, 19, 10 };
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

        // Get any value to be the pivot value
        int pivot = arr[0];
        // Declare 2 other arrays of the same size of original array to comport the lesser than and greater than pivot values
        int[] arrLeft = new int[arr.length];
        int[] arrRight = new int[arr.length];

        // Just keep the real size of the arrLeft and arrRight
        int arrLeftSize = 0;
        int arrRightSize = 0;

        // Now, we pass through arr checking for the vales lesser than pivot and greater than pivot values and adding
        // them into arrLeft and arrRight respectively
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= pivot) {
                arrLeft[arrLeftSize++] = arr[i];
            } else {
                arrRight[arrRightSize++] = arr[i];
            }
        }

        // Here we truncate arrLeft and arrRight just keep the values we're interested
        arrLeft = arrayTrunc(arrLeft, 0, arrLeftSize);
        arrRight = arrayTrunc(arrRight, 0, arrRightSize);

        // And now we do a quicksort on arrLeft and arrRight too
        int[] qSortedArrayLeft = quicksort(arrLeft);
        int[] qSortedArrayRight = quicksort(arrRight);

        // Now, we put all of them together to return the sorted array
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
