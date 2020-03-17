/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] >= nums2[n]) {
                nums1[index] = nums1[m];
                m --;
                index --;
            } else if (nums1[m] < nums2[n]) {
                nums1[index] = nums2[n];
                n --;
                index --;
            }
        }
        if (m < 0 && n >= 0) {
            for (int i = n; i >= 0; i --) {
                nums1[i] = nums2[i];
            }
        }
        else if (m >= 0 && n < 0) {
            for (int i = m; i >= 0; i --) {
                nums1[i] = nums1[i];
            }
        }
    }
}
// @lc code=end

