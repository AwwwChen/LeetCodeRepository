/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 外观数列
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String res = "1";
        for (int i = 2; i <= n; i ++) {
            res = countAndSayCore(res);
        }
        return res;
    }

    private String countAndSayCore(String str) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (true) {
            int count = 1;
            while (index + 1 < str.length() && str.charAt(index) == str.charAt(index + 1)) {
                count ++;
                index ++;
            }
            res.append(String.valueOf(count));
            res.append(str.charAt(index));
            index ++;
            if (index > str.length() - 1) break;
        }
        return res.toString();
    }
}
// @lc code=end

