package com.yixihan.random.day0904;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
 * <p>
 * 例如：
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 输入：columnNumber = 1
 * 输出："A"
 * <p>
 * 输入：columnNumber = 28
 * 输出："AB"
 * <p>
 * 输入：columnNumber = 701
 * 输出："ZY"
 * <p>
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 *
 * @author : yixihan
 * @create : 2022-09-04-9:48
 */
public class ConvertToTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder ();

        for (int i = columnNumber; i > 0; i /= 26) {
            i--;
            sb.append ((char) (i % 26 + 'A'));
        }

        return sb.reverse ().toString ();
    }
}
