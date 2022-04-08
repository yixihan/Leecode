package com.yixihan.month06.day0408;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * <p>
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * <p>
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *
 * @author : yixihan
 * @create : 2022-04-08-12:55
 */
public class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<> ();
        List<List<Integer>> ans = new ArrayList<> ();

        if (root == null) {
            return ans;
        }

        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();
            List<Integer> list = new ArrayList<> ();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll ();
                if (node.children != null) {
                    queue.addAll (node.children);
                }
                list.add (node.val);

            }
            // System.out.println (list);
            ans.add (list);
        }

        return ans;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
