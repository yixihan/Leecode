package com.yixihan.month01.day1018;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yixihan
 */
public class NumberComplement {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int complement = findComplement(i);
        System.out.println(complement);
    }

    public static int findComplement(int num) {

        BigInteger bigInteger1 = new BigInteger(String.valueOf(num));
        String str = bigInteger1.toString(2);

        String[] split = str.split("");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            if ("1".equals(s)) {
                builder.append("0");
            } else {
                builder.append("1");
            }
        }

        return Integer.parseInt(builder.toString(), 2);
    }

    @Test
    public void test1 () {
        String res = Integer.toBinaryString(5);
        System.out.println(res);

        // 将字符串转换为数字进行打印，但不建议这么做，当为负数时，int型的表示不了32的一个整数，另外，int的位数有大小，打印的值超出范围就会报错
        int in = Integer.parseInt(res);
        System.out.print(in + "\n");
    }
}
