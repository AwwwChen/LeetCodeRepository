/*
 * @lc app=leetcode.cn id=307 lang=java
 *
 * [307] 区域和检索 - 数组可修改
 */

// @lc code=start
// 解法一：这个问题是303问题的升级版，这个问题需要更新区间存储的数据
class NumArray { 
    private Integer[] data; 
    private Integer[] tree;

    public void update(int i, int val) {
        set(i, val);
    }

    private void set(int index, int e) {
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException();
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    // 递归从下更新到上
    private void set(int treeIndex, int l, int r, int index, int e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            this.data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                this.data[i] = nums[i];
            }
            this.tree = new Integer[nums.length * 4];
            buildSegmentTree(0, 0, data.length - 1);
        }
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChildIndex, l, mid);
        buildSegmentTree(rightChildIndex, mid + 1, r);
        tree[treeIndex] = tree[leftChildIndex] + tree[rightChildIndex];
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
    
    public int sumRange(int i, int j) {
        return queryTree(0, 0, data.length - 1, i, j);
    }

    private Integer queryTree(int treeIndex, int l, int r, int i, int j) {
        if (l == i && r == j) {
            return this.tree[treeIndex];
        }
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        if (j <= mid ) {
            return queryTree(leftChildIndex, l, mid, i, j);
        } else if (i >= mid + 1) {
            return queryTree(rightChildIndex, mid + 1, r, i, j);
        } else {
            return queryTree(leftChildIndex, l, mid, i, mid) + queryTree(rightChildIndex, mid + 1, r, mid + 1, j);
        }
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end


// 解法二：这个解法效率很低
class NumArray2 {
    // sums[i]存储前i个元素的和
    private int[] sums;
    private int[] data;

    public NumArray(int[] nums) {
        data = new int[nums.length];
        for (int i = 0; i < nums.length; i ++)
            data[i] = nums[i];
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i ++) {
            sums[i + 1]  = sums[i] + nums[i]; 
        }
    }

    public void update(int i, int val) {
        data[i] = val;
        for (int index = i; index < data.length; index ++) {
            sums[index + 1] = sums[index] + data[index];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}