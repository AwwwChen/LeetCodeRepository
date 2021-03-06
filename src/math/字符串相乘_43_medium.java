/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "";
        if (num1.equals("0") || num2.equals("0")) return "0";
        // 让num2.length() <= num1.length()
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        String cur = "";
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder a = new StringBuilder();
            int numi = num2.charAt(i) - '0';
            int flag = 0;
            for (int j = num1.length() - 1; j >= 0; j--) {
                int numj = num1.charAt(j) - '0';
                if (numj * numi + flag >= 10) {
                    a.append((numj * numi + flag) % 10);
                    flag = (numj * numi + flag) / 10;
                } else {
                    a.append(numj * numi + flag);
                    flag = 0;
                }
            }
            if (flag != 0) {
                a.append(flag);
                flag = 0;
            }
            a.reverse();
            for (int k = 1; k < num2.length() - i; k ++) a.append('0');
            if (!cur.equals("")) cur = add(cur, a.toString());
            else cur = a.toString();
        }
        return cur;
    }
    
    public String add(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int flag = 0;

        // 让num2.length() <= num1.length()
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        int j = num1.length() - 1;
        for (int i = num2.length() - 1; i >= 0; i --) {
            int a = num2.charAt(i) - '0';
            int b = num1.charAt(j) - '0';
            if ( a + b + flag >= 10) {
                res.append((a + b + flag) % 10);
                flag = 1;
            } else {
                res.append(a + b + flag);
                flag = 0;
            }
            j--;
        }
        for (; j >= 0; j--) {
            int a = num1.charAt(j) - '0';
            if (a + flag >= 10) {
                res.append(String.valueOf((a + flag) % 10));
                flag = 1;
            } else {
                res.append(String.valueOf(a + flag));
                flag = 0;
            }
        }
        if (flag == 1) res.append('1');
        return res.reverse().toString();
    }
}
// @lc code=end

