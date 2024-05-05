package com.lhvsofteng.java.sandbox;

import java.util.HashSet;
import java.util.Set;

public class SumUpToK {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        System.out.println("Response: " + doesItSumUpWithSet(new int[] { 10, 15, 3, 7, 45}, 48));
    }

    public static boolean doesItSumUpWithSet(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int value : arr) {
            int diff = k - value;
            if (set.contains(diff))
                return true;
            set.add(value);
        }
        return false;
    }

    public static boolean doesItSumUp(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            int diff = k - arr[i];
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[j] == diff)
                    return true;
            }
        }
        return false;
    }
}
