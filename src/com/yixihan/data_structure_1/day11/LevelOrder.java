package com.yixihan.data_structure_1.day11;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 *
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 *
 * 输入：root = [1]
 * 输出：[[1]]
 *
 * 输入：root = []
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-03-20-11:37
 */
public class LevelOrder {
    List<List<Integer>> ans = new ArrayList<> ();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }

        Stack<List<TreeNode>> stack = new Stack<> ();

        List<TreeNode> nodeList = new ArrayList<> ();
        nodeList.add (root);
        stack.push (nodeList);

        while (! stack.isEmpty ()) {
            nodeList = stack.pop ();
            if (nodeList.isEmpty ()) {
                break;
            }
            List<Integer> valList = new ArrayList<>();
            List<TreeNode> childList = new ArrayList<>();

            for (TreeNode node : nodeList) {
                valList.add (node.val);

                if (node.left != null) {
                    childList.add (node.left);
                }
                if (node.right != null) {
                    childList.add (node.right);
                }
            }

            stack.push(childList);
            ans.add(valList);
        }

        return ans;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
