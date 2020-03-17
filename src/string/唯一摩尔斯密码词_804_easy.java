import java.util.TreeSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new TreeSet<>();
        for (String word : words) {
            char[] charTemp = word.toCharArray();
            StringBuilder str = new StringBuilder();
            for (char c : charTemp) {
                str.append(codes[c - 'a']);
            }
            set.add(str.toString());
        }
        return set.size();
    }
}
// @lc code=end

