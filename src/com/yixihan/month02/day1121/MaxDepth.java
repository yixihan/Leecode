package com.yixihan.month02.day1121;

import java.util.List;

/**
 * @author : yixihan
 * @create : 2021-11-21-0:49
 */
public class MaxDepth {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }else {

            int depth = 0;

            for (Node child : root.children) {
                depth = Math.max(depth, maxDepth(child));
            }

            return depth + 1;
        }
    }

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
