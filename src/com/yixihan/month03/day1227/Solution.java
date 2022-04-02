package com.yixihan.month03.day1227;

/**
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 *
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 *
 * age[y] <= 0.5 * age[x] + 7
 * age[y] > age[x]
 * age[y] > 100 && age[x] < 100
 * 否则，x 将会向 y 发送一条好友请求。
 *
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 *
 * 返回在该社交媒体网站上产生的好友请求总数。
 *
 * 输入：ages = [16,16]
 * 输出：2
 * 解释：2 人互发好友请求。
 *
 * 输入：ages = [16,17,18]
 * 输出：2
 * 解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 *
 * 输入：ages = [20,30,100,110,120]
 * 输出：3
 * 解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 *
 * @author : yixihan
 * @create : 2021-12-27-14:56
 */
public class Solution {

    private static final int N = 130;

    public int numFriendRequests(int[] ages) {

        int[] nums = new int[N];
        int ans = 0;

        for (int i : ages) {
            nums[i]++;
        }
        for (int i = 1; i < N; i++) {
            nums[i] += nums[i - 1];
        }
        for (int y = 1, x = 1; y < N; y++) {
            // 有 a 个 y
            int a = nums[y] - nums[y - 1];
            if (a == 0) {
                continue;
            }
            if (x < y) {
                x = y;
            }
            while (x < N && check (x, y)) {
                x++;
            }
            // [y, x) 为合法的 x 范围，对于每个 y 而言，有 b 个 x
            int b = nums[x - 1] - nums[y - 1] - 1;
            if (b > 0) {
                ans += b * a;
            }
        }
        return ans;
    }

    private boolean check(int x, int y) {

        if (y <= 0.5 * x + 7){
            return false;
        }
        return y <= x;
    }

}
