package com.leetheoo.middle;

import java.util.*;

/**
 * <pre>
 *  file:com.leeheoo.middle.Subsets
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 03
 *  ${TODO}
 *  https://leetcode.cn/problems/subsets/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 10:14        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class Subsets
{
    List<Integer> t = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args)
    {
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> subsets = new Subsets().subsets2(nums);
        System.out.println(subsets.toString());
    }

    private List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    private List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int all = res.size();
            for (int j = 0; j < all; j++) {
                List<Integer> tmp = new ArrayList<>(res.get(j));
                tmp.add(num);
                res.add(tmp);
            }
        }
        return res;
    }
}
