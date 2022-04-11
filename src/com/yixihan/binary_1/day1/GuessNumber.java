package com.yixihan.binary_1.day1;

/**
 * 猜数字游戏的规则如下：
 *
 * 每轮游戏，我都会从 1 到 n 随机选择一个数字。 请你猜选出的是哪个数字。
 * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
 * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，返回值一共有 3 种可能的情况（-1，1 或 0）：
 *
 * -1：我选出的数字比你猜的数字小 pick < num
 * 1：我选出的数字比你猜的数字大 pick > num
 * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
 * 返回我选出的数字。
 *
 *
 * 输入：n = 10, pick = 6
 * 输出：6
 *
 * 输入：n = 1, pick = 1
 * 输出：1
 *
 * 输入：n = 2, pick = 1
 * 输出：1
 *
 * 输入：n = 2, pick = 2
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-03-28-14:02
 */
public class GuessNumber {

    private final int pick;

    public GuessNumber(int pick) {
        this.pick = pick;
    }

    public int guessNumber(int n) {
        long left = 1;
        long right = n;

        while (left <= right) {
            System.out.println ("left : " + left + ", right : " + right);
            long mid = (left + right) / 2;
            if (guess ((int) mid) == 1) {
                left = mid + 1;
            } else if (guess ((int) mid) == -1) {
                right = mid - 1;
            } else {
                return (int) mid;
            }
        }

        return -1;
    }

    private int guess(int num) {
        return Integer.compare (num, pick);
    }
}
