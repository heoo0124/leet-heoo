package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.PerfectSquare
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/valid-perfect-square/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/8 15:47        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class PerfectSquare
{
    public static void main(String[] args)
    {
        System.out.println(new PerfectSquare().myIsPerfectSquare(9));
    }

    private boolean myIsPerfectSquare(int num)
    {
        if(num == 1){
            return true;
        }
        int left = 2, right = num-1;
        while (left <= right){
            long mid  = (right - left)/2 + left;
            long a = mid * mid;
            if(a == num)
            {
                return true;
            }else if(a > num){
                right = (int)mid - 1;
            }else {
                left = (int)mid + 1;
            }
        }
        return false;
    }
}
