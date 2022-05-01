package com.yixihan.month07.day0501;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
 * <p>
 * 输入：root1 = [2,1,4], root2 = [1,0,3]
 * 输出：[0,1,1,2,3,4]
 * <p>
 * 输入：root1 = [1,null,8], root2 = [8,1]
 * 输出：[1,1,8,8]
 * <p>
 *
 * @author : yixihan
 * @create : 2022-05-01-21:39
 */
public class Solution {
    List<Integer> ans = new ArrayList<> ();

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 != null) {
            dfs (root1);
        }
        if (root2 != null) {
            dfs (root2);
        }

        ans.sort (Integer::compareTo);

        return ans;

    }

    private void dfs(TreeNode node) {
        if (node.left != null) {
            dfs (node.left);
        }

        ans.add (node.val);

        if (node.right != null) {
            dfs (node.right);
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
