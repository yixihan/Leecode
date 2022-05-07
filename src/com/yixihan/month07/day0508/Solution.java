package com.yixihan.month07.day0508;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-05-08-0:25
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        // 方法一 : 哈希表
        //        Map<Integer, Integer> map = new HashMap<> (nums.length);
        //        List<Integer> ans = new ArrayList<> (nums.length / 2);
        //
        //        for (int num : nums) {
        //            map.put (num, map.getOrDefault (num, 0) + 1);
        //            if (map.get (num) == 2) {
        //                ans.add (num);
        //            }
        //}
        //
        //        return ans;

        // 方法二 :
        List<Integer> ans = new ArrayList<> (nums.length / 2);

        for (int num : nums) {

            num = Math.abs (num);
            if (nums[num - 1] > 0) {
                nums[num - 1] *= -1;
            } else {
                ans.add (num);
            }
        }

        return ans;
    }
}
