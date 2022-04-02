package com.yixihan.offer.day07;

import javax.swing.tree.TreeNode;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-02-27-14:11
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        TreeNode node = dfs (root);

        return compare (node, root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        } else{
            TreeNode node = new TreeNode (root.val);
            node.left = dfs (root.right);
            node.right = dfs (root.left);
            return node;
        }
    }

    private boolean compare (TreeNode A, TreeNode B) {
        if ((A == null && B != null) || (A != null && B == null)) {
            return false;
        } else if (A == null) {
            return true;
        }

        return (A.val == B.val) && compare (A.right, B.right) && compare (A.left, B.left);
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
