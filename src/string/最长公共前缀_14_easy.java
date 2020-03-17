/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
// 解法三：二分搜索
class Solution {
    public String longestCommonPrefix(String[] strs) {

    }
}

// 解法二：水平扫描
class Solution2 {
}

// 解法一：垂直扫描
class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int index = 0;
        int minLength = Integer.MAX_VALUE;
        StringBuilder res = new StringBuilder();
        while (true) {
            if (strs[0].length() == 0) return "";
            char c = strs[0].charAt(index);
            boolean flag = false;
            for (String str : strs) {
                if (str.length() < minLength) minLength = str.length();
                if (index >= str.length() || str.charAt(index) != c) {
                    flag = true;
                    break;
                }
            }
            if (!flag) res.append(c);
            if (flag || ++index >= minLength) break;
        }
        return res.toString();
    }
}
// @lc code=end

