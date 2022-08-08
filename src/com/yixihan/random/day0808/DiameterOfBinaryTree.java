package com.yixihan.random.day0808;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * <p>
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 *
 * @author : yixihan
 * @create : 2022-08-08-8:51
 */
public class DiameterOfBinaryTree {

    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs (root);

        return max;
    }

    private int dfs (TreeNode root) {
        if (root.left == null && root.right == null) {
            return 0;
        }

        int leftDepth = root.left == null ? 0 : dfs (root.left) + 1;
        int rightDepth = root.right == null ? 0 : dfs (root.right) + 1;
        max = Math.max (max, leftDepth + rightDepth);
        return Math.max (leftDepth, rightDepth);
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
