package com.yixihan.random.day0707;

/**
 * 有效括号字符串 定义：对于每个左括号，都能找到与之对应的右括号，反之亦然。详情参见题末「有效括号字符串」部分。
 * <p>
 * 嵌套深度 depth 定义：即有效括号字符串嵌套的层数，depth(A) 表示有效括号字符串 A 的嵌套深度。详情参见题末「嵌套深度」部分。
 * <p>
 * 有效括号字符串类型与对应的嵌套深度计算方法如下图所示：
 * <p>
 * 给你一个「有效括号字符串」 seq，请你将其分成两个不相交的有效括号字符串，A 和 B，并使这两个字符串的深度最小。
 * <p>
 * 不相交：每个 seq[i] 只能分给 A 和 B 二者中的一个，不能既属于 A 也属于 B 。
 * A 或 B 中的元素在原字符串中可以不连续。
 * A.length + B.length = seq.length
 * 深度最小：max(depth(A), depth(B)) 的可能取值最小。
 * 划分方案用一个长度为 seq.length 的答案数组 answer 表示，编码规则如下：
 * <p>
 * answer[i] = 0，seq[i] 分给 A 。
 * answer[i] = 1，seq[i] 分给 B 。
 * 如果存在多个满足要求的答案，只需返回其中任意 一个 即可。
 * <p>
 * 输入：seq = "(()())"
 * 输出：[0,1,1,1,1,0]
 * <p>
 * 输入：seq = "()(())()"
 * 输出：[0,0,0,1,1,0,1,1]
 * 解释：本示例答案不唯一。
 * 按此输出 A = "()()", B = "()()", max(depth(A), depth(B)) = 1，它们的深度最小。
 * 像 [1,1,1,0,0,1,1,1]，也是正确结果，其中 A = "()()()", B = "()", max(depth(A), depth(B)) = 1 。
 *
 * @author : yixihan
 * @create : 2022-07-07-13:43
 */
public class MaxDepthAfterSplit {

    /**
     * 栈上的左括号只要按奇偶分配给A和B就可以啦！
     *
     * @param seq
     * @return
     */
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length ()];
        int index = 0;

        for (char c : seq.toCharArray ()) {
            ans[index] = c == '(' ? index & 1 : ((index + 1) & 1);
            index++;
        }

        return ans;
    }
}
