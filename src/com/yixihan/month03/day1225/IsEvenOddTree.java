package com.yixihan.month03.day1225;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 *
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 *
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 *
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 *
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 *
 * 输入：root = [1]
 * 输出：true
 *
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 *
 * @author : yixihan
 * @create : 2021-12-25-8:16
 */
public class IsEvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<> ();
        boolean flag = true;

        deque.addLast (root);
        while (!deque.isEmpty ()) {
            int size = deque.size ();
            int prev = flag ? 0 : 0x3f3f3f3f;

            while (size-- > 0) {
                TreeNode node = deque.pollFirst ();
                int cur = node.val;
                if (flag && (cur % 2 == 0 || cur <= prev)) {
                    return false;
                }
                if (!flag && (cur % 2 != 0 || cur >= prev)) {
                    return false;
                }

                prev = cur;
                if (node.left != null) {
                    deque.addLast (node.left);
                }
                if (node.right != null) {
                    deque.addLast (node.right);
                }
            }
            flag = ! flag;
        }

        return true;
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
