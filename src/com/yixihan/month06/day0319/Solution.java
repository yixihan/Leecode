package com.yixihan.month06.day0319;

import javax.swing.tree.TreeNode;

/**
 * 你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。
 *
 * 空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 *
 *
 * 输入: 二叉树: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * 输出: "1(2(4))(3)"
 *
 * 解释: 原本将是“1(2(4)())(3())”，
 * 在你省略所有不必要的空括号对之后，
 * 它将是“1(2(4))(3)”。
 *
 * 输入: 二叉树: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * 输出: "1(2()(4))(3)"
 *
 * 解释: 和第一个示例相似，
 * 除了我们不能省略第一个对括号来中断输入和输出之间的一对一映射关系。
 *
 * @author : yixihan
 * @create : 2022-03-19-10:41
 */
public class Solution {
    StringBuilder sb = new StringBuilder ();

    public String tree2str(TreeNode root) {

        if (root == null) {
            return "()";
        }

        preOrder (root);

        return sb.toString ();
    }

    private void preOrder (TreeNode node) {
        if(node == null) {
            sb.append ("()");
        } else {
            sb.append (node.val);
        }


        if (node.left != null) {
            sb.append ("(");
            preOrder (node.left);
            sb.append (")");
        }
        if (node.right != null) {
            if (node.left == null) {
                sb.append ("()");
            }
            sb.append ("(");
            preOrder (node.right);
            sb.append (")");

        }

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
