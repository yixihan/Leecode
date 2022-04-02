package com.yixihan.month03.day1223;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个字符串 s ，考虑其所有 重复子串 ：即，s 的连续子串，在 s 中出现 2 次或更多次。这些出现之间可能存在重叠。
 *
 * 返回 任意一个 可能具有最长长度的重复子串。如果 s 不含重复子串，那么答案为 "" 。
 *
 * 输入：s = "banana"
 * 输出："ana"
 *
 * 输入：s = "abcd"
 * 输出：""
 * @author : yixihan
 * @create : 2021-12-23-0:47
 */
public class Solution {

    int[] nums;
    long mod = Integer.MAX_VALUE;

    public String longestDupSubstring(String s) {
        int length = s.length ();
        nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = s.charAt (i) - 'a';
        }

        //二分确定待查子串长度，若当前子串可以查出重复，则left右移，若不能则right左移
        int left = 1;
        int right = length;
        int L;
        while (left != right) {
            L = left + (right - left) / 2;
            if (search (L) != -1) {
                left = L + 1;
            }
            else {
                right = L;
            }
        }

        int end = search (left - 1);
        return end != -1 ? s.substring (end - left + 2, end + 1) : "";

    }

    public int search(int length) {
        Map<Long, List<Integer>> seen = new HashMap<> ();
        //first是第一个子串[0, length)的hash值
        long first = nums[0];
        //highest = 26^(length-1)，用于后续计算其他子串的hash
        long highest = 1;
        for (int i = 1; i < length; i++) {
            first = (first * 26 + nums[i]) % mod;
            highest = (highest * 26) % mod;
        }
        List<Integer> list = new ArrayList<> ();
        list.add (length - 1);
        seen.put (first, list);

        long temp = first;
        for (int i = length; i < nums.length; i++) {
            //最后加一个mod是考虑到前面的值可能是负数
            temp = (temp * 26 - highest * nums[i - length] * 26 % mod + nums[i] + mod) % mod;
            List<Integer> isContain = seen.getOrDefault (temp, null);
            if (isContain == null) {
                List<Integer> tempList = new ArrayList<> ();
                tempList.add (i);
                seen.put (temp, tempList);
            } else {
                for (int index : isContain) {
                    boolean isSame = check (index, i, length);
                    if (isSame) {
                        return i;
                    }
                }
                isContain.add (i);
                seen.put (temp, isContain);
            }
        }
        return -1;
    }

    private boolean check(int begin1, int begin2, int length) {
        for (int i = 0; i < length; i++) {
            if (nums[begin1 - i] != nums[begin2 - i]) {
                return false;
            }
        }
        return true;
    }

}
