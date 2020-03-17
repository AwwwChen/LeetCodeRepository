import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new LinkedList<LinkedList<Integer>>();
        if (nums == null || nums.length < 3) return results;
        Arrays.sort(nums);
        int s = 0;
        int t = nums.length - 1;
        while (t - s >= 2) {
            if (nums[s] + nums[t] < 0) {
                if ()
            }
        

        } 
    }
}
// @lc code=end

