/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
// 解法：
// 1. 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
// 2. 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
// 3. 将 A[i] 与 A[k] 交换
// 4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
// 5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4

class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i] > nums[i - 1]) break;
            else i--;
        }
        if (i == 0) {
            // 改进的话也可以直接逆置数组
            Arrays.sort(nums);
            return;
        } else {
            int temp = nums[i - 1];
            int minDiff = Integer.MAX_VALUE;
            int minDiffIndex = i;
            for (int j = i; j < nums.length; j ++) {
                if (nums[j] - temp <= 0) continue;
                else {
                    if (nums[j] - temp < minDiff) {
                        minDiff = nums[j] - temp;
                        minDiffIndex = j;
                    }
                }
            }
            nums[i - 1] = nums[minDiffIndex];
            nums[minDiffIndex] = temp;
            // 改进的话也可以直接逆置数组
            Arrays.sort(nums, i, nums.length);
            return;
        }
    }
}
// @lc code=end

