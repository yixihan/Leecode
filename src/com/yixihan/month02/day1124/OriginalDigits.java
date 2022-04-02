package com.yixihan.month02.day1124;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 *
 * 输入：s = "owoztneoer"
 * 输出："012"
 *
 * 输入：s = "fviefuro"
 * 输出："45"
 *
 * @author : yixihan
 * @create : 2021-11-24-12:28
 */
public class OriginalDigits {

    /**
     * zero one two three four five six seven eight nine
     * z         w         u         x         g
     *       o       t          f         v          n
     *
     * 根据数字中的独一无二字符找值, 最笨比的方法
     */
    public String originalDigits(String s) {

        Map<Character, Integer> map = new HashMap<>(16);
        StringBuilder builder = new StringBuilder(s.length() / 4);

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 0
        while (map.containsKey('z') && map.get('z') > 0) {
            builder.append(0);
            map.put('z', map.get('z') - 1);
            map.put('e', map.get('e') - 1);
            map.put('r', map.get('r') - 1);
            map.put('o', map.get('o') - 1);
        }

        // 2
        while (map.containsKey('w') && map.get('w') > 0) {
            builder.append(2);
            map.put('t', map.get('t') - 1);
            map.put('w', map.get('w') - 1);
            map.put('o', map.get('o') - 1);
        }

        // 4
        while (map.containsKey('u') && map.get('u') > 0) {
            builder.append(4);
            map.put('f', map.get('f') - 1);
            map.put('o', map.get('o') - 1);
            map.put('u', map.get('u') - 1);
            map.put('r', map.get('r') - 1);
        }

        // 6
        while (map.containsKey('x') && map.get('x') > 0) {
            builder.append(6);
            map.put('s', map.get('s') - 1);
            map.put('i', map.get('i') - 1);
            map.put('x', map.get('x') - 1);
        }

        // 8
        while (map.containsKey('g') && map.get('g') > 0) {
            builder.append(8);
            map.put('e', map.get('e') - 1);
            map.put('i', map.get('i') - 1);
            map.put('g', map.get('g') - 1);
            map.put('h', map.get('h') - 1);
            map.put('t', map.get('t') - 1);
        }

        // 1
        while (map.containsKey('o') && map.get('o') > 0) {
            builder.append(1);
            map.put('o', map.get('o') - 1);
            map.put('n', map.get('e') - 1);
            map.put('e', map.get('e') - 1);
        }

        // 3
        while (map.containsKey('t') && map.get('t') > 0) {
            builder.append(3);
            map.put('t', map.get('t') - 1);
            map.put('h', map.get('h') - 1);
            map.put('r', map.get('r') - 1);
            map.put('e', map.get('e') - 1);
            map.put('e', map.get('e') - 1);
        }

        // 5
        while (map.containsKey('f') && map.get('f') > 0) {
            builder.append(5);
            map.put('f', map.get('f') - 1);
            map.put('i', map.get('i') - 1);
            map.put('v', map.get('v') - 1);
            map.put('e', map.get('e') - 1);
        }

        // 7
        while (map.containsKey('v') && map.get('v') > 0) {
            builder.append(7);
            map.put('s', map.get('s') - 1);
            map.put('e', map.get('e') - 1);
            map.put('v', map.get('v') - 1);
            map.put('e', map.get('e') - 1);
            map.put('n', map.get('n') - 1);
        }

        // 9
        while (map.containsKey('i') && map.get('i') > 0) {
            builder.append(9);
            map.put('n', map.get('n') - 1);
            map.put('i', map.get('i') - 1);
            map.put('n', map.get('n') - 1);
            map.put('e', map.get('e') - 1);
        }


        char[] chars = builder.toString().toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }
}
