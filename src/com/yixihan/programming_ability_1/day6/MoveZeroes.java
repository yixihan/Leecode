package com.yixihan.programming_ability_1.day6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-03-16-13:42
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {

        // 方法一 : 利用辅助数组存储非 0 值
        int n = nums.length;
        List<Integer> list = new ArrayList<> (n);

        for (int num : nums) {
            if (num != 0) {
                list.add (num);
            }
        }

        for (int i = 0; i < list.size (); i++) {
            nums[i] = list.get (i);
        }

        for (int i = list.size (); i < n; i++) {
            nums[i] = 0;
        }

        // 方法二
        // 思路 第一个位置 0 放第一个不为 0 的数字，第 n 个位置 n-1 放第 n 个不为 0 的数字。
        // 如果 某元素原本就处位得当则不做处理，否则，在上述移动后，将原位置置为 0
        for (int i = 0, count = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //执行替换操作
                if (count != i) {
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }
}
