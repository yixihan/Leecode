package com.yixihan.random.day0903;

/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * <p>
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * <p>
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * <p>
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * <p>
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-03-13:10
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return equalsTree (p, q);
    }

    private boolean equalsTree(TreeNode p, TreeNode q) {
        if (p != null && q != null && p.val != q.val) {
            return false;
        } else if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }

        return equalsTree (p.left, q.left) && equalsTree (p.right, q.right);
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
