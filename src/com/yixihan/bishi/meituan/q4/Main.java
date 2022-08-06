package com.yixihan.bishi.meituan.q4;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-08-06-9:59
 */
public class Main {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        helper (nums);
//        System.out.println (map);
        List<Integer> trainList = new ArrayList<>();
        List<Integer> testList = new ArrayList<>();

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet ()) {
            int size = entry.getValue ().size ();
            int half = size % 2 == 0 ? size / 2 : size / 2 + 1;

            for (int i = 0; i < size; i++) {
                if (i < half) {
                    trainList.add (entry.getValue ().get (i) + 1);
                } else {
                    testList.add (entry.getValue ().get (i) + 1);
                }
            }
        }

        Collections.sort (trainList);
        Collections.sort (testList);
        show (trainList);
        show (testList);

    }

    private static void show(List<Integer> list) {
        for (int i = 0; i < list.size (); i++) {
            if (i != list.size () - 1) {
                System.out.print (list.get (i) + " ");
            } else {
                System.out.println (list.get (i));
            }
        }
    }

    private static void helper (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault (nums[i], new ArrayList<> ());
            list.add (i);
            map.put (nums[i], list);
        }
    }
}
