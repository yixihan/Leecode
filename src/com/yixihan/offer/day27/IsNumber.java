package com.yixihan.offer.day27;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * <p>
 * 输入：s = "0"
 * 输出：true
 * <p>
 * 输入：s = "e"
 * 输出：false
 * <p>
 * 输入：s = "."
 * 输出：false
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-03-18-12:53
 */
public class IsNumber {

    /**
     * ‘.’出现正确情况：只出现一次，且在e的前面
     * <p>
     * ‘e’出现正确情况：只出现一次，且出现前有数字
     * <p>
     * ‘+’‘-’出现正确情况：只能在开头和e后一位
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        if (s == null || s.length () == 0) return false;
        //去掉首位空格
        s = s.trim ();
        char[] chars = s.toCharArray ();
        int n = chars.length;
        boolean numFlag = false;
        boolean dotFlag = false;
        boolean eFlag = false;
        
        for (int i = 0; i < n; i++) {
            //判定为数字，则标记numFlag
            if (chars[i] >= '0' && chars[i] <= '9') {
                numFlag = true;
                //判定为.  需要没出现过.并且没出现过e
            } else if (chars[i] == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                //判定为e，需要没出现过e，并且出过数字了
            } else if ((chars[i] == 'e' || chars[i] == 'E') && !eFlag && numFlag) {
                eFlag = true;
                numFlag = false;//为了避免123e这种请求，出现e之后就标志为false
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((chars[i] == '+' || chars[i] == '-') && (i == 0 || chars[i - 1] == 'e' || chars[i - 1] == 'E')) {
                continue;
                //其他情况，都是非法的
            } else {
                return false;
            }
        }
        return numFlag;
    }
}
