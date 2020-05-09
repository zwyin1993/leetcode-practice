package com.me.leetcode.graph;

import com.me.leetcode.linkedlist.ListNode;
import com.sun.tools.corba.se.idl.StringGen;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 广度优先搜索.
 * 图上求最短路径
 * 一个问题如果可以抽象为全排列，可以考虑使用广度优先搜索，求最短路径
 *
 * @author zwyin
 */
public class Bfs {

    public void template(ListNode start, ListNode target) {
        Queue<ListNode> queue = new LinkedList<>(); // 记录要遍历的节点
        Set<ListNode> visit = new HashSet<>(); // 记录节点是否已经走过
        int step = 0;
        queue.add(start);
        visit.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            /* 遍历当前层的节点，找到下一层的节点*/
            for (int i = 0; i < size; i++) {
                ListNode curr = queue.poll();
                if (curr == target) {
                    return;
                }
                // 当前节点的下一层节点入队列,判断节点是否visit
            }
            /* 当前层遍历结束，步数+1 */
            step++;
        }
    }

    /**
     * 求二叉树的最短路径.
     *
     * @param tree
     * @return
     */
    public int minDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 1;
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (null == curr.left && null == curr.right) {
                    return depth;
                }
                if (null != curr.left) {
                    queue.add(curr.left);
                }
                if (null != curr.right) {
                    queue.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 打开密码锁.
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        int step = 0;
        queue.add("0000");
        visit.add("0000");
        Set<String> deads = new HashSet<>();
        for (String deadend : deadends) {
            deads.add(deadend);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (deads.contains(curr)) {
                    continue;
                }
                if (curr == target) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = upLock(curr, j);
                    if (!visit.contains(up)) {
                        queue.add(up);
                        visit.add(up);
                    }
                    String down = downLock(curr, j);
                    if (!visit.contains(down)) {
                        queue.add(down);
                        visit.add(down);
                    }
                }
                step++;
            }
        }
        return -1;
    }

    private String downLock(String s, int i) {
        // 向下转动，每次-1
        char[] chs = s.toCharArray();
        if (chs[i] == '0') {
            chs[i] = '9';
        } else {
            int tmp = (int) chs[i] - 1;
            chs[i] = (char) tmp;
        }
        return new String(chs);
    }

    private String upLock(String s, int i) {
        // 向上转动锁,每次+1
        char[] chs = s.toCharArray();
        if (chs[i] == '9') {
            chs[i] = '0';
        } else {
            int tmp = (int) chs[i] + 1;
            chs[i] = (char) tmp;
        }
        return new String(chs);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Bfs test = new Bfs();
        int i = test.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202");
        System.out.println(i);
    }
}
