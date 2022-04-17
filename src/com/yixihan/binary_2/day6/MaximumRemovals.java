package com.yixihan.binary_2.day6;

/**
 * 给你两个字符串 s 和 p ，其中 p 是 s 的一个 子序列 。
 * 同时，给你一个元素 互不相同 且下标 从 0 开始 计数的整数数组 removable ，
 * 该数组是 s 中下标的一个子集（s 的下标也 从 0 开始 计数）。
 * <p>
 * 请你找出一个整数 k（0 <= k <= removable.length），选出 removable 中的 前 k 个下标，
 * 然后从 s 中移除这些下标对应的 k 个字符。整数 k 需满足：在执行完上述步骤后， p 仍然是 s 的一个 子序列 。
 * 更正式的解释是，对于每个 0 <= i < k ，先标记出位于 s[removable[i]] 的字符，
 * 接着移除所有标记过的字符，然后检查 p 是否仍然是 s 的一个子序列。
 * <p>
 * 返回你可以找出的 最大 k ，满足在移除字符后 p 仍然是 s 的一个子序列。
 * <p>
 * 字符串的一个 子序列 是一个由原字符串生成的新字符串，
 * 生成过程中可能会移除原字符串中的一些字符（也可能不移除）但不改变剩余字符之间的相对顺序。
 * <p>
 * 输入：s = "abcacb", p = "ab", removable = [3,1,0]
 * 输出：2
 * 解释：在移除下标 3 和 1 对应的字符后，"abcacb" 变成 "accb" 。
 * "ab" 是 "accb" 的一个子序列。
 * 如果移除下标 3、1 和 0 对应的字符后，"abcacb" 变成 "ccb" ，那么 "ab" 就不再是 s 的一个子序列。
 * 因此，最大的 k 是 2 。
 * <p>
 * 输入：s = "abcbddddd", p = "abcd", removable = [3,2,1,4,5,6]
 * 输出：1
 * 解释：在移除下标 3 对应的字符后，"abcbddddd" 变成 "abcddddd" 。
 * "abcd" 是 "abcddddd" 的一个子序列。
 * <p>
 * 输入：s = "abcab", p = "abc", removable = [0,1,2,3,4]
 * 输出：0
 * 解释：如果移除数组 removable 的第一个下标，"abc" 就不再是 s 的一个子序列。
 *
 * @author : yixihan
 * @create : 2022-04-17-16:09
 */
public class MaximumRemovals {
    public int maximumRemovals(String s, String p, int[] removable) {
        char[] str0 = s.toCharArray ();
        char[] str1 = p.toCharArray ();
        int ans = 0;//我们要返回的值，答案
        int left = 1;//左边界
        int right = removable.length;//右边界
        while (left <= right) {//开始循环找答案
            int mid = left + right >> 1;//位运算高效求中点
            //这里调用的方法下面讲，他的作用就是删除前mid个removable所指的位置的字符后
            if (search1 (mid, str0, str1, removable)) {//是否还能满足p是s的子序列，如果满足返回true
                ans = mid;//进入条件则说明满足，当前的mid就是候选答案之一，最后一个满足要求的mid就一定是答案
                left = mid + 1;//当前mid满足的话我们就要去尝试更大的数值，以缩小答案的范围
            } else {//不满足
                right = mid - 1;//那我们就要去尝试更小的数，寻找能满足的
            }
            str0 = s.toCharArray ();//我们在search1方法中改变了str0的值，所以要重新赋值
        }
        return ans;
    }

    private boolean search1(int mid, char[] str0, char[] str1, int[] removable) {
        for (int i = 0; i < mid; i++) {//这里做的就是将前mid个removable中所指的字符"删除"
            str0[removable[i]] = '1';
        }
        int j = 0;
        for (char c : str0) {//判断p是不是s的子序列
            if (j < str1.length) {
                if (str1[j] == c) {
                    j++;
                }
            } else {//已经遍历完p，即可说明p是s的子序列
                return true;
            }
        }
        //已经遍历完p，即可说明p是s的子序列
        return j == str1.length;//已经遍历完s但是没有完全找到p对应的字符，即p不是s的子序列。
    }

}
