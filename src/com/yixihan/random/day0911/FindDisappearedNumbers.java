package com.yixihan.random.day0911;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
 * 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
 *
 * @author : yixihan
 * @create : 2022-09-11-10:12
 */
public class FindDisappearedNumbers {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<> (n);
        List<Integer> list = new ArrayList<> (n);
        for (int i = 0; i < nums.length; i++) {
            set.add (nums[i]);
            list.add (i + 1);
        }

        list.removeAll (set);
        return list;

    }
}
