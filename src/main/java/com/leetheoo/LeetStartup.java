package com.leetheoo;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.util.List;

/**
 * <pre>
 *  file:com.leetheoo.LeetStartup
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/21 14:42        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class LeetStartup
{
    public static void main(String[] args) {
        List<String> hard = FileUtil.listFileNames("D:\\projsourcode\\IJidea_work\\leet-heoo\\src\\main\\java\\com\\leetheoo\\hard");
        List<String> middle = FileUtil.listFileNames("D:\\projsourcode\\IJidea_work\\leet-heoo\\src\\main\\java\\com\\leetheoo\\middle");
        List<String> simple = FileUtil.listFileNames("D:\\projsourcode\\IJidea_work\\leet-heoo\\src\\main\\java\\com\\leetheoo\\simple");
        System.out.println("hard: " + hard.size() + "");
        System.out.println("middle: " + middle.size() + "");
        System.out.println("simple: " + simple.size() + "");
        System.out.println("all: " + (simple.size()+middle.size()+hard.size()) + "");
    }
}
