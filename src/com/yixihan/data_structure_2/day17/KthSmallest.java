package com.yixihan.data_structure_2.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * <p>
 * 输入：root = [3,1,4,null,2], k = 1
 * 输出：1
 * <p>
 * 输入：root = [5,3,6,2,4,null,null,1], k = 3
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-04-09-13:33
 */
public class KthSmallest {

    List<Integer> list = new ArrayList<> ();
    int k;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        this.k = k;
        inorder (root);
        return list.get (k - 1);
    }

    private void inorder(TreeNode root) {

        if (list.size () > k - 1) {
            return;
        }

        if (root.left != null) {
            inorder (root.left);
        }

        list.add (root.val);

        if (root.right != null) {
            inorder (root.right);
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
