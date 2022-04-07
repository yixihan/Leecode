package com.yixihan.data_structure_2.day15;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * （即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * <p>
 * 输入：root = []
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-04-07-15:12
 */
public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<> ();

        if (root == null) {
            return ans;
        }

        boolean flag = true;
        List<TreeNode> rootList = new ArrayList<> ();
        rootList.add (root);

        while (!rootList.isEmpty ()) {
            int size = rootList.size ();
            List<Integer> list = new ArrayList<> ();
            List<TreeNode> childrenList = new ArrayList<> ();
            for (int i = 0; i < size; i++) {
                TreeNode node = rootList.get (i);
                list.add (node.val);
                if (node.left != null) {
                    childrenList.add (node.left);
                }
                if (node.right != null) {
                    childrenList.add (node.right);
                }
            }

            if (!flag) {
                Collections.reverse (list);
            }
            ans.add (list);
            flag = !flag;

            rootList = new ArrayList<> (childrenList);
        }

        return ans;
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
