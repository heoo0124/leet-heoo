package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.BackspaceCompare
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/backspace-string-compare/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/13 14:22        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class BackspaceCompare
{
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(new BackspaceCompare().backspaceCompare(s, t));
    }

    private boolean myBackspaceCompare(String s, String t) {
        return moveBks(s).equals(moveBks(t));
    }

    private String moveBks(String s)
    {
        if(s.contains("#")){
            int i = s.indexOf("#");
            if(i == 0){
                return moveBks(s.substring(1,s.length()));
            }else {
                return moveBks(s.substring(0, i-1) + s.substring(i + 1, s.length()));
            }
        }else {
            return s;
        }
    }

    // 一个解法
    private boolean aBackspaceCompare(String s, String t) {
        StringBuilder ss = new StringBuilder();
        StringBuilder tt = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c != '#'){
                ss.append(c);
            }else if(ss.length()>0){
                ss.deleteCharAt(ss.length()-1);
            }
        }
        for(char c : t.toCharArray()){
            if(c != '#'){
                tt.append(c);
            }else if(tt.length()>0){
                tt.deleteCharAt(tt.length()-1);
            }
        }
        return ss.toString().equals(tt.toString());
    }

    // 双指针
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }
}
