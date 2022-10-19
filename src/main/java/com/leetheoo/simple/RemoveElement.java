package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.RemoveElement
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/remove-element/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/8 16:40        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class RemoveElement {
    public static void main(String[] args)
    {
        int[] nums = new int[]{2,2};
        int val = 3;
        System.out.println(new RemoveElement().myRemoveElement(nums,val));
    }

    private int myRemoveElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                nums[i] = -1;
                result++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == -1)
            {
                for (int j = i + 1; j < nums.length; j++) {
                    if(nums[j] != -1){
                        nums[i] = nums[j];
                        nums[j] = -1;
                        break;
                    }
                }
            }

        }
        for (int num : nums) {
            System.out.println(num);
        }
        return nums.length - result;
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
