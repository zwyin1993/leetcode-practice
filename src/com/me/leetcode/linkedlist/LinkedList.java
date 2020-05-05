package com.me.leetcode.linkedlist;

import java.util.List;

/**
 * .
 *
 * @author zwyin
 */
public class LinkedList {
    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(1);
        head.next = mergeCalc(l1, l2);
        return head.next;
    }

    private ListNode mergeCalc(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeCalc(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeCalc(l1, l2.next);
            return l2;
        }
    }

    /**
     * 判断一个链表是否成环
     * 使用快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (null != fast.next && null != fast.next.next) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.val == fast.val) {
                return true;
            }
        }
        return false;
    }

    /**
     * 单链表反转.
     *
     * @param l
     * @return
     */
    public ListNode reverse(ListNode l) {
        ListNode head = new ListNode(0);
        head.next = l;
        ListNode pre = l;
        ListNode curr = l.next;
        while (null != curr) {
            pre.next = curr.next;
            curr.next = head.next;
            head.next = curr;
            curr = pre.next;
        }
        return head.next;
    }

    /**
     * 删除链表中的倒数第N个节点.
     * 使用快慢指针
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy; // 指向slow的前一个节点
        for (int i = 0; i < n; i++) { // 令fast和slow相隔n个节点，则当fast==null时，slow即为要删除的节点
            if (null == fast) {
                return head;
            } else {
                fast = fast.next;
            }
        }
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        slow.next = null;
        return dummy.next;
    }

    /**
     * 两两交换链表中的节点
     *
     * @param head 首节点
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (null != pre.next && null != pre.next.next) {
            ListNode curr = pre.next.next;
            pre.next.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            pre = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l = ListNode.buildNodes(new int[]{1, 3, 4, 2});
        ListNode l2 = ListNode.buildNodes(new int[]{1, 2, 4});
        LinkedList list = new LinkedList();
        ListNode ll = list.swapPairs(l);
        System.out.println(ll);
    }
}
