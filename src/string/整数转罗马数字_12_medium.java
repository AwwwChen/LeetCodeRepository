/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
// 解法一：每一步都使用当前较大的罗马数字作为加法因子，最后得到罗马数字表示就是长度最少的。
//        其实本质是贪心算法的思路
class Solution {
    public String intToRoman(int num) {
        StringBuilder roman = new StringBuilder();
        if (num >= 1000) {
            int count = num / 1000;
            for (int i = 0 ; i < count; i ++)
                roman.append("M");
            num = num % 1000;
        }
        if (num >= 900) {
            num = num - 900;
            roman.append("CM");
        }
        if (num >= 500) {
            num = num - 500;
            roman.append("D");
        }
        if (num >= 400) {
            num = num - 400;
            roman.append("CD");
        }
        if (num >= 100) {
            int count = num / 100;
            for (int i = 0 ; i < count; i ++)
                roman.append("C");
            num = num % 100;
        }
        if (num >= 90) {
            num = num - 90;
            roman.append("XC");
        }
        if (num >= 50) {
            num = num - 50;
            roman.append("L");
        }
        if (num >= 40) {
            num = num - 40;
            roman.append("XL");
        }
        if (num >= 10) {
            int count = num / 10;
            for (int i = 0 ; i < count; i ++)
                roman.append("X");
            num = num % 10;
        }
        if (num == 9)
            return roman.append("IX").toString();
        if (num >= 5) {
            num = num - 5;
            roman.append("V");
        }
        if (num == 4) 
            return roman.append("IV").toString();
        
        for (int i = 0 ; i < num; i ++)
            roman.append("I");

        return roman.toString();
    }
}
// @lc code=end

