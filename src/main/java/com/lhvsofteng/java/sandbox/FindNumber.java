package com.lhvsofteng.java.sandbox;

import java.util.Arrays;

public class FindNumber {
    public static void main(String[] a) {
        int[] ints = new int[1000]; // {-9, 14, 37, 102};

        for (int i = 0; i < ints.length; i++) {
            double rand = Math.random();
            double multiplier = rand > 0.5d ? 1.0d : -1.0d;
            ints[i] =  (int) (Math.random() * 1000 * multiplier);
            ///// System.out.print(String.format("i = %d; ", ints[i]));
        }

        //System.out.println();
        System.out.println(A.exists(ints, 102));
        System.out.println(A.exists(ints, -431));
    }

    public static class A {
        public static boolean exists(int[] ints, int k) {
            long startTime = System.currentTimeMillis();
            try {
                Arrays.sort(ints);

                if (k < ints[0] || k > ints[ints.length - 1])
                    return false;
                
                return search(ints, 0, ints.length - 1, k);
            } finally {
                System.out.println(String.format("Ran in: %d", System.currentTimeMillis() - startTime));
            } 
        }

        private static boolean search(int[] ints, int start, int end, int k) {
            if (start < 0 || end < 0 || end < start) {
                return false;
            }

            int mid = Double.valueOf(Math.ceil(((end - start) / 2.0) + start)).intValue();

            if (ints[mid] == k) {
                return true;
            } 
            
            if (start == end) {
                return false;
            }

            if (k < ints[mid]) {
                return search(ints, start, mid - 1, k);
            } else {
                return search(ints, mid, end, k);
            }
        }
    }

}