package com.yixihan.random.day0713;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉搜索树的 root ，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 * 使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 *
 * @author : yixihan
 * @create : 2022-07-13-8:57
 */
public class IncreasingBST {

    List<Integer> list = new ArrayList<>();

    public TreeNode increasingBST(TreeNode root) {
        innerOrder (root);
        return buildTree ();
    }

    private void innerOrder (TreeNode node) {
        if (node.left != null) {
            innerOrder (node.left);
        }

        list.add (node.val);

        if (node.right != null) {
            innerOrder (node.right);
        }
    }

    private TreeNode buildTree () {
        TreeNode root = new TreeNode (list.get (0));
        TreeNode node = root;

        for (int i = 1; i < list.size (); i++) {
            node.right = new TreeNode (list.get (i));
            node = node.right;
        }

        return root;
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
