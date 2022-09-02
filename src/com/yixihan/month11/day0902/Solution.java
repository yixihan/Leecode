package com.yixihan.month11.day0902;

/**
 * 给定一个二叉树的 root ，返回 最长的路径的长度 ，这个路径中的 每个节点具有相同值 。 这条路径可以经过也可以不经过根节点。
 * <p>
 * 两个节点之间的路径长度 由它们之间的边数表示。
 * <p>
 * 输入：root = [5,4,5,1,1,5]
 * 输出：2
 * <p>
 * 输入：root = [1,4,5,4,4,5]
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-09-02-12:31
 */
public class Solution {

    int maxLen = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root != null) {
            dfs (root, 0);
        }
        return maxLen;
    }

    private int dfs(TreeNode r, int val) {
        if (r == null) {
            return 0;
        }
        int left = dfs (r.left, r.val);
        int right = dfs (r.right, r.val);
        maxLen = Math.max (maxLen, left + right);
        if (r.val == val) {
            return Math.max (left, right) + 1;
        }
        return 0;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
