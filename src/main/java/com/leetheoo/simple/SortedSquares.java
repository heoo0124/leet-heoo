package com.leetheoo.simple;

import java.util.Arrays;

/**
 * <pre>
 *  file:com.leetheoo.simple.SortedSquares
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/squares-of-a-sorted-array/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/13 16:52        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class SortedSquares
{
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        for (int i : new SortedSquares().sortedSquares(nums)) {
            System.out.println(i);
        }
    }

    private int[] mySortedSquares(int[] nums)
    {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * nums[i];
        }
        // Arrays.sort(res);
        quickSort(res,0,res.length-1);
        return res;
    }

    private void quickSort(int[] a,int l,int r){
        if(l>=r) return;
        //选择第一个数为key
        int i = l; int j = r; int key = a[l];

        while(i<j){
            //从右向左找第一个小于key的值
            while(i<j && a[j]>=key) j--;
            if(i<j){
                a[i] = a[j];
                i++;
            }
            //从左向右找第一个大于key的值
            while(i<j && a[i]<key) i++;

            if(i<j){
                a[j] = a[i];
                j--;
            }
        }
        //i == j
        a[i] = key;
        //递归调用
        quickSort(a, l, i-1);
        //递归调用
        quickSort(a, i+1, r);
    }

    private int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                ans[pos] = nums[i] * nums[i];
                ++i;
            } else {
                ans[pos] = nums[j] * nums[j];
                --j;
            }
            --pos;
        }
        return ans;
    }

}
