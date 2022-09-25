package com.yixihan.random.day0925;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 *
 * @author : yixihan
 * @date : 2022-09-25-10:41
 */
public class FindSubsequences {

    List<List<Integer>> ans = new ArrayList<> ();
    List<Integer> path = new ArrayList<> ();

    public List<List<Integer>> findSubsequences(int[] nums) {
        helper (nums, 0);
        return ans;
    }

    private void helper (int[] nums, int start) {
        if (path.size () > 1) {
            ans.add (new ArrayList<> (path));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty () && nums[i] < path.get (path.size () - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            path.add (nums[i]);
            helper (nums, i + 1);
            path.remove (path.size () - 1);
        }
    }
}
