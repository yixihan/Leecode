package com.yixihan.month02.day1123;

import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2021-11-23-0:21
 */
public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {


        char[] arr1 = s.toCharArray();
        char[] arr2 = goal.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (! Arrays.toString(arr1).equals(Arrays.toString(arr2))) {
            return false;
        }

        int[] countArr = new int[26];

        if (s.equals(goal)) {
            for (char c : arr1) {
                countArr[c - 'a']++;

                if (countArr[c - 'a'] >= 2) {
                    return true;
                }
            }
            return false;
        }

        arr1 = s.toCharArray();
        arr2 = goal.toCharArray();

        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return count == 2;
    }
}
