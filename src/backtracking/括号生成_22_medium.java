import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
// 解法一：对于回溯法，如果递归函数用到了可变参数：
// 可变参数比如下面的Stack：那么在递归前后一定要恢复它原来的值（看下面代码注释1，2，3，4，5的地方）。
// 不可变参数比如下面的String，因为传的是副本所以不需要恢复原来的值。
class Solution {
    public List<String> generateParenthesis(int n) {
        return constructBrackets(n, new Stack<>(), 1, "");
    }

    private static List<String> constructBrackets(int n, Stack<Character> stack, int index, String str) {
        List<String> list = new ArrayList<>();
        if (index == 2 * n) {
            if (!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                if (stack.isEmpty()) {
                    // (1) 上面pop了这里一定要push
                    stack.push('(');
                    String s = str + ")";
                    list.add(s);
                    return list;
                }
                // (2) 上面pop了这里一定要push
                stack.push('(');
                return null;
            } else {
                return null;
            }
        }
        List<String> res = null;

        if (stack.isEmpty()) {
            stack.push('(');
            String s = str + "(";
            res = constructBrackets(n, stack, index + 1, s);
            if (res != null)
                list.addAll(res);
            // (3) 上面push了这里一定要pop
            stack.pop();
        } else {
            if (stack.peek() == '(') {
                stack.pop();
                String s = str + ")";
                res = constructBrackets(n, stack, index + 1, s);
                if (res != null)
                    list.addAll(res);
                // (4) 上面pop了这里一定要push
                stack.push('(');

                stack.push('(');
                s = str + "(";
                res = constructBrackets(n, stack, index + 1, s);
                if (res != null)
                    list.addAll(res);
                // (5) 上面push了这里一定要pop
                stack.pop();
            }
        }
        return list;
    }
}
// @lc code=end

