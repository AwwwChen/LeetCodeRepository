/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        return binarySearch(nums, target, start, end);
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        // 二分搜索到最后一个位置要考虑如果元素不存在，是插入到当前元素的前面还是后面
        if (start == end) {
            if (nums[start] >= target) return start;
            else return start + 1;
        }
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) return binarySearch(nums, target, start, mid);
        else return binarySearch(nums, target, mid + 1, end);
    }
}
// @lc code=end

