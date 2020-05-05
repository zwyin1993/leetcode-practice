package com.me.leetcode.dynamicprogramming;

/**
 * 跳跃游戏.
 *
 * @author zwyin
 */
public class Jump {
    /**
     * 最少跳跃步数
     * 贪心算法，每步都跳最大长度
     *
     * @param nums 每一格子可以跳跃的最大长度
     * @return
     */
    public int leastJumpStep(int[] nums) {
        int step = 0;
        int end = 0;
        int maxPosition = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) { // 到达当前步数可到的最大值，更新下一步能到达的最大值
                end = maxPosition;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        Jump jump = new Jump();
        System.out.println(jump.leastJumpStep(arr));
    }
}
