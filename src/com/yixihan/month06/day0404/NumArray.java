package com.yixihan.month06.day0404;

/**
 * 给你一个数组 nums ，请你完成两类查询。
 * <p>
 * 其中一类查询要求 更新 数组 nums 下标对应的值
 * 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 * <p>
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和
 * （即，nums[left] + nums[left + 1], ..., nums[right]）
 * <p>
 * <p>
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * <p>
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 *
 * @author : yixihan
 * @create : 2022-04-04-15:50
 */
public class NumArray {
    int[] tree;
    int[] nums;
    int n;

    public void buildTree(int node, int start, int end) {
        if (start == end) {
            tree[node] = nums[start];
            return;
        }
        int mid = (start + end) >> 1;
        int left = node * 2 + 1;
        int right = node * 2 + 2;
        buildTree (left, start, mid);
        buildTree (right, mid + 1, end);
        tree[node] = tree[left] + tree[right];
    }

    public void updateTree(int idx, int node, int val, int start, int end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            nums[idx] = val;
            tree[node] = val;
        } else {
            int mid = (start + end) >> 1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;
            if (idx >= start && idx <= mid) {
                updateTree (idx, left, val, start, mid);
            } else {
                updateTree (idx, right, val, mid + 1, end);
            }

            tree[node] = tree[left] + tree[right];
        }
    }

    public int query(int L, int R, int node, int start, int end) {
        if (L > end || R < start) {
            return 0;
        }
        if (start == end) {
            return tree[node];
        }
        if (L <= start && end <= R) {
            return tree[node];
        } else {
            int mid = (start + end) >> 1;
            int left = node * 2 + 1;
            int right = node * 2 + 2;
            int ls = query (L, R, left, start, mid);
            int rs = query (L, R, right, mid + 1, end);
            return ls + rs;
        }
    }

    public NumArray(int[] nums) {
        n = nums.length;
        if (n == 0) {
            return;
        }
        this.nums = nums;
        tree = new int[n * 4];
        buildTree (0, 0, n - 1);
    }

    public void update(int i, int val) {
        updateTree (i, 0, val, 0, n - 1);
    }

    public int sumRange(int i, int j) {
        return query (i, j, 0, 0, n - 1);
    }
}
