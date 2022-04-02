package com.yixihan.offer.day15;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-07-11:59
 */
public class PathSum {
    int target;
    List<List<Integer>> ans = new ArrayList<>();


    public List<List<Integer>> pathSum(TreeNode root, int target) {
        this.target = target;

        search (root, 0, new ArrayList<>());

        return ans;

    }

    private void search (TreeNode node, int sum, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add (node.val);
        sum += node.val;

        if (sum == target && node.left == null && node.right == null) {
            ans.add (new ArrayList<>(list));
        } else {
            search (node.left, sum, list);
            search (node.right, sum, list);
        }

        list.remove (list.size () - 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
