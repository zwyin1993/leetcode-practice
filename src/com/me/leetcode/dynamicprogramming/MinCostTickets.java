package com.me.leetcode.dynamicprogramming;

/**
 * 最少票价.
 *
 * @author zwyin
 */
public class MinCostTickets {
    /**
     * 最少票价
     *
     * @param days  要出行的天数
     * @param costs 出行1，7，30分别需要多少前
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length - 1] + 1]; // 暂存每一天最少花费多少钱
        int day = 0;
        for (int i = 1; i < dp.length; i++) {
            if (i == days[day]) {
                int dp1 = dp[i - 1] + costs[0];
                int dp7 = i >= 7 ? dp[i - 7] + costs[1] : dp[0] + costs[1];
                int dp30 = i >= 30 ? dp[i - 30] + costs[2] : dp[0] + costs[2];
                dp[i] = Math.min(dp1, dp7);
                dp[i] = Math.min(dp[i], dp30);
                day++; // 不要忘记
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        MinCostTickets test = new MinCostTickets();
        int i = test.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15});
        System.out.println(i);
    }
}
