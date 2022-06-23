package com.yixihan.random.day0623;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yixihan
 * @create : 2022-06-23-9:43
 */
public class BuildTreeByPreAndIn {

    Map<Integer, Integer> map = new HashMap<> ();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射, 帮助我们快速定位根节点
        for (int i = 0; i < n; i++) {
            map.put (inorder[i], i);
        }

        return helper (0, n - 1, 0, n - 1, preorder, inorder);
    }

    private TreeNode helper(int leftPre, int rightPre, int leftIn, int rightIn, int[] pre, int[] in) {
        if (leftIn > rightIn) {
            return null;
        }

        // 1. 前序遍历第一个即根节点, 获取根节点后, 在 hashMap 里面找根节点在中序遍历的位置
        int rootVal = pre[leftPre];
        int rootIndex = map.get (rootVal);

        // 2. 建立根节点
        TreeNode root = new TreeNode (rootVal);

        // 3. 获取根节点左子树节点的个数
        int leftNums = rootIndex - leftIn;

        // 4. 递归建立左子树, 右子树
        /*
        递归左子树
        采用分治的思想递归处理左子树
        左子树的 preorder 范围为 : leftPre + 1, leftPre + leftNums
        左子树的 inorder 范围为 : leftIn, rootIndex - 1
        */
        root.left = helper (leftPre + 1, leftPre + leftNums, leftIn, rootIndex - 1, pre, in);
        /*
        递归右子树
        右子树的 preorder 范围为 : leftPre + leftNums + 1, rightPre
        右子树的 inorder 范围为 : rootIndex + 1, rightIn
        */
        root.right = helper (leftPre + leftNums + 1, rightPre, rootIndex + 1, rightIn, pre, in);

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
