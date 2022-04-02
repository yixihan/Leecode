package com.yixihan.offer.day25;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * @author : yixihan
 * @create : 2022-03-16-12:28
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][]{};
        }

        List<int[]> list = new ArrayList<> ();


        for (int left = 0, right = 1, sum = 0; right < target; right++) {
            sum += right;

            while (sum > target) {
                sum += left++;
            }

            if (sum == target) {
                int[] temp = new int[right - left + 1];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = left + i;
                }
                list.add(temp);
            }
        }

        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
