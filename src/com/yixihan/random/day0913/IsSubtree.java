package com.yixihan.random.day0913;

/**
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * <p>
 * 输入：root = [3,4,5,1,2], subRoot = [4,1,2]
 * 输出：true
 * <p>
 * 输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-13-11:17
 */
public class IsSubtree {

    TreeNode target;
    boolean flag;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        target = subRoot;
        dfs (root);
        System.out.println (equals (root, subRoot));

        return flag;
    }

    private void dfs(TreeNode root) {
        boolean isEquals = equals (root, target);
        if (isEquals) {
            flag = true;
            System.out.println (flag);
        }

        if (root.left != null) {
            dfs (root.left);
        }
        if (root.right != null) {
            dfs (root.right);
        }
    }

    private boolean equals(TreeNode node, TreeNode target) {
        if (node == null && target == null) {
            return true;
        } else if (node != null && target != null && node.val == target.val) {
            return equals (node.left, target.left) && equals (node.right, target.right);
        } else {
            return false;
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
}
