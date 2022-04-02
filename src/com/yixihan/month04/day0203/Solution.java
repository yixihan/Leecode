package com.yixihan.month04.day0203;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你数字 k ，请你返回和为 k 的斐波那契数字的最少数目，其中，每个斐波那契数字都可以被使用多次。
 * <p>
 * 斐波那契数字定义为：
 * <p>
 * F1 = 1
 * F2 = 1
 * Fn = Fn-1 + Fn-2 ， 其中 n > 2 。
 * 数据保证对于给定的 k ，一定能找到可行解。
 * <p>
 * 输入：k = 7
 * 输出：2
 * 解释：斐波那契数字为：1，1，2，3，5，8，13，……
 * 对于 k = 7 ，我们可以得到 2 + 5 = 7 。
 * <p>
 * 输入：k = 10
 * 输出：2
 * 解释：对于 k = 10 ，我们可以得到 2 + 8 = 10 。
 * <p>
 * 输入：k = 19
 * 输出：3
 * 解释：对于 k = 19 ，我们可以得到 1 + 5 + 13 = 19 。
 *
 * @author : yixihan
 * @create : 2022-02-03-13:23
 */
public class Solution {

    private List<Integer> fibonacci = new ArrayList<> ();

    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        int index;
        getFibonacci (k);

        System.out.println (fibonacci);
        if (fibonacci.get (fibonacci.size () - 1) > k) {
            k -= fibonacci.get (fibonacci.size () - 2);
            index = fibonacci.size () - 2;
        } else {
            k -= fibonacci.get (fibonacci.size () - 1);
            index = fibonacci.size () - 1;
        }
        count++;
        while (k > 0) {
            if (fibonacci.contains (k)) {
                return count + 1;
            } else {
                for (int i = index; i >= 0; i--) {
                    if (k > fibonacci.get (i)) {
                        k -= fibonacci.get (i);
                        index = i;
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }

    private void getFibonacci(int k) {
        if (fibonacci.isEmpty ()) {
            fibonacci.add (1);
            fibonacci.add (1);
        }
        if (fibonacci.get (fibonacci.size () - 1) < k) {
            fibonacci.add (fibonacci.get (fibonacci.size () - 1) + fibonacci.get (fibonacci.size () - 2));
            getFibonacci (k);
        }
    }


    //*************** 贪心算法
    public int findMinFibonacciNumbers1(int k) {
        int a = 1, b = 1;
        int ans = 0;
        while (b <= k) {
            int c = a + b;
            a = b;
            b = c;
        }
        while (k != 0) {
            if (k >= b) {
                k -= b;
                ans++;
            }
            int c = b - a;
            b = a;
            a = c;
        }
        return ans;
    }
}
