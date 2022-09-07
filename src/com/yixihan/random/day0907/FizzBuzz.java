package com.yixihan.random.day0907;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * <p>
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 * <p>
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * <p>
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * <p>
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * @author : yixihan
 * @create : 2022-09-07-13:59
 */
public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<> (n);

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add ("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add ("Fizz");
            } else if (i % 5 == 0) {
                list.add ("Buzz");
            } else {
                list.add (String.valueOf (i));
            }
        }

        return list;
    }
}
