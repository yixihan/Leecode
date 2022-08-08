package com.yixihan.random.day0808;

/**
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 *
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *
 * @author : yixihan
 * @create : 2022-08-08-8:49
 */
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;

        for (int j : arr) {
            if (j % 2 != 0) {
                cnt++;
            } else {
                cnt = 0;
            }

            if (cnt >= 3) {
                return true;
            }
        }

        return false;
    }
}
