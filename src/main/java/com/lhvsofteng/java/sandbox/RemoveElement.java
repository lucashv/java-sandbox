package com.lhvsofteng.java.sandbox;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        RemoveElement rl = new RemoveElement();
        rl.removeElement2(arr, 2);
    }

    public int removeElement2(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}