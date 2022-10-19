package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.SearchInsert
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/7 18:44        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class SearchInsert
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1};
        int target = 2;
        System.out.println(new SearchInsert().searchInsert(nums, target));
    }

    private int searchInsert(int[] nums, int target) {
        int mid = 0,left = 0, right = nums.length - 1;
        while (left <= right){
            mid = (right - left) / 2 + left;
            int num = nums[mid];
            if(target == num){
                return mid;
            }else if(target < num){
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return nums[mid] >= target ? mid : mid+1;
    }
}
