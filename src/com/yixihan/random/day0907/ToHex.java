package com.yixihan.random.day0907;

/**
 * 给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。
 * <p>
 * 注意:
 * <p>
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；
 * 对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * <p>
 * 输入:
 * 26
 * <p>
 * 输出:
 * "1a"
 * <p>
 * 输入:
 * -1
 * <p>
 * 输出:
 * "ffffffff"
 *
 * @author : yixihan
 * @create : 2022-09-07-13:52
 */
public class ToHex {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder ();
        while (num > 0 && sb.length () < 8) {
            sb.append (hex[num & 0xf]);
            num >>= 4;
        }

        return sb.reverse ().toString ();
    }
}
