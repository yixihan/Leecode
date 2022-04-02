package com.yixihan.data_structure_1.day1;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums 。
 * 如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-03-11-13:46
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {

        // 方式一 : stream 流
//        return Arrays.stream (nums).distinct ().count () != nums.length;

        // 方法二 : set
        Set<Integer> set = new HashSet<> ();

        for (int num : nums) {
            if (set.contains (num)) {
                return true;
            }
            set.add (num);
        }


        return false;

    }
}
