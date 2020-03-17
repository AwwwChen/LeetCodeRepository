/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子序和
 */

// @lc code=start
// 解法二：分治法

// 连续子序列的最大和主要由这三部分子区间里元素的最大和得到：
// 第 1 部分：子区间 [left, mid - 1]；
// 第 2 部分：子区间 [mid + 1, right]；
// 第 3 部分：包含mid的子区间，即nums[mid]一定会被选取。
// 对它们三者求最大值即可。

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length - 1;
        return divideAndConquerCore(nums, start, end);
    }

    private int divideAndConquerCore(int[] nums, int start, int end) {
        if (start == end) return nums[end];
        if (start > end) return Integer.MIN_VALUE;
        int mid = (start + end) / 2;
        int leftmax = 0;
        int sum = 0;
        for (int i = mid - 1; i >= start; i --) {
            sum += nums[i];
            if (sum > leftmax) leftmax = sum;
        }
        int rightmax = 0;
        sum = 0;
        for (int i = mid + 1; i <= end; i ++) {
            sum += nums[i];
            if (sum > rightmax) rightmax = sum;
        }
        int midmax = rightmax + leftmax + nums[mid];
        return Math.max(midmax, Math.max(divideAndConquerCore(nums, start, mid - 1), divideAndConquerCore(nums, mid + 1, end)));
    }
}
// @lc code=end

// 解法一：剑指offer原题解法思路
class Solution1 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException();
        if (nums.length == 1) return nums[0];
        int sum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (sum < 0) sum = nums[i];
            else sum += nums[i];
            
            if (sum > max) max = sum;
        }
        return max;
    }
}