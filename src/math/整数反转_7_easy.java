import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
// 解法二：更简洁的解法，判断溢出条件

class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0)  {
            flag = true;
            x = -x;
        }
        int res = 0;
        while (x != 0) {
            int temp = x % 10;
            x = x / 10;
            if (res > Integer.MAX_VALUE / 10) {
                return 0;
            } else if (res == Integer.MAX_VALUE / 10 && temp > 7) {
                return 0;
            } else {
                res = res * 10 + temp;
            }
        }
        if (flag) return -res;
        else return res;
    }
}
// @lc code=end

// 解法一：弹出和推入数字 & 溢出前进行检查
class Solution2 {
    public int reverse(int x) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0 ) {
            x = - x;
            flag = true;
        }
        while(x != 0) {
            stack.push(x % 10);
            x = x / 10;
        }
        int res = 0;
        int i = 0;
        while(!stack.isEmpty()) {
            int temp = stack.pop();
            if (i == 0 && temp == 0)  {
                continue;
            } else {
                if (temp >= 2 && res >)
                res += temp * Math.pow(10, i);
                i ++;
            }
        }
        if (res == Integer.MAX_VALUE) return 0;
        if (flag) return -res;
        else return res;
    }
}


