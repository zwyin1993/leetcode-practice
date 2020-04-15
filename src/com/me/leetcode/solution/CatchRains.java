package com.me.leetcode.solution;

import java.util.Stack;

/**
 * 接雨水.
 *
 * @author zwyin
 */
public class CatchRains {
    /**
     * 接雨水.
     * 按列求值
     * 动态规划，计算左侧最大值
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int maxLeft = height[0];
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) { // 最左侧和最右侧是无法接雨水的
            maxLeft = Math.max(maxLeft, height[i]);
            int tmp = Math.min(maxLeft, maxRight[i]) - height[i];
            sum += Math.max(tmp, 0);
        }
        return sum;
    }

    /**
     * 接雨水.
     * 按列求值
     * 使用双指针
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {// 向右移动
                maxLeft = Math.max(maxLeft, height[left]);
                int tmp = maxLeft - height[left];
                sum += Math.max(tmp, 0);
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                int tmp = maxRight - height[right];
                sum += Math.max(tmp, 0);
                right--;
            }
        }
        return sum;
    }

    /**
     * 接雨水.
     * 按行求值
     * 使用栈进行计算,当前元素小于栈顶元素，当前元素入栈，否则计算面积
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        Stack<Integer> stack = new Stack<>(); // stack存的是下标
        stack.push(0);
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int bottomIndex = stack.pop();
                while (!stack.isEmpty() && height[stack.peek()] == height[bottomIndex]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    sum += (Math.min(height[stack.peek()], height[i]) - height[bottomIndex])
                            * (i - stack.peek() - 1);// 面积 = 长 * 高
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
