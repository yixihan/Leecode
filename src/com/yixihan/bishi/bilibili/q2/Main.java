package com.yixihan.bishi.bilibili.q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-09-20-19:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt ();
        int[] nums = new int[n];
        int maxB = Integer.MIN_VALUE;
        int maxR = Integer.MIN_VALUE;
        int minB = Integer.MAX_VALUE;
        int minR = Integer.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt ();
        }

        char[] arr = sc.next ().toCharArray ();
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == 'B') {
                maxB = Math.max (maxB, nums[i]);
                minB = Math.min (minB, nums[i]);
            } else if (arr[i] == 'R') {
                maxR = Math.max (maxR, nums[i]);
                minR = Math.min (minR, nums[i]);
            }
        }
        max = Math.max (max, (long) maxB * maxR);
        max = Math.max (max, (long) maxB * minR);
        max = Math.max (max, (long) minB * minR);
        max = Math.max (max, (long) minB * maxR);

        System.out.println (max);
    }
}

/*
Scanner sc = new Scanner (System.in);
int n = sc.nextInt ();
int[] nums = new int[n];
int maxB = Integer.MIN_VALUE;
int maxR = Integer.MIN_VALUE;
int minB = Integer.MAX_VALUE;
int minR = Integer.MAX_VALUE;

for (int i = 0; i < nums.length; i++) {
    nums[i] = sc.nextInt ();
}

char[] arr = sc.next ().toCharArray ();
for (int i = 0; i < nums.length; i++) {
    if (arr[i] == 'B') {
        maxB = Math.max (maxB, nums[i]);
        minB = Math.min (minB, nums[i]);
    } else if (arr[i] == 'R') {
        maxR = Math.max (maxR, nums[i]);
        minR = Math.min (minR, nums[i]);
    }
}

System.out.println (Math.max (maxB * maxR, minB * minR));
 */
