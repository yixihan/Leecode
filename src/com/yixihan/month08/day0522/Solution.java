package com.yixihan.month08.day0522;

import java.util.HashMap;
import java.util.Map;

/**
 * 在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，
 * 先使得累计整数和 达到或超过  100 的玩家，即为胜者。
 * <p>
 * 如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
 * <p>
 * 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
 * <p>
 * 给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），
 * 若先出手的玩家是否能稳赢则返回 true ，否则返回 false 。假设两位玩家游戏时都表现 最佳 。
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 11
 * 输出：false
 * 解释：
 * 无论第一个玩家选择哪个整数，他都会失败。
 * 第一个玩家可以选择从 1 到 10 的整数。
 * 如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
 * 第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
 * 同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 0
 * 输出：true
 * <p>
 * 输入：maxChoosableInteger = 10, desiredTotal = 1
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-05-22-9:03
 */
public class Solution {

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }

        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }

        Map<Integer, Boolean> map = new HashMap<> ();
        return getAns (maxChoosableInteger, desiredTotal, 0, map);
    }

    private boolean getAns(int length, int nowTarget, int used, Map<Integer, Boolean> map) {
        if (map.containsKey (used)) {
            return map.get (used);
        }

        for (int i = 0; i < length; i++) {
            int cur = (1 << i);
            if ((cur & used) == 0) {
                if (nowTarget <= i + 1 || !getAns (length, nowTarget - (i + 1), cur | used, map)) {
                    map.put (used, true);
                    return true;
                }
            }
        }

        map.put (used, false);
        return false;
    }
}
