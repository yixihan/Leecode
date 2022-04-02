package com.yixihan.offer.day06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
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
 *   [20,9],
 *   [15,7]
 * ]
 *
 * @author : yixihan
 * @create : 2022-02-26-15:16
 */
public class LevelOrder3 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {

        show (root, 0);

        for (int i = 1; i < ans.size (); i += 2) {
            Collections.reverse (ans.get (i));
        }

        return ans;
    }

    private void show(TreeNode root, int k) {
        if (root != null) {
            if (ans.size () <= k) {
                ans.add (new ArrayList<> ());
            }

            ans.get (k).add (root.val);
            show (root.left, k + 1);
            show (root.right, k + 1);
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
