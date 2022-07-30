package com.yixihan.month10.day0730;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个由不同正整数的组成的非空数组 nums ，考虑下面的图：
 * <p>
 * 有 nums.length 个节点，按从 nums[0] 到 nums[nums.length - 1] 标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j]之间才有一条边。
 * 返回 图中最大连通组件的大小 。
 * <p>
 * 输入：nums = [4,6,15,35]
 * 输出：4
 * <p>
 * 输入：nums = [20,50,9,63]
 * 输出：2
 * <p>
 * 输入：nums = [2,3,6,7,4,12,21,39]
 * 输出：8
 *
 * @author : yixihan
 * @create : 2022-07-30-9:01
 */
public class Solution {

    public int largestComponentSize(int[] nums) {
        int[] group = new int[100005];
        for (int i = 1; i <= 100000; i++) {
            group[i] = i;
        }
        for (int i = 0; i < nums.length; i++) {
            findUnion (i, group, nums);
        }
        int[] count = new int[100005];
        for (int num : nums) {
            count[find (group[num], group)]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100000; i++) {
            ans = Math.max (ans, count[i]);
        }
        return ans;
    }

    private void findUnion(int idx, int[] group, int[] nums) {
        int a = nums[idx];
        nums[idx] = -1;
        List<Integer> list = new ArrayList<> ();
        for (int i = 2; i * i <= a; i++) {
            if (a % i == 0) {
                if (nums[idx] == -1) {
                    nums[idx] = i;
                }
                list.add (i);
                while (a % i == 0) {
                    a /= i;
                }
            }
        }
        if (a != 1) {
            list.add (a);
        }
        if (nums[idx] == -1) {
            nums[idx] = a;
        }
        for (int i = 0; i < list.size (); i++) {
            int b = list.get (i);
            for (int j = i + 1; j < list.size (); j++) {
                int c = list.get (j);
                union (b, c, group);
            }
        }
    }

    private void union(int a, int b, int[] group) {
        a = find (a, group);
        b = find (b, group);
        group[b] = a;
    }

    private int find(int a, int[] group) {
        if (a != group[a]) {
            group[a] = find (group[a], group);
        }
        return group[a];
    }
}
