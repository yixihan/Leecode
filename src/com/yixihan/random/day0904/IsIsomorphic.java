package com.yixihan.random.day0904;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。
 * 不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-09-04-10:11
 */
public class IsIsomorphic {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<> ();
        char[] arr1 = s.toCharArray ();
        char[] arr2 = t.toCharArray ();
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey (arr1[i])) {
                if (map.containsValue (arr2[i])) {
                    return false;
                }

                map.put (arr1[i], arr2[i]);
            } else {
                if (map.get (arr1[i]) != arr2[i]) {
                    return false;
                }
            }

        }
        System.out.println (map);


        return true;
    }
}
