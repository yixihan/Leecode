package com.yixihan.random.day0914;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 * 解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
 * 因此返回 [3, 14.5, 11] 。
 * <p>
 * 输入：root = [3,9,20,15,7]
 * 输出：[3.00000,14.50000,11.00000]
 *
 * @author : yixihan
 * @create : 2022-09-14-10:24
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<> ();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                sum += node.val;
                if (node.left != null) {
                    queue.add (node.left);
                }
                if (node.right != null) {
                    queue.add (node.right);
                }
            }

            list.add (sum / size);
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
