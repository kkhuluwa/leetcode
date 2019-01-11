package com.kkhuluwa.leetcode.linkedlist;

import com.kkhuluwa.leetcode.ListNode;

/**
 * 203. Remove Linked List Elements
 * 203. 删除链表中的元素
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 * 删除链表中等于给定值 val 的所有元素。
 * <p>
 * 示例
 * 给定: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * 返回: 1 --> 2 --> 3 --> 4 --> 5
 */
public class Problem203 {
    public ListNode removeElements(ListNode head, int val) {
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return null;
        }
        //添加一个假的头
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        //指针遍历
        ListNode cursor = dummy.next, prev = dummy;
        while (cursor != null) {
            if (cursor.val == val) {
                // 删除当前节点,操作后不移动指针，让下一次循环继续对比该节点
                prev.next = cursor.next;
            } else {
                //不相等 指针下移
                prev = prev.next;
            }

            cursor = cursor.next;
        }


        return dummy.next;
    }

    public ListNode removeElements2(ListNode head, int val) {
        if (val > Integer.MAX_VALUE || val < Integer.MIN_VALUE) {
            return null;
        }
        //添加一个假的头
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        //指针遍历
        ListNode cursor = dummy;
        while (cursor.next != null) {
            if (cursor.next.val == val) {
                cursor.next = cursor.next.next;
            } else {
                cursor = cursor.next;
            }
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        ListNode result = new Problem203().removeElements(node, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
