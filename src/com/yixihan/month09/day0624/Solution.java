package com.yixihan.month09.day0624;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 *
 * @author : yixihan
 * @create : 2022-06-24-9:10
 */
public class Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<> ();
        Queue<TreeNode> queue = new LinkedList<> ();

        if (root == null) {
            return list;
        }

        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();
            int maxVal = queue.peek ().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                maxVal = Math.max (maxVal, node.val);

                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }
            list.add (maxVal);
        }

        return list;
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
