package com.leetheoo.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *  file:com.leetheoo.simple.BinarySearch
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/binary-search/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/7 16:21        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class BinarySearch
{
    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        //                      0,1,2,3,4, 5
        int target = 2;
        System.out.println(new BinarySearch().search(nums, target));
    }

    private int search(int[] nums, int target)
    {
        if(nums[nums.length-1] == target){
            return nums.length-1;
        }
        if(nums.length == 1){
            return nums[nums.length-1] == target ? 0 : -1;
        }
        if(nums.length == 2){
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] == target){
                    res=i;
                }
            }

            return res;
        }

        if(target > nums[nums.length-1] || target < nums[0]){
            return -1;
        }
        return binarySearch(nums,target,nums.length/2,nums.length);
    }

    private int binarySearch(int[] nums, int target, int flag, int length)
    {
        if(length == 2 && nums[flag] != target){
            return -1;
        }
        if(target >= nums[flag]){
            if(target == nums[flag]){
                return flag;
            }
            return binarySearch(nums, target, (length+flag)/2,length);
        }else {
            return binarySearch(nums, target, flag/2, flag);
        }

    }

    // 标准答案
    public int searchS(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int search01(int[] nums, int target){
        List<Integer> collect = Arrays.stream(nums).boxed().collect(Collectors.toList());
        if(collect.contains(target)){
            return collect.indexOf(target);
        }else {
            return -1;
        }
    }
}
