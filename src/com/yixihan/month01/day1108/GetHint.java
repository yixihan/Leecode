package com.yixihan.month01.day1108;

import org.junit.jupiter.api.Test;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 *
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 *
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛），
 * 有多少位属于数字猜对了但是位置不对（称为 "Cows", 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 *
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 *
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 *
 * 输入: secret = "1807", guess = "7810"
 * 输出: "1A3B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1807"
 *   |
 * "7810"
 *
 * 输入: secret = "1123", guess = "0111"
 * 输出: "1A1B"
 * 解释: 数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 *
 * 输入：secret = "1", guess = "0"
 * 输出："0A0B"
 *
 * @author : yixihan
 * @create : 2021-11-08-11:21
 */
public class GetHint {

    public String getHint(String secret, String guess) {

        int[] nums = new int[10];
        int countA = 0;
        int countB = 0;
        StringBuilder buffer = new StringBuilder(4);

        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                countA++;
            } else{
                if (nums[guess.charAt(i) - '0']-- > 0) {
                    countB++;
                }
                if(nums[secret.charAt(i) - '0']++ < 0) {
                    countB++;
                }
            }
        }
        return buffer.append(countA).append("A").append(countB).append("B").toString();
        // return countA + "A" + countB + "B";
    }

    @Test
    public void test () {
        System.out.println(getHint("1123", "0111"));
        System.out.println(getHint("1807", "7810"));
    }
}
