package com.yixihan.random.day0922;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 * 求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *
 * @author : yixihan
 * @create : 2022-09-22-9:17
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<> (n);
        for (int i = 0; i < n; i++) {
            list.add (i);
        }

        int index = 0;
        while (list.size () > 1) {
            index += m - 1;
            index = index % list.size ();
            list.remove (index);
        }

        return list.get (0);

        // 数学公式
        /*
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
         */
    }
}
