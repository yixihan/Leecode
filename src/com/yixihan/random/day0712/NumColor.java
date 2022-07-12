package com.yixihan.random.day0712;

import java.util.HashSet;
import java.util.Set;

/**
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
 * <p>
 * 输入：root = [1,3,2,1,null,2]
 * 输出：3
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 * <p>
 * 输入：root = [3,3,3]
 * 输出：1
 * 解释：焰火中仅出现 1 个颜色，值为 3
 *
 * @author : yixihan
 * @create : 2022-07-12-9:25
 */
public class NumColor {

    Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {
        preOrder (root);
        return set.size ();
    }

    private void preOrder (TreeNode node) {
        set.add (node.val);

        if (node.left != null) {
            preOrder (node.left);
        }
        if (node.right != null) {
            preOrder (node.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
