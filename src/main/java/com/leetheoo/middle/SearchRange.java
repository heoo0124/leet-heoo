package com.leetheoo.middle;

/**
 * <pre>
 *  file:com.leetheoo.middle.SearchRange
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/7 19:49        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class SearchRange
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{1};
        int target = 1;

        for (int i : new SearchRange().mySearchRange(nums, target)) {
            System.out.println(i);
        }
    }

    private int[] mySearchRange(int[] nums, int target) {
        boolean flag = false;
        int[] res = new int[]{-1,-1};
        int mid = 0, left = 0, right = nums.length - 1;
        while (left <= right){
            mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                flag = true;
                break;
            }else if(nums[mid] > target) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if(flag){
            for (int i = mid - 1; i >= -1; i--) {
                if (i== -1 || nums[i] != target) {
                    res[0] = i + 1;
                    break;
                }
            }
            for (int i = mid + 1; i <= nums.length; i++) {
                if (i== nums.length || nums[i] != target) {
                    res[1] = i - 1;
                    break;
                }
            }
        }

        return res;
    }
}
