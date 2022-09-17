package com.yixihan.random.day0917;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 * <p>
 * 输入：s = "abbxxxxzzy"
 * 输出：[[3,6]]
 * 解释："xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 * <p>
 * 输入：s = "abc"
 * 输出：[]
 * 解释："a","b" 和 "c" 均不是符合要求的较大分组。
 * <p>
 * 输入：s = "abcdddeeeeaabbbcd"
 * 输出：[[3,5],[6,9],[12,14]]
 * 解释：较大分组为 "ddd", "eeee" 和 "bbb"
 * <p>
 * 输入：s = "aba"
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-09-17-9:36
 */
public class LargeGroupPositions {

    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<> ();
        char[] arr = s.toCharArray ();
        int cnt = 1;
        int start = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                cnt++;
            } else {
                end = i - 1;
                if (cnt >= 3) {
                    ans.add (new ArrayList<> (Arrays.asList (start, end)));
                }
                cnt = 1;
                start = i;
            }
        }
        if (cnt >= 3) {
            end = arr.length - 1;
            ans.add (new ArrayList<> (Arrays.asList (start, end)));
        }

        return ans;
    }
}
