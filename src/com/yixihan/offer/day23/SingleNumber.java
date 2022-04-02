package com.yixihan.offer.day23;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 *
 * 输入：nums = [3,4,3,3]
 * 输出：4
 *
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-03-14-10:54
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        // 方法一 : Hash 表
//        Map<Integer, Integer> map = new HashMap<>(nums.length / 3 + 1);
//
//        for (int num : nums) {
//            map.put (num, map.getOrDefault (num, 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
//            if (entry.getValue () == 1) {
//                return entry.getKey ();
//            }
//        }
//
//        return -1;

        // 方法二 : 计数法
        Arrays.sort (nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1] && count == 0) {
                return nums[i];
            }

            if (nums[i] == nums[i + 1]) {
                count++;
            } else if (nums[i] != nums[i + 1] && count != 0) {
                count = 0;
            }
        }

        return nums[nums.length - 1];

        // 方法三 : 不会的位运算
//        int ones = 0, twos = 0;
//        for(int num : nums){
//            ones = ones ^ num & ~twos;
//            twos = twos ^ num & ~ones;
//        }
//        return ones;
    }
}
