package com.yixihan.month08.day0524;

/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-05-24-0:14
 */
public class Solution {
    public boolean isUnivalTree(TreeNode root) {

        if (root == null) {
            return true;
        }

        if ((root.left != null && root.val != root.left.val) || (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isUnivalTree (root.left) && isUnivalTree (root.right);

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
