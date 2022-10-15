package com.yixihan.month12.day1015;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个数组 target 和一个整数 n。每次迭代，需要从  list = { 1 , 2 , 3 ..., n } 中依次读取一个数字。
 * <p>
 * 请使用下述操作来构建目标数组 target ：
 * <p>
 * "Push"：从 list 中读取一个新元素， 并将其推入数组中。
 * "Pop"：删除数组中的最后一个元素。
 * 如果目标数组构建完成，就停止读取更多元素。
 * 题目数据保证目标数组严格递增，并且只包含 1 到 n 之间的数字。
 * <p>
 * 请返回构建目标数组所用的操作序列。如果存在多个可行方案，返回任一即可。
 * <p>
 * 输入：target = [1,3], n = 3
 * 输出：["Push","Push","Pop","Push"]
 * 解释：
 * 读取 1 并自动推入数组 -> [1]
 * 读取 2 并自动推入数组，然后删除它 -> [1]
 * 读取 3 并自动推入数组 -> [1,3]
 * <p>
 * 输入：target = [1,2,3], n = 3
 * 输出：["Push","Push","Push"]
 * <p>
 * 输入：target = [1,2], n = 4
 * 输出：["Push","Push"]
 * 解释：只需要读取前 2 个数字就可以停止。
 *
 * @author yixihan
 * @date 2022-10-15-11:53
 */
public class Solution {

    static String[] action = {"Push", "Pop"};

    public List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<> ();
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (index < target.length && target[index] == i) {
                list.add (action[0]);
                index++;
            } else if (index >= target.length) {
                break;
            } else {
                list.add (action[0]);
                list.add (action[1]);
            }
        }

        return list;
    }
}
