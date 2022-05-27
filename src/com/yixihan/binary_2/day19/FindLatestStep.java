package com.yixihan.binary_2.day19;

import java.util.TreeSet;

/**
 * 给你一个数组 arr ，该数组表示一个从 1 到 n 的数字排列。有一个长度为 n 的二进制字符串，该字符串上的所有位最初都设置为 0 。
 * <p>
 * 在从 1 到 n 的每个步骤 i 中（假设二进制字符串和 arr 都是从 1 开始索引的情况下），二进制字符串上位于位置 arr[i] 的位将会设为 1 。
 * <p>
 * 给你一个整数 m ，请你找出二进制字符串上存在长度为 m 的一组 1 的最后步骤。一组 1 是一个连续的、由 1 组成的子串，且左右两边不再有可以延伸的 1 。
 * <p>
 * 返回存在长度 恰好 为 m 的 一组 1  的最后步骤。如果不存在这样的步骤，请返回 -1 。
 * <p>
 * 输入：arr = [3,5,1,2,4], m = 1
 * 输出：4
 * 解释：
 * 步骤 1："00100"，由 1 构成的组：["1"]
 * 步骤 2："00101"，由 1 构成的组：["1", "1"]
 * 步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
 * 步骤 4："11101"，由 1 构成的组：["111", "1"]
 * 步骤 5："11111"，由 1 构成的组：["11111"]
 * 存在长度为 1 的一组 1 的最后步骤是步骤 4 。
 * <p>
 * 输入：arr = [3,1,5,4,2], m = 2
 * 输出：-1
 * 解释：
 * 步骤 1："00100"，由 1 构成的组：["1"]
 * 步骤 2："10100"，由 1 构成的组：["1", "1"]
 * 步骤 3："10101"，由 1 构成的组：["1", "1", "1"]
 * 步骤 4："10111"，由 1 构成的组：["1", "111"]
 * 步骤 5："11111"，由 1 构成的组：["11111"]
 * 不管是哪一步骤都无法形成长度为 2 的一组 1 。
 * <p>
 * 输入：arr = [1], m = 1
 * 输出：1
 * <p>
 * 输入：arr = [2,1], m = 2
 * 输出：2
 *
 * @author : yixihan
 * @create : 2022-05-27-12:05
 */
public class FindLatestStep {
    public int findLatestStep(int[] arr, int m) {
        if (m == arr.length) {
            return m;
        }
        // 左开右开区间，两个连续的数之间包含为连续的1长度
        TreeSet<Integer> treeSet = new TreeSet<> ();
        treeSet.add (0);
        treeSet.add (arr.length + 1);
        // 逆序拆分，使用了tree加速查找拆分的位置，并在每次拆分后判断左右连续1的长度是否符合条件
        for (int i = arr.length - 1; i >= 0; i--) {
            int divIndex = arr[i];
            int lower = treeSet.lower (divIndex);
            int higher = treeSet.higher (divIndex);
            if (divIndex - lower - 1 == m || higher - divIndex - 1 == m) {
                return i;
            } else {
                treeSet.add (divIndex);
            }
        }
        return -1;
    }
}
