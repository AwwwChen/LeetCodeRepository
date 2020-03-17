import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

 // 解法三：利用Java的Comparator比较器 匿名创建比较器
// @lc code=start
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // 创建匿名的比较器
        // Java中PriorityQueue实现的是最小堆
        // PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a, Integer b) {
        //         return map.get(a) - map.get(b);
        //     }
        // });
        // 进一步优化，创建lambda表达式
        PriorityQueue<Integer> queue = new PriorityQueue<>( (a, b) -> map.get(a) - map.get(b));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry.getKey());
            } else {
                if (map.get(queue.peek()) < entry.getValue()) {
                    queue.remove();
                    queue.add(entry.getKey());
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }
}
// @lc code=end

class Solution2 {
    private class Frequency{
        int e;
        int freq;
        public Frequency(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        public int getElement() {
            return this.e;
        }

        public int getFreq() {
            return this.freq;
        }

        // @Override
        // public int compareTo(Frequency another) {
        //     if (this.freq > another.freq)
        //         return 1;
        //     else if (this.freq < another.freq)
        //         return -1;
        //     else
        //         return 0;
        // }
    }

    // 解法一：
    private class FreqComparator implements Comparator<Frequency> {
        @Override
        public int compare(Frequency a, Frequency b) {
            return a.freq - b.freq;
        }
    }

    // 解法二：
    private class MapEntryComparator implements Comparator<Map.Entry<Integer, Integer>> {
        @Override
        public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
            return a.getValue() - b.getValue();
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // Java中PriorityQueue实现的是最小堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new MapEntryComparator());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.add(entry);
            } else {
                if (queue.peek().getValue() < entry.getValue()) {
                    queue.remove();
                    queue.add(entry);
                }
            }
        }
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(queue.poll().getKey());
        }
        return list;
    }
}