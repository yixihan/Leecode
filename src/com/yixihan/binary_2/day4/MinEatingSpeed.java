package com.yixihan.binary_2.day4;

/**
 * 珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。
 * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 *
 * @author : yixihan
 * @create : 2022-04-14-15:13
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;

        for (int pile : piles) {
            r = Math.max (r, pile);
        }

        while (l < r) {
            int mid = (l + r) >> 1;
            int count = 0;

            for (int pile : piles) {
                count += pile / mid;
                if (pile % mid != 0) {
                    count++;
                }
            }

            if (count > h) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
