package com.yixihan.bishi.tuhu.q2;


import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-08-31-18:52
 */
public class Solution {

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param oils int整型一维数组
     * @param box  int整型
     * @return int整型
     */
    public int change(int[] oils, int box) {
        // write code here
        Arrays.sort (oils);
        int cnt = -1;

        for (int i = oils.length - 1; i >= 0; i--) {
            int tmp = helper (oils, box, i);
            if (tmp != -1) {
                if (cnt == -1) {
                    cnt = tmp;
                } else {
                    cnt = Math.min (cnt, tmp);
                }
            }
        }

        return cnt;
    }

    private int helper (int[] oils, int box, int start) {
        int cnt = 0;

        for (int i = start; i >= 0; i--) {
            if (oils[i] > box) {
                continue;
            }
            cnt += box / oils[i];
            box %= oils[i];
        }

        return box == 0 ? cnt : -1;
    }
}

