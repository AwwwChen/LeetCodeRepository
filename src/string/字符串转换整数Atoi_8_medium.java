/*
 * @lc app=leetcode.cn id=8 lang=java
 *
 * [8] 字符串转换整数 (atoi)
 */

// @lc code=start
class Solution {
    String maxInt = String.valueOf(Integer.MAX_VALUE);
    String minInt = String.valueOf(Integer.MIN_VALUE);

    public int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;
        boolean positiveFlag = true;
        boolean numFlag = false;
        boolean zeroFlag = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '+') positiveFlag = true;
            else if (i == 0 && str.charAt(i) == '-') positiveFlag = false;
            else {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') break;
                if (str.charAt(i) == '0' && !numFlag) {
                    zeroFlag = true;
                    continue;
                }
                numFlag = true;
                res.append(str.charAt(i));
            }
        }

        // 检查整数是否合法：
        if (res.length() == 0) {
            // if (zeroFlag == true) return 0;
            return 0;
        } else if (!checkBound(res.toString(), positiveFlag)) {
            if (positiveFlag) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (positiveFlag) {
            return Integer.valueOf(res.toString());
        } else {
            return Integer.valueOf(res.insert(0, '-').toString());
        }
    }

    private boolean checkBound(String res, boolean flag) {
        if (flag) {
            if (res.length() > maxInt.length()) return false;
            else if (res.length() < maxInt.length()) return true;
            else {
                if (res.compareTo(maxInt) > 0) return false;
                else return true;
            }
        } else {
            if (res.length() + 1 > minInt.length()) return false;
            else if (res.length() + 1 < minInt.length()) return true;
            else {
                if (res.compareTo(minInt.substring(1, minInt.length())) > 0) return false;
                else return true;
            }
        }
    }
}
// @lc code=end

