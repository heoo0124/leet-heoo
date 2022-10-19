package com.leetheoo.middle;

/**
 * <pre>
 *  file:com.leetheoo.middle.MinSubArrayLen
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/minimum-size-subarray-sum/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/15 13:46        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class MinSubArrayLen
{
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 8;
        System.out.println(new MinSubArrayLen().minSubArrayLen(target, nums));
    }

    private int myMinSubArrayLen(int target, int[] nums)
    {
        int i = 0, j = 0;
        int mid = 0, left = 0, right = nums.length - 1;
        while (left <= right)
        {
            mid = (right - left) / 2 + left;
            while (i < nums.length)
            {
                int y = 0;
                j = mid;
                for (int k = i; k < j; k++) {
                    y += nums[k];
                }
                if(y < target){
                    if(i + j == nums.length-1){
                        i = -1;
                        j++;
                        if(j == nums.length){
                            j=-1;
                            left = mid + 1;
                            break;
                        }
                    }
                }else if(y > target){
                    right = mid - 1;
                    break;
                }else {
                    return j+1;
                }
                i++;
            }

        }

        return j+1;
    }

    private int minSubArrayLen(int target, int[] nums) {
        // 最终的结果
        int result = Integer.MAX_VALUE;
        // 子序列的数值之和
        int sum = 0;
        // 滑动窗口起始位置
        int i = 0;
        // 子序列的长度
        int subLength = 0;
        // 设置子序列起点为i
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            // 设置子序列终止位置为j
            while (sum >= target) {
                // 取子序列的长度
                subLength = (j - i + 1);
                result = result < subLength ? result : subLength;
                // 这里体现出滑动窗口的精髓之处，不断变更i（子序列的起始位置）
                sum -= nums[i++];
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
