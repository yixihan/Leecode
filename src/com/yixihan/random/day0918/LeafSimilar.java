package com.yixihan.random.day0918;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
 * <p>
 * 举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。
 * <p>
 * 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
 * <p>
 * 如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
 * <p>
 * 输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
 * 输出：true
 * <p>
 * 输入：root1 = [1,2,3], root2 = [1,3,2]
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-18-8:54
 */
public class LeafSimilar {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = getLeafList (root1);
        List<Integer> list2 = getLeafList (root2);
        System.out.println (list1);
        System.out.println (list2);
        return list1.equals (list2);
    }

    private List<Integer> getLeafList(TreeNode root) {
        List<Integer> leafList = new ArrayList<> ();
        if (root == null) {
            return leafList;
        }

        dfs (root, leafList);
        return leafList;
    }

    private void dfs (TreeNode root, List<Integer> leafList) {
        if (root.left == null && root.right == null) {
            leafList.add (root.val);
        }

        if (root.left!= null) {
            dfs (root.left, leafList);
        }

        if (root.right!= null) {
            dfs (root.right, leafList);
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
