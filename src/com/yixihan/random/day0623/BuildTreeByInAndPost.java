package com.yixihan.random.day0623;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 *
 * @author : yixihan
 * @create : 2022-06-23-9:17
 */
public class BuildTreeByInAndPost {

    Map<Integer, Integer> map = new HashMap<> ();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        // 构造哈希映射, 帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            map.put (inorder[i], i);
        }
        return helper (0, n - 1, 0, n - 1, inorder, postorder);
    }

    private TreeNode helper(int leftIn, int rightIn, int leftPost, int rightPost, int[] in, int[] post) {
        if (leftIn > rightIn) {
            return null;
        }

        // 1. 后序遍历最后一个即根节点, 获取根节点后, 在 hashMap 里面找根节点在中序遍历的位置
        int rootIn = post[rightPost];
        int rootIndex = map.get (rootIn);

        // 2. 建立根节点
        TreeNode root = new TreeNode (rootIn);

        // 3. 获取根节点左子树节点的个数
        int leftNums = rootIndex - leftIn;

        // 4. 递归建立左子树, 右子树
        /*
        递归左子树
        采用分治的思想递归处理左子树
        左子树的 inorder 范围为 : leftL, rootIndex - 1
        左子树的 postorder 范围为 : leftPost, leftPost + leftNums - 1
         */
        root.left = helper (leftIn, rootIndex - 1, leftPost, leftPost + leftNums - 1, in, post);
        /*
        递归右子树
        右子树的 inorder 范围为 : rootIndex + 1, rightIn
        右子树的 postorder 范围为 : leftPost + leftNums, rightPost - 1
         */
        root.right = helper (rootIndex + 1, rightIn, leftPost + leftNums, rightPost - 1, in, post);
        return root;
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
