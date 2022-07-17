package com.yixihan.random.day0717;

import java.util.*;

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。
 * 你可以按 任意顺序 返回答案。
 * <p>
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * @author : yixihan
 * @create : 2022-07-17-9:20
 */
public class CommonChars {

    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        if (words.length == 0) {
            return ans;
        }
        int[] hash = new int[26];
        for (char c : words[0].toCharArray ()) {
            hash[c - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] hashOtherStr = new int[26];
            for (char c : words[i].toCharArray ()) {
                hashOtherStr[c - 'a']++;
            }

            for (int k = 0; k < 26; k++) {
                hash[k] = Math.min (hash[k], hashOtherStr[k]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (hash[i] != 0) { // 注意这里是while，多个重复的字符
                char c= (char) (i+'a');
                ans.add(String.valueOf(c));
                hash[i]--;
            }
        }

        return ans;
    }
}
