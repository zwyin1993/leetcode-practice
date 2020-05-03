package com.me.leetcode.practice;

/**
 * .
 *
 * @author zwyin
 */
public class ArrayPractice {
    /**
     * 删除排序数组中的重复项
     *
     * @param nums 数组
     * @return 新数组的长度
     */
    public int removeDuplicates(int[] nums) {
        int end = 0; // 新数组的最后一位
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[end]) {
                continue;
            }
            nums[++end] = nums[i];
        }
        return end + 1;
    }

    public static void main(String[] args) {
        ArrayPractice test = new ArrayPractice();
        int i = test.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(i);
    }
}
