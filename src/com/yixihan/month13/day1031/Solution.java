package com.yixihan.month13.day1031;

/**
 * 神奇字符串 s 仅由 '1' 和 '2' 组成，并需要遵守下面的规则：
 * <p>
 * 神奇字符串 s 的神奇之处在于，串联字符串中 '1' 和 '2' 的连续出现次数可以生成该字符串。
 * s 的前几个元素是 s = "1221121221221121122……" 。
 * 如果将 s 中连续的若干 1 和 2 进行分组，可以得到 "1 22 11 2 1 22 1 22 11 2 11 22 ......" 。
 * 每组中 1 或者 2 的出现次数分别是 "1 2 2 1 1 2 1 2 2 1 2 2 ......" 。上面的出现次数正是 s 自身。
 * <p>
 * 给你一个整数 n ，返回在神奇字符串 s 的前 n 个数字中 1 的数目。
 * <p>
 * 输入：n = 6
 * 输出：3
 * 解释：神奇字符串 s 的前 6 个元素是 “122112”，它包含三个 1，因此返回 3 。
 * <p>
 * 输入：n = 1
 * 输出：1
 *
 * @author yixihan
 * @date 2022-10-31-9:10
 */
public class Solution {

    /**
     * str的构造：
     * index = 0，str = “”，尾部添加一个'1'，str更新为“1”
     * index = 1，str = “1”，尾部添加str[index] - '0' = 2个 ‘2’，str 更新为 “122”，
     * index = 2，str = “122”，尾部添加str[index] - '0' = 2个 ‘1’，str 更新为 “122 11”，
     * index = 3，str = “12211”，尾部添加str[index] - '0' = 1个 ‘2’，str更新为“12211 2”
     * index = 4，str = “122112”，尾部添加str[index] - '0' = 1个 ‘1’，str更新 “122112 1”，
     * index = 5，str = “1221121”，尾部添加str[index] - '0' = 2个 ‘2’，str更新为“1221121 22”
     * index = 6，str = “122112122”，尾部添加str[index] - '0' = 1个‘1’，str 更新 “122112122 1”，
     * index = 7，str = “1221121221”，尾部添加str[index] - '0' = 2个‘2’，str更新为“1221121221 22”
     * ...
     *
     * @param n
     * @return
     */
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder ("122");
        int ans = 0;

        for (int i = 2; sb.length () < n; ) {
            for (int j = sb.charAt (i++) - '0'; j > 0; j--) {
                sb.append ("1");
            }
            for (int j = sb.charAt (i++) - '0'; j > 0; j--) {
                sb.append ("2");
            }
        }

        char[] arr = sb.toString ().toCharArray ();
        for (int i = 0; i < n; i++) {
            char c = arr[i];
            if (c == '1') {
                ans++;
            }
        }

        return ans;
    }
}
