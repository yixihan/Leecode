package com.yixihan.data_structure_1.day14;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-03-23-12:24
 */
public class FindTarget {

    Set<Integer> set = new HashSet<> ();
    boolean flag = false;

    public boolean findTarget(TreeNode root, int k) {

        if (root == null) {
            return false;
        }
        inorder (root, k);
        return flag;
    }

    private void inorder(TreeNode node, int k) {
        if (node.left != null) {
            inorder (node.left, k);
        }

        if (set.contains (node.val)) {
            flag = true;
            return;
        } else {
            set.add (k - node.val);
        }

        if (node.right != null) {
            inorder (node.right, k);
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
