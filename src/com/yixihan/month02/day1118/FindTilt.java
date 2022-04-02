package com.yixihan.month02.day1118;



/**
 * @author : yixihan
 * @create : 2021-11-18-0:09
 */
public class FindTilt {


    /**
     * 双层递归
     */
    public int findTilt(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.abs(sum(root.left) - sum(root.right)) + findTilt(root.left) + findTilt(root.right);
    }

    public int sum(TreeNode root){
        if (root != null) {
            return root.val + sum(root.left) + sum(root.right);
        }
        return 0;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) { this.val = val; }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}