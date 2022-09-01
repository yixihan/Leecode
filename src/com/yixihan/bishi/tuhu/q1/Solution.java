package com.yixihan.bishi.tuhu.q1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : yixihan
 * @create : 2022-08-31-18:52
 */
public class Solution {

    Set<Integer> set = new HashSet<> ();
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * 烟花颜色数
     *
     * @param root TreeNode类 烟花二叉树
     * @return int整型
     */
    public int numColor(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        preorder (root);
        return set.size ();
    }

    private void preorder (TreeNode node) {
        set.add (node.val);

        if (node.left != null) {
            preorder (node.left);
        }
        if (node.right != null) {
            preorder (node.right);
        }
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;

        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

    }
}




