package com.yixihan.offer.day07;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-02-27-13:03
 */
public class IsSubStructure {

    public boolean isSubStructure(TreeNode A, TreeNode B) {

        if (A == null || B == null) {
            return false;
        }

        return compare (A, B) || isSubStructure (A.left, B) || isSubStructure (A.right, B);
    }

    private boolean compare(TreeNode A, TreeNode B) {
        // A不一定要为空，因为B是A的子树，比如[1]是[1,3]的子树
        if (B == null) {
            return true;
        }

        // A为空，B不为空必然不是子树
        if (A == null) {
            return false;
        }

        return (A.val == B.val) && compare (A.left, B.left) && compare (A.right, B.right);
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
