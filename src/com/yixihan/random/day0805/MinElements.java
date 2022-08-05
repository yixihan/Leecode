package com.yixihan.random.day0805;

/**
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * <p>
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * <p>
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * <p>
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * <p>
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-08-05-12:58
 */
public class MinElements {

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;

        for (int num : nums) {
            sum += num;
        }

        long diff = Math.abs (goal - sum);
        return diff > limit ? (int) (diff % limit == 0 ? diff / limit : diff / limit + 1) : diff == limit ? 0 : 1;
    }
}
