package com.yixihan.month06.day0331;

import java.util.ArrayList;
import java.util.List;

/**
 * 自除数 是指可以被它包含的每一位数整除的数。
 * <p>
 * 例如，128 是一个 自除数 ，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
 * 自除数 不允许包含 0 。
 * <p>
 * 给定两个整数 left 和 right ，返回一个列表，列表的元素是范围 [left, right] 内所有的 自除数 。
 * <p>
 * 输入：left = 1, right = 22
 * 输出：[1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * <p>
 * 输入：left = 47, right = 85
 * 输出：[48,55,66,77]
 *
 * @author : yixihan
 * @create : 2022-03-31-0:29
 */
public class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> ans = new ArrayList<> ();

        for (int i = left; i <= right; i++) {
            if (verify (i)) {
                ans.add (i);
            }
        }

        return ans;
    }

    private boolean verify (int num) {
        for (int i = num; i > 0; i /= 10) {
            int val = (i % 10);
            if (val == 0 || num % val != 0) {
                return false;
            }
        }

        return true;
    }
}
