package com.yixihan.month11.day0822;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给你一棵二叉树的根节点 root ，请你构造一个下标从 0 开始、大小为 m x n 的字符串矩阵 res ，
 * 用以表示树的 格式化布局 。构造此格式化布局矩阵需要遵循以下规则：
 * <p>
 * 树的 高度 为 height ，矩阵的行数 m 应该等于 height + 1 。
 * 矩阵的列数 n 应该等于 2height+1 - 1 。
 * 根节点 需要放置在 顶行 的 正中间 ，对应位置为 res[0][(n-1)/2] 。
 * 对于放置在矩阵中的每个节点，设对应位置为 res[r][c] ，将其左子节点放置在 res[r+1][c-2height-r-1] ，右子节点放置在 res[r+1][c+2height-r-1] 。
 * 继续这一过程，直到树中的所有节点都妥善放置。
 * 任意空单元格都应该包含空字符串 "" 。
 * 返回构造得到的矩阵 res 。
 * <p>
 * 输入：root = [1,2]
 * 输出：
 * [["","1",""],
 * ["2","",""]]
 * <p>
 * 输入：root = [1,2,3,null,4]
 * 输出：
 * [["","","","1","","",""],
 * ["","2","","","","3",""],
 * ["","","4","","","",""]]
 *
 * @author : yixihan
 * @create : 2022-08-22-7:17
 */
public class Solution {

    List<List<String>> ans;
    List<List<TreeNode>> tmpLists;
    int height;
    int m;
    int n;

    public List<List<String>> printTree(TreeNode root) {
        height = getHeight (root, 1);
        m = height;
        n = (int) (Math.pow (2, height) - 1);
        ans = new ArrayList<> (m);
        tmpLists = new ArrayList<> (m);
        helper (root);

        for (List<TreeNode> tmpList : tmpLists) {
            List<String> list = new ArrayList<> (n);
            for (TreeNode treeNode : tmpList) {
                list.add (treeNode == null ? "" : String.valueOf (treeNode.val));
            }
            ans.add (list);
        }

        return ans;
    }

    private int getHeight(TreeNode root, int height) {
        if (root == null || (root.left == null && root.right == null)) {
            return height;
        } else {
            return Math.max (height, Math.max (getHeight (root.left, height + 1), getHeight (root.right, height + 1)));
        }
    }

    private void helper(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<> ();
        queue.add (root);
        List<TreeNode> rootList = new ArrayList<> (n);
        fill (rootList);
        rootList.set ((n - 1) / 2, root);
        tmpLists.add (rootList);
        int r = 1;
        while (!queue.isEmpty ()) {
            int size = queue.size ();
            boolean flag = false;
            List<TreeNode> list = new ArrayList<> (n);
            fill (list);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                int c = ans.get (r - 1).indexOf (node);
                System.out.println (node.val);
                System.out.println (c);

                if (node.left != null) {
                    list.set ((int) (c - Math.pow (2, height - r - 1)), node.left);
                    flag = true;
                    queue.add (node.left);
                }
                if (node.right != null) {
                    list.set ((int) (c + Math.pow (2, height - r - 1)), node.right);
                    flag = true;
                    queue.add (node.right);
                }
            }
            if (flag) {
                tmpLists.add (list);
            }
            r++;
        }

    }

    private void fill(List<TreeNode> list) {
        for (int i = 0; i < n; i++) {
            list.add (null);
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
}
/*
[1,2]
[1,2,3,null,4]
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, null, 32, null, null, 33, null, null, 34]
0
7
0
3
0
3
0
1
0
1
0
2

 */