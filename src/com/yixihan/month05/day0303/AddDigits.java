package com.yixihan.month05.day0303;

/**
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。返回这个结果。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: num = 38
 * 输出: 2
 * 解释: 各位相加的过程为：
 * 38 --> 3 + 8 --> 11
 * 11 --> 1 + 1 --> 2
 * 由于 2 是一位数，所以返回 2。
 * 示例 1:
 *
 * 输入: num = 0
 * 输出: 0
 *
 * @author : yixihan
 * @create : 2022-03-03-12:38
 */
public class AddDigits {
    public int addDigits(int num) {
        // 方法一
//        List<Integer> list = new ArrayList<>();
//        while (num >= 10 ) {
//            int value = num;
//            while (value >= 1) {
//                list.add (value % 10);
//                value /= 10;
//            }
//            num = 0;
//            for (Integer val : list) {
//                num += val;
//            }
//            list.clear ();
//
//        }
//
//        return num;

        // 方法二
        /*
        假如一个三位数'abc'，其值大小为s1 = 100 * a + 10 * b + 1 * c，经过一次各位相加后，变为s2 = a + b + c，
        减小的差值为(s1 -s2) = 99 * a + 9 * b， 差值可以被9整除，每一个循环都这样，缩小了9的倍数。
        当num小于9，即只有一位时，直接返回num，大于9时，如果能被9整除，则返回9（因为不可能返回0也不可能返回两位数及以上的值），
        如果不能被整除，就返回被9除的余数。
         */
        if (num > 9) {
            num %= 9;
            if (num == 0) {
                return 9;
            }
        }

        return num;
    }
}
