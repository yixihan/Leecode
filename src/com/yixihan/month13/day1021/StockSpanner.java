package com.yixihan.month13.day1021;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author yixihan
 * @date 2022-10-21-8:57
 */
public class StockSpanner {

    private Deque<int[]> stk = new ArrayDeque<> ();

    public StockSpanner() {

    }

    public int next(int price) {
        int cnt = 1;
        while (!stk.isEmpty () && stk.peek ()[0] <= price) {
            cnt += stk.pop ()[1];
        }
        stk.push (new int[]{price, cnt});
        return cnt;
    }

}
