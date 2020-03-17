import java.math.BigInteger;
/*
 * @lc app=leetcode.cn id=67 lang=java
 *
 * [67] 二进制求和
 */

// @lc code=start
// 解法二：位操作 需要转换为数字操作
// 33 位 1，不能转换为 Integer。
// 65 位 1，不能转换为 Long。
// 500000001 位 1，不能转换为 BigInteger。
class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        BigInteger aNum = new BigInteger(a, 2);
        BigInteger bNum = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);

        BigInteger res = aNum.xor(bNum);
        BigInteger carry = aNum.and(bNum).shiftLeft(1);
        while (carry.compareTo(zero) != 0) {
            BigInteger temp = res;
            res = res.xor(carry);
            carry = carry.and(temp).shiftLeft(1);
        }
        return res.toString(2);
    }
}
// @lc code=end


// 解法一：模拟进位
class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;
        
        boolean temp = false;
        StringBuilder res = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;
        while (aIndex >= 0 && bIndex >= 0) {
            if (a.charAt(aIndex) == '1' && b.charAt(bIndex) == '1') {
                if (temp) {
                    res.append('1');
                } else {
                    res.append('0');
                    temp = true;
                }
            } else if (a.charAt(aIndex) == '0' && b.charAt(bIndex) == '0') {
                if (temp) {
                    res.append('1');
                    temp = false;
                } else res.append('0');
            } else {
                if (temp) res.append('0');
                else res.append('1');
            }
            aIndex --;
            bIndex --;
        }
        int index = 0;
        String str = "";
        if (aIndex < 0 && bIndex < 0) {
            if (temp) return res.append('1').reverse().toString();
            else return res.reverse().toString();
        } else if (aIndex >= 0) {
            str = a.substring(0, aIndex + 1);
        } else {
            str = b.substring(0, bIndex + 1);
        }
        index = str.length() - 1;
        while (index >= 0) {
            if (temp && str.charAt(index) == '1') res.append('0');
            else if (temp && str.charAt(index) == '0') {
                res.append('1');
                temp = false;
            } else {
                res.append(str.charAt(index));
            }
            index --;
        }
        if (temp) return res.append('1').reverse().toString();
        else return res.reverse().toString();
    }
}