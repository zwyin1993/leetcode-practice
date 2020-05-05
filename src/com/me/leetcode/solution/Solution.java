package com.me.leetcode.solution;

import java.util.Stack;

/**
 * 记录一些特殊场景的题目.
 *
 * @author zwyin
 */
public class Solution {

    /**
     * 买卖股票的最佳时机
     *
     * @param prices 每一天的股票
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        // 每天的股价-之前的最低值，即为今天能赚取的最大利润
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    /**
     * 乘最多谁的容器
     * 使用双指针，area=(right - left) * Math.max(height[right], height[left])
     * 当right-left缩小时，只有height[right]或height[left]增大，才可能是面积增大
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = (right - left) * Math.min(height[right], height[left]);
        while (left < right) {
            if (height[left] < height[right]) {
                // 右移
//                left++;
                ++left;
            } else {
//                right--;
                --right;
            }
            int tmp = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, tmp);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(i);
    }
}
