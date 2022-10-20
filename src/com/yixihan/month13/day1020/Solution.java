package com.yixihan.month13.day1020;

import org.junit.Test;

/**
 * 我们构建了一个包含 n 行( 索引从 1  开始 )的表。首先在第一行我们写上一个 0。
 * 接下来的每一行，将前一行中的0替换为01，1替换为10。
 * <p>
 * 例如，对于 n = 3 ，第 1 行是 0 ，第 2 行是 01 ，第3行是 0110 。
 * 给定行数 n 和序数 k，返回第 n 行中第 k 个字符。（ k 从索引 1 开始）
 * <p>
 * 输入: n = 1, k = 1
 * 输出: 0
 * 解释: 第一行：0
 * <p>
 * 输入: n = 2, k = 1
 * 输出: 0
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * <p>
 * 输入: n = 2, k = 2
 * 输出: 1
 * 解释:
 * 第一行: 0
 * 第二行: 01
 * * 链接：https://leetcode.cn/problems/k-th-symbol-in-grammar
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yixihan
 * @date 2022-10-20-9:03
 */
public class Solution {

    StringBuilder sb = new StringBuilder ();

    public int kthGrammar(int n, int k) {
        sb.append (0);
        dfs (n);
        return sb.charAt (k - 1) - 48;
    }

    private void dfs (int n) {
        if (n == 1) {
            return;
        }
        StringBuilder tmp = new StringBuilder ();

        for (int i = 0; i < sb.length (); i++) {
            if (sb.charAt (i) == '0') {
                tmp.append ("01");
            } else if (sb.charAt (i) == '1') {
                tmp.append ("10");
            }
        }

        System.out.println (tmp);
        sb = new StringBuilder (tmp);
        dfs (n - 1);
    }

    @Test
    public void test () {
        System.out.println (32 ^ 6);
    }
}
