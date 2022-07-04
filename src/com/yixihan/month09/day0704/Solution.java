package com.yixihan.month09.day0704;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 * <p>
 * 输入：arr = [4,2,1,3]
 * 输出：[[1,2],[2,3],[3,4]]
 * <p>
 * 输入：arr = [1,3,6,10,15]
 * 输出：[[1,3]]
 * <p>
 * 输入：arr = [3,8,-10,23,19,-4,-14,27]
 * 输出：[[-14,-10],[19,23],[23,27]]
 *
 * @author : yixihan
 * @create : 2022-07-04-8:18
 */
public class Solution {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort (arr);
        List<List<Integer>> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 1; i < arr.length; i++) {
            min = Math.min (Math.abs (arr[i - 1] - arr[i]), min);
        }

        for (int i = 1; i < arr.length; i++) {
            if (min == Math.abs (arr[i - 1] - arr[i])) {
                List<Integer> list = new ArrayList<>();
                list.add (arr[i - 1]);
                list.add (arr[i]);
                ans.add (list);
            }
        }

        return ans;
    }
}
