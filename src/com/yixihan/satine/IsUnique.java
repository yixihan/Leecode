package com.yixihan.satine;

import java.util.HashSet;
import java.util.Set;

/**
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * @author : yixihan
 * @create : 2022-03-03-17:13
 */
public class IsUnique {
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        boolean flag = true;
        for (int i = 0; i < astr.length (); i++) {
            char val = astr.charAt (i);
            if (! set.contains (val)) {
                set.add (val);
            } else {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
