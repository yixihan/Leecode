package com.yixihan.month06.day0321;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 给定一个二叉搜索树 root 和一个目标结果 k，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 9
 * 输出: true
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], k = 28
 * 输出: false
 *
 * @author : yixihan
 * @create : 2022-03-21-10:17
 */
public class Solution {

    List<Integer> list = new ArrayList<> ();

    public boolean findTarget(TreeNode root, int k) {
        // 方法一 : 垃圾递归
        //        return findVal (root, root, k);
        // 方法二 : 利用 set
        //        Set<Integer> set = new HashSet<> ();
        //        return findVal (root, set, k);
        // 方法三 : 中序遍历, 返回有序序列, 双指针
        inorder (root);
        int left = 0;
        int right = list.size () - 1;

        while (left < right) {
            int sum = list.get (left) + list.get (right);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                left++;
            } else if (sum > k) {
                right--;
            }
        }

        return false;

    }

    private boolean findVal(TreeNode left, TreeNode right, int k) {
        if (left == null || right == null) {
            return false;
        }
        if (left.val + right.val == k) {
            if (left != right) {
                return true;
            } else {
                return findVal (left.left, right.right, k);
            }
        }
        if (left.val + right.val < k) {
            return findVal (left, right.right, k) || findVal (left.right, right, k);
        }
        if (left.val + right.val > k) {
            return findVal (left.left, right, k) || findVal (left, right.left, k);
        }

        return false;
    }

    private boolean findVal(TreeNode node, Set<Integer> set, int k) {
        if (node != null) {
            if (set.contains (node.val)) {
                return true;
            } else {
                set.add (k - node.val);
            }
            return findVal (node.right, set, k) || findVal (node.left, set, k);
        }
        return false;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder (node.left);
        }

        list.add (node.val);

        if (node.right != null) {
            inorder (node.right);
        }
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
