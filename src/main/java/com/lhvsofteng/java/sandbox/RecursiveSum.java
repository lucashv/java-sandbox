package com.lhvsofteng.java.sandbox;

public class RecursiveSum {
    public static void main(String[] args) {
        int[] a = new int[] { 3, 4, 5, 6, 7 ,9, 2 };
        RecursiveSum rs = new RecursiveSum();
        System.out.println("Resultado: " + rs.sum(a));
    }

    public int sum(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        } else {
            int[] newArr = new int[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--)
                newArr[i - 1] = arr[i];
            return arr[0] + sum(newArr);
        }
    }
}
