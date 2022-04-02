package com.yixihan.month02.day1119;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yixihan
 * @create : 2021-11-19-9:15
 */
public class IntegerReplacement {

    private static Map<Long, Integer> map;

    public int integerReplacement(int n) {
        map = new HashMap<>((int) Math.log(n));
        return dfs(n);
    }

    private int dfs (long n) {
        if (n == 1) {
            return 0;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);

        return ans;
    }

}
