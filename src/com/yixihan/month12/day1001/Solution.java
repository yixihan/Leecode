package com.yixihan.month12.day1001;

/**
 * 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * <p>
 * 请你按下述方式重新格式化电话号码。
 * <p>
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * <p>
 * 返回格式化后的电话号码。
 * <p>
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 * <p>
 * 输入：number = "123 4-567"
 * 输出："123-45-67"
 * 解释：数字是 "1234567".
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 4 个数字，所以将它们分成两个含 2 个数字的块。这 2 块分别是 "45" 和 "67" 。
 * 连接这些块后得到 "123-45-67" 。
 * <p>
 * 输入：number = "123 4-5678"
 * 输出："123-456-78"
 * 解释：数字是 "12345678" 。
 * 步骤 1：第 1 个块 "123" 。
 * 步骤 2：第 2 个块 "456" 。
 * 步骤 3：剩下 2 个数字，将它们放入单个含 2 个数字的块。第 3 个块是 "78" 。
 * 连接这些块后得到 "123-456-78" 。
 * <p>
 * 输入：number = "12"
 * 输出："12"
 * <p>
 * 输入：number = "--17-5 229 35-39475 "
 * 输出："175-229-353-94-75"
 *
 * @author yixihan
 * @date 2022-10-02-9:19
 */
public class Solution {

    public String reformatNumber(String number) {
        StringBuilder tmp = new StringBuilder ();
        StringBuilder sb = new StringBuilder ();
        for (char c : number.toCharArray ()) {
            if (c >= '0' && c <= '9') {
                tmp.append (c);
            }
        }
        System.out.println (tmp);

        int len = tmp.length ();
        int flag = len % 3;
        int count = len / 3;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (cnt < count) {
                if (flag == 1) {
                    sb.insert (sb.length () - 2, "-").deleteCharAt (sb.length () - 1).append (tmp.charAt (i));
                } else if (flag == 2){
                    sb.append (tmp.substring (i));
                }
            } else {
                sb.append (tmp.substring (i, i + 3)).append ("-");
                cnt++;
                i += 2;
            }
            System.out.println (sb);
        }

        return sb.toString ();
    }
}
