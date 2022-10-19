package com.leetheoo.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <pre>
 *  file:com.leeheoo.simple.TwoSum
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 02
 *  ${TODO}
 *  https://leetcode.cn/problems/two-sum/?plan=zhitongche&plan_progress=zl0rswe
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 14:59        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class TwoSum
{
    public static void main(String[] args)
    {
        int[] nums = new int[] { 3, 2, 4 };
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }

    private static int[] twoSum(int[] nums, int target)
    {
        int[] res = new int[] { 0, 0 };
        List<Integer> intList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++)
        {
            if (target - nums[i] == nums[i])
            {
                res[0] = intList.indexOf(nums[i]);
                res[1] = intList.lastIndexOf(target - nums[i]);
                if (res[0] != res[1])
                {
                    break;
                }

            }
            if (intList.contains(target - nums[i]))
            {
                res[0] = i;
                res[1] = intList.indexOf(target - nums[i]);

                if (res[0] != res[1])
                {
                    break;
                }
            }
        }

        return res;
    }

    private int[] twoSumPro(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<>(6);
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }

        return indexs;
    }
}
