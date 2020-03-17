import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

// @lc code=start
// 解法二：

class MapSum {
    private class Node {
        int value;
        Map<Character, Node> next;

        public Node() {
            this.next = new TreeMap<>();
        }
    }
    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        this.root = new Node();
    }

    private int getValue(String key) {
        Node cur = root;
        for (int i = 0; i < key.length(); i ++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c))
                return 0;
            cur = cur.next.get(c);
        }
        return cur.value;
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i ++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            } 
            cur = cur.next.get(c);
        }
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        int sum = 0;
        for (int i = 0; i < prefix.length(); i++ ){
            char c = prefix.charAt(i);
            if(!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        // 递归到底 但是这步可以省略
        // if (node.next.size() == 0) 
        //     return node.value;
        int res = node.value;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
// @lc code=end
// 解法一：
//字典树每个节点存储当前前缀的键值的总和 sum
//字典树指向词末尾节点的值定义为 value
class MapSum1 {
    private class Node {
        boolean isWord;
        int value;
        int sum;
        Map<Character, Node> next;

        public Node() {
            this.next = new TreeMap<>();
            this.isWord = false;
        }
    }
    private Node root;
    private int size;

    /** Initialize your data structure here. */
    public MapSum1() {
        this.root = new Node();
    }

    private int getValue(String key) {
        Node cur = root;
        for (int i = 0; i < key.length(); i ++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c))
                return 0;
            cur = cur.next.get(c);
        }
        if (!cur.isWord) return 0;
        return cur.value;
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        int value = getValue(key);
        for (int i = 0; i < key.length(); i ++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
                cur.next.get(c).sum = val;
            } else {
                cur.next.get(c).sum = cur.next.get(c).sum - value + val;
            }
            cur = cur.next.get(c);
        }
        cur.isWord = true;
        cur.value = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i ++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            } else {
                cur = cur.next.get(c);
            }
        }
        return cur.sum;
    }
}

