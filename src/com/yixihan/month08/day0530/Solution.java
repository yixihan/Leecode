package com.yixihan.month08.day0530;

/**
 * 给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
 * <p>
 * 例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
 * 对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
 * <p>
 * 返回这些数字之和。题目数据保证答案是一个 32 位 整数。
 * <p>
 * 输入：root = [1,0,1,0,1,0,1]
 * 输出：22
 * 解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 * <p>
 * 输入：root = [0]
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-05-30-8:13
 */
public class Solution {

    int ans = 0;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getVal (root, new StringBuilder ());
        return ans;
    }

    private void getVal(TreeNode node, StringBuilder sb) {

        sb.append (node.val);
        if (node.left == null && node.right == null) {
            // System.out.println (sb.toString ());
            ans += Integer.parseInt (sb.toString (), 2);
        }

        if (node.left != null) {
            getVal (node.left, new StringBuilder (sb));
        }

        if (node.right != null) {
            getVal (node.right, new StringBuilder (sb));
        }
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
