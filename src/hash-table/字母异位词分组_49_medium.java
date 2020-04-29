
import java.util.*;
/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
// 解法二：存储标识字符串中字符记录作为键的哈希表
class Solution {
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            List<String> value;
            if (map.containsKey(key)) {
                value = map.get(key);
            } else {
                value = new ArrayList<>();
            }
            value.add(str);
            map.put(key, value);
        }
        for (String key : map.keySet()) {
            results.add(map.get(key));
        }
        return results;
    }

    private String getKey(String str) {
        int [] alphabet = new int [26];
        for (int i = 0; i < str.length(); i ++) {
            alphabet[str.charAt(i) - 'a'] ++;
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < alphabet.length; i ++) {
            res.append(alphabet[i]);
            res.append('#');
        }
        return res.toString();
    }
}
// @lc code=end

// 解法一：相当于暴力法 非常低效
class Solution1 {
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for (String str : strs) {
            if (results.size() == 0) {
                List<String> result = new ArrayList<>();
                result.add(str);
                results.add(result);
            } else {
                boolean flag = false;
                for (int i = 0; i < results.size(); i ++) {
                    List<String> result = results.get(i);
                    if (compareEqual(result.get(0), str)) {
                        result.add(str);
                        flag = true;
                    }
                }
                if (!flag) {
                    List<String> temp = new ArrayList<>();
                    temp.add(str);
                    results.add(temp);
                }
            }
        }
        return results;
    }

    public boolean compareEqual(String a, String b) {
        int[] table = new int[26];
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i ++) table[a.charAt(i) - 'a'] ++;
        for (int i = 0; i < b.length(); i ++) table[b.charAt(i) - 'a'] --;
        for (int i = 0; i < table.length; i ++) {
            if (table[i] != 0) {
                return false;
            }
        }
        return true;
    }
}