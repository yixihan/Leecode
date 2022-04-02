package com.yixihan.offer.day24;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 * @author : yixihan
 * @create : 2022-03-15-10:49
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {

        // 方法一 : 暴力解
//        int n = nums.length;
//        Arrays.sort (nums);
//        int count = 1;
//        int nowVal = nums[0];
//
//        for (int i = 1; i < n; i++) {
//            if (nowVal == nums[i]) {
//                count++;
//            } else {
//                if (count >= (n + 1) / 2) {
//                    return nowVal;
//                } else {
//                    nowVal = nums[i];
//                    count = 1;
//                }
//            }
//        }
//
//        return nowVal;

        // 方法二 : 数组中必定存在大于数组长度一般的数字, 所以排序后此数字必定在数组中间
//        int n = nums.length;
//        Arrays.sort (nums);
//
//        return nums[n / 2];

        // 方法三 : 哈希表 不太行
//        Map<Integer, Integer> map = new HashMap<> ();
//
//        for (int num : nums) {
//            map.put (num, map.getOrDefault (num, 0) + 1);
//
//            if (map.get (num) > nums.length / 2) {
//                return num;
//            }
//        }
//
//        return -1;

        // 方法四 : 摩尔排序法 最优解
        int count = 0;
        int card = -1;

        for (int num : nums) {
            if (count == 0) {
                card = num;
            }
            count += (card == num) ? 1 : -1;
        }

        return card;
    }

}
