package com.yixihan.month02.day1126;


/**
 * 给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。
 * 如果节点不存在，则返回 NULL。
 *
 *
 * @author : yixihan
 * @create : 2021-11-26-9:26
 */
public class SearchBST {


    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
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