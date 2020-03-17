/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    List<List<String>> results = new ArrayList<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        TreeMap<String, List<String>> treeMap = new TreeMap<String, List<String>>((a , b) -> {
            int[] table = new int[26];
            if (a.length() != b.length()) return a.length() - b.length();
            for (int i = 0; i < a.length(); i ++) table[a.charAt(i) - 'a'] ++;
            for (int i = 0; i < b.length(); i ++) table[b.charAt(i) - 'a'] --;
            for (int i = 0; i < table.length; i ++) {
                if (table[i] != 0) {
                    return 1;
                }
            }
            return 0;
        });

        for (int i = 0; i < strs.length; i ++) {
            if (!treeMap.containsKey(strs[i])) {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                treeMap.put(strs[i], list);
            } else {
                List<String> list = treeMap.get(strs[i]);
                list.add(strs[i]);
                treeMap.put(strs[i], list);
            }
        }
        for (String key : treeMap.keySet()) {
            results.add(treeMap.get(key));
        }
        return results;
    }
}
// @lc code=end

