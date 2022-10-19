package com.leetheoo.middle;

import java.util.Random;

/**
 * <pre>
 *  file:com.leeheoo.middle.ListRandom
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description: 05
 *  ${TODO}
 *  https://leetcode.cn/problems/linked-list-random-node/?plan=zhitongche&plan_progress=zl0rswe
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/6 16:33        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class ListRandom
{
    ListNode head;
    Random random;

    public ListRandom(ListNode head)
    {
        this.head = head;
        random = new Random();
    }

    public int getRandom()
    {
        int i = 1, ans = 0;
        for (ListNode node = head; node != null; node = node.next)
        {
            // 1/i 的概率选中（替换为答案）
            if (random.nextInt(i) == 0)
            {
                ans = node.val;
            }
            ++i;
        }
        return ans;
    }
}

class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}