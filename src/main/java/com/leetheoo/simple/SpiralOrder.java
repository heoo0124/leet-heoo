package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.SpiralOrder
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/21 14:40        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class SpiralOrder
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int right = matrix.length;
        int down = matrix[0].length;

        System.out.println(mySpiralOrder(matrix));
    }

    private static int[] mySpiralOrder(int[][] matrix)
    {
        if( matrix.length==0) return new int[0];
        int[] res = new int[matrix.length*matrix[0].length];
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1, index = 0;
        while (index < matrix.length*matrix[0].length){
            for (int i = left; i <= right; i++) {
                if(index==matrix.length*matrix[0].length){
                    break;
                }
                res[index++] = matrix[up][i];
            }
            up++;
            for (int i = up; i <= down; i++) {
                if(index==matrix.length*matrix[0].length){
                    break;
                }
                res[index++] = matrix[i][right];
            }
            right--;
            for (int i = right; i >= left; i--) {
                if(index==matrix.length*matrix[0].length){
                    break;
                }
                res[index++] = matrix[down][i];
            }
            down--;
            for (int i = down; i >= up; i--) {
                if(index==matrix.length*matrix[0].length){
                    break;
                }
                res[index++] = matrix[i][left];
            }
            left++;
        }

        return res;
    }
}
