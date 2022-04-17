package com.yixihan.competition.lccup;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-04-16-15:09
 */
public class PerfectMenu {

    int[] materials;

    public int perfectMenu(int[] materials, int[][] cookbooks, int[][] attribute, int limit) {

        int n = cookbooks.length;

        int ans = -1;

        for (int i = 0; i < n; i++) {
            // 美味度
            int cnt1 = 0;
            // 饱腹感
            int cnt2 = 0;
            this.materials = Arrays.copyOf (materials, materials.length);
            if (verifyEnough (cookbooks[i])) {
                del (cookbooks[i]);
                cnt1 += attribute[i][0];
                cnt2 += attribute[i][1];

                for (int j = i + 1; j < n; j++) {
                    if (verifyEnough (cookbooks[j])) {
                        del (cookbooks[j]);
                        cnt1 += attribute[j][0];
                        cnt2 += attribute[j][1];
                    } else {
                        break;
                    }
                }
            }
            System.out.println ("i :" + i);
            System.out.println ("cnt1 : " + cnt1);
            System.out.println ("cnt2 : " + cnt2);
            if (limit <= cnt2) {
                ans = Math.max (ans, cnt1);
            }

        }
        return ans;
    }

    private boolean verifyEnough(int[] cookbook) {
        return this.materials[0] >= cookbook[0]
                && this.materials[1] >= cookbook[1]
                && this.materials[2] >= cookbook[2]
                && this.materials[3] >= cookbook[3]
                && this.materials[4] >= cookbook[4];
    }

    private void del(int[] cookbook) {
        this.materials[0] -= cookbook[0];
        this.materials[1] -= cookbook[1];
        this.materials[2] -= cookbook[2];
        this.materials[3] -= cookbook[3];
        this.materials[4] -= cookbook[4];
    }

    static class Main {
        public static void main(String[] args) {
            int[] meterials = {43,57,56,34,58};
            int[][] cookbooks = {{12,23,43,12,43}, {3,12,14,16,18}, {8,22,13,18,13},{5,22,31,19,8},{23,31,12,21,15},{14,23,16,8,9},{19,23,17,12,8}};
            int[][] attribute = {{5,5}, {7,5}, {4,8},{12,14},{8,7},{3,7},{8,6}};
            int limit = 13;
            //            int[] meterials = {3, 2, 4, 1, 2};
            //            int[][] cookbooks = {{1, 1, 0, 1, 2}, {2, 1, 4, 0, 0}, {3, 2, 4, 1, 0}};
            //            int[][] attribute = {{3, 2}, {2, 4}, {7, 6}};
            //            int limit = 1;
            System.out.println (new PerfectMenu ().perfectMenu (meterials, cookbooks, attribute, limit));
        }
    }

}
