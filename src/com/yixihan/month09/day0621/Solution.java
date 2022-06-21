package com.yixihan.month09.day0621;

/**
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * <p>
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 * @author : yixihan
 * @create : 2022-06-21-9:36
 */
public class Solution {
    public String defangIPaddr(String address) {
        char[] arr = address.toCharArray ();
        StringBuilder sb = new StringBuilder ();

        for (char c : arr) {
            if (c == '.') {
                sb.append ("[.]");
            } else {
                sb.append (c);
            }
        }

        return sb.toString ();
    }
}
