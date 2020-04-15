package com.me.leetcode.solution;

/**
 * 回文字符串.
 * 类似：伤害自来水来自海上
 *
 * @author zwyin
 */
public class Palindrome {
    public String longestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int maxLength = 0;
        int startIdx = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = palindromeLength(s, i, i); // 计算奇回文长度
            int len2 = palindromeLength(s, i, i + 1); // 计算偶回文长度
            if (Math.max(len1, len2) > maxLength) {
                startIdx = len1 > len2 ? i - len1 / 2 : i - len2 / 2 + 1;
                maxLength = Math.max(len1, len2);
            }
        }
        return s.substring(startIdx, startIdx + maxLength);
    }

    private int palindromeLength(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // 这里可以举实例；如当left==2，right==5时跳出，长度应该是2，那就是5 - 2 -1
    }

    public static void main(String[] args) {
        Palindrome test = new Palindrome();
        String s = test.longestPalindrome("abab");
        System.out.println(s);
    }
}
