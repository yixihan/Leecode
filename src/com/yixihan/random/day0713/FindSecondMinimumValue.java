package com.yixihan.random.day0713;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。
 * 如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。
 * <p>
 * 更正式地说，即 root.val = min(root.left.val, root.right.val) 总成立。
 * <p>
 * 给出这样的一个二叉树，你需要输出所有节点中的 第二小的值 。
 * <p>
 * 如果第二小的值不存在的话，输出 -1 。
 * <p>
 * 输入：root = [2,2,5,null,null,5,7]
 * 输出：5
 * 解释：最小的值是 2 ，第二小的值是 5 。
 * <p>
 * 输入：root = [2,2,2]
 * 输出：-1
 * 解释：最小的值是 2, 但是不存在第二小的值。
 *
 * @author : yixihan
 * @create : 2022-07-13-9:05
 */
public class FindSecondMinimumValue {

    Set<Integer> set = new HashSet<> ();

    public int findSecondMinimumValue(TreeNode root) {
        preOrder (root);
        List<Integer> list = new ArrayList<> (set);
        if (list.size () < 2) {
            return -1;
        } else {
            Collections.sort (list);
            return list.get (1);
        }
    }

    private void preOrder (TreeNode root) {
        set.add (root.val);
        if (root.left != null) {
            preOrder (root.left);
        }
        if (root.right != null) {
            preOrder (root.right);
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
