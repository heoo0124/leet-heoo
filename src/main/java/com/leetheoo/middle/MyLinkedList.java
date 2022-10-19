package com.leetheoo.middle;

import java.util.LinkedList;

/**
 * <pre>
 *  file:com.leetheoo.middle.MyLinkedList
 *  Copyright (c) 2022, eccang.com All Rights Reserved.
 *
 *  Description:
 *  ${TODO}
 *  https://leetcode.cn/problems/design-linked-list/
 *  Revision History
 *  Date,                  Who,                        What;
 *  2022/9/22 11:44        @author yangtaiwei          Initial.
 *
 * </pre>
 */
public class MyLinkedList
{
    int val=-1;
    MyLinkedList next;

    public MyLinkedList() {

    }

    public MyLinkedList(int val) { this.val = val; }

    public int get(int index)
    {
        if(index < 0) return -1;
        if(index == 0) return val;
        int i=1;
        MyLinkedList tmp = next;
        while (i<=index && tmp != null)
        {
            if(i == index){
                return tmp.val;
            }
            tmp = tmp.next;
            i++;
        }

        return -1;
    }

    public void addAtHead(int val)
    {
        if(this.val == -1){
            this.val = val;
        }else {
            int tmp = this.val;
            this.val = val;
            MyLinkedList tmpNext = this.next;
            MyLinkedList myLinkedList = new MyLinkedList(tmp);
            myLinkedList.next = tmpNext;
            this.next = myLinkedList;
        }
    }

    public void addAtTail(int val) {
        if(this.next == null)
        {
            if(this.val==-1){
                this.val = val;
            }else {
                this.next = new MyLinkedList(val);
            }
            return;
        }

        MyLinkedList tmp = next;
        while (true)
        {
            if(tmp.next == null){
                tmp.next = new MyLinkedList(val);
                break;
            }
            tmp = tmp.next;
        }
    }

    public void addAtIndex(int index, int val)
    {
        if(index < 1){
            addAtHead(val);
        }else {
            MyLinkedList tmp = this.next;
            int i = 1;
            while (i<=index){
                if(i==index && tmp == null) {
                    addAtTail(val);
                    break;
                }
                MyLinkedList next = tmp.next;
                if(i == index){
                    int nextVal = tmp.val;
                    tmp.val = val;
                    MyLinkedList myLinkedList = new MyLinkedList(nextVal);
                    myLinkedList.next = next==null ? null : next.next;
                    tmp.next = myLinkedList;
                    break;
                }else {
                    tmp = next;
                }
                i++;
            }
        }
    }

    public void deleteAtIndex(int index)
    {
        MyLinkedList tmp = this.next;
        if(index == 0){
            this.val = tmp==null ? -1 : tmp.val;
            this.next = tmp==null ? null : tmp.next;
            return;
        }
        int i = 1;
        while (i <= index)
        {
            MyLinkedList next = tmp.next;
            if(i==index && next == null) {
                tmp = null;
                break;
            }
            if(i == index){
                tmp.val = next.val;
                tmp.next = next==null ? null : next.next;
                break;
            }else {
                tmp = next;
            }
            i++;
        }
    }

    public static void main(String[] args)
    {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.deleteAtIndex(1);
        linkedList.addAtIndex(1,2);
        int i = linkedList.get(1);
        linkedList.deleteAtIndex(1);
        int i1 = linkedList.get(1);

        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);
        linkedList.get(1);
        linkedList.deleteAtIndex(0);
        linkedList.get(0);

        MyLinkedList head = new MyLinkedList(5);
        head.next = new MyLinkedList(2);
        head.next.next = new MyLinkedList(3);
        head.next.next.next = new MyLinkedList(4);
        head.next.next.next.next = new MyLinkedList(4);
        head.next.next.next.next.next = new MyLinkedList(6);
    }
}
