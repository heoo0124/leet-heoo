package com.leetheoo.middle;

import java.util.*;

/**
 * <pre>
 *  file:com.leetheoo.middle.TotalFruit
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/fruit-into-baskets/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/19 10:03        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class TotalFruit
{
    public static void main(String[] args)
    {
        int[] nums = new int[]{2,3,1,2,3,4,3};
        new TotalFruit().totalFruit(nums);
    }

    private int myTotalFruit(int[] fruits)
    {
        Set<Integer> box = new HashSet<>();
        int res = 1;
        for (int i = 0; i < fruits.length; i++)
        {
            box.add(fruits[i]);
            for (int j = i+1; j < fruits.length; j++) {
                if(res == 1){
                    box.add(fruits[j]);
                    res++;
                }else {
                    if(!box.add(fruits[j])){
                        break;
                    }else {
                        res++;
                    }
                }
            }

        }

        return 0;
    }

    public int totalFruit(int[] fruits) {
        // 存放滑动窗口采摘水果，窗口最大值为2
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < fruits.length) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while (map.size() > 2) {
                // count为水果最大数目，当map大小超过2时，滑窗需前移left;
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
