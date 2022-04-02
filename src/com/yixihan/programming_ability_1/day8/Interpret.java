package com.yixihan.programming_ability_1.day8;

/**
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。
 * 然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *
 * @author : yixihan
 * @create : 2022-03-18-14:29
 */
public class Interpret {
    public String interpret(String command) {
        StringBuilder sb = new StringBuilder (command.length ());
        char[] chars = command.toCharArray ();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'G') {
                sb.append ("G");
            } else if (chars[i] == '(' && chars[i + 1] == 'a') {
                i += 3;
                sb.append ("al");
            } else if (chars[i] == '(' && chars[i + 1] == ')') {
                i += 1;
                sb.append ("o");
            }
        }
        return sb.toString ();
    }
}
