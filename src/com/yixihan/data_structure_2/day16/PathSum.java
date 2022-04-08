package com.yixihan.data_structure_2.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * <p>
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-04-08-15:25
 */
public class PathSum {

    List<List<Integer>> ans;
    int targetSum;

    public List<List<Integer>> pathSum(TreeNode root, int _targetSum) {
        ans = new ArrayList<> ();
        targetSum = _targetSum;

        if (root == null) {
            return ans;
        }

        dfs (root, 0, new ArrayList<> ());
        return ans;
    }

    private void dfs(TreeNode root, int sum, List<Integer> list) {

        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && root.val + sum == targetSum) {
            list.add (root.val);
            ans.add (new ArrayList<> (list));
            list.remove (list.size () - 1);
            return;
        }

        list.add (root.val);
        dfs (root.left, sum + root.val, list);
        dfs (root.right, sum + root.val, list);
        list.remove (list.size () - 1);
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
