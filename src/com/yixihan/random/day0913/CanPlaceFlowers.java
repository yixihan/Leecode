package com.yixihan.random.day0913;

import java.util.Arrays;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组  flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。
 * 另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-09-13-11:31
 */
public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cnt = 0;
        int[] cloneFlowerbed = new int[flowerbed.length + 2];
        System.arraycopy (flowerbed, 0, cloneFlowerbed, 1, flowerbed.length);
        flowerbed = Arrays.copyOf (cloneFlowerbed, cloneFlowerbed.length);

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 &&flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                cnt++;
            }
        }

        return cnt >= n;
    }
}
