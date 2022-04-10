package com.yixihan.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。
 * 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 * <p>
 * 输入: s = "III"
 * 输出: 3
 * <p>
 * 输入: s = "IV"
 * 输出: 4
 * <p>
 * 输入: s = "IX"
 * 输出: 9
 * <p>
 * 输入: s = "LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * <p>
 * 输入: s = "MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * @author : yixihan
 * @create : 2022-04-10-15:52
 */
public class RomanToInt {

    Map<Character, Integer> map = new HashMap<> (16);

    {
        map.put ('I', 1);
        map.put ('V', 5);
        map.put ('X', 10);
        map.put ('L', 50);
        map.put ('C', 100);
        map.put ('D', 500);
        map.put ('M', 1000);
    }

    public int romanToInt(String s) {
        int ans = 0;
        char[] arr = s.toCharArray ();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && arr[i] == 'I' && arr[i + 1] == 'V') {
                ans += 4;
                i++;
            } else if (i < n - 1 && arr[i] == 'I' && arr[i + 1] == 'X') {
                ans += 9;
                i++;
            } else if (i < n - 1 && arr[i] == 'X' && arr[i + 1] == 'L') {
                ans += 40;
                i++;
            } else if (i < n - 1 && arr[i] == 'X' && arr[i + 1] == 'C') {
                ans += 90;
                i++;
            } else if (i < n - 1 && arr[i] == 'C' && arr[i + 1] == 'D') {
                ans += 400;
                i++;
            } else if (i < n - 1 && arr[i] == 'C' && arr[i + 1] == 'M') {
                ans += 900;
                i++;
            } else {
                ans += map.get (arr[i]);
            }
        }

        return ans;
    }
}
