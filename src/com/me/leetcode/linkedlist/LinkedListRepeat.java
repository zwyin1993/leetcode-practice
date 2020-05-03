package com.me.leetcode.linkedlist;

/**
 * 两数之和.
 * leetcode第2题
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * @author zwyin
 */
public class LinkedListRepeat {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
     * 默认l1的值 > l2的值
     *
     * @param l1
     * @param l2
     * @param offset 偏移量，便是两个节点是不是在同一位
     * @return 当前和
     */
    private ListNode calc(ListNode l1, ListNode l2, int offset) {
        if (null == l1) {
            return l1;
        }

        l1.val = offset == 0 ? l1.val + l2.val : l1.val;
        l1.next = offset == 0 ? calc(l1.next, l2.next, 0) : calc(l1.next, l2, offset - 1);
        if (null != l1.next && l1.next.val > 9) {
            l1.val += 1;
            l1.next.val = l1.next.val % 10;
        }
        return l1;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.buildNodes(new int[]{1, 2, 3});
        ListNode l2 = ListNode.buildNodes(new int[]{1, 2, 3});
        LinkedListRepeat repeat = new LinkedListRepeat();
        System.out.println(repeat.addTwoNumbers(l1, l2));
    }
}
