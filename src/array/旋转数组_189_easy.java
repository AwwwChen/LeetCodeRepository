/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
// 解法二：使用反转

class Solution {
    public void rotate(int[] nums, int k) {

    }
}

// @lc code=end

// 解法一：使用环状替换 
// 注意可能出现为完全交换完，就回到替换的初始位置的问题，比如当nums.length % k == 0 这种情况。
// 针对回到初始位置的问题，此时可能将下标值加1，继续下一轮替换。
class Solution1 {
    public void rotate(int[] nums, int k) {
        int temp;
        int t;
        int index;
        int count = 0;
        if (nums.length <= 1 || k == 0) return;

        for (int i = 0; i < nums.length; i ++) {
            index = i;
            temp = nums[index];
            do {
                count++;
                t = temp;
                temp = nums[(index + k) % nums.length];
                nums[(index + k) % nums.length] = t;
                index = (index + k) % nums.length;
                if (count == nums.length) return;
            } while (index != i);
        }
    }
}

