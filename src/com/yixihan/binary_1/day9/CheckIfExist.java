package com.yixihan.binary_1.day9;

/**
 * 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
 * <p>
 * 更正式地，检查是否存在两个下标 i 和 j 满足：
 * <p>
 * i != j
 * 0 <= i, j < arr.length
 * arr[i] == 2 * arr[j]
 * <p>
 * 输入：arr = [10,2,5,3]
 * 输出：true
 * 解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
 * <p>
 * 输入：arr = [7,1,14,11]
 * 输出：true
 * 解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
 * <p>
 * 输入：arr = [3,1,7,11]
 * 输出：false
 * 解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
 *
 * @author : yixihan
 * @create : 2022-04-05-14:43
 */
public class CheckIfExist {
    public boolean checkIfExist(int[] arr) {

        // 哈希表
//        int n = arr.length;
//        Map<Double, Integer> map = new HashMap<>(2 * n);
//        for (int val : arr) {
//            if (map.containsKey ((double) val)) {
//                return true;
//            }
//            map.put (2 * (double) val, val);
//            map.put ((double) val / 2, val);
//        }
//        System.out.println (map);
//        return false;

        // 排序 + 二分
//        int n = arr.length;
//        Arrays.sort (arr);
//        // System.out.println (Arrays.toString (arr));
//        for (int i = 0; i < n; i++) {
//            int val = 2 * arr[i];
//            int index = Arrays.binarySearch (arr, val);
//            if (index >= 0 && index != i) {
//                // System.out.println (i);
//                return true;
//            }
//        }
//        // System.out.println (map);
//        return false;

        // 暴力解
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] * 2;
            for (int j = 0; j < arr.length; j++) {
                if (num == arr[j] && i != j) {
                    return true;
                }
            }
        }
        return false;
    }
}
