/*
 * @lc app=leetcode.cn id=303 lang=java
 *
 * [303] 区域和检索 - 数组不可变
 */

// @lc code=start
// 解法二：基于动态规划的思想
class NumArray {
    // sums[i]存储前i个元素的和
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];
        sums[0] = 0;
        for (int i = 0; i < nums.length; i ++) {
            sums[i + 1]  = sums[i] + nums[i]; 
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
// @lc code=end

// 解法一：使用线段树解决（这题使用线段树会慢，因为数据是不会改变的，所以不适合用线段树）
class NumArray1 {
    private Integer[] data; 
    private Integer[] tree;

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
