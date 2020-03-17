/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int a = 0; 
        int b = 0;
        for (; ; ) {
            nums[a] = nums[b];
            while (b < nums.length && nums[b] == nums[a]) {
                b++;
            }
            if (b == nums.length) break;
            a++;
        }
        return a + 1;
    }
}
// @lc code=end

