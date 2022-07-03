package com.yixihan.random.day0703;

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
 * @create : 2022-07-03-10:25
 */
public class LongestUnivaluePath {

    int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength (root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength (node.left);
        int right = arrowLength (node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft = left + 1;
        }

        if (node.right != null && node.right.val == node.val) {
            arrowRight = right + 1;
        }

        ans = Math.max (ans, arrowLeft + arrowRight);
        return Math.max (arrowLeft, arrowRight);

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
