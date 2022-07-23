package com.yixihan.random.day0723;

/**
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true 。否则，返回 false 。
 *
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 *
 * 输入：s = "110"
 * 输出：true
 *
 * @author : yixihan
 * @create : 2022-07-23-13:07
 */
public class CheckOnesSegment {

    public boolean checkOnesSegment(String s) {

        return !s.contains ("01");
    }
}
