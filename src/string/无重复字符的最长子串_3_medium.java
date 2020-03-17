import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
// 解法一：指针加哈希表（滑动窗口）
class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int index = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                max = Math.max(max, i - index);
                if (map.get(chars[i]) >= index) 
                    index = map.get(chars[i]) + 1;
                map.put(chars[i], i);
            } else {
                map.put(chars[i], i);
            }
        }
        return Math.max(max, chars.length - index);
    }
}
// @lc code=end

