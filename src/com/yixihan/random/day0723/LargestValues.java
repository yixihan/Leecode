package com.yixihan.random.day0723;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 *     1
 *    / \
 *   3   2
 *  / \   \
 * 5   3   9
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 *   1
 *  / \
 * 2   3
 * 示例3：
 * <p>
 * 输入: root = [1]
 * 输出: [1]
 * <p>
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 * 1
 *  \
 *   2
 * <p>
 * 输入: root = []
 * 输出: []
 *
 * @author : yixihan
 * @create : 2022-07-23-10:17
 */
public class LargestValues {

    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<> ();
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        queue.add (root);
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                maxValue = Math.max (node.val, maxValue);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add (maxValue);
        }

        return ans;
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
