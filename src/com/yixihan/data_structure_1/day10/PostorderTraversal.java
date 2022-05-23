package com.yixihan.data_structure_1.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * @author : yixihan
 * @create : 2022-03-19-11:41
 */
public class PostorderTraversal {
    List<Integer> ans = new ArrayList<> ();
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }

        postOrder (root);
        return ans;
    }

    private void postOrder (TreeNode node) {
        if (node.left != null) {
            postOrder (node.left);
        }

        if (node.right != null) {
            postOrder (node.right);
        }

        ans.add (node.val);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
