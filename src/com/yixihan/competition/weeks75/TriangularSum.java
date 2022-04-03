package com.yixihan.competition.weeks75;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-04-02-22:43
 */
public class TriangularSum {
    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        List<Integer> list1 = new ArrayList<> ();
        List<Integer> list2 = new ArrayList<> ();

        for (int i = 0; i < nums.length - 1; i++) {
            list2.add ((nums[i] + nums[i + 1]) % 10);
        }
        if (list2.size () == 1) {
            return list2.get (0);
        }

        while (true) {
            if (list2.size () == 1) {
                return list2.get (0);
            }
            for (int i = 0; i < list2.size () - 1; i++) {
                list1.add ((list2.get (i) + list2.get (i + 1)) % 10);
            }

            list2.clear ();
            if (list1.size () == 1) {
                return list1.get (0);
            }
            for (int i = 0; i < list1.size () - 1; i++) {
                list2.add ((list1.get (i) + list1.get (i + 1)) % 10);
            }
            list1.clear ();
        }
    }

    static class Main {
        public static void main(String[] args) {
            int[] nums2 = new int[]{1, 2, 3, 4, 5, 6};
            int[] nums1 = new int[]{1, 2, 3, 4, 5};
            System.out.println (new TriangularSum ().triangularSum (nums1));
            System.out.println (new TriangularSum ().triangularSum (nums2));
        }
    }

}
