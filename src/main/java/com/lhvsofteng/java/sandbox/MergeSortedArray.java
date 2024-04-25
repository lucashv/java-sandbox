package com.lhvsofteng.java.sandbox;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println("nums1 => " + 
            Arrays.stream(nums1)
                .mapToObj(Integer::valueOf)
                .map(String::valueOf)
                .collect(Collectors.joining(",")));
                
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < nums2.length; i++) {
            nums1[m + i] = nums2[i];
        }
        
        for (int x = 0; x < nums1.length; x++) {
            for (int y = 0; y < nums1.length; y++) {
                if (nums1[y] >= nums1[x]) {
                    int aux = nums1[x];
                    nums1[x] = nums1[y];
                    nums1[y] = aux;
                }               
            }
        }
    }
}