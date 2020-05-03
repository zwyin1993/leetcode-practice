package com.me.leetcode.practice;

/**
 * 字符串类题目.
 *
 * @author zwyin
 */
public class StringPractice {
    /**
     * 计算无重复字符的最长子串
     * 使用窗口进行计算
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int left = 0;
        int right = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            // 比较当前字符和窗口内的字符是否相同，如果相同则窗口右移
            for (int j = left; j <= right; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    left = j + 1;
                    break;
                }
            }
            right++;
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * Z型变换.
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        int cycle = 2 * numRows - 2; // 一个周期内的字符数
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) { // 按行拼接
            for (int i = 0; row + cycle * i < s.length(); i++) {
                sb.append(s.charAt(row + cycle * i));
                // 首末行添加一个字符，中间行添加两个字符
                if (row == 0 || row == numRows - 1) {
                    continue;
                }
                if (cycle * (i + 1) - row < s.length()) {
                    sb.append(s.charAt(cycle * (i + 1) - row));
                }
            }
        }
        return sb.toString();
    }

    /**
     * Z型变换.
     * 代码优化
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert1(String s, int numRows) {
        int cycle = 2 * numRows - 2;
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; row + i < s.length(); i += cycle) { // 优化在 i += cycle
                sb.append(s.charAt(row + i));
                if (row != 0 && row != numRows - 1 && i + cycle - row < s.length()) {
                    sb.append(s.charAt(i + cycle - row));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        String res = (new StringPractice()).convert1(s, 4);
        System.out.println(res);
    }
}
