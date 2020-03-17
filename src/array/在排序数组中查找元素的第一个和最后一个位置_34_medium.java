/*
 * @lc app=leetcode.cn id=34 lang=java
 *
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 */

// @lc code=start
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};
        int[] result = new int[2];
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid + 1;
            else if (nums[mid] > target) end = mid;
            else if (nums[mid] == target) {
                result[0] = startIndex(nums, start, mid + 1, target);
                result[1] = endIndex(nums, mid, end, target);
                break;
            } 
        }
        if (start >= end) return new int[] {-1, -1};
        return result;
    }
    private int startIndex(int[] nums, int start, int end, int target) {
        if (start == end + 1) return start;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target && ((mid - 1) < start || nums[mid - 1] != target)) return mid;
        else if (nums[mid] == target) return startIndex(nums, start, mid, target);
        else { // nums[mid] < target
            return startIndex(nums, mid + 1, end, target);
        }
    }

    private int endIndex(int[] nums, int start, int end, int target) {
        if (start == end + 1) return start;
        int mid = start + (end - start) / 2;
        if (nums[mid] == target && ((mid + 1) >= end || nums[mid + 1] != target)) return mid;
        else if (nums[mid] == target) return endIndex(nums, mid + 1, end, target);
        else { // nums[mid] > target
            return endIndex(nums, start, mid, target);
        }
    }
}
// @lc code=end

