import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;
/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 */

// @lc code=start
// 解法一：基于集合
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums1.length; i ++) {
            set.add(nums1[i]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i ++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i ++)
            ret[i] = list.get(i);
        return ret;
    }
}
// @lc code=end

