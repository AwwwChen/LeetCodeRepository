/*
 * @lc app=leetcode.cn id=5 lang=java
 *
 * [5] 最长回文子串
 */

// @lc code=start
// 解法二：中心扩展算法 
// 遍历每一个中心（一共有2*n - 1）个 
// 从每个中心出发同时往左往右遍历直到第一个两边的字符不等
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        if (s.length() == 1) return s;
        int maxLength = 1;
        int index = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i ++) {
            if (i != s.length() - 1) {
                int record1 = 1 + longestPalindrome(s, i - 1, i + 1);
                int record2 = longestPalindrome(s, i, i + 1);
                if (record1 > record2) {
                    if (record1 > maxLength) {
                        flag = true;
                        index = i;
                        maxLength = record1;
                    }
                } else {
                    if (record2 > maxLength) {
                        flag = false;
                        index = i;
                        maxLength = record2;
                    }
                }
            } else {
                int record1 = 1 + longestPalindrome(s, i - 1, i + 1);
                if (record1 > maxLength) {
                    flag = true;
                    index = i;
                    maxLength = record1;
                }
            }
        }
        if (flag) {
            return s.substring(index - (maxLength - 1) / 2,  index + (maxLength - 1) / 2 + 1);
        } else {
            return s.substring(index - maxLength / 2 + 1, index + maxLength / 2 + 1);
        }
    }
    private int longestPalindrome(String s, int start, int end) {
        if (start < 0 || end >= s.length()) return 0;
        int count = 0;
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) count += 2;
            else break;
            start --;
            end ++;
        }
        return count;
    }
}
// @lc code=end

// 解法一：动态规划（未优化） 
// 定义:
//           P(i, j) = true  如果Si...Sj是回文子串
//           P(i, j) = false 如果Si...Sj不是回文子串
// 递推公式：
//           P(i, j) = P(i+1, j-1) && Si == Sj
// 时间复杂度：O(n^2); 空间复杂度：0(n^2)
class Solution1 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return s;
        if (s.length() == 1) return s;
        boolean [][] dp = new boolean [s.length()][s.length()];
        int maxj = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i ++) dp[i][i] = true;
        for (int i = 0; i < s.length() - 1; i ++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
            if (dp[i][i + 1]) {
                maxj = 1;
                l = i;
                r = i + 1;
            }
        }
        for (int j = 2; j < s.length(); j ++) {
            for (int i = 0; i < s.length() - j; i ++) {
                dp[i][i + j] = (s.charAt(i) == s.charAt(i + j)) && (dp[i + 1][i + j - 1]);
                if (dp[i][i + j] && (j > maxj)) {
                    maxj = j;
                    l = i;
                    r = i +j;
                } 
            }
        }
        return s.substring(l, r + 1);
    }
}