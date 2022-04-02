package com.yixihan.offer.day32;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 输入：n = 12
 * 输出：5
 * <p>
 * 输入：n = 13
 * 输出：6
 *
 * @author : yixihan
 * @create : 2022-03-23-13:57
 */
public class CountDigitOne {
    public int countDigitOne(int n) {

        int sum = 0;
        int a;
        int b;
        int c;
        long temp = 1;

        while (n / temp > 0) {
            a = (int) (n / (10 * temp));
            b = (int) ((n / temp) % 10);
            c = (int) (n % temp);

            if (b < 1) {
                sum += a * temp;
            } else if (b == 1) {
                sum += a * temp + c + 1;
            } else {
                sum += (a + 1) * temp;
            }

            temp *= 10;
        }

        return sum;

    }
}
