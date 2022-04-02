package com.yixihan.data_structure_2.day1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * @author : yixihan
 * @create : 2022-03-24-9:50
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {

        // 方法一 : set
//        Set<Integer> set = new HashSet<> ();
//
//        for (int num : nums) {
//            if (!set.contains (num)) {
//                set.add (num);
//            } else {
//                set.remove (num);
//            }
//        }
//
//        return set.iterator ().next ();

        // 方法二 : 排序后比较
//        Arrays.sort (nums);
//
//        if (nums.length < 2 || nums[0] != nums[1]) {
//            return nums[0];
//        }
//
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
//                return nums[i];
//            }
//        }
//
//        return nums[nums.length - 1];

        // 方法三 : 异或
        // 交换律：a ^ b ^ c <=> a ^ c ^ b
        // 任何数于0异或为任何数 0 ^ n => n
        // 相同的数异或为0: n ^ n => 0
        int a = 0;
        for (int num : nums) {
            a = a ^ num;
        }

        return a;
    }
}
