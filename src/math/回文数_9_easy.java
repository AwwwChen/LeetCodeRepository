import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
// 解法三：将整数的右半边反转，看反转后的数和余下的数是否相等。比如123321，翻转321->123，123==123所以返回true

// 解法二：将整数全部反转，看反转后的数是否相等
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int temp = x;
        int res = 0;
        // 整数反转
        while(temp != 0) {
            res = res * 10 + temp % 10;
            temp /= 10;
        }
        return x == res;
    }
}
// @lc code=end

// 解法一：将整数转为字符数组，然后使用左右指针解决
class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        ArrayList<Character> list = new ArrayList<>();
        
        while(x != 0) {
            list.add((char) (x % 10));
            x = x / 10;
        }
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (!list.get(r).equals(list.get(l))) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }
}