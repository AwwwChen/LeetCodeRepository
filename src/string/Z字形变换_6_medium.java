import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
// 解法一：找规律
//  首行和尾行，相邻两字符的下标规律（下面实例的0  8 16）：
//          index = index + 2 * numRows - 2
//  非首行和尾行，当中会有一个多输出来的字符（下面实例的7 15），也要考虑进去：
//          index = index + 2 * numRows - 2 - 2 * i
//  注意判断是否还有下一个字符：index < s.length()
//  0         8          16
//  1      7  9       15 17
//  2    6    10    14   18
//  3  5      11 13
//  4         12 
class Solution2 {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < numRows; i ++) {
            StringBuilder res = new StringBuilder();
            int index = i;
            while (index < s.length()) {
                res.append(s.charAt(index));
                if (i == numRows - 1 && index + 2 * numRows - 2 >= s.length())
                    break;
                if (index + 2 * numRows - 2 - 2 * i >= s.length())
                    break;
                if (i != 0 && i != numRows - 1)
                    res.append(s.charAt(index + 2 * numRows - 2 - i * 2));
                index += 2 * numRows - 2;
            }
            str.append(res);
        }
        return str.toString();
    }
}


// 解法二：按行排序
//使用Math.min(numRows, s.length())个字符串来表示Z字形图案中的每一行。
//从左到右迭代s，将每个字符添加到合适的行。
//  可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
//  只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> strList = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i ++) {
            strList.add(new StringBuilder());
        }
        int index = 0;
        boolean reverse = false;
        for (int i = 0; i < s.length(); i ++) {
            strList.get(index).append(s.charAt(i));
            if (i % (numRows - 1) == 0)
                reverse = !reverse;
            if (reverse) index++;
            else index--;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : strList) {
            result.append(sb);
        }
        return result.toString();
    }
}
// @lc code=end

