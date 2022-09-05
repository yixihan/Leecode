package com.yixihan.random.day0905;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * <p>
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * <p>
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 *
 * @author : yixihan
 * @create : 2022-09-05-13:58
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<> ();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (end + 1 == nums[i]) {
                end = nums[i];
            } else {
                if (start == end) {
                    ans.add (String.valueOf (start));
                } else {
                    ans.add (start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (start == end) {
            ans.add (String.valueOf (start));
        } else {
            ans.add (start + "->" + end);
        }
        return ans;
    }
}
