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

    public static void main(String[] args) {
        CatchRains solution = new CatchRains();
        int i = solution.trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }
}
