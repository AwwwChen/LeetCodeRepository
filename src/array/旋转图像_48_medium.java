/*
 * @lc app=leetcode.cn id=48 lang=java
 *
 * [48] 旋转图像
 */

// @lc code=start
// 解法一：不是用辅助空间，原地变换
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) return;
        int length = matrix.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            int col = i;
            while (col < j) {
                int nowi = i;
                int nowj = col;
                // 坐标转换公式
                int nexti = nowj;
                int nextj = length - 1 - nowi;
                int temp = matrix[nowi][nowj];
                while (true) {
                    int t = temp;
                    temp = matrix[nexti][nextj];
                    matrix[nexti][nextj] = t;
                    nowi = nexti;
                    nowj = nextj;
                    if (nowi == i && nowj == col) break;
                    nexti = nowj;
                    nextj = length - 1 - nowi;
                }
                col ++;
            }
            i++;
            j--;
        }
    }
}
// @lc code=end

