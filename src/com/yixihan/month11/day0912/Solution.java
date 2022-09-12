package com.yixihan.month11.day0912;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-09-12-10:39
 */
public class Solution {

    List<Integer> list = new ArrayList<> ();
    int minDiff = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        dfs (root);
        list.sort ((Comparator.comparingInt (o -> o)));
        for (int i = 1; i < list.size (); i++) {
            minDiff = Math.min (list.get (i) - list.get (i - 1), minDiff);
        }
        return minDiff;
    }

    private void dfs(TreeNode root) {
        list.add (root.val);

        if (root.left != null) {
            dfs (root.left);
        }
        if (root.right != null) {
            dfs (root.right);
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
