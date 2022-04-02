package com.yixihan.month03.day0106;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 *
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 *
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 *
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 *
 * @author : yixihan
 * @create : 2022-01-06-12:13
 */
public class Solution {

    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String[] split = path.split ("/");
        StringBuilder builder = new StringBuilder();

        for (String s : split) {

            if (".".equals (s) || "".equals (s) || ("..".equals (s) && stack.isEmpty ())) {
                continue;
            } else if ("..".equals (s)) {
                stack.pop ();
            } else {
                stack.push (s);
            }
        }

        while (! stack.isEmpty ()) {
            builder.insert (0, stack.pop ());
            builder.insert (0, "/");
        }

        if(builder.length() == 0) {
            builder.append("/");
        }
        return builder.toString ();
    }
}
