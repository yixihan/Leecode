package com.yixihan.month11.day0903;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *
 * @author : yixihan
 * @create : 2022-09-03-12:53
 */
public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort (pairs, Comparator.comparingInt (o -> o[1]));
        int ans = 1;
        int tmp = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                ans++;
                tmp = pairs[i][1];
            }
        }

        return ans;
    }
}
