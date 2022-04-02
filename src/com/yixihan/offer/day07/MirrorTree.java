package com.yixihan.offer.day07;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *
 * 示例 1：
 *
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * @author : yixihan
 * @create : 2022-02-27-13:18
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        dfs (root);

        return root;
    }

    private void dfs (TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        if (root.left != null) {
            dfs (root.left);
        }

        if (root.right != null) {
            dfs (root.right);
        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
