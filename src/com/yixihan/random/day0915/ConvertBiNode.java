package com.yixihan.random.day0915;

/**
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 * 实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 注意：本题相对原题稍作改动
 * <p>
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 *
 * @author : yixihan
 * @create : 2022-09-15-10:32
 */
public class ConvertBiNode {

    TreeNode tmp;

    public TreeNode convertBiNode(TreeNode root) {
        tmp = new TreeNode (Integer.MAX_VALUE);
        TreeNode pre = tmp;
        dfs (root);
        return pre.right;
    }

    private void dfs (TreeNode node) {
        if (node == null) {
            return;
        }
        dfs (node.left);
        tmp.right = node;
        node.left = null;
        tmp = tmp.right;
        dfs (node.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
