package com.yixihan.greedy;

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
 * @create : 2022-03-29-10:22
 */
public class MaxPathSum {
    int max = -1001;

    /**
     * 所有树的题目，都想成一颗只有根、左节点、右节点 的小树。然后一颗颗小树构成整棵大树，所以只需要考虑这颗小树即可。
     * 接下来分情况， 按照题意：一颗三个节点的小树的结果只可能有如下6种情况：
     * <p>
     * 根 + 左 + 右
     * 根 + 左
     * 根 + 右
     * 根
     * 左
     * 右
     * <p>
     * 好了，分析上述6种情况， 只有 2,3,4 可以向上累加，而1,5,6不可以累加
     * （这个很好想，情况1向上累加的话，必然出现分叉，情况5和6直接就跟上面的树枝断开的，没法累加），
     * 所以我们找一个全局变量存储 1,5,6这三种不可累加的最大值， 另一方面咱们用遍历树的方法求2,3,4这三种可以累加的情况。
     * 最后把两类情况得到的最大值再取一个最大值即可。
     *
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        int newMax = dfs (root);
        return Math.max (max, newMax);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1001;
        }

        int left = dfs (root.left);
        int right = dfs (root.right);
        // System.out.println ("letf : " + left + ", right : " + right + ", root : " + root.val);
        max = Math.max (max, Math.max (root.val + left + right, Math.max (left, right)));
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
