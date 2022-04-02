package com.yixihan.data_structure_1.day13;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * <p>
 * <p>
 * 输入：root = [4,2,7,1,3], val = 2
 * 输出：[2,1,3]
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-22-10:04
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (root.val > val) {
            return searchBST (root.left, val);
        } else {
            return searchBST (root.right, val);
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
