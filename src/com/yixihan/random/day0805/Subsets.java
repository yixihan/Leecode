package com.yixihan.random.day0805;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author : yixihan
 * @create : 2022-08-05-17:21
 */
public class Subsets {

    List<List<Integer>> ans = new ArrayList<> ();
    List<Integer> res = new ArrayList<> ();

    public List<List<Integer>> subsets(int[] nums) {
        dfs (nums, 0);
        return ans;
    }

    public void dfs(int[] nums, int start) {
        ans.add (new ArrayList<> (res));
        for (int i = start; i < nums.length; i++) {
            res.add (nums[i]);
            dfs (nums, i + 1);
            res.remove (res.size () - 1);
        }
    }
}
