package com.leetheoo.middle;

import java.util.Arrays;

/**
 * <pre>
 *  file:com.leetheoo.middle.GenerateMatrix
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/spiral-matrix-ii/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/20 17:37        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class GenerateMatrix
{
    public static void main(String[] args)
    {
        System.out.println(Arrays.toString(myGenerateMatrix(3)));
    }

    private static int[][] myGenerateMatrix(int n)
    {
        int[][] res = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n - 1, index = 1;
        while(index <= n * n){
            for(int i = left; i < right; i++){
                res[up][i] = index++;
            }
            up++;
            for(int i = up; i < down; i++){
                res[i][right] = index++;
            }
            right--;
            for(int i = right; i > left; i--){
                res[down][i] = index++;
            }
            down--;
            for(int i = down; i > up; i--){
                res[i][left] = index++;
            }
            left++;
        }
        return res;
    }
}
