package com.yixihan.random.day0710;

import java.util.*;

/**
 * 给定两个数组，arr1 和 arr2，
 * <p>
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * <p>
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * @author : yixihan
 * @create : 2022-07-10-9:10
 */
public class RelativeSortArray {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<> ();
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[arr1.length];

        for (int val : arr2) {
            map.put (val, 0);
        }

        for (int val : arr1) {
            if (map.containsKey (val)) {
                map.put (val, map.get (val) + 1);
            } else {
                list.add (val);
            }
        }

        int index = 0;
        for (int val : arr2) {
            for (int j = 0; j < map.get (val); j++) {
                ans[index++] = val;
            }
        }

        Collections.sort (list);
        for (Integer val : list) {
            ans[index++] = val;
        }

        return ans;
    }
}
