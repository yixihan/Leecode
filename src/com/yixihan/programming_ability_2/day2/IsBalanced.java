package com.yixihan.programming_ability_2.day2;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *
 * 输入：root = []
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-03-24-10:43
 */
public class IsBalanced {
    boolean flag = true;

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        inorder (root);
        System.out.println (flag);

        return flag;

    }

    private int getDeep(TreeNode node, int deep) {
        if (node == null) {
            return deep;
        } else {
            deep++;
        }

        return Math.max (getDeep (node.left, deep), getDeep (node.right, deep));
    }

    private void inorder(TreeNode node) {
        int leftDeep = 0;
        int rightDeep = 0;

        if (node.left != null) {
            leftDeep = getDeep (node.left, 0);
            inorder (node.left);
        }

        if (node.right != null) {
            rightDeep = getDeep (node.right, 0);
            inorder (node.right);
        }

        if (Math.abs (rightDeep - leftDeep) > 1) {
            flag = false;
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
