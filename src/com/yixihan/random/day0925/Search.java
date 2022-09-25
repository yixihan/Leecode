package com.yixihan.random.day0925;

/**
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
 * 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 * <p>
 * 输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 * 输出: 8（元素5在该数组中的索引）
 * <p>
 * 输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
 * 输出：-1 （没有找到）
 *
 * @author : yixihan
 * @date : 2022-09-25-10:54
 */
public class Search {

    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                // mid == target, 则继续往左搜寻, 找到最小的索引, 最小索引一定不为 0
                while (mid > 0 && arr[mid - 1] == arr[mid]) {
                    mid--;
                }
                return mid;
            }

            if (arr[mid] < arr[r]) {
                // 说明 mid ~ r 是递增序列, 判读 target 是否在中间
                if (arr[mid] < target && target <= arr[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else if (arr[mid] > arr[r]) {
                //说明 l ~ mid 是递增序列, 判读 target 是否在中间
                if (arr[l] <= target && target < arr[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // arr[mid] == arr[r] 说明要么 r ~ 0 ~ mid 都相等, 要么 mid ~ r 都相等, 无论哪种 r 都可以舍去
                r--;
            }
        }
        return -1;
    }
}
