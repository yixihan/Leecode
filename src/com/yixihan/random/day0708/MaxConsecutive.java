package com.yixihan.random.day0708;

import java.util.Arrays;

/**
 * Alice 管理着一家公司，并租用大楼的部分楼层作为办公空间。Alice 决定将一些楼层作为 特殊楼层 ，仅用于放松。
 * <p>
 * 给你两个整数 bottom 和 top ，表示 Alice 租用了从 bottom 到 top（含 bottom 和 top 在内）的所有楼层。
 * 另给你一个整数数组 special ，其中 special[i] 表示  Alice 指定用于放松的特殊楼层。
 * <p>
 * 返回不含特殊楼层的 最大 连续楼层数。
 * <p>
 * 输入：bottom = 2, top = 9, special = [4,6]
 * 输出：3
 * 解释：下面列出的是不含特殊楼层的连续楼层范围：
 * - (2, 3) ，楼层数为 2 。
 * - (5, 5) ，楼层数为 1 。
 * - (7, 9) ，楼层数为 3 。
 * 因此，返回最大连续楼层数 3 。
 * <p>
 * 输入：bottom = 6, top = 8, special = [7,6,8]
 * 输出：0
 * 解释：每层楼都被规划为特殊楼层，所以返回 0 。
 *
 * @author : yixihan
 * @create : 2022-07-08-7:44
 */
public class MaxConsecutive {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort (special);
        int n = special.length;
        int ans = 0;

        if ((n == top - bottom + 1) && (special[0] == bottom) && (special[n - 1] == top)) {
            return 0;
        }

        for (int j : special) {
            ans = Math.max (ans, Math.abs (bottom - j));
            bottom = j + 1;
        }

        return Math.max (ans, top - special[n - 1]);
    }
}
