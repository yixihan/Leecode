package com.yixihan.month10.day0721;

/**
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * <p>
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * <p>
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 * <p>
 * 输入：root = [1,null,0,0,1]
 * 输出：[1,null,0,null,1]
 * 解释：
 * 只有红色节点满足条件“所有不包含 1 的子树”。 右图为返回的答案。
 * <p>
 * 输入：root = [1,0,1,0,0,0,1]
 * 输出：[1,null,1,null,1]
 * <p>
 * 输入：root = [1,1,0,1,1,0,1,0]
 * 输出：[1,1,0,1,1,null,1]
 *
 * @author : yixihan
 * @create : 2022-07-21-9:21
 */
public class Solution {

    public TreeNode pruneTree(TreeNode root) {
        return delTree (root);
    }

    private TreeNode delTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        node.left = delTree (node.left);
        node.right = delTree (node.right);

        if (node.left == null && node.right == null && node.val == 0) {
            return null;
        }
        return node;
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
