/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) throw new IllegalArgumentException();
        int temp = 1;
        int[] res = new int[digits.length];
        for (int i = digits.length - 1; i >= 0; i --) {
            if (digits[i] + temp >= 10) res[i] = 0;
            else {
                res[i] = temp + digits[i];
                temp = 0;
            }
        }
        if (temp == 1) {
            res = new int[digits.length + 1];
            Arrays.fill(res, 0);
            res[0] = 1;
        }
        return res;
    }
}
// @lc code=end

