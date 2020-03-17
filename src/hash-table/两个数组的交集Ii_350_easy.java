import java.util.ArrayList;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=350 lang=java
 *
 * [350] 两个数组的交集 II
 */

// @lc code=start
// 解法一：基于映射表
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums1.length; i ++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums2.length; i ++) {
            if (map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                if (map.get(nums2[i]) == 1) map.remove(nums2[i]);
                else map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
// @lc code=end

