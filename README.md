# content
本项目用于算法与数据结构的学习，主要内容包括：

- [读书笔记](./doc/算法与数据结构.md)
- [题解](./doc/算法与数据结构练习.md)
- [总结](./doc/数据结构与算法.xmind)

## 时间线 
> 记录什么时间做了什么题

| 时间      | 题目                                                         | 难度 | leetcode图解                                                 | repeat   | 备注                                               |
| --------- | ------------------------------------------------------------ | ---- | ------------------------------------------------------------ | -------- | -------------------------------------------------- |
| 2020/5/6  | [最少票价](./src/com/me/leetcode/dynamicprogramming/MinCostTickets.java) | 🌟🌟   | [题目详细描述](https://leetcode-cn.com/problems/minimum-cost-for-tickets/) |          | 动态规划                                           |
| 2020/4/15 | [接雨水](./src/com/me/leetcode/solution/CatchRains.java)     | 🌟🌟🌟  | [图解](https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/) | 2020/5/3 | 按行求和按列求                                     |
| 2020/4/15 | [两数之和，使用链表](./src/com/me/leetcode/linkedlist/ListNode.java) | 🌟🌟   | [力扣链接](https://leetcode-cn.com/problems/add-two-numbers/) | 2020/5/2 | 递归                                               |
| 2020/4/15 | [最长回文子串](./src/com/me/leetcode/solution/Palindrome.java) | 🌟🌟   | [力扣链接](https://leetcode-cn.com/problems/longest-palindromic-substring/) | 2020/5/2 |                                                    |
|           | [无重复字符的最长子串](./src/com/me/leetcode/practice/StringPractice.java) | 🌟🌟   |                                                              | 2020/5/3 | 利用窗口处理                                       |
|           | [Z字形变换](./src/com/me/leetcode/practice/StringPractice.java) | 🌟🌟   |                                                              | 2020/5/3 | 需要了解Z字的周期是多少                            |
|           | [整数反转](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟    |                                                              | 2020/5/3 | 在添加新元素前判断是否会越界                       |
|           | [字符串转整数](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟🌟   |                                                              | 2020/5/3 |                                                    |
|           | [罗马数字转整数](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟    |                                                              | 2020/5/3 |                                                    |
|           | [合并两个有序链表](./src/com/me/leetcode/linkedlist/LinkedList.java) | 🌟    |                                                              | 2020/5/3 |                                                    |
|           | [删除有序数组中的重复元素](./src/com/me/leetcode/practice/ArrayPractice.java) | 🌟    |                                                              | 2020/5/3 |                                                    |
|           | [外观数列](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟    | [题目详细描述](https://leetcode-cn.com/problems/count-and-say/) | 2020/5/3 |                                                    |
|           | [买卖股票的最佳时机](./src/com/me/leetcode/solution/Solution.java) | 🌟    |                                                              | 2020/5/3 | 依次计算当前能赚取的最大利润                       |
|           | [环形链表](./src/com/me/leetcode/linkedlist/LinkedList.java) | 🌟    |                                                              | 2020/5/3 | 使用快慢指针，快慢指针还用于解决**固定间隔**的问题 |
|           | [快乐数](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟    |                                                              | 2020/5/3 | 本质是检测是否成环，使用快慢指针                   |
|           | [单链表反转](./src/com/me/leetcode/linkedlist/LinkedList.java) | 🌟    |                                                              | 2020/5/3 |                                                    |
|           | [盛最多水的容器](./src/com/me/leetcode/solution/Solution.java) | 🌟🌟   | [题目图解](https://leetcode-cn.com/problems/container-with-most-water/) | 2020/5/4 | 双指针，两端向中间逼近                             |
|           | [数字转罗马数字](./src/com/me/leetcode/practice/IntegerPractice.java) | 🌟🌟   |                                                              | 2020/5/4 | 贪心算法，将可供选择的数字逆序暂存，每次选择最大的 |
|           | [删除倒数第K个节点](./src/com/me/leetcode/linkedlist/LinkedList.java) | 🌟🌟   |                                                              | 2020/5/4 | 快慢指针                                           |
|           | [两两交换链表中的节点](./src/com/me/leetcode/linkedlist/LinkedList.java) | 🌟🌟   |                                                              | 2020/5/4 | 画图求解                                           |
|           | [有效的数独](./src/com/me/leetcode/solution/Sudoku.java)     | 🌟🌟   | [题目详细描述](https://leetcode-cn.com/problems/valid-sudoku/) | 2020/5/4 | 暴力法，依次验证每个位置是否合法，包括行、列、3\*3 |
|           | [跳跃游戏2](./src/com/me/leetcode/dynamicprogramming/Jump.java) | 🌟🌟🌟  |                                                              | 2020/5/4 | 贪心算法，或者动态规划；推荐贪心算法，效率更高     |
|           |                                                              |      |                                                              |          |                                                    |



