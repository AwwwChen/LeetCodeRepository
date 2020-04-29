
import java.util.*;
/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */

// @lc code=start
// 解法一：思路同《三数之和》
class Solution {
    private List<List<Integer>> results;
    public List<List<Integer>> fourSum(int[] nums, int target) {
        results = new ArrayList<>();
        if (nums == null || nums.length < 4) return results;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i = updateI(nums, i)) {

            // 优化：增加减支策略
            // 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏
            int min =nums[i] + nums[i + 1]+ nums[i + 2] + nums[i + 3];
            if( min > target){
                break;
            }
            // 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略
            int max = nums[i] + nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3];
            if(max < target){
                continue;
            }
            // 确定后两个元素
            for (int j = i + 1; j < nums.length - 2; j = updateJ(nums, j)) {
                int t = target - nums[i] - nums[j];
                int l = j + 1;
                int r = nums.length - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == t) {
                        List<Integer> result = new ArrayList<>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[l]);
                        result.add(nums[r]);
                        results.add(result);
                        l ++; r --;
                        while (l < r && nums[l] == nums[l - 1]) l++;
                        while (r > l && nums[r] == nums[r + 1]) r--;
                    } else if (nums[l] + nums[r] < t) {
                        l ++;
                    } else {
                        r --;
                    }
                }
            }
        }
        return results;
    }

    // i 移动到下一个不重复的位置
    private int updateI(int[] nums, int i) {
        i ++;
        while(i < nums.length - 3 && nums[i] == nums[i - 1]) i ++;
        return i;
    }

    // j 移动到下一个不重复的位置
    private int updateJ(int[] nums, int j) {
        j ++;
        while(j < nums.length - 2 && nums[j] == nums[j - 1]) j ++;
        return j;
    }
}
// @lc code=end
