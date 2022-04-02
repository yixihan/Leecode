package com.yixihan.offer.day18;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 *
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 * @author : yixihan
 * @create : 2022-03-10-11:21
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);


        while (! queue.isEmpty ()) {
            int leftDeep = 0;
            int rightDeep = 0;
            TreeNode node = queue.poll ();
            if (node.left != null) {
                leftDeep = getDeep (node.left, leftDeep + 1);
                queue.add (node.left);
            }
            if (node.right != null) {
                rightDeep = getDeep (node.right, rightDeep + 1);
                queue.add (node.right);
            }

            if (Math.abs (leftDeep - rightDeep) > 1) {
                return false;
            }

        }

        return true;
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
