package com.yixihan.offer.day23;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * @author : yixihan
 * @create : 2022-03-14-11:08
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {

        // 方法一 : set
//        int[] ans = new int[2];
//        Set<Integer> set = new HashSet<> ();
//
//        for (int num : nums) {
//            if (! set.contains (num)) {
//                set.add (num);
//            } else {
//                set.remove (num);
//            }
//        }
//
//        Iterator<Integer> iterator = set.iterator ();
//        ans[0] = iterator.next ();
//        ans[1] = iterator.next ();
//        return ans;

        // 方法二 : 左右对比
        Arrays.sort (nums);
        int[] ans= new int[2];
        int index = 0;
        if (nums[0] != nums[1]) {
            ans[index++] = nums[0];
        }
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            ans[index++] = nums[nums.length - 1];
        }

        for (int i = 1; i < nums.length - 1 && index < 2; i++) {
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                ans[index++] = nums[i];
            }
        }

        return ans;

        // 方法三 : 不会的分组位运算
        //用于将所有的数异或起来
//        int k = 0;
//
//        for(int num: nums) {
//            k ^= num;
//        }
//
//        //获得k中最低位的1
//        int mask = 1;
//
//        //mask = k & (-k) 这种方法也可以得到mask，具体原因百度 哈哈哈哈哈
//        while((k & mask) == 0) {
//            mask <<= 1;
//        }
//
//        int a = 0;
//        int b = 0;
//
//        for(int num: nums) {
//            if((num & mask) == 0) {
//                a ^= num;
//            } else {
//                b ^= num;
//            }
//        }
//
//        return new int[]{a, b};
    }

}
