package com.yixihan.competition.week287;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-04-03-11:17
 */
public class MaximumCandies {
    public int maximumCandies(int[] candies, long k) {
        List<Integer> list = new ArrayList<> ();
        long count = 0;
        for (int candy : candies) {
            count += candy;
            list.add (candy);
        }

        if (count < k) {
            return 0;
        }
        list.sort (((o1, o2) -> o2 - o1));
        if (list.size () < k) {
            return (int) (count / k);
        }

        while (true) {
            if (k - 2 >= 0 && list.get (0) / 2 > list.get ((int) k - 2)) {
                k--;
            } else {
                return list.get ((int) k - 1);
            }
        }

    }

    static class Main {
        public static void main(String[] args) {
            int[] candies = {5, 8};
            System.out.println (new MaximumCandies ().maximumCandies (candies, 5));
        }
    }
}
