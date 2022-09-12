package com.yixihan.random.day0912;

/**
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。
 * <p>
 * 输入：s = "PPALLP"
 * 输出：true
 * 解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
 * <p>
 * 输入：s = "PPALLL"
 * 输出：false
 * 解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
 *
 * @author : yixihan
 * @create : 2022-09-12-10:58
 */
public class CheckRecord {

    public boolean checkRecord(String s) {
        boolean isA = false;
        boolean isL = false;
        int cntA = 0;
        int cntL = 0;
        for (char c : s.toCharArray ()) {
            if (c == 'A') {
                cntL = 0;
                if (++cntA >= 2) {
                    isA = true;
                    break;
                }
            } else if (c == 'L') {
                if (++cntL >= 3) {
                    isL = true;
                    break;
                }
            } else {
                cntL = 0;
            }
        }

        return !isA && !isL;
    }
}
