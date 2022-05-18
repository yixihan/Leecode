package com.yixihan.binary_2.day10;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~ 2h 个节点。
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 * 输入：root = []
 * 输出：0
 * <p>
 * 输入：root = [1]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-05-18-13:17
 */
public class CountNodes {

    int ans = 0;

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder (root);
        return ans;
    }

    private void inorder(TreeNode root) {
        if (root.left != null) {
            inorder (root.left);
        }

        ans++;

        if (root.right != null) {
            inorder (root.right);
        }
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
