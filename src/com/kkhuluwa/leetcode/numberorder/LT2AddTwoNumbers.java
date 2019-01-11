package com.kkhuluwa.leetcode.numberorder;

import com.kkhuluwa.leetcode.ListNode;

public class LT2AddTwoNumbers {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dumpHead = new ListNode(0);
            ListNode p = l1;
            ListNode q = l2;
            ListNode curr = dumpHead;
            int carry = 0;
            while (p != null || q != null) {
                int x = (p == null) ? 0 : p.val;
                int y = (q == null) ? 0 : q.val;
                int sum = carry + x + y;
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }

            // 最后了 两个列表长度一样  但是 跳出了，最后一位的长度需要判断
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }

            return dumpHead.next;
        }
    }
}