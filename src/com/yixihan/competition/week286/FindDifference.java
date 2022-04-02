package com.yixihan.competition.week286;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-03-27-10:31
 */
public class FindDifference {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<> ();

        Arrays.sort (nums1);
        Arrays.sort (nums2);

        List<Integer> list = new ArrayList<>();
        for (int val : nums1) {
            int index = Arrays.binarySearch (nums2, val);
            if (index >= 0 && !list.contains (val)) {
                list.add (val);
            }
        }
        ans.add (new ArrayList<> (list));
        list.clear ();
        for (int val : nums2) {
            int index = Arrays.binarySearch (nums1, val);
            if (index >= 0 && !list.contains (val)) {
                list.add (val);
            }
        }
        ans.add (new ArrayList<> (list));
        return ans;
    }
}
