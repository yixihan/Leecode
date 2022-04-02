package com.yixihan.offer.day06;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *
 * @author : yixihan
 * @create : 2022-02-26-14:36
 */
public class LevelOrder1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);

        List<Integer> list = new ArrayList<> ();

        while (! queue.isEmpty ()) {
            TreeNode node = queue.poll ();
            list.add (node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        int[] ans = new int[list.size ()];
        int index = 0;

        while (! list.isEmpty ()) {
            ans[index++] = list.remove (0);
        }

        return ans;
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
