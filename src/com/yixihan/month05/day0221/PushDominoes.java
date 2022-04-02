package com.yixihan.month05.day0221;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * n 张多米诺骨牌排成一行，将每张多米诺骨牌垂直竖立。在开始时，同时把一些多米诺骨牌向左或向右推。
 *
 * 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *
 * 如果一张垂直竖立的多米诺骨牌的两侧同时有多米诺骨牌倒下时，由于受力平衡， 该骨牌仍然保持不变。
 *
 * 就这个问题而言，我们会认为一张正在倒下的多米诺骨牌不会对其它正在倒下或已经倒下的多米诺骨牌施加额外的力。
 *
 * 给你一个字符串 dominoes 表示这一行多米诺骨牌的初始状态，其中：
 *
 * dominoes[i] = 'L'，表示第 i 张多米诺骨牌被推向左侧，
 * dominoes[i] = 'R'，表示第 i 张多米诺骨牌被推向右侧，
 * dominoes[i] = '.'，表示没有推动第 i 张多米诺骨牌。
 * 返回表示最终状态的字符串。
 *
 * 输入：dominoes = "RR.L"
 * 输出："RR.L"
 * 解释：第一张多米诺骨牌没有给第二张施加额外的力。
 *
 * 输入：dominoes = ".L.R...LR..L.."
 * 输出："LL.RR.LLRRLL.."
 *
 * @author : yixihan
 * @create : 2022-02-21-8:46
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {

        char[] cs = dominoes.toCharArray ();
        int n = cs.length;
        int[] g = new int[n];
        Deque<int[]> d = new ArrayDeque<> ();

        for (int i = 0; i < n; i++) {
            if (cs[i] == '.') {
                continue;
            }

            int dir = cs[i] == 'L' ? -1 : 1;
            d.add (new int[]{i, 1, dir});
            g[i] = 1;
        }

        while (! d.isEmpty()) {
            int[] info = d.pollFirst();
            int loc = info[0];
            int time = info[1];
            int dire = info[2];
            int ne = loc + dire;

            if (cs[loc] == '.' || (ne < 0 || ne >= n)) {
                continue;
            }
            if (g[ne] == 0) { // 首次受力
                d.addLast(new int[]{ne, time + 1, dire});
                g[ne] = time + 1;
                cs[ne] = dire == -1 ? 'L' : 'R';
            } else if (g[ne] == time + 1) { // 多次受力
                cs[ne] = '.';
            }
        }
        return String.valueOf(cs);

    }
}
