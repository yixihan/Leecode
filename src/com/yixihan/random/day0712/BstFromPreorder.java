package com.yixihan.random.day0712;

/**
 * 给定一个整数数组，它表示BST(即 二叉搜索树 )的 先序遍历 ，构造树并返回其根。
 * <p>
 * 保证 对于给定的测试用例，总是有可能找到具有给定需求的二叉搜索树。
 * <p>
 * 二叉搜索树 是一棵二叉树，其中每个节点， Node.left 的任何后代的值 严格小于 Node.val , Node.right 的任何后代的值 严格大于 Node.val。
 * <p>
 * 二叉树的 前序遍历 首先显示节点的值，然后遍历Node.left，最后遍历Node.right。
 * <p>
 * 输入：preorder = [8,5,1,7,10,12]
 * 输出：[8,5,10,1,7,null,12]
 * <p>
 * 输入: preorder = [1,3]
 * 输出: [1,null,3]
 *
 * @author : yixihan
 * @create : 2022-07-12-9:06
 */
public class BstFromPreorder {

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;

        for (int val : preorder) {
            root = buildTree (val, root);
        }

        return root;
    }

    private TreeNode buildTree (int val, TreeNode node) {
        if (node == null) {
            return new TreeNode (val);
        }

        if (val < node.val) {
            node.left = buildTree (val, node.left);
        } else {
            node.right = buildTree (val, node.right);
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
