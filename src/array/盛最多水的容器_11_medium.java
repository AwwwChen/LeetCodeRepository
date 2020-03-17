/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max = 0;
        while (l < r) {
            if ((r - l) * Math.min(height[l], height[r]) > max) {
                max = (r - l) * Math.min(height[l], height[r]);
            }

            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
// @lc code=end

