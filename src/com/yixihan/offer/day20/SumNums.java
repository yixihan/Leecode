package com.yixihan.offer.day20;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 * @author : yixihan
 * @create : 2022-03-11-13:44
 */
public class SumNums {
    int sum = 0;

    public int sumNums(int n) {
        getSum (n);
        return this.sum;
    }

    private void getSum (int n) {
        if (n > 0) {
            this.sum += n;
            getSum (n - 1);
        } else {
            return;
        }
    }
}
