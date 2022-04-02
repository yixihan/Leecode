package com.yixihan.programming_ability_1.day5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 *
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[1,3,5,6,2,4]
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 * @author : yixihan
 * @create : 2022-03-15-11:18
 */
public class Preorder {

    List<Integer> ans = new ArrayList<> ();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return ans;
        }

        ans.add (root.val);

        if (root.children != null && root.children.size () > 0) {
            for (Node node : root.children) {
                preorder (node);
            }
        }

        return ans;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
