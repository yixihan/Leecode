package com.yixihan.month10.day0805;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。
 * <p>
 * 注意，根节点 root 位于深度 1 。
 * <p>
 * 加法规则如下:
 * <p>
 * 给定整数 depth，对于深度为 depth - 1 的每个非空树节点 cur ，创建两个值为 val 的树节点作为 cur 的左子树根和右子树根。
 * cur 原来的左子树应该是新的左子树根的左子树。
 * cur 原来的右子树应该是新的右子树根的右子树。
 * 如果 depth == 1 意味着 depth - 1 根本没有深度，那么创建一个树节点，值 val 作为整个原始树的新根，而原始树就是新根的左子树。
 * <p>
 * 输入: root = [4,2,6,3,1,5], val = 1, depth = 2
 * 输出: [4,1,1,2,null,null,6,3,1,5]
 * <p>
 * 输入: root = [4,2,null,3,1], val = 1, depth = 3
 * 输出:  [4,2,null,1,1,3,null,null,1]
 *
 * @author : yixihan
 * @create : 2022-08-05-8:17
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);
        int treeDepth = 1;

        if (depth == 1) {
            return new TreeNode (val, root, null);
        }

        while (!queue.isEmpty ()) {
            int size = queue.size ();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                if (treeDepth == depth - 1) {
                    TreeNode leftNode = new TreeNode (val, node.left, null);
                    TreeNode rightNode = new TreeNode (val, null, node.right);
                    node.left = leftNode;
                    node.right = rightNode;
                }
                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }

            if (++treeDepth >= depth) {
                break;
            }
        }

        return root;
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
