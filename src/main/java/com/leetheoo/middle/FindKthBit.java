package com.leetheoo.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *  file:com.leeheoo.middle.FindKthBit
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 06
 *  ${TODO}
 *  https://leetcode.cn/problems/find-kth-bit-in-nth-binary-string/?envType=study-plan&id=wangyi
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 17:03        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class FindKthBit
{
    private String sn = "";
    private List<String> allSn = new ArrayList<>();
    public static void main(String[] args) {
        //System.out.println(new FindKthBit().getSn(4));
        System.out.println(new FindKthBit().myfindKthBit(20 ,1000000));
    }

    private char myfindKthBit(int n, int k) {
        String Sn = getSn(n);
        //System.out.println(Sn);
        return Sn.charAt(k-1);
    }

    private String getSn(int n){
        for (int i = 1; i <= n; i++) {
            if(i==1){
                sn = "0";
                allSn.add(sn);
            } else {
                sn = allSn.get(i-2) + "1" + new StringBuilder(invert(allSn.get(i-2))).reverse().toString();
                allSn.add(sn);
            }
        }

        return sn;
    }

    private String invert(String sn)
    {
        String zero = sn.replaceAll("0", "2");
        String one = zero.replaceAll("1", "0");
        return one.replaceAll("2","1");
    }

    private char findKthBitPro(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << (n - 1);
        if (k == mid) {
            return '1';
        } else if (k < mid) {
            return findKthBitPro(n - 1, k);
        } else {
            k = mid * 2 - k;
            return invert(findKthBitPro(n - 1, k));
        }
    }

    private char invert(char bit) {
        return (char) ('0' + '1' - bit);
    }
}
