package com.yixihan.offer.day15;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *
 * @author : yixihan
 * @create : 2022-03-07-11:32
 */
public class KthLargest {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<> ();
        // 方法一 : 层次遍历
//        show (root, list);
//        list.sort (Integer::compare);

        // 方法二 : 前序遍历
//        preShow (root, list);
//        list.sort (Integer::compare);

        // 方法三 : 中序遍历, 此树为搜索树, 中序遍历出来为有序数
        midShow (root, list);
        return list.get (list.size () - k);
    }

    private void show (TreeNode root, List<Integer> list) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add (root);

        while (! queue.isEmpty ()) {
            TreeNode node = queue.poll();
            list.add (node.val);

            if (node.left != null) {
                queue.add (node.left);
            }
            if (node.right != null) {
                queue.add (node.right);
            }
        }
    }

    private void preShow (TreeNode root, List<Integer> list) {

        if (root.left != null) {
            preShow (root.left, list);
        }

        list.add (root.val);

        if (root.right != null) {
            preShow (root.right, list);
        }
    }

    private void midShow (TreeNode root, List<Integer> list) {

        if (root.left != null) {
            midShow (root.left, list);
        }

        list.add (root.val);

        if (root.right != null) {
            midShow (root.right, list);
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
