/*
 * @lc app=leetcode.cn id=69 lang=java
 *
 * [69] x 的平方根
 */

// @lc code=start
class Solution {
    public int mySqrt(int x) {
        if (x < 0) throw new IllegalArgumentException();
        if (x == 0 || x == 1) return x;
        return mySqrtCore(x, 1, x);
    }

    private int mySqrtCore(int x, int start, int end) {
        if (start == end) return start;
        int mid = (start + end) / 2;

        if ((x / mid) >= mid && (x / (mid + 1) < (mid + 1))) return mid;
        else if ((x / (mid + 1) >= (mid + 1))) return mySqrtCore(x, mid, end);
        else return mySqrtCore(x, start, mid);
    }
}
// @lc code=end

