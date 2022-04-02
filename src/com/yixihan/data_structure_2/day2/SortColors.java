package com.yixihan.data_structure_2.day2;

/**
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库的sort函数的情况下解决这个问题。
 * <p>
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * @author : yixihan
 * @create : 2022-03-25-14:41
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // 方法一 : 快排
        //        quickSort (nums, 0, nums.length - 1);

        // 方法二 : 妙法
        int num0 = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[num2++] = 2;
                nums[num1++] = 1;
                nums[num0++] = 0;
            } else if (nums[i] == 1) {
                nums[num2++] = 2;
                nums[num1++] = 1;
            } else {
                nums[num2++] = 2;
            }
        }
    }


    /**
     * 快排
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int midVal = arr[(left + right) / 2];

        while (l < r) {

            while (arr[l] < midVal) {
                l++;
            }

            while (arr[r] > midVal) {
                r--;
            }

            if (l >= r) {
                break;
            }

            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            if (arr[l] == midVal) {
                r--;
            }

            if (arr[r] == midVal) {
                l++;
            }
        }

        if (l == r) {
            l++;
            r--;
        }

        if (l < right) {
            quickSort (arr, l, right);
        }

        if (r > left) {
            quickSort (arr, left, r);
        }
    }
}
