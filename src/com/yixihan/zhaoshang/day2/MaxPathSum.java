package com.yixihan.zhaoshang.day2;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
 * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * @author : yixihan
 * @create : 2022-04-15-10:54
 */
public class MaxPathSum {

    int ans = -1001;

    public int maxPathSum(TreeNode root) {
        int newMax = dfs (root);
        return Math.max (ans, newMax);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1001;
        }

        int left = dfs (root.left);
        int right = dfs (root.right);

        ans = Math.max (ans, Math.max (root.val + left + right, Math.max (left, right)));

        return Math.max (root.val, Math.max (root.val + left, root.val + right));
    }

    public class TreeNode {
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
