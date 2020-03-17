/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private String[] alphabetTable = new String[] {
        "", "",
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz",
    };
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        letterCombinationsCore(digits.toCharArray(), 0, new StringBuilder(), result);
        return result;
    }

    private void letterCombinationsCore(char[] digits, int index, StringBuilder tempString, List<String> result) {
        if (tempString.length() == digits.length) {
            result.add(tempString.toString());
            return;
        }
        char[] nowChars = alphabetTable[digits[index] - '0'].toCharArray();
        for (int i = 0; i < nowChars.length; i ++) {
            tempString.append(nowChars[i]);
            letterCombinationsCore(digits, index + 1, tempString, result);
            tempString.deleteCharAt(tempString.length() - 1);            
        }
    }
}
// @lc code=end

