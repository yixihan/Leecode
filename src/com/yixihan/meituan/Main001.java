package com.yixihan.meituan;

import java.util.Scanner;

/**
 * 小美是美团的前端工程师，为了防止系统被恶意攻击，小美必须要在用户输入用户名之前做一个合法性检查，
 * 一个合法的用户名必须满足以下几个要求：
 * <p>
 * 用户名的首字符必须是大写或者小写字母。
 * 用户名只能包含大小写字母，数字。
 * 用户名需要包含至少一个字母和一个数字。
 * 如果用户名合法，请输出 "Accept"，反之输出 "Wrong"。
 * 格式：
 * <p>
 * 输入：
 * - 输入第一行包含一个正整数 T，表示需要检验的用户名数量。
 * - 接下来有 T 行，每行一个字符串 s，表示输入的用户名。
 * 输出：
 * - 对于每一个输入的用户名 s，请输出一行，即按题目要求输出一个字符串。
 * <p>
 * 输入：
 * 5
 * Ooook
 * Hhhh666
 * ABCD
 * Meituan
 * 6666
 * 输出：
 * Wrong
 * Accept
 * Wrong
 * Wrong
 * Wrong
 *
 * @author : yixihan
 * @create : 2022-04-14-15:45
 */
public class Main001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt ();
        String[] names = new String[t];

        for (int i = 0; i < t; i++) {
            names[i] = sc.next ();
        }

        sc.close ();

        for (String name : names) {
            System.out.println (check (name));
        }

    }

    public static String check(String name) {
        boolean numFlag = false;
        char firstLetter = name.charAt (0);
        if (verifyLetter (firstLetter)) {
            for (char c : name.toCharArray ()) {
                if (verifyNum (c) || verifyLetter (c)) {
                    numFlag = true;
                } else {
                    return "Wrong";
                }
            }

            if (numFlag) {
                return "Accept";
            }

        }
        return "Wrong";
    }

    private static boolean verifyNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean verifyLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
