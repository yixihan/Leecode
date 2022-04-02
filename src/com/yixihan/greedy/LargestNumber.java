package com.yixihan.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : yixihan
 * @create : 2022-03-16-14:40
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {


        //合法性
        if (nums == null || nums.length == 0) {
            return "";
        }

        // 方法一 : 自己实现排序算法算法
        //        sort (nums);


        // 方法二 : 使用 java api
        //数字数组->字符数组  转化
        String[] strArr = new String[nums.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = String.valueOf(nums[i]);
        }

        // 排序规则 o1 + o2 与 o2 + o1 比较
        Arrays.sort (strArr, (o1, o2) -> (o2 + o1).compareTo (o1 + o2));

        StringBuilder sb = new StringBuilder ();
        for (String str : strArr) {
            sb.append (str);
        }

        //特殊情况 若干个零
        if (sb.charAt(0) == '0') {
            return "0";
        }

        return sb.toString ();
    }

    // 自己实现排序
    private void sort (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                String val1 = nums[j] + String.valueOf (nums[j + 1]);
                String val2 = nums[j + 1] + String.valueOf (nums[j]);
                if (val1.compareTo (val2) < 0) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
