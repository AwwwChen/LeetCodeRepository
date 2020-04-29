
import java.util.*;
/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */

// @lc code=start
// 解法一：思路同《三数之和》解法二
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length - 2;) {
            // two sum 的做法
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] + nums[i] < target) {
                    if (target - (nums[l] + nums[r] + nums[i]) < min) {
                        min = target - (nums[l] + nums[r] + nums[i]);
                        sum = nums[l] + nums[r] + nums[i];
                    }
                    l ++;
                    while (l < r && nums[l] == nums[l - 1]) l ++;
                } else {
                    if ((nums[l] + nums[r] + nums[i]) - target < min) {
                        min = (nums[l] + nums[r] + nums[i]) - target;
                        sum = nums[l] + nums[r] + nums[i];
                    }
                    r --;
                    while (l < r && nums[r] == nums[r + 1]) r --;
                }
            }
            i ++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i ++;
        }
        return sum;
    }
}
// @lc code=end
