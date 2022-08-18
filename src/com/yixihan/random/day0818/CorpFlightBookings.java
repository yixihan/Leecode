package com.yixihan.random.day0818;

/**
 * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
 *
 * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
 *
 * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
 *
 * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
 * 输出：[10,55,45,25,25]
 * 解释：
 * 航班编号        1   2   3   4   5
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       20  20
 * 预订记录 3 ：       25  25  25  25
 * 总座位数：      10  55  45  25  25
 * 因此，answer = [10,55,45,25,25]
 *
 * 输入：bookings = [[1,2,10],[2,2,15]], n = 2
 * 输出：[10,25]
 * 解释：
 * 航班编号        1   2
 * 预订记录 1 ：   10  10
 * 预订记录 2 ：       15
 * 总座位数：      10  25
 * 因此，answer = [10,25]
 *
 * @author : yixihan
 * @create : 2022-08-18-14:06
 */
public class CorpFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n];
        int[] c = new int[n + 1];

        for (int[] booking : bookings) {
            int l = booking[0] - 1;
            int r = booking[1] - 1;
            int v = booking[2];
            c[l] += v;
            c[r + 1] -= v;
        }

        ans[0] = c[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + c[i];
        }

        return ans;
    }
}
