package com.yixihan.random.day0710;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * <p>
 * 输入: nums = [21,21]
 * 输出: 64
 * <p>
 * 输入: nums = [1,2,3,4,5]
 * 输出: 0
 *
 * @author : yixihan
 * @create : 2022-07-10-8:29
 */
public class SumFourDivisors {

    Map<Integer, Integer> map = new HashMap<> ();

    public int sumFourDivisors(int[] nums) {
        int ans = 0;


        for (int num : nums) {
            ans += helper (num);
        }

        return ans;
    }

    public int helper(int n) {
        if (map.containsKey (n)) {
            return map.get (n);
        }
        int count = 2;
        int sum = 0;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (i * i == n) {
                    count++;  //平方数时只能算一个因数
                    sum += i;
                } else {
                    count += 2;
                    sum += (i + n / i);
                }
            }
            if (count > 4) {
                map.put (n, 0);
                return 0;//剪枝
            }
        }
        if (count == 4) {
            map.put (n, sum + 1 + n);
            return sum + 1 + n; //加上1和本身
        }
        map.put (n, 0);
        return 0; //不满足情况则返回0
    }
}
