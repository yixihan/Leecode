package com.yixihan.competition.week288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-04-10-10:30
 */
public class LargestInteger {
    public int largestInteger(int num) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        char[] arr = String.valueOf (num).toCharArray ();

        for (char c : arr) {
            int val = c - '0';
            if (val % 2 == 0) {
                list1.add (val);
            } else {
                list2.add (val);
            }
        }

        list1.sort ((o1, o2) -> o2 - o1);
        list2.sort ((o1, o2) -> o2 - o1);

        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] - '0') % 2 == 0) {
                arr[i] = (char) (list1.remove (0) + '0');
            } else {
                arr[i] = (char) (list2.remove (0) + '0');
            }
        }

        System.out.println (Arrays.toString (arr));

        return Integer.parseInt (new String (arr));
    }

    static class Main {
        public static void main(String[] args) {
            System.out.println (new LargestInteger ().largestInteger (1234));
        }
    }
}
