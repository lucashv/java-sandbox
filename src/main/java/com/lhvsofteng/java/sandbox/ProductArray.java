package com.lhvsofteng.java.sandbox;

import java.util.Arrays;

// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i of the new array is
// the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our
// input was [3, 2, 1], the expected output would be [2, 3, 6].
// Follow-up: what if you can't use division?
public class ProductArray {
    public static void main(String[] args) {
        System.out.println("Hello");
        System.out.println("Input { 3, 2, 1 }: " +
                Arrays.toString(findProducts2(new int[] { 3, 2, 1 })));
    }

    public static int[] findProducts1(int[] ints) {
        int[] outInts = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (i != j) {
                    if (outInts[i] == 0) {
                        outInts[i] = ints[j];
                    } else {
                        outInts[i] = outInts[i] * ints[j];
                    }
                }
            }
        }

        return outInts;
    }

    public static int[] findProducts2(int[] ints) {
        int[] outInts = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length; j++) {
                if (outInts[i] == 0) {
                    outInts[i] = ints[j];
                } else {
                    outInts[i] *= ints[j];
                }
            }
            outInts[i] /= ints[i];
        }

        return outInts;
    }
}
