package com.yixihan.random.day0823;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
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
 * @create : 2022-08-23-7:49
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<> ();
        list.add (new ArrayList<> ());

        for (int num : nums) {
            int size = list.size ();
            for (int j = 0; j < size; j++) {
                List<Integer> tmp = new ArrayList<> (list.get (j));
                tmp.add (num);
                list.add (new ArrayList<> (tmp));
            }
        }

        return list;
    }
}
