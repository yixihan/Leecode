package com.yixihan.data_structure_1.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,2,3]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * @author : yixihan
 * @create : 2022-03-19-11:47
 */
public class PreorderTraversal {

    List<Integer> ans = new ArrayList<> ();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }

        preOrder (root);
        return ans;
    }

    private void preOrder (TreeNode node) {

        ans.add (node.val);

        if (node.left != null) {
            preOrder (node.left);
        }

        if (node.right != null) {
            preOrder (node.right);
        }
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
