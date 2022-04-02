package com.yixihan.data_structure_1.day13;

/**
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 *
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 *
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 *
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 *
 * @author : yixihan
 * @create : 2022-03-22-10:16
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode (val);
        }

        insert (root, val);
        return root;
    }

    private void insert (TreeNode node, int val) {

        if (node.val > val) {
            if (node.left == null) {
                node.left = new TreeNode (val);
            } else {
                insert (node.left, val);
            }
        } else {
            if (node.right == null) {
                node.right = new TreeNode (val);
            } else {
                insert (node.right, val);
            }
        }
    }

    public class TreeNode {
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
}
