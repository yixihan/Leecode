package com.yixihan.month09.day0619;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 *
 * @author : yixihan
 * @create : 2022-06-19-11:15
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<> ();
    int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        helper (root);
        List<Integer> list = new ArrayList<> ();

        for (Integer val : map.keySet ()) {
            if (map.get (val) == max) {
                list.add (val);
            }
        }

        int[] ans = new int[list.size ()];
        int index = 0;
        for (Integer val : list) {
            ans[index++] = val;
        }

        return ans;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = helper (node.left);
        int right = helper (node.right);

        int val = left + right + node.val;
        map.put (val, map.getOrDefault (val, 0) + 1);
        max = Math.max (max, map.get (val));
        return val;
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
