/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (target < 0 || candidates == null || candidates.length == 0) return results;
        Arrays.sort(candidates);
        combinationSumCore(candidates, target, candidates[0], new ArrayList<>());
        return results;
    }

    private void combinationSumCore(int[] candidates, int target, int num, List<Integer> result) {
        if (target < 0) return;
        else if (target == 0) {
            results.add(new ArrayList<>(result));
        }
        int index = Arrays.binarySearch(candidates, num);
        for (int i = index; i < candidates.length; i ++ ) {
            result.add(candidates[i]);
            combinationSumCore(candidates, target - candidates[i], candidates[i], result);
            result.remove(result.size() - 1);
        }
    }
}
// @lc code=end

