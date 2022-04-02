package com.yixihan.greedy;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *
 * @author : yixihan
 * @create : 2022-03-17-14:25
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        // 遍历每个字符，得出每个字符最后出现的index
        // 用栈数据结构保存字符串，后进先出
        // 记录某个字符是否已再栈中保存

        // 获取字符串数组
        char[] chars = s.toCharArray ();

        // 定义一个长度为26的数组，记录每个字符最后出现的index
        int[] num = new int[26];
        for (int i = 0; i < chars.length; i++) {
            num[chars[i] - 'a'] = i;
        }

        // 定义栈
        Deque<Character> stack = new ArrayDeque<> ();
        // 定义某个字符是否保存在栈中
        boolean[] visited = new boolean[26];

        // 开始遍历字符
        for (int i = 0; i < chars.length; i++) {
            // 如果当前字符已经再栈中，则continue
            if (visited[chars[i] - 'a']) {
                continue;
            }

            // 取出栈顶字符和当前字符作比较，while循环
            /**
             【1】栈必须非空
             【2】取出栈顶元素和当前元素比较，栈顶元素比当前大
             【3】栈顶元素再当前字符后面，还存在，则移除栈顶元素
             */
            // 此处必须要用while，用if就会有遗漏，参考测试用例 "bcabdcacndjhcsdjabcddend"
            while (!stack.isEmpty () && stack.peekLast () > chars[i] && num[stack.peekLast () - 'a'] > i) {
                //移除栈顶元素
                Character c = stack.removeLast ();
                //表示该字符没有在栈中出现
                visited[c - 'a'] = false;
                System.out.println ("当前元素【" + chars[i] + "】比栈顶元素【" + c + "】小" + "，而且栈顶元素再后面还存在" + "，需要移除了栈顶元素");
            }

            // 否则将该字符加入栈中，并设置已经存在栈中
            stack.addLast (chars[i]);
            System.out.println (chars[i] + "压入栈中，成功啦");

            visited[chars[i] - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder ();
        for (Character c : stack) {
            sb.append (c);
        }

        return sb.toString ();
    }
}
