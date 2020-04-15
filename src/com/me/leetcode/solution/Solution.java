package com.me.leetcode.solution;

import java.util.Stack;

/**
 * 记录一些特殊场景的题目.
 *
 * @author zwyin
 */
public class Solution {
    public static void main(String[] args) {
        CatchRains solution = new CatchRains();
        int i = solution.trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }
}
