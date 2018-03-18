package com.kkhuluwa.leetcode.linkedlist;

import java.util.List;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * <p>
 * 比较相邻两个节点的大小（这个问题一开始没想明白，浪费了时间），如果后面的节点和前面的节点相同，那么删除前面的节点
 * <p>
 * 使用的方法就是通用的，仅访问当前节点的情况下，删除当前节点，
 * 赋值法，当前的数值等于下个点的数值，当前的后继节点，等于下一个的下一个节点（这个地方下一个节点的赋值记忆不清楚导致代码错过）
 */
public class Problem83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode currentNode = head.next;
        ListNode slowNode = head;
        while (currentNode != null) {

            if (slowNode.val == currentNode.val) {
                slowNode = deleteCurrentNode(slowNode);
            } else {
                slowNode = currentNode;
            }

            currentNode = currentNode.next;
        }

        return head;

    }

    /**
     * 删除当前节点
     *
     * @param head
     * @return
     */
    public ListNode deleteCurrentNode(ListNode head) {
        if (head == null || head.next == null) {
            head = null;
            return head;
        }
        head.val = head.next.val;
        head.next = head.next.next;
        return head;
    }
}
