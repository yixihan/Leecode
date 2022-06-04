package com.yixihan.month08.day0604;

import java.util.HashSet;
import java.util.Set;

/**
 * 每个 有效电子邮件地址 都由一个 本地名 和一个 域名 组成，以 '@' 符号分隔。
 * 除小写字母之外，电子邮件地址还可以含有一个或多个 '.' 或 '+' 。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是 本地名 ，而 leetcode.com 是 域名 。
 * 如果在电子邮件地址的 本地名 部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名中没有点的同一地址。
 * 请注意，此规则 不适用于域名 。
 * <p>
 * 例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。
 * 如果在 本地名 中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件。同样，此规则 不适用于域名 。
 * <p>
 * 例如 m.y+name@email.com 将转发到 my@email.com。
 * 可以同时使用这两个规则。
 * <p>
 * 给你一个字符串数组 emails，我们会向每个 emails[i] 发送一封电子邮件。返回实际收到邮件的不同地址数目。
 * <p>
 * 输入：emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 * <p>
 * 输入：emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
 * 输出：3
 *
 * @author : yixihan
 * @create : 2022-06-04-14:25
 */
public class Solution {

    Set<String> set = new HashSet<> ();

    public int numUniqueEmails(String[] emails) {
        for (String email : emails) {
            judgeEmail (email);
        }

        return set.size ();
    }

    private void judgeEmail(String email) {
        char[] arr = email.toCharArray ();
        int n = arr.length;
        StringBuilder sb = new StringBuilder ();
        boolean add = false;
        boolean and = false;

        for (char c : arr) {
            if (c == '+') {
                add = true;
                continue;
            }
            if (c == '@') {
                and = true;
            }
            if (add && !and || c == '.' && !and) {
                continue;
            }

            sb.append (c);
        }

        System.out.println (sb);

        set.add (sb.toString ());
    }
}
