package com.yixihan.offer.day18;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *
 * 例如：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @author : yixihan
 * @create : 2022-03-10-11:09
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<> ();

        return getDeep (root, 1);
    }

    private int getDeep (TreeNode node, int deep) {
        if (node == null || (node.left == null && node.right == null)) {
            return deep;
        }

        return Math.max (getDeep (node.left, deep + 1), getDeep (node.right, deep + 1));
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
