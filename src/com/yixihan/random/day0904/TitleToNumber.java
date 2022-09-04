package com.yixihan.random.day0904;

/**
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
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
 * 输入: columnTitle = "A"
 * 输出: 1
 * <p>
 * 输入: columnTitle = "AB"
 * 输出: 28
 * <p>
 * 输入: columnTitle = "ZY"
 * 输出: 701
 *
 * @author : yixihan
 * @create : 2022-09-04-10:00
 */
public class TitleToNumber {

    public int titleToNumber(String columnTitle) {
        int tmp = 1;
        int ans = 0;

        char[] charArray = columnTitle.toCharArray ();
        for (int i = charArray.length - 1; i >= 0; i--) {
            ans += (charArray[i] - 'A' + 1) * tmp;
            tmp *= 26;
        }

        return ans;
    }
}
