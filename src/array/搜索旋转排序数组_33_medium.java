/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0] == target) return 0;
        else if (nums.length == 1 && nums[0] != target) return -1;

        if (nums[0] < nums[nums.length - 1]) {
            int index = Arrays.binarySearch(nums, target);
            if (index < 0 || index >= nums.length || nums[index] != target) return -1;
            return index;
        } else if (target > nums[nums.length - 1] && target < nums[0]) {
            return -1;
        } else {
            int rMax = nums[nums.length - 1];
            int lMin = nums[0];
            boolean rflag = true;
            if (target <= rMax) rflag = true;
            else if (target >= lMin) rflag = false;
            // 二分搜索
            int start = 0;
            int end = nums.length;
            while (start < end) {
                int mid = (start + end) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] >= lMin && rflag) start = mid + 1;
                else if (nums[mid] <= rMax && !rflag) end = mid;
                else if (nums[mid] >= lMin && !rflag) {
                    if (nums[mid] > target) end = mid;
                    else start = mid + 1; 
                } else {
                    if (nums[mid] < target) start = mid + 1;
                    else end = mid; 
                }
            }
            return -1;
        }
    }
}
// @lc code=end

