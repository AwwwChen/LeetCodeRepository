import java.util.HashMap;
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
// 解法二：借助HashMap + 双向链表实现
class LRUCache {

    class Node {
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.size = capacity;
        this.head = null;
        this.tail = null;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;
            if (tail != cur) {
                Node prev = cur.prev;
                Node next = cur.next;
                next.prev = prev;

                // node不是首节点
                if (prev != null) {
                    prev.next = next;
                    // node是首节点
                } else {
                    head = next;
                }

                cur.prev = tail;
                tail.next = cur;
                cur.next = null;
                tail = cur;
            }
        } else if (map.size() + 1 <= size) {
            Node cur = new Node(key, value);
            map.put(key, cur);
            if (map.size() == 1) {
                tail = cur;
                head = cur;
            } else {
                cur.prev = tail;
                cur.next = null;
                tail.next = cur;
                tail = cur;
            }
        } else {
            Node cur = head;
            if (head == tail) {
                head = tail = null;
            } else {
                head = cur.next;
                cur.next = null;
                head.prev = null;
            }
            map.remove(cur.key);
            put(key, value);
        }
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            if (tail != cur) {
                Node prev = cur.prev;
                Node next = cur.next;
                next.prev = prev;

                // node不是首节点
                if (prev != null) {
                    prev.next = next;
                    // node是首节点
                } else {
                    head = next;
                }

                cur.prev = tail;
                tail.next = cur;
                cur.next = null;
                tail = cur;
            }
            return cur.val;
        } else {
            return -1;
        }
    }
}

// 解法一：借助集合类的LinkedHashMap的特性，重写removeEldestEntry方法
// class LRUCache1 {
//     class Cache<K, V> extends LinkedHashMap<K, V> {
//         private int capacity;
        
//         public Cache(int capacity) {
//             // 一定要设置第三个参数为true 因为要按照访问顺序来排序
//             super(16, 0.75f, true);
//             this.capacity = capacity;
//         }
        
//         @Override
//         protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
//             return this.size() > this.capacity;
//         }
//     }
//     private LRUCache.Cache<Integer, Integer> cache;

//     public LRUCache1(int capacity) {
//         this.cache = new Cache<Integer, Integer>(capacity);
//     }
    
//     public int get(int key) {
//         if (this.cache.get(key) != null)
//             return this.cache.get(key);
//         return -1;
//     }
    
//     public void put(int key, int value) {
//         this.cache.put(key, value);
//     }
// }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

