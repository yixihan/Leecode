package com.yixihan.data_structure_2.day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'.。
 * <p>
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，
 * 返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 *
 * @author : yixihan
 * @create : 2022-04-01-14:14
 */
public class FindRepeatedDnaSequences {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length ();
        List<String> ans = new ArrayList<> ();
        if (n < 10) {
            return ans;
        }
        Map<String, Integer> map = new HashMap<> (n - 10);

        for (int i = 0; i < n - 9; i++) {
            String val = s.substring (i, i + 10);
            map.put (val, map.getOrDefault (val, 0) + 1);

            if (map.get (val) >= 2 && !ans.contains (val)) {
                ans.add (val);
            }
        }

        // System.out.println (map);

        return ans;


    }
}
