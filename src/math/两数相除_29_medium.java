






/*
 * @lc app=leetcode.cn id=29 lang=java
 *
 * [29] 两数相除
 */

// @lc code=start
// 解法一：加减模拟除法
class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) throw new IllegalArgumentException();
        if (dividend == 0) return 0;

        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            int count = 0;
            if (dividend > 0) {
                // 剪支
                if ( divisor == 1) return dividend;
                else if (divisor == 2) return dividend >> 1;
                while (dividend >= divisor) {
                    dividend -= divisor;
                    count ++;
                }
            } else {
                // 剪支
                if (divisor == -1 && dividend != Integer.MIN_VALUE) return -dividend;
                if (divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;
                if (divisor == -2 && dividend != Integer.MIN_VALUE) return (-dividend) >> 1;
                if (divisor == -2 && dividend == Integer.MIN_VALUE) return (Integer.MAX_VALUE >> 1) + 1;
                while (dividend <= divisor) {
                    dividend -= divisor;
                    count ++;
                    if (count == Integer.MAX_VALUE) break;
                } 
            }
            return count;
        } else {
            int count = 0;
            if (dividend > 0) {
                // 剪支
                if ( divisor == -1) return -dividend;
                if ( divisor == -2) return -(dividend >> 1);
                while (-dividend <= divisor) {
                    dividend += divisor;
                    count --;
                }
            } else {
                // 剪支
                if (divisor == 1) return dividend;
                if (divisor == 2 && dividend != Integer.MIN_VALUE) return - ((-dividend) >> 1);
                if (divisor == 2 && dividend == Integer.MIN_VALUE) return - ((Integer.MAX_VALUE >> 1) + 1);
                while(dividend <= - divisor) {
                    dividend += divisor;
                    count --;
                }
            }
            return count;
        }

    }
}
// @lc code=end
