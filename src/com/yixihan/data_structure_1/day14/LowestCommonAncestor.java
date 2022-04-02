package com.yixihan.data_structure_1.day14;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
 * 最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * <p>
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 * @author : yixihan
 * @create : 2022-03-23-12:29
 */
public class LowestCommonAncestor {

    List<TreeNode> listP = new ArrayList<> ();
    List<TreeNode> listQ = new ArrayList<> ();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 方法一 : 蠢方法
//        if (root == null) {
//            return null;
//        }
//
//        search (root, p, listP);
//        search (root, q, listQ);
//
//        TreeNode ans = root;
//
//        for (int i = 0, j = 0; i < listP.size () && j < listQ.size (); i++, j++) {
//            if (listP.get (i) == listQ.get (j)) {
//                ans = listP.get (i);
//            }
//        }
//
//        return ans;

        // 方法二 : 利用搜索二叉树特性
        if (root == null) {
            return null;
        }

        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor (root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor (root.right, p, q);
        } else {
            return root;
        }
    }

    private void search(TreeNode node, TreeNode target, List<TreeNode> list) {
        list.add (node);

        if (node == target) {
            return;
        }

        if (node.left != null && node.val > target.val) {
            search (node.left, target, list);
        }
        if (node.right != null && node.val < target.val) {
            search (node.right, target, list);
        }


    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
