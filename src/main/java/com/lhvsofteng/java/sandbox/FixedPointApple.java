package com.lhvsofteng.java.sandbox;

public class FixedPointApple {
    public static void main(String[] args) {
        int[] arr1 = new int[] { -6, 0, 2, 40 };
        int[] arr2 = new int[] { 1, 5, 7, 8 };

        System.out.println(" arr1 = " + hasFixedPoint(arr1));
        System.out.println(" arr2 = " + hasFixedPoint(arr2));
    }

    private static boolean hasFixedPoint(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                return true;
            }
        }
        return false;
    }
}
