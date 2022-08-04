package com.yixihan.random.day0804;

/**
 * @author : yixihan
 * @create : 2022-08-04-10:04
 */
public class DistributeCoins {

    int ans = 0;

    /**
     * 从后序遍历的第一个叶子节点开始，假设自己有x个金币，剩余x-1个金币都还给父节点，x-1可能为负数、0、正数
     * x-1 < 0说明不够金币，需要从父节点获得，因此子节点有|x-1|个入方向的操作，次数加上|x-1|
     * x-1 == 0说明刚好，无需与父节点有金币的交换，次数加0
     * x-1 > 0 说明有多余的金币，需要交给父节点，因此子节点有x-1个出方向的操作，次数加上|x-1|
     */
    public int distributeCoins(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper (root);
        return ans;
    }

    private int helper (TreeNode node) {
        if (node.left != null) {
            node.val += helper (node.left);
        }

        if (node.right != null) {
            node.val += helper (node.right);
        }

        ans += Math.abs (node.val - 1);
        return node.val - 1;
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
