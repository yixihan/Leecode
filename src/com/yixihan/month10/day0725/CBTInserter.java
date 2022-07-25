package com.yixihan.month10.day0725;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。
 * 使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 *
 * @author : yixihan
 * @create : 2022-07-25-9:26
 */
public class CBTInserter {

    TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int val) {
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);
        int rootVal = 0;

        k:
        while (!queue.isEmpty ()) {
            int size = queue.size ();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                if (node.left != null) {
                    queue.add (node.left);
                } else {
                    node.left = new TreeNode (val);
                    rootVal = node.val;
                    break k;
                }

                if (node.right != null) {
                    queue.add (node.right);
                } else {
                    node.right = new TreeNode (val);
                    rootVal = node.val;
                    break k;
                }
            }
        }

        return rootVal;
    }

    public TreeNode get_root() {
        return root;
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
}
