package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leeheoo.simple.MaxProfit
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 04
 *  ${TODO}
 *  https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan&id=wangyi
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 14:27        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class MaxProfit
{
    public static void main(String[] args)
    {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(myMaxProfit(prices));
    }

    private static int myMaxProfit(int[] prices)
    {
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++)
        {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    private int maxProfit2(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
