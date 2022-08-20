package com.yixihan.random.day0818;

/**
 * 句子 是由若干个单词组成的字符串，单词之间用单个空格分隔，其中每个单词可以包含数字、小写字母、和美元符号 '$' 。
 * 如果单词的形式为美元符号后跟着一个非负实数，那么这个单词就表示一个价格。
 * <p>
 * 例如 "$100"、"$23" 和 "$6.75" 表示价格，而 "100"、"$" 和 "2$3" 不是。
 * 注意：本题输入中的价格均为整数。
 * <p>
 * 给你一个字符串 sentence  和一个整数 discount 。
 * 对于每个表示价格的单词，都在价格的基础上减免 discount% ，并 更新 该单词到句子中。
 * 所有更新后的价格应该表示为一个 恰好保留小数点后两位 的数字。
 * <p>
 * 返回表示修改后句子的字符串。
 * <p>
 * 输入：sentence = "there are $1 $2 and 5$ candies in the shop", discount = 50
 * 输出："there are $0.50 $1.00 and 5$ candies in the shop"
 * 解释：
 * 表示价格的单词是 "$1" 和 "$2" 。
 * - "$1" 减免 50% 为 "$0.50" ，所以 "$1" 替换为 "$0.50" 。
 * - "$2" 减免 50% 为 "$1" ，所以 "$1" 替换为 "$1.00" 。
 * <p>
 * 输入：sentence = "1 2 $3 4 $5 $6 7 8$ $9 $10$", discount = 100
 * 输出："1 2 $0.00 4 $0.00 $0.00 7 8$ $0.00 $10$"
 * 解释：
 * 任何价格减免 100% 都会得到 0 。
 * 表示价格的单词分别是 "$3"、"$5"、"$6" 和 "$9"。
 * 每个单词都替换为 "$0.00"。
 *
 * @author : yixihan
 * @create : 2022-08-18-13:45
 */
public class DiscountPrices {

    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder ();
        double percentage = (100 - (double) discount) / 100;

        for (String split : sentence.split (" ")) {
            if (split.startsWith ("$")) {
                System.out.println (111);
                try {
                    String format = String.format ("%.2f", Long.parseLong (split.substring (1)) * percentage);
                    sb.append ("$").append (format).append (" ");
                } catch (Exception e) {
                    sb.append (split).append (" ");
                }
            } else {
                sb.append (split).append (" ");
            }
        }

        return sb.deleteCharAt (sb.length () - 1).toString ();
    }
}