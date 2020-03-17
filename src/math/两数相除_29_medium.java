/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
class Solution {
    public int divide(int dividend, int divisor) {

        if (divisor == 0) throw new IllegalArgumentException();
        if (dividend == 0) return 0;

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            if (dividend < 0) { 
                dividend = -dividend;
                divisor = -divisor; 
            }
            if (Math.abs(dividend) < Math.abs(divisor)) return 0;
            else {
                int count = 0;
                while (dividend >= divisor) {
                    dividend -= divisor;
                    count ++;
                }
                return count;
            } 
        } else {
            if (dividend < 0) dividend = -dividend;
            if (divisor < 0) divisor = -divisor;
            int count = 0;
            while (dividend >= divisor) {
                dividend -= divisor;
                count ++;
            }
            return -count;
        }

    }
}
// @lc code=end

