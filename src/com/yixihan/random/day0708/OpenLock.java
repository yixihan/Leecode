package com.yixihan.random.day0708;

import java.util.*;

/**
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：把最后一位反向旋转一次即可 "0000" -> "0009"。
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：无法旋转到目标数字且不被锁定。
 *
 * @author : yixihan
 * @create : 2022-07-08-7:21
 */
public class OpenLock {

    Set<String> set = new HashSet<> ();
    String s;
    String t;


    public int openLock(String[] deadends, String target) {
        t = target;
        s = "0000";
        if (s.equals (t)) {
            return 0;
        }

        set.addAll (Arrays.asList (deadends));
        if (set.contains (t) || set.contains (s)) {
            return -1;
        }

        return bfs ();
    }

    private int bfs() {
        // d1 代表从起点 s 开始搜索（正向）
        // d2 代表从结尾 t 开始搜索（反向）
        Deque<String> d1 = new ArrayDeque<> ();
        Deque<String> d2 = new ArrayDeque<> ();

        /*
         * m1 和 m2 分别记录两个方向出现的状态是经过多少次转换而来
         * e.g.
         * m1 = {"1000":1} 代表 "1000" 由 s="0000" 旋转 1 次而来
         * m2 = {"9999":3} 代表 "9999" 由 t="9996" 旋转 3 次而来
         */
        Map<String, Integer> m1 = new HashMap<> ();
        Map<String, Integer> m2 = new HashMap<> ();
        d1.addLast (s);
        m1.put (s, 0);
        d2.addLast (t);
        m2.put (t, 0);

        /*
         * 只有两个队列都不空，才有必要继续往下搜索
         * 如果其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，如果 d1 为空了，说明从 s 搜索到底都搜索不到 t，反向搜索也没必要进行了
         */

        while (!d1.isEmpty () && !d2.isEmpty ()) {
            int tmp = -1;
            if (d1.size () <= d2.size ()) {
                tmp = update (d1, m1, m2);
            } else {
                tmp = update (d2, m2, m1);
            }

            if (tmp != -1) {
                return tmp;
            }
        }

        return -1;
    }

    private int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size ();
        while (m-- > 0) {
            String poll = deque.pollFirst ();
            char[] pcs = poll.toCharArray ();
            int step = cur.get (poll);

            // 枚举替换哪个字符
            for (int i = 0; i < 4; i++) {
                for (int j = -1; j <= 1; j++) {
                    // 能「正向转」也能「反向转」，这里直接枚举偏移量 [-1,1] 然后跳过 0
                    if (j == 0) {
                        continue;
                    }

                    // 求得替换字符串 str
                    int origin = pcs[i] - '0';
                    int next = (origin + j) % 10 == -1 ? 9 : (origin + j) % 10;

                    char[] clone = pcs.clone ();
                    clone[i] = (char) (next + '0');
                    String str = String.valueOf (clone);

                    if (set.contains (str)) {
                        continue;
                    }
                    if (cur.containsKey (str)) {
                        continue;
                    }

                    // 如果在「另一方向」找到过，说明找到了最短路，否则加入队列
                    if (other.containsKey (str)) {
                        return step + 1 + other.get (str);
                    } else {
                        deque.addLast (str);
                        cur.put (str, step + 1);
                    }
                }
            }
        }
        return -1;
    }
}
