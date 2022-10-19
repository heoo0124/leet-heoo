package com.leetheoo.simple;

/**
 * <pre>
 *  file:com.leetheoo.simple.RemoveElements
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/remove-linked-list-elements/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/21 15:08        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class RemoveElements
{
    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(1);
        for (int i = 7; i < 7; i++) {

        }

        myRemoveElements(head,1);

    }

    // 执行用时：
    //0 ms
    //100.00%
    //内存消耗：
    //41.9 MB
    //92.55%
    private static ListNode myRemoveElements(ListNode head, int val)
    {
        if(head == null) return new ListNode();
        while (head.val == val){
            head = head.next;
            if(head == null) break;

        }

        ListNode tmp = head;
        while (tmp.next != null){
            ListNode next = tmp.next;
            if(next.val == val){
                tmp.next = next.next;
            }else {
                tmp = next;
            }
        }

        return head;
    }
}

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
