/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return results;
        Arrays.sort(nums);
        permuteUniqueCore(nums, 0, new ArrayList<>());
        return results;
    }

    private void permuteUniqueCore(int[] nums, int index, List<Integer> result) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        Set<Integer> used = new HashSet<>();
        for (int i = index; i < nums.length; i ++) {
            if (used.contains(nums[i])) continue;
            swap(nums, i, index);
            used.add(nums[index]);
            result.add(nums[index]);
            permuteUniqueCore(nums, index + 1, result);
            result.remove(result.size() - 1);
            swap(nums, i, index);
        }
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
// @lc code=end

