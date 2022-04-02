package com.yixihan.data_structure_1.day10;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 *
 * 输入：root = []
 * 输出：[]
 *
 * 输入：root = [1]
 * 输出：[1]
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 *
 * @author : yixihan
 * @create : 2022-03-19-11:45
 */
public class InorderTraversal {
    List<Integer> ans = new ArrayList<> ();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }

        inOrder (root);
        return ans;
    }

    private void inOrder (TreeNode node) {
        if (node.left != null) {
            inOrder (node.left);
        }

        ans.add (node.val);

        if (node.right != null) {
            inOrder (node.right);
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
