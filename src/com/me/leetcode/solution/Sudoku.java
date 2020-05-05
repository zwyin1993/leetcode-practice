package com.me.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * 数独.
 *
 * @author zwyin
 */
public class Sudoku {
    /**
     * 有效的数独
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // 比较3*3方格内是否满足
                if ((row + 1) % 3 == 0 && (col + 1) % 3 == 0
                        && !isSamllSudokuOk(board, row, col)) {
                    return false;
                }
                // 判断当前行和列是否满足
                if (board[row][col] == '.') {
                    continue;
                }
                if (!isOk(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSamllSudokuOk(char[][] board, int row, int col) {
        Set<Character> set = new HashSet<>();
        for (int i = row - 2; i <= row; i++) {
            for (int j = col - 2; j <= col; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
        }
        return true;
    }

    private boolean isSamllSudokuOk1(char[][] board, int row, int col) { // 使用数组代替set
        boolean[] status = new boolean[9];
        for (int i = row - 2; i <= row; i++) {
            for (int j = col - 2; j <= col; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int index = board[i][j] - '1'; // 下标从0开始
                if (status[index]) { // 如果已经存在
                    return false;
                } else {
                    status[index] = true;
                }
            }
        }
        return true;
    }

    private boolean isOk(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == board[row][col]) {
                return false;
            }
        }

        for (int i = 0; i < col; i++) {
            if (board[row][i] == board[row][col]) {
                return false;
            }
        }
        return true;
    }


}
