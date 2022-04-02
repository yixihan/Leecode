package com.yixihan.programming_ability_1.day4;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * 输入：n = 2
 * 输出：false
 *
 * @author : yixihan
 * @create : 2022-03-14-11:32
 */
public class IsHappy {
    Set<Integer> set = new HashSet<> ();

    public boolean isHappy(int n) {
        // 方法一 : Set
//        if (n == 1) {
//            return true;
//        }
//
//        if (set.contains (n)) {
//            return false;
//        }
//        set.add (n);
//        int ans = 0;
//
//        while (n > 0) {
//            ans += (n % 10) * (n % 10);
//            n /= 10;
//        }
//
//
//        return isHappy (ans);
        // 方法二 : 快慢指针
        if (n == 1) {
            return true;
        }

        int num1 = n;
        int num2 = getNext (n);

        while (num1 != num2) {
            num1 = getNext (num1);
            num2 = getNext (num2);
            num2 = getNext (num2);

            if (num1 == 1 || num2 == 1) {
                return true;
            }
        }

        return false;
    }

    private int getNext (int n) {
        int ans = 0;

        while (n > 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }

        return ans;
    }
}
