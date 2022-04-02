package com.yixihan.programming_ability_2.day6;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *
 * @author : yixihan
 * @create : 2022-03-28-9:22
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<> ();
        stack.push (0);

        for (int i = 1; i < n; i++) {
            int count = 0;
            while (!stack.isEmpty () && temperatures[stack.peek ()] < temperatures[i]) {
                int k = stack.peek ();
                if (temperatures[k] < temperatures[i]) {
                    ans[k] = i - k;
                    stack.pop ();
                } else {
                    break;
                }
            }
            stack.push (i);
        }

        return ans;
    }
}
