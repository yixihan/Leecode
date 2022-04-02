package com.yixihan.data_structure_1.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 *
 * @author : yixihan
 * @create : 2022-03-23-12:10
 */
public class IsValidBST {

    List<Integer> list = new ArrayList<> ();

    public boolean isValidBST(TreeNode root) {

        // 方法一 : 究极蠢方法
        //        if (root == null) {
        //            return true;
        //        }
        //
        //        if (root.left != null) {
        //            if (getMaxVal (root.left, root.left.val) >= root.val) {
        //                return false;
        //            }
        //        }
        //
        //        if (root.right != null) {
        //            if (getMinVal (root.right, root.right.val) <= root.val) {
        //                return false;
        //            }
        //        }
        //
        //        return isValidBST (root.left) && isValidBST (root.right);

        // 中序遍历
        if (root == null) {
            return true;
        }

        inorder (root);
        return check ();
    }

    /************** 蠢方法对应的方法 ********************/
    private int getMinVal(TreeNode node, int val) {
        if (node == null) {
            return val;
        }

        val = Math.min (val, node.val);
        return Math.min (getMinVal (node.right, val), getMinVal (node.left, val));
    }

    private int getMaxVal(TreeNode node, int val) {
        if (node == null) {
            return val;
        }

        val = Math.max (val, node.val);
        return Math.max (getMaxVal (node.right, val), getMaxVal (node.left, val));
    }

    /**************** 中序遍历 ***********************/
    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder (node.left);
        }

        list.add (node.val);

        if (node.right != null) {
            inorder (node.right);
        }
    }

    private boolean check() {
        for (int i = 0; i < list.size () - 1; i++) {
            if (list.get (i + 1) <= list.get (i)) {
                return false;
            }
        }
        return true;
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
