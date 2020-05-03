package com.me.leetcode.solution;

import java.util.Stack;

/**
 * .
 *
 * @author zwyin
 */
public class SolutionRepeat {
    /**
     * 最长回文子串
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 计算每一位的max(最长奇回文，最长偶回文)
        int max = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = currentPalindroome(s, i, i); // 奇回文长度
            int len2 = currentPalindroome(s, i, i + 1); // 偶回文长度
            if (max < Math.max(len1, len2)) {
                startIndex = len1 > len2 ? i - len1 / 2 : i - len2 / 2 + 1;
                max = Math.max(len1, len2);
            }
        }
        return s.substring(startIndex, startIndex + max);
    }

    private int currentPalindroome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    /**
     * 接雨水.
     * 按列求值
     * 动态规划。当前列雨水数=min(左边最高点，右边最高点) - height[i]
     *
     * @param height 每一列的高度
     * @return 最大雨水数
     */
    public int cacheRains(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int maxLeft = height[0];
        int[] maxRight = new int[height.length];
        maxRight[height.length - 1] = height[height.length - 1];
        // 计算每一列的右边最大值
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length; i++) {
            maxLeft = Math.max(maxLeft, height[i]);
            int currSum = Math.min(maxLeft, maxRight[i]) - height[i];
            sum += Math.max(currSum, 0);
        }
        return sum;
    }

    /**
     * 双指针，按列求值
     *
     * @param height
     * @return
     */
    public int cacheRains2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) { // 右移
                maxLeft = Math.max(maxLeft, height[left]);
                int currSum = maxLeft - height[left];
                // 这里为什么不是Math.min(maxLeft, maxRight),因为此时maxLeft已经更新了，
                // 但是maxRight没有更新，但是可以确认的是maxLeft肯定小于maxRight
                // 如果进到找个条件，表示maxLeft一直小于height[right],所以Math.min(maxLeft, maxRight) == maxLeft
                sum += Math.max(currSum, 0);
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                int currSum = maxRight - height[right];
                sum += Math.max(currSum, 0);
                right--;
            }
        }
        return sum;
    }

    /**
     * 按行求值.
     *
     * @param height
     * @return
     */
    public int cacheRains3(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) { // 计算当前行
                int bottomIndex = stack.pop();
                while (height[bottomIndex] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) { // 左侧柱子都比i索引的低
                    sum += (Math.min(height[i], height[stack.peek()]) - height[bottomIndex]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return sum;
    }

}
