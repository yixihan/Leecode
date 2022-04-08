package com.yixihan.data_structure_2.day16;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * <p>
 * 输入: []
 * 输出: []
 *
 * @author : yixihan
 * @create : 2022-04-08-15:19
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<> ();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add (root);

        while (!deque.isEmpty ()) {
            TreeNode lastNode = deque.peekLast ();
            ans.add (lastNode.val);

            int size = deque.size ();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll ();
                if (node.left != null) {
                    deque.add(node.left);
                }

                if (node.right != null) {
                    deque.add (node.right);
                }
            }
        }
        return ans;
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
