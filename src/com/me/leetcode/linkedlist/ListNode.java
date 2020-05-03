package com.me.leetcode.linkedlist;

import java.util.List;

/**
 * 单链表类算法题解.
 *
 * @author zwyin
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
    ListNode() {}

    @Override
    public String toString() {
        return String.format("val:%s; next:%s", val, next);
    }

    /**
     * 两数之和.
     * @param l1 链表1
     * @param l2 链表2
     * @return 两数之和
     */
    public ListNode addTowNumbers(ListNode l1, ListNode l2) {
        int len1 = l1.length();
        int len2 = l2.length();
        ListNode head = new ListNode(1);
        head.next = len1 > len2 ? calc(l1, l2, len1 - len2) : calc(l2, l1, len2 - len1);
        if (head.next.val > 9) {
            head.next.val = head.next.val % 10;
            return head;
        }
        return head.next;
    }

    /**
     * l1的长度是大于l2的.
     * @param l1
     * @param l2
     * @param offset
     * @return
     */
    private ListNode calc(ListNode l1, ListNode l2, int offset) {
        if (null == l1) {
            return null;
        }
        l1.val = offset == 0 ? l1.val + l2.val : l1.val;
        l1.next = offset == 0 ? calc(l1.next, l2.next, 0) : calc(l1.next, l2, offset - 1);
        if (null != l1.next && l1.next.val > 9) {
            l1.val += l1.next.val / 10;
            l1.next.val = l1.next.val % 10;
        }
        return l1;
    }

    /********************* listnod的公共类 *************************/
    public int length() {
        int count = 0;
        ListNode l = this;
        while (null != l) {
            count++;
            l = l.next;
        }
        return count;
    }

    /**
     * 通过数组构建单链表.
     * @param arr
     * @return
     */
    public static ListNode buildNodes(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode l = head;
        for (int i : arr) {
            ListNode curr = new ListNode(i);
            l.next = curr;
            l = curr;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l = buildNodes(new int[]{1, 2, 3});
        ListNode l2 = buildNodes(new int[]{3, 4});
        ListNode node = new ListNode();
        ListNode ll = node.addTowNumbers(l, l2);
        System.out.println(ll);
    }
}
