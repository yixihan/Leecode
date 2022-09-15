package com.yixihan.bishi.qianxin.q1;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-09-15-19:12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int[][] nums = split (sc.nextLine (), sc.nextLine ());
        sc.close ();

        helper (nums);
    }

    private static void helper(int[][] nums) {
        long sum = 0;
        List<Integer> listA = new ArrayList<> ();
        List<Integer> listB = new ArrayList<> ();
        Arrays.sort (nums, ((o1, o2) -> Math.max (o2[0], o2[1]) - Math.max (o1[0], o1[1])));

        for (int[] num : nums) {
            if (num[0] > num[1]) {
                if (listA.size () >= 2 && num[0] * 6 / 10 < num[1]) {
                    listA.add (num[0]);
                    System.out.println ("A买");
                } else {
                    listB.add (num[1]);
                    System.out.println ("B买");
                }
            } else {
                // 有一种情况未考虑
                if (listB.size () % 3 == 2) {
                    listB.sort ((Comparator.comparingInt (o -> o)));
                    int start = listB.size () / 3;
                    int min = Math.min (listB.get (start), num[1]);
                    if (num[1] - min < num[0]) {
                        listB.add (num[1]);
                        System.out.println ("B买");
                    } else {
                        listA.add (num[0]);
                        System.out.println ("A买");
                    }
                } else {
                    listA.add (num[0]);
                    System.out.println ("A买");
                }
            }
        }

        System.out.println (listA);
        System.out.println (listB);

        if (listA.size () >= 3) {
            for (int val : listA) {
                sum += val * 6L / 10;
            }
        } else {
            for (int val : listA) {
                sum += val;
            }
        }

        int start = listB.size () / 3;
        for (int i = start; i < listB.size (); i++) {
            sum += listB.get (i);
        }

        System.out.println (sum);
    }


    private static int[][] split(String str1, String str2) {
        String[] splits1 = str1.split (",");
        String[] splits2 = str2.split (",");
        int[][] nums = new int[splits1.length][2];
        int index = 0;
        for (int i = 0; i < splits1.length; i++) {
            nums[index][0] = Integer.parseInt (splits1[i]);
            nums[index++][1] = Integer.parseInt (splits2[i]);
        }

        return nums;
    }
}
