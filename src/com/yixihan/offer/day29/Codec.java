package com.yixihan.offer.day29;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 *
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 *
 * @author : yixihan
 * @create : 2022-03-20-11:20
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        return root.val + "," + serialize (root.left) + serialize (root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split (",");
        Queue<String> queue = new LinkedList<> ();

        for (String val : values) {
            queue.offer (val);
        }

        return help (queue);
    }

    private TreeNode help(Queue<String> queue) {

        String val = queue.poll ();
        if (val == null || "null".equals (val) || "".equals (val)) {
            return null;
        }

        TreeNode root = new TreeNode (Integer.parseInt (val));
        root.left = help (queue);
        root.right = help (queue);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
