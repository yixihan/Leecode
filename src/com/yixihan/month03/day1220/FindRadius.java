package com.yixihan.month03.day1220;

import java.util.Arrays;

/**
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 *
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 *
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 *
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 *
 * 输入: houses = [1,2,3], heaters = [2]
 * 输出: 1
 * 解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
 *
 * 输入: houses = [1,2,3,4], heaters = [1,4]
 * 输出: 1
 * 解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
 *
 * 输入：houses = [1,5], heaters = [2]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2021-12-20-0:02
 */
public class FindRadius {

    public int findRadius(int[] houses, int[] heaters) {

        Arrays.sort (houses);
        Arrays.sort (heaters);

        int radius = 0;
        int index = 0;

        for (int house : houses) {
            while (index < heaters.length && heaters[index] < house) {
                index++;
            }

            if (index == 0) {
                radius = Math.max (radius, heaters[index] - house);
            } else if (index == heaters.length) {
                return Math.max (radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
            } else {
                radius = Math.max (radius, Math.min (heaters[index] - house, house - heaters[index - 1]));
            }
        }

        return radius;
    }
}
