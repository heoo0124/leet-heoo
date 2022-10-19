package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.RemoveDuplicates
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/13 10:22        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class RemoveDuplicates
{
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println("长度是：" + new RemoveDuplicates().removeDuplicates(nums));
    }

    private int myRemoveDuplicates(int[] nums) {
        int j = 0,k = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i+1] == nums[i]) {
                int tmp = nums[i];
                nums[i+1] = 10001;
                nums[i] = nums[i+1];
                nums[i+1] = tmp;
                j++;
            }
            if(nums[i] != 10001){
                nums[k++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 10001){
                nums[k++] = nums[i];
            }
        }

        for (int num : nums) {
            System.out.println(num);
        }
        return j;
    }

    private int removeDuplicates(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length; i ++ ) {
            if (i == 0 || nums[i] != nums[i - 1]){
                nums[t ++ ] = nums[i];
            }
        }
        return t;
    }
}
