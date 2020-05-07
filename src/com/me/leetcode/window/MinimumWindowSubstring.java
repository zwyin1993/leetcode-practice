package com.me.leetcode.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最小覆盖子串.
 *
 * @author zwyin
 */
public class MinimumWindowSubstring {
    /**
     * 找出字符串s中包含t中所有字母的最小子串
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : t.toCharArray()) {
            Integer cnt = need.get(ch);
            if (null == cnt) {
                cnt = 1;
            } else {
                cnt++;
            }
            need.put(ch, cnt);
        }
        Map<Character, Integer> window = new HashMap<>();
        for (char ch : t.toCharArray()) {
            window.putIfAbsent(ch, 0);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0; // substring的起始索引
        int len = Integer.MAX_VALUE; // sybstring的长度
        while (right < s.length()) {
            char ch = s.charAt(right);
            right++;
            // 加入窗口
            if (need.containsKey(ch)) {
                window.computeIfPresent(ch, (k, v) -> v + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.computeIfPresent(d, (k, v) -> v - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        for (char ch : p.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            // 右移
            right++;
            // 窗口内数据更新
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                // 满足条件，结果暂存
                if (valid == need.size()) {
                    res.add(left);
                }
                // 窗口左移
                char d = s.charAt(left);
                left++;
                // 更新窗口内数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.computeIfPresent(d, (k, v) -> v - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring test = new MinimumWindowSubstring();
        List<Integer> ll = test.findAnagrams("abacebabacd", "abac");
        ll.forEach(a -> System.out.println(a));
    }
}
