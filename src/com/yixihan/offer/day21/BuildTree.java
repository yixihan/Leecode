package com.yixihan.offer.day21;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * @author : yixihan
 * @create : 2022-03-12-11:13
 */
public class BuildTree {
    
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<> ();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        
        for (int i = 0; i < inorder.length; i++) {
            dic.put (inorder[i], i);
        }
        
        return build (0, 0, inorder.length - 1);
    }

    private TreeNode build(int root, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode node = new TreeNode (preorder[root]);
        int i = dic.get (preorder[root]);
        node.left = build (root + 1, left, i - 1);
        node.right = build (root + i - left + 1, i + 1, right);
        return node;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
