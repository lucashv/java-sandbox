package com.lhvsofteng.java.sandbox;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[] { 0,0,1,1,1,2,2,3,3,4 };
        //int[] arr = new int[] { 1,1,1,2 };
        int k = removeDuplicates(arr);
        System.out.println("k = " + k);
        System.out.println("arr = " + Arrays.stream(arr)
                .boxed()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                int x = i;
                while(x < nums.length && nums[i] == nums[x]) x++;
                for (int j = i + 1; j < nums.length - 1 && x < nums.length; j++) {
                    nums[j] = nums[x++];
                }
            }
        }
        int k = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[k] != nums[i+1])
                k++;
        }
        return k + 1;
    }
}
