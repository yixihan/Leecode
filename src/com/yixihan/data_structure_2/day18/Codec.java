package com.yixihan.data_structure_2.day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 *
 * @author : yixihan
 * @create : 2022-04-10-13:33
 */
public class Codec {

    public String serialize(TreeNode root) {
        List<Integer> order = order (root);
        return order.toString ();
    }

    public TreeNode deserialize(String data) {
        if ("[]".equals (data)) {
            return null;
        }
        List<Integer> list = stringToList (data);
        return buildTree (list);
    }

    private List<Integer> order(TreeNode root) {
        List<Integer> ans = new ArrayList<> ();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<> ();
        queue.add (root);

        while (!queue.isEmpty ()) {
            int size = queue.size ();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll ();
                if (node == null) {
                    ans.add (null);
                } else {
                    ans.add (node.val);
                    queue.add (node.left);
                    queue.add (node.right);
                }
            }
        }

        for (int i = ans.size () - 1; i >= 0; i--) {
            if (ans.get (i) == null) {
                ans.remove (i);
            } else {
                break;
            }
        }
        System.out.println (ans);

        return ans;
    }

    private TreeNode buildTree(List<Integer> data) {
        Queue<TreeNode> queue = new LinkedList<> ();
        TreeNode root = new TreeNode (data.get (0));
        queue.add (root);

        int i = 1;

        while (!queue.isEmpty ()) {
            TreeNode node = queue.poll ();
            if (i < data.size () && data.get (i) != null) {
                TreeNode left = new TreeNode (data.get (i));
                node.left = left;
                queue.add (left);
            }
            i++;
            if (i < data.size () && data.get (i) != null) {
                TreeNode right = new TreeNode (data.get (i));
                node.right = right;
                queue.add (right);
            }
            i++;

        }

        return root;
    }

    private List<Integer> stringToList(String data) {
        List<Integer> list = new ArrayList<> ();
        String[] splits = data.substring (1, data.length () - 1).split (", ");

        for (String split : splits) {
            if ("null".equals (split)) {
                list.add (null);
            } else {
                list.add (Integer.parseInt (split));
            }
        }

        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
