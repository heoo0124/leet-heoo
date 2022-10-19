package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.MoveZeroes
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/move-zeroes/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/13 11:53        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class MoveZeroes
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1};
        new MoveZeroes().myMoveZeroes(nums);
    }

    private void myMoveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j++] = nums[i];
                nums[i] = 0;
            }
        }
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
