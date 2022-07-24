package com.yixihan.bishi.keda.q3;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-07-23-19:12
 */
public class Main {

    static int cnt = 0;

    static {
        getCnt ();
        System.out.println (cnt);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int guessCnt = sc.nextInt ();
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) {
            nums[i] = sc.nextInt ();
        }

        getCnt ();
        System.out.println ((cnt == guessCnt) + " " + helper (nums));
        Random rd = new Random ();
        System.out.println ((guessCnt == cnt ? "no" : "yes") + " " + (helper (nums) ? "no" : "yes"));
    }

    private static boolean helper(int[] nums) {
        int tmp = 4;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 4 || nums[i] > 12) {
                return false;
            }
            for (int j = 0; j < tmp; j++) {
                if (nums[i] - tmp + i > 0) {
                    nums[i] -= 3;
                } else {
                    nums[i + j] -= 1;
                    nums[i] -= 1;
                }
            }
            tmp--;
        }

        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }

    private static void getCnt() {
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                cnt++;
            }
        }
    }
}

/*
6 5 5 5 4
0 4 4 4 4
0 0 1 4 3
0 0 0 1 1
0 0 0 0 0
 */
