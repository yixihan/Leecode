package com.yixihan.month11.day0820;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * <p>
 * 输入：nums = [3,2,1,6,0,5]
 * 输出：[6,3,5,null,2,0,null,null,1]
 * 解释：递归调用如下所示：
 * - [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
 * - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
 * - 空数组，无子节点。
 * - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
 * - 空数组，无子节点。
 * - 只有一个元素，所以子节点是一个值为 1 的节点。
 * - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
 * - 只有一个元素，所以子节点是一个值为 0 的节点。
 * - 空数组，无子节点。
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[3,null,2,null,1]
 *
 * @author : yixihan
 * @create : 2022-08-20-8:09
 */
public class Solution {

    int[] nums;

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return dfs (0, nums.length);
    }

    private TreeNode dfs (int start, int end) {
        int maxIndex;

        if (start == end || (maxIndex = getMaxIndex (start, end)) == -1) {
            return null;
        }

        TreeNode root = new TreeNode (nums[maxIndex]);
        root.left = dfs (start, maxIndex);
        root.right = dfs (maxIndex + 1, end);

        return root;
    }

    private int getMaxIndex (int start, int end) {
        int maxValue = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = start; i < end; i++) {
            if (maxValue < nums[i]) {
                maxIndex = i;
                maxValue = nums[i];
            }
        }

        return maxIndex;
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
