package com.kkhuluwa.leetcode.linkedlist;

/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head.
 * <p>
 * For example,
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * <p>
 * 这个问题可以拆分成两个简单的单链表问题，
 * 1. 不知链表长度情况下，求倒数第N个元素，使用两个指针 间隔N，当快指针到链表尾端，慢指针到了目标
 * 2.只能访问当前节点情况下，删除当前节点
 */
public class Problems19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lastNNode = getLastNNode(head, n);
        if (lastNNode == null) {
            return null;
        }
        if (lastNNode.next != null) {
            deleteCurrentNode(lastNNode);
        } else {
            head = deleteLastNode(head);
        }

        return head;

    }

    public ListNode deleteLastNode(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head.next.next;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = null;
        return head;
    }


    public ListNode getLastNNode(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 先移动N位
        for (int i = 0; i < n - 1; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        if (fast == null) {
            return null;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;

    }

    /**
     * 当节点没有下一个节点时不能使用该方法
     *
     * @param node
     * @return
     */
    public ListNode deleteCurrentNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode nextNode = node.next;
        if (nextNode == null) {
            return null;
        }
        node.val = nextNode.val;
        node.next = nextNode.next;

        return node;
    }

    public static void main(String args[]) {
        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
        ListNode result = new Problems19().removeNthFromEnd(node, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


}
