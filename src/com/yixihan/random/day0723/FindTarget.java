package com.yixihan.random.day0723;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。
 * 假设二叉搜索树中节点的值均唯一。
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * <p>
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 * @author : yixihan
 * @create : 2022-07-23-13:16
 */
public class FindTarget {

    Map<Integer, Integer> map = new HashMap<> ();
    int target;

    public boolean findTarget(TreeNode root, int k) {
        target = k;
        return dfs (root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (!map.containsKey (root.val)) {
            map.put (target - root.val, root.val);
        } else {
            return true;
        }

        return dfs (root.left) || dfs (root.right);
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
