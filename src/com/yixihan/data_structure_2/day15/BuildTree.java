package com.yixihan.data_structure_2.day15;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历，
 * inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 * <p>
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 * <p>
 * 输入: preorder = [-1], inorder = [-1]
 * 输出: [-1]
 *
 * @author : yixihan
 * @create : 2022-04-07-15:20
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper (preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        if (p_start == p_end) {
            return null;
        }

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode (root_val);

        // 在中序遍历中找到根节点的位置
        int i_root_index = getInorderIndex (i_start, i_end, root_val, inorder);
        int leftNum = i_root_index - i_start;

        //递归的构造左子树
        root.left = buildTreeHelper (preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, i_root_index);
        //递归的构造右子树
        root.right = buildTreeHelper (preorder, p_start + leftNum + 1, p_end, inorder, i_root_index + 1, i_end);
        return root;


    }

    private int getInorderIndex(int i_start, int i_end, int root_val, int[] inorder) {
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                return i;
            }
        }

        return -1;
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
