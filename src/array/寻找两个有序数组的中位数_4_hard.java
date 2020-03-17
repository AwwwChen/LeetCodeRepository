/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个有序数组的中位数
 */

// @lc code=start
// 解法一：分三种情况考虑
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        if (nums2[nums2.length - 1] <= nums1[0]) {
            if ((nums2.length + nums1.length) % 2 == 1) {
                int mid = (nums2.length + nums1.length) / 2;
                if (mid <= nums2.length - 1)
                    return nums2[mid];
                else
                    return nums1[mid - nums2.length];
            } else {
                int rMid = (nums2.length + nums1.length) / 2;
                int lMid = rMid - 1;
                if (lMid >= nums2.length)
                    return (nums1[rMid - nums2.length] + nums1[lMid - nums2.length]) / 2.0;
                else if (rMid >= nums2.length - 1)
                    return (nums2[rMid] + nums2[lMid]) / 2.0;
                else 
                    return (nums2[rMid] + nums1[0]) / 2.0;

            }
        } else if (nums1[nums2.length - 1] <= nums2[0]) {
            if ((nums2.length + nums1.length) % 2 == 1) {
                int mid = (nums2.length + nums1.length) / 2;
                if (mid <= nums1.length - 1)
                    return nums1[mid];
                else
                    return nums2[mid - nums1.length];
            } else {
                int rMid = (nums2.length + nums1.length) / 2;
                int lMid = rMid - 1;
                if (lMid >= nums1.length)
                    return (nums2[rMid - nums1.length] + nums2[lMid - nums1.length]) / 2.0;
                else if (rMid >= nums1.length - 1)
                    return (nums1[rMid] + nums1[lMid]) / 2.0;
                else 
                    return (nums1[rMid] + nums2[0]) / 2.0;

            }
        } else {


        }
    }
}
// @lc code=end

