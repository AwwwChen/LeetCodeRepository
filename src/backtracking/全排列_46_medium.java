/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
// 解法二：回溯法思路二（递归求解）
class Solution {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return results;
        List<Integer> result = new ArrayList<>();
        permuteCore(nums, 0, result);
        return results;
    }

    private void permuteCore(int[] nums, int index, List<Integer> result) {
        if (result.size() == nums.length) {
            results.add(new ArrayList<>(result));
            return;
        }
        for (int i = index; i < nums.length; i ++) {
            swap(nums, i, index);
            result.add(nums[index]);
            permuteCore(nums, index + 1, result);
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

// 解法一：回溯法（递归求解）
class Solution1 {
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return results;
        List<Integer> numslist = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) numslist.add(nums[i]);
        permute(numslist, nums.length, new ArrayList<>());
        return results;
    }

    private void permute(List<Integer> nums, int length, List<Integer> result) {
        if (result.size() == length) {
            results.add(new ArrayList<>(result));
        }

        for (int i = 0; i < nums.size(); i ++) {
            int num = nums.get(i);
            result.add(num);
            nums.remove(i);
            permute(nums, length, result);
            // 一定要保持原来nums里面元素的顺序，也就是插入到原来删除的位置
            nums.add(i, num);
            result.remove(result.size() - 1);
        }
    }
}
