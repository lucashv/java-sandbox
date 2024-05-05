package com.lhvsofteng.java.sandbox;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ProductArray2 {
    public static void main(String[] args) {
        System.out.println("Hello ");
        int[] array = new int[] {1, 2, 3, 4, 5};
        int[] newArray = productArray2(array);
        System.out.println("new Array: " + Arrays.stream(newArray)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));

    }

    public static int[] productArray2(int[] array) {
        int[] newArray = new int[array.length];
        int product = 0;

        for (int value : array) {
            product = (product == 0) ? value : product * value ;
        }

        for (int i = 0; i < array.length; i++)
            newArray[i] = product / array[i];

        return newArray;
    }

    public static int[] productArray(int[] array) {
        int[] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int product = 0;
            for (int j = 0; j < array.length; j++) {
                if (i == j)
                    continue;
                if (product == 0)
                    product = array[j];
                else
                    product *= array[j];
            }
            newArray[i] = product;
        }
        return newArray;
    }
}
