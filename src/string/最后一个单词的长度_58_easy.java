/*
 * @lc app=leetcode.cn id=58 lang=java
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String res = s.trim();
        if (res.length() == 0) return 0;

        int count = 0;
        for (int i = res.length() - 1; i >= 0; i -- ) {
            if (!(res.charAt(i) >= 'a' && res.charAt(i) <= 'z') && !(res.charAt(i) >= 'A' && res.charAt(i) <= 'Z')) {
                break;
            }
            count ++;
        }
        return count;
    }
}
// @lc code=end

