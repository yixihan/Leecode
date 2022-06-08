package com.yixihan.month08.day0607;

/**
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 *
 * @author : yixihan
 * @create : 2022-06-08-14:23
 */
public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = -1;

        for (int pile : piles) {
            max = Math.max (max, pile);
        }

        while (min < max) {
            int mid = (min + max) >> 1;
            int count = 0;

            for (int pile : piles) {
                count += pile / mid;
                if (pile % mid != 0) {
                    count += 1;
                }
            }

            if (count > h) {
                min = mid + 1;
            } else {
                max = mid;
            }

        }

        return min;
    }
}
