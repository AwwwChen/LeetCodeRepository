import java.util.LinkedHashMap;
/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    class Cache<K, V> extends LinkedHashMap<K, V> {
        private int capacity;
        
        public Cache(int capacity) {
            // 一定要设置第三个参数为true 因为要按照访问顺序来排序
            super(16, 0.75f, true);
            this.capacity = capacity;
        }
        
        @Override
        protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
            return this.size() > this.capacity;
        }
    }
    private LRUCache.Cache<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.cache = new Cache<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        if (this.cache.get(key) != null)
            return this.cache.get(key);
        return -1;
    }
    
    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

