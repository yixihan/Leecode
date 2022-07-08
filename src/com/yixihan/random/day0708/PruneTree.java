package com.yixihan.random.day0708;

/**
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 * <p>
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 * <p>
 * 输入: [1,0,1,0,0,0,1]
 * 输出: [1,null,1,null,1]
 * <p>
 * 输入: [1,1,0,1,1,0,1,0]
 * 输出: [1,1,0,1,1,null,1]
 *
 * @author : yixihan
 * @create : 2022-07-08-8:03
 */
public class PruneTree {

    public TreeNode pruneTree(TreeNode root) {
        return delTreeNode (root);
    }

    private TreeNode delTreeNode(TreeNode node) {

        if (node == null) {
            return null;
        }

        node.left = delTreeNode (node.left);
        node.right = delTreeNode (node.right);

        return node.left == null && node.right == null && node.val == 0 ? null : node;
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
