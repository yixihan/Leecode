package com.yixihan.random.day0923;

/**
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。
 * 给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。
 * 若有多个魔术索引，返回索引值最小的一个。
 * <p>
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * <p>
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * <p>
 *
 * @author : yixihan
 * @date : 2022-09-23-17:08
 */
public class FindMagicIndex {

    public int findMagicIndex(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                ans = i;
                break;
            }
        }

        return ans;
    }
}
