package com.yixihan.random.day0622;

import java.util.Arrays;

/**
 * 给你一个字符串数组 nums 和一个整数 k 。nums 中的每个字符串都表示一个不含前导零的整数。
 * <p>
 * 返回 nums 中表示第 k 大整数的字符串。
 * <p>
 * 注意：重复的数字在统计时会视为不同元素考虑。
 * 例如，如果 nums 是 ["1","2","2"]，那么 "2" 是最大的整数，"2" 是第二大的整数，"1" 是第三大的整数。
 * <p>
 * 输入：nums = ["3","6","7","10"], k = 4
 * 输出："3"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["3","6","7","10"]
 * 其中第 4 大整数是 "3"
 * <p>
 * 输入：nums = ["2","21","12","1"], k = 3
 * 输出："2"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["1","2","12","21"]
 * 其中第 3 大整数是 "2"
 * <p>
 * 输入：nums = ["0","0"], k = 2
 * 输出："0"
 * 解释：
 * nums 中的数字按非递减顺序排列为 ["0","0"]
 * 其中第 2 大整数是 "0"
 *
 * @author : yixihan
 * @create : 2022-06-22-9:05
 */
public class KthLargestNumber {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort (nums, (a1, a2) -> {
            if (a1.length () == a2.length ()) {
                for (int i = 0; i < a2.length (); i++) {
                    char a = a1.charAt (i);
                    char b = a2.charAt (i);
                    if (a != b) {
                        return b - a;
                    }
                }

                return 0;
            } else {
                return a2.length () - a1.length ();
            }
        });

        return nums[nums.length - k];

    }
}
