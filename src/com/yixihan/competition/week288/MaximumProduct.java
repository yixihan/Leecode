package com.yixihan.competition.week288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : yixihan
 * @create : 2022-04-10-11:24
 */
public class MaximumProduct {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        for (int i = 0; i < k; i++) {
            queue.offer(queue.poll() + 1);
        }
        long prod = 1;
        for (int num : queue) {
            prod = prod * num % 1000000007;
        }
        return (int) prod;
    }

    static class Main {
        public static void main(String[] args) {
            System.out.println (new MaximumProduct ().maximumProduct (new int[]{92, 36, 15, 84, 57, 60, 72, 86, 70, 43, 16}, 62));
        }
    }
}
