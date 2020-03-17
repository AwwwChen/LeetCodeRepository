/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int answer, preAnswer;
        answer = 2;
        preAnswer = 1;
        for (int i = 3; i <= n; i ++) {
            int temp = answer;
            answer = answer + preAnswer;
            preAnswer = temp;
        }
        return answer;
    }
}
// @lc code=end

