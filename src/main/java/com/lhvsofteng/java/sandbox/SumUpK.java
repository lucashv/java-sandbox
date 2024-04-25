package com.lhvsofteng.java.sandbox;

public class SumUpK {
    public static void main(String[] args) {
        System.out.println("Hello...");
        System.out.println("Does it add up to K? { 10, 15, 3, 7 } :" + addUpToK(new int[] { 10, 15, 3, 7 }, 17));
        System.out.println("Does it add up to K? { 3, 5, 10, 45 } :" + addUpToK(new int[] { 3, 5, 10, 45 }, 7));
        System.out.println("Does it add up to K? { 3, 5, 10, 45 } :" + addUpToK(new int[] { 6, 5, 10, 45 }, 7));
    }

    public static boolean addUpToK(int[] ints, int k) {
        if (ints.length == 0) {
            return false;
        }

        for (int i = 0; i < ints.length; i++) {
            int curr = ints[i];
            for (int j = 0; j < ints.length; j++) {
                if (i != j && curr + ints[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean addUpToKWithDP(int[] ints, int k) {
        if (ints.length == 0) {
            return false;
        }

        for (int i = 0; i < ints.length; i++) {
            int curr = ints[i];
            for (int j = 0; j < ints.length; j++) {
                if (i != j && curr + ints[j] == k) {
                    return true;
                }
            }
        }

        return false;
    }
}
