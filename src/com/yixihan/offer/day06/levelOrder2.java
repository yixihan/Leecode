package com.yixihan.offer.day06;

import java.util.*;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * @author : yixihan
 * @create : 2022-02-26-15:03
 */
public class levelOrder2 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        show (root, 0);

        return ans;
    }

    private void show(TreeNode root, int k) {
        if (root != null) {
            if (ans.size () <= k) {
                ans.add (new ArrayList<> ());
            }

            ans.get (k).add (root.val);

            show (root.left, k +1);
            show (root.right, k +1);
        }
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
