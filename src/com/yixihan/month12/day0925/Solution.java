package com.yixihan.month12.day0925;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。
 * 0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；
 * 6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 *
 * @author : yixihan
 * @date : 2022-09-25-10:31
 */
public class Solution {

    Map<Character, Character> map = new HashMap<> (6);

    {
        map.put ('0', '0');
        map.put ('1', '1');
        map.put ('2', '5');
        map.put ('5', '2');
        map.put ('6', '9');
        map.put ('8', '8');
        map.put ('9', '6');
    }

    public int rotatedDigits(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (helper (i)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean helper(int num) {
        String str = String.valueOf (num);
        StringBuilder sb = new StringBuilder ();
        for (char c : str.toCharArray ()) {
            if (map.containsKey (c)) {
                sb.append (map.get (c));
            } else {
                return false;
            }
        }

        return !sb.toString ().equals (str);
    }
}
