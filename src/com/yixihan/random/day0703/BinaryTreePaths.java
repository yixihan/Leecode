package com.yixihan.random.day0703;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 *
 * @author : yixihan
 * @create : 2022-07-03-9:34
 */
public class BinaryTreePaths {

    List<String> list = new ArrayList<> ();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return list;
        }
        dfs (root, new StringBuilder ());
        return list;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append (root.val);
            list.add (sb.toString ());
        } else {
            sb.append (root.val).append ("->");
            if (root.left != null) {
                dfs (root.left, new StringBuilder (sb));
            }
            if (root.right != null) {
                dfs (root.right, new StringBuilder (sb));
            }
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
