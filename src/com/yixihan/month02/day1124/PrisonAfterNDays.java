package com.yixihan.month02.day1124;

import java.util.Arrays;

/**
 * 8 间牢房排成一排，每间牢房不是有人住就是空着。
 *
 * 每天，无论牢房是被占用或空置，都会根据以下规则进行更改：
 *
 * 如果一间牢房的两个相邻的房间都被占用或都是空的，那么该牢房就会被占用。
 * 否则，它就会被空置。
 * （请注意，由于监狱中的牢房排成一行，所以行中的第一个和最后一个房间无法有两个相邻的房间。）
 *
 * 我们用以下方式描述监狱的当前状态：如果第 i 间牢房被占用，则 cell[i]==1，否则 cell[i]==0。
 *
 * 根据监狱的初始状态，在 N 天后返回监狱的状况（和上述 N 种变化）。
 *
 * 输入：cells = [0,1,0,1,1,0,0,1], N = 7
 * 输出：[0,0,1,1,0,0,0,0]
 * 解释：
 * 下表概述了监狱每天的状况：
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 *
 * 输入：cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * 输出：[0,0,1,1,1,1,1,0]
 *
 *
 * @author : yixihan
 * @create : 2021-11-24-16:40
 */
public class PrisonAfterNDays {


    /**
     * 因为题目限定 cells.length = 8, 故该变化每 14 天为一个循环, n % 14 即可
     *
     * 注意 : 当 n > 14 且 n % 14 == 0 时, 需循环 14 次
     */
    public int[] prisonAfterNDays(int[] cells, int n) {

        int time = n % 14;

        if (time == 0) {
            time = 14;
        }

        int length = cells.length;
        int[] temp = new int[length];

        for (int i = 0; i < time; i++) {

            System.arraycopy(cells, 0, temp, 0, length);

            for (int j = 1; j < length - 1; j++) {

                if (cells[j - 1] == cells[j + 1]) {
                    temp[j] = 1;
                } else {
                    temp[j] = 0;
                }

            }

            temp[0] = 0;
            temp[length - 1] = 0;

//            System.out.println(Arrays.toString(temp));
            System.arraycopy(temp, 0, cells, 0, length);
        }

        return cells;
    }
}
