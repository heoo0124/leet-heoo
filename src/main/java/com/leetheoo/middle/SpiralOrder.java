package com.leetheoo.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  file:com.leetheoo.middle.SpiralOrder
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/spiral-matrix/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/21 10:55        @author yangtaiwei          Initial.
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

    /**执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
       内存消耗：39.1 MB, 在所有 Java 提交中击败了98.75%的用户*/
    public static List<Integer> mySpiralOrder(int[][] matrix)
    {
        List<Integer> res = new ArrayList<>();
        int up = 0, down = matrix.length-1, left = 0, right = matrix[0].length-1, index = 0;
        while (res.size() < matrix.length*matrix[0].length){
            for (int i = left; i <= right; i++) {
                if(res.size()==matrix.length*matrix[0].length){
                    break;
                }
                res.add(matrix[up][i]);
            }
            up++;
            for (int i = up; i <= down; i++) {
                if(res.size()==matrix.length*matrix[0].length){
                    break;
                }
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                if(res.size()==matrix.length*matrix[0].length){
                    break;
                }
                res.add(matrix[down][i]);
            }
            down--;
            for (int i = down; i >= up; i--) {
                if(res.size()==matrix.length*matrix[0].length){
                    break;
                }
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}
