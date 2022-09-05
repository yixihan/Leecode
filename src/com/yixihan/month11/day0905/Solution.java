package com.yixihan.month11.day0905;

import java.util.*;

/**
 * 给定一棵二叉树 root，返回所有重复的子树。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 如果两棵树具有相同的结构和相同的结点值，则它们是重复的。
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * <p>
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * <p>
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 *
 * @author : yixihan
 * @create : 2022-09-05-13:26
 */
public class Solution {

    Map<String, Integer> map = new HashMap<> ();
    Map<Integer, TreeNode> idxMap = new HashMap<> ();
    Set<Integer> repeat = new HashSet<> ();
    int idx = 0;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs (root);
        List<TreeNode> list = new ArrayList<> ();
        for (int i : repeat) {
            list.add (idxMap.get (i));
        }
        return list;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int[] tri = {node.val, dfs (node.left), dfs (node.right)};
        String flag = Arrays.toString (tri);
        if (map.containsKey (flag)) {
            int rIdx = map.get (flag);
            repeat.add (rIdx);
            return rIdx;
        } else {
            map.put (flag, ++idx);
            idxMap.put (idx, node);
            return idx;
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
