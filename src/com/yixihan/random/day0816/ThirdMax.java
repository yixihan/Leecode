package com.yixihan.random.day0816;

import java.util.*;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 *
 * @author : yixihan
 * @create : 2022-08-16-9:07
 */
public class ThirdMax {

    public int thirdMax(int[] nums) {
        Set<Long> set = new TreeSet<> (Comparator.reverseOrder ());

        for (int num : nums) {
            set.add ((long) num);
        }

        List<Long> list = new ArrayList<> (set);

        return Math.toIntExact (list.size () >= 3 ? list.get (2) : list.get (0));
    }
}
