package com.yixihan.random.day0716;

/**
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”。
 * <p>
 * <p>
 * 输入：0.625
 * 输出："0.101"
 * <p>
 * 输入：0.1
 * 输出："ERROR"
 * 提示：0.1无法被二进制准确表示
 *
 * @author : yixihan
 * @create : 2022-07-16-7:58
 */
public class PrintBin {

    public String printBin(double num) {
        if (num < 0 || num >= 1) {
            return "ERROR";
        }
        StringBuilder sb = new StringBuilder ();
        sb.append ("0.");
        while (num != 0) {
            num *= 2;
            sb.append (num - 1 >= 0 ? 1 : 0);
            if (num >= 1) {
                num--;
            }
            if (sb.length () > 32) {
                return "ERROR";
            }
        }
        return sb.toString ();
    }
}
