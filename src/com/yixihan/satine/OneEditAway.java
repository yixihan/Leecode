package com.yixihan.satine;

import java.util.Map;

/**
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * @author : yixihan
 * @create : 2022-03-04-13:39
 */
public class OneEditAway {
    public boolean oneEditAway(String first, String second) {

        if (Math.abs (first.length () - second.length ()) > 1) {
            return false;
        } else if (first.length () == second.length () && first.length () == 1) {
            return true;
        }

        int count = 0;

        int indexJ = 0;
        int indexI = 0;
        for (; indexI < first.length () && indexJ < second.length (); indexI++, indexJ++) {
            if (first.charAt (indexI) != second.charAt (indexJ)) {
                count++;
                if (indexJ + 1 < second.length () && first.charAt (indexI) == second.charAt (indexJ + 1)) {
                    indexJ++;
                } else if (indexI + 1 < first.length () &&first.charAt (indexI + 1) == second.charAt (indexJ)) {
                    indexI++;
                }

                if (count > 1) {
                    System.out.println (count);
                    return false;
                }
            }
        }
        if (indexI < first.length ()) {
            count += first.length () - indexI;
        }

        if (indexJ < second.length ()) {
            count += second.length () - indexJ;
        }
        return count <= 1;
    }
}
