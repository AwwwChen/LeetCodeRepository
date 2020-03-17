import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * @lc app=leetcode.cn id=771 lang=java
 *
 * [771] 宝石与石头
 */

// @lc code=start
// 解法一：
class Solution {
    public int numJewelsInStones(String J, String S) {
        char[] charsS = S.toCharArray();
        char[] charsJ = J.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char j : charsJ) {
            set.add(j);
        }
        int count = 0;
        for (char s : charsS) {
            if (set.contains(s)) count++;
        }
        return count;
    }
}
// @lc code=end

