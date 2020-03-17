/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    private List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (target < 0 || candidates == null || candidates.length == 0) return results;
        Arrays.sort(candidates);
        combinationSumCore(candidates, target, 0, new ArrayList<>());
        return results;
    }

    private void combinationSumCore(int[] candidates, int target, int index, List<Integer> result) {
        if (target < 0) return;
        else if (target == 0) {
            results.add(new ArrayList<>(result));
        }
        for (int i = index; i < candidates.length; i = nextIndex(candidates, i) ) {
            result.add(candidates[i]);
            combinationSumCore(candidates, target - candidates[i], i + 1, result);
            result.remove(result.size() - 1);
        }
    }

    private int nextIndex(int[] candidates, int index) {
        int i;
        for (i = index; i < candidates.length; i ++) {
            if (candidates[index] != candidates[i]) break;
        }
        return i;
    }
}
// @lc code=end

