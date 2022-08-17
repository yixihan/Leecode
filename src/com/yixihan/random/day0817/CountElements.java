package com.yixihan.random.day0817;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * 给你一个整数数组 nums ，统计并返回在 nums 中同时至少具有一个严格较小元素和一个严格较大元素的元素数目。
 * <p>
 * 输入：nums = [11,7,2,15]
 * 输出：2
 * 解释：元素 7 ：严格较小元素是元素 2 ，严格较大元素是元素 11 。
 * 元素 11 ：严格较小元素是元素 7 ，严格较大元素是元素 15 。
 * 总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 * <p>
 * 输入：nums = [-3,3,3,90]
 * 输出：2
 * 解释：元素 3 ：严格较小元素是元素 -3 ，严格较大元素是元素 90 。
 * 由于有两个元素的值为 3 ，总计有 2 个元素都满足在 nums 中同时存在一个严格较小元素和一个严格较大元素。
 *
 * @author : yixihan
 * @create : 2022-08-17-9:08
 */
public class CountElements {

    public int countElements(int[] nums) {
        Arrays.sort (nums);
        int cnt = 0;

        for (int num : nums) {
            if (num != nums[0] && num != nums[nums.length - 1]) {
                cnt++;
            }
        }

        return cnt;
    }
}
