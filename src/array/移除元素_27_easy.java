/*
 * @lc app=leetcode.cn id=27 lang=java
 *
 * [27] 移除元素
 */

// @lc code=start
// 解法二：快慢指针
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

// 解法一：前后指针
class Solution1 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            if (nums[i] == val && nums[j] != val) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j --;
                i ++;
                count ++;
            } else if (nums[i] != val && nums[j] != val) {
                i ++;
            } else if (nums[j] == val) {
                count++;
                j --;
            }
        }
        return nums.length - count;
    }
}
// @lc code=end

