package com.yixihan.random.day0721;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * <p>
 * 例如，下面的二进制手表读取 "3:25" 。
 * <p>
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * <p>
 * 小时不会以零开头：
 * <p>
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 输入：turnedOn = 9
 * 输出：[]
 *
 * @author : yixihan
 * @create : 2022-07-21-9:56
 */
public class ReadBinaryWatch {

    List<String> ans;
    int[] nums = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int turnedOn) {
        ans = new ArrayList<> ();

        helper (turnedOn, 0, 0, 0);


        return ans;
    }

    private void helper(int turnedOn, int start, int hour, int minute) {
        if (turnedOn == 0) {
            if (hour > 11 || minute > 59) {
                return;
            }
            StringBuilder sb = new StringBuilder ();
            // 小时
            sb.append (hour).append (":");
            // 分钟
            if (minute < 10) {
                sb.append (0).append (minute);
            } else {
                sb.append (minute);
            }

            ans.add (sb.toString ());
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 回溯做选择
            if (i < 4) {
                hour += nums[i];
            } else {
                minute += nums[i];
            }

            // 递归
            helper (turnedOn - 1, i + 1, hour, minute);

            // 回溯取消选择
            if (i < 4) {
                hour -= nums[i];
            } else {
                minute -= nums[i];
            }

        }

    }
}
