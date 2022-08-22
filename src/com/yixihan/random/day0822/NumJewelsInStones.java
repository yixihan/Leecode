package com.yixihan.random.day0822;

/**
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * <p>
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * <p>
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * <p>
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 *
 * @author : yixihan
 * @create : 2022-08-22-8:37
 */
public class NumJewelsInStones {

    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;

        for (char c : stones.toCharArray ()) {
            if (jewels.indexOf (c) >= 0) {
                ans++;
            }
        }

        return ans;
    }
}
