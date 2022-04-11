package com.yixihan.binary_1.day3;

/**
 * 给你两个整数数组 arr1 ， arr2 和一个整数 d ，请你返回两个数组之间的 距离值 。
 * <p>
 * 「距离值」 定义为符合此距离要求的元素数目：对于元素 arr1[i] ，不存在任何元素 arr2[j] 满足 |arr1[i]-arr2[j]| <= d 。
 * <p>
 * 输入：arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2
 * 输出：2
 * 解释：
 * 对于 arr1[0]=4 我们有：
 * |4-10|=6 > d=2
 * |4-9|=5 > d=2
 * |4-1|=3 > d=2
 * |4-8|=4 > d=2
 * 所以 arr1[0]=4 符合距离要求
 * <p>
 * 对于 arr1[1]=5 我们有：
 * |5-10|=5 > d=2
 * |5-9|=4 > d=2
 * |5-1|=4 > d=2
 * |5-8|=3 > d=2
 * 所以 arr1[1]=5 也符合距离要求
 * <p>
 * 对于 arr1[2]=8 我们有：
 * |8-10|=2 <= d=2
 * |8-9|=1 <= d=2
 * |8-1|=7 > d=2
 * |8-8|=0 <= d=2
 * 存在距离小于等于 2 的情况，不符合距离要求
 * <p>
 * 故而只有 arr1[0]=4 和 arr1[1]=5 两个符合距离要求，距离值为 2
 * <p>
 * 输入：arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3
 * 输出：2
 * <p>
 * 输入：arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6
 * 输出：1
 *
 * @author : yixihan
 * @create : 2022-03-30-8:19
 */
public class FindTheDistanceValue {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        boolean flag;

        for (int k : arr1) {
            flag = true;
            for (int i : arr2) {
                if (Math.abs (k - i) <= d) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                ans++;
            }
        }

        return ans;

        // 二分法
//        int n2 = arr2.length;
//        Arrays.sort (arr2);
//
//        int ans = 0;
//        boolean flag;
//
//        for (int val : arr1) {
//            flag = true;
//            for (int left = 0, right = n2 - 1; left <= right; ) {
//                int mid = (left + right) / 2;
//                if (Math.abs (val - arr2[mid]) <= d) {
//                    flag = false;
//                    break;
//                } else if (val > arr2[mid]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//
//            if (flag) {
//                ans++;
//            }
//        }
//
//        return ans;
    }
}
