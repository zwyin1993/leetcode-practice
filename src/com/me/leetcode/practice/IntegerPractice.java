package com.me.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * .
 *
 * @author zwyin
 */
public class IntegerPractice {

    /**
     * 整数反转.整数的范围是[-2^31, 2^31 - 1]
     * 样例：123，-123，120
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                break;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                break;
            }
            res = res * 10 + pop;
            x = x / 10;
        }
        return res;
    }

    /**
     * 字符串转数字
     *
     * @param s
     * @return
     */
    public int myAtoI(String s) {
        int flag = 0; // 符号为标志
        boolean begin = false; // 开始空字符判断
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (!begin && ch == ' ') {
                continue; // 空字符过滤
            }
            begin = true;
            if (flag == 0 && ch == '-') {
                flag = -1;
                continue; // 负数符号位过滤
            }
            if (flag == 0 && ch == '+') {
                flag = 1;
                continue; // 正数符号位过滤
            }
            if (ch < '0' || ch > '9') {
                continue; // 非数字过滤
            }
            int pop = Integer.parseInt(String.valueOf(ch));
            if (flag == 0) {
                flag = 1;
                res = pop;
                continue;
            }
            if (flag * res > Integer.MAX_VALUE / 10 || (flag * res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return Integer.MAX_VALUE;
            }
            if (flag * res < Integer.MIN_VALUE / 10 || (flag * res == Integer.MIN_VALUE / 10 && pop > 8)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + pop;
        }
        return flag * res;
    }

    /**
     * 罗马数字转数字
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        Character pre = null;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character ch = s.charAt(i);
            if (null == pre) {
                res += map.get(ch);
                pre = ch;
                continue;
            }

            if (map.get(pre) > map.get(ch)) {
                res -= map.get(ch);
            } else {
                res += map.get(ch);
            }
            pre = ch;
        }
        return res;
    }

    /**
     * 外观数列.
     * leetcode 38题
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = countAndSay(res);
        }
        return res;
    }

    private String countAndSay(String res) {
        int cnt = 0;
        Character pre = null;
        StringBuilder sb = new StringBuilder();
        for (Character curr : res.toCharArray()) {
            if (null == pre) {
                pre = curr;
                cnt++;
                continue;
            }
            if (curr == pre) {
                cnt++;
                continue;
            }
            sb.append(cnt).append(pre);
            cnt = 1;
            pre = curr;
        }
        sb.append(cnt).append(pre);
        return sb.toString();
    }

    /**
     * 快乐数
     * 本质是能否成环，使用快慢指针
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (fast != slow) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return slow == 1;
    }

    private int getNext(int n) {
        int total = 0;
        while (n > 0) {
            int t = n % 10;
            total += t * t;
            n = n / 10;
        }
        return total;
    }


    public static void main(String[] args) {
        IntegerPractice test = new IntegerPractice();
        System.out.println(test.isHappy(4));
    }
}
