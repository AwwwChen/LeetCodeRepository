/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length < 9 || board[0].length < 9) return false;
        boolean[][] columns = new boolean[9][10];
        boolean[][] rows = new boolean[9][10];
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                boolean[] temp = new boolean[10];
                for (int row = i; row < i + 3; row ++) {
                    for (int col = j; col < j + 3; col ++) {
                        if (board[row][col] != '.') {
                            int num = board[row][col] - '0';
                            
                            if (rows[row][num]) return false;
                            else rows[row][num] = true;
                            if (columns[col][num]) return false;
                            else columns[col][num] = true;
                            if (temp[num]) return false;
                            else temp[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }
}
// @lc code=end

