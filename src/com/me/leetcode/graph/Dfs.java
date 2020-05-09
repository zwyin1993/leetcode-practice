package com.me.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * .
 *
 * @author zwyin
 */
public class Dfs {
    public void template(int[] nums) {
        List<int[]> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int[] selected = nums;
        dfs(path, selected, res);
    }

    private void dfs(List<Integer> path, int[] selected, List<int[]> res) {
        /*if (满足结束条件) {
            res.add(路径);
        }
        for 选择 in 选择列表 {
            做选择;
            dfs(path, selected, res);
            撤销选择;
        }*/
    }
}
