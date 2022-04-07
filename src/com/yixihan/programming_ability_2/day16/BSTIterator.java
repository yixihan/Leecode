package com.yixihan.programming_ability_2.day16;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。
 * BST 的根节点 root 会作为构造函数的一部分给出。
 * 指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 *
 * @author : yixihan
 * @create : 2022-04-07-15:42
 */
public class BSTIterator {

    // 中序遍历, 存储进 ArrayList
    //    List<Integer> inorderList = new ArrayList<> ();
    //
    //    public BSTIterator(TreeNode root) {
    //        if (root != null) {
    //            inorder (root);
    //        }
    //    }
    //
    //    public int next() {
    //        return inorderList.remove (0);
    //    }
    //
    //    public boolean hasNext() {
    //        return ! inorderList.isEmpty ();
    //    }
    //
    //    private void inorder (TreeNode root) {
    //        if (root.left != null) {
    //            inorder (root.left);
    //        }
    //
    //        inorderList.add (root.val);
    //
    //        if (root.right != null) {
    //            inorder (root.right);
    //        }
    //    }

    Deque<TreeNode> d = new ArrayDeque<> ();

    public BSTIterator(TreeNode root) {
        // 步骤 1
        dfsLeft (root);
    }

    public int next() {
        // 步骤 2
        TreeNode root = d.pollLast ();
        int ans = root.val;
        // 步骤 3
        root = root.right;
        // 步骤 1
        dfsLeft (root);
        return ans;
    }

    void dfsLeft(TreeNode root) {
        while (root != null) {
            d.addLast (root);
            root = root.left;
        }
    }

    public boolean hasNext() {
        return !d.isEmpty ();
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
