package com.yixihan.random.day0804;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个二叉搜索树 root (BST)，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * <p>
 * 提醒一下， 二叉搜索树 满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * 输入：root = [0,null,1]
 * 输出：[1,null,1]
 *
 * @author : yixihan
 * @create : 2022-08-04-9:25
 */
public class BstToGst {

    List<Integer> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        mediumOrder (root);
        preSumHelper ();
//        System.out.println (map);
        setTree (root);
        return root;
    }

    private void mediumOrder (TreeNode node) {
        if (node.left != null) {
            mediumOrder (node.left);
        }

        list.add (node.val);

        if (node.right != null) {
            mediumOrder (node.right);
        }
    }

    private void preSumHelper () {
        int[] preSum = new int[list.size () + 1];
        for (int i = 0; i < list.size (); i++) {
            preSum[i + 1] = preSum[i] + list.get (i);
            map.put (list.get (i), preSum[i]);
        }
        sum = preSum[preSum.length - 1];
    }

    private void setTree (TreeNode node) {
        if (node.left != null) {
            setTree (node.left);
        }

        node.val = sum - map.get (node.val);

        if (node.right != null) {
            setTree (node.right);
        }
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
