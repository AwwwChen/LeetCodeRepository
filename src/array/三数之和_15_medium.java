import java.util.*;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
// 解法二：排序 + twosum的优化 注意跳过重复元素
class Solution {
    private List<List<Integer>> results;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        results = new ArrayList<>();
        for (int i = 0; i < nums.length - 2;) {
            int target = -nums[i];
            // two sum 的做法
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    results.add(temp);
                    l ++; r --;
                    while (l < r && nums[l] == nums[l - 1]) l ++;
                    while (l < r && nums[r] == nums[r + 1]) r --;
                } else if (nums[l] + nums[r] < target) l ++;
                else r --;
            }
            i ++;
            while (i < nums.length - 2 && nums[i] == nums[i - 1]) i ++;
        }
        return results;
    }
}

// 解法一：排序 + 暴力解 会超时
class Solution1 {
    private List<List<Integer>> results;
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        results = new ArrayList<>();
        HashSet<Integer> first = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i ++) {
            if (first.contains(nums[i])) continue;
            boolean flag1 = false;
            HashSet<Integer> second = new HashSet<>();
            for (int j = i + 1; j < nums.length - 1; j ++) {
                if (second.contains(nums[j])) continue;
                HashSet<Integer> third = new HashSet<>();
                for (int k = j + 1; k < nums.length; k ++) {
                    if (third.contains(nums[k])) continue;
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        results.add(temp);
                    }
                    third.add(nums[k]);
                }
                second.add(nums[j]);
            }
            first.add(nums[i]);
        }
        return results;
    }
}
// @lc code=end

