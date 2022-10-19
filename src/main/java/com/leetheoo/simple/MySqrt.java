package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.MySqrt
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/sqrtx/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/8 10:03        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class MySqrt {
    public static void main(String[] args)
    {
        // 2147395599
        // 8192
        System.out.println(new MySqrt().myMySqrt(2147395599));
    }

    private int myMySqrt(int x) {
        if(0< x && x <= 3 ){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        // 2 3 4 5 6 7 8
        int left = 2, right = x-1;
        while (left <= right){
            long mid  = (right - left)/2 + left;
            long a = mid * mid,b = (mid + 1) * (mid + 1);
            if(a == x || (a < x && x < b))
            {
                return (int)mid;
            }else if(a > x){
                right = (int)mid - 1;
            }else {
                left = (int)mid + 1;
            }
        }
        return 0;
    }
}
