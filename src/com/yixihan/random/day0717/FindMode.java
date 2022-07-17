package com.yixihan.random.day0717;

import java.util.*;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 *
 * @author : yixihan
 * @create : 2022-07-17-8:53
 */
public class FindMode {

    Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        preOrder (root);

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<> ((o1, o2) -> o2.getValue () - o1.getValue ());
        List<Integer> list = new ArrayList<> ();
        queue.addAll (map.entrySet ());

        int max = queue.peek ().getValue ();
        while (!queue.isEmpty ()) {
            if (queue.peek ().getValue () == max) {
                list.add (queue.poll ().getKey ());
            } else {
                break;
            }
        }

        int[] ans = new int[list.size ()];
        int index = 0;
        for (int val : list) {
            ans[index++] = val;
        }

        return ans;
    }

    private void preOrder (TreeNode node) {
        map.put (node.val, map.getOrDefault (node.val, 0) + 1);

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
