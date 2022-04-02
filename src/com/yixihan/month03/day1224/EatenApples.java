package com.yixihan.month03.day1224;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i] 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 *
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 *
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 *
 * 输入：apples = [1,2,3,5,2], days = [3,2,1,4,2]
 * 输出：7
 * 解释：你可以吃掉 7 个苹果：
 * - 第一天，你吃掉第一天长出来的苹果。
 * - 第二天，你吃掉一个第二天长出来的苹果。
 * - 第三天，你吃掉一个第二天长出来的苹果。过了这一天，第三天长出来的苹果就已经腐烂了。
 * - 第四天到第七天，你吃的都是第四天长出来的苹果。
 *
 * 输入：apples = [3,0,0,0,0,2], days = [3,0,0,0,0,2]
 * 输出：5
 * 解释：你可以吃掉 5 个苹果：
 * - 第一天到第三天，你吃的都是第一天长出来的苹果。
 * - 第四天和第五天不吃苹果。
 * - 第六天和第七天，你吃的都是第六天长出来的苹果。
 *
 * @author : yixihan
 * @create : 2021-12-24-0:14
 */
public class EatenApples {

    public int eatenApples(int[] apples, int[] days) {

        Queue<int[]> queue = new PriorityQueue<> (Comparator.comparingInt (o -> (o[1] + o[2])));
        int max = 0;

        for (int i = 0; i < apples.length + 20000; i++) {

            // 放入当天的苹果
            if (apples.length > i && apples[i] > 0 && days[i] > 0) {
                queue.add (new int[] {apples[i], i, days[i]});
            }

            // 吃最早过期的苹果
            if (! queue.isEmpty ()) {
                int[] cur = queue.poll ();

                if (cur[0]-- > 0 && i < cur[1] + cur[2]) {
                    if (cur[0] > 0) {
                        queue.offer (cur);
                    }
                    max++;
                }
            }

            // 取出今天过期的苹果
            while (! queue.isEmpty () && i + 1 == queue.peek ()[1] + queue.peek ()[2]) {
                queue.poll ();
            }
        }

        return max;
    }

    public int eatenApples2(int[] apples, int[] days) {
        int day = 0;
        //找出苹果还未全部腐烂的最后日期
        for (int i = 0; i < days.length; i++) {
            day = Math.max (i + days[i], day);
        }
        //下标值表示失效日期，存储在当天后即腐烂的苹果数
        int[] tmp = new int[day];
        int curMax = day, res = 0;
        for (int i = 0; i < day; i++) {
            //保存当天新长出的苹果
            if (i < apples.length && apples[i] != 0) {
                tmp[i + days[i] - 1] += apples[i];
                curMax = Math.min (curMax, i + days[i] - 1);
            }
            //有苹果就拿出来吃掉
            int idx = Math.max (i, curMax);
            while (idx < day && tmp[idx] == 0) {
                idx++;
            }
            if (idx != day) {
                tmp[idx]--;
                res++;
            }
        }
        return res;
    }
}
