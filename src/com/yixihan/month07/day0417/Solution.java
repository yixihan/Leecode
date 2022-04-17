package com.yixihan.month07.day0417;

import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-04-17-14:38
 */
public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] splits = paragraph.toLowerCase ().split("[ ,.!?:;']");
        Map<String, Integer> map = new HashMap<>(splits.length);
        Set<String> set = new HashSet<>(Arrays.asList(banned));

        for (String split : splits) {
            if (!"".equals (split) && ! set.contains (split)) {
                map.put (split, map.getOrDefault (split, 0) + 1);
            }
        }

        System.out.println (map);
        String ans = "";
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet ()) {
            if (max < entry.getValue ()) {
                max = entry.getValue ();
                ans = entry.getKey ();
            }
        }
        return ans;
    }

}
