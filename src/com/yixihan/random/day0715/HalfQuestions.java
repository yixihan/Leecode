package com.yixihan.random.day0715;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 有 N 位扣友参加了微软与力扣举办了「以扣会友」线下活动。
 * 主办方提供了 2*N 道题目，整型数组 questions 中每个数字对应了每道题目所涉及的知识点类型。
 * 若每位扣友选择不同的一题，请返回被选的 N 道题目至少包含多少种知识点类型。
 * <p>
 * 输入：questions = [2,1,6,2]
 * 输出：1
 * 解释：有 2 位扣友在 4 道题目中选择 2 题。
 * 可选择完成知识点类型为 2 的题目时，此时仅一种知识点类型
 * 因此至少包含 1 种知识点类型。
 * <p>
 * 输入：questions = [1,5,1,3,4,5,2,5,3,3,8,6]
 * 输出：2
 * 解释：有 6 位扣友在 12 道题目中选择题目，需要选择 6 题。
 * 选择完成知识点类型为 3、5 的题目，因此至少包含 2 种知识点类型。
 *
 * @author : yixihan
 * @create : 2022-07-15-9:29
 */
public class HalfQuestions {

    public int halfQuestions(int[] questions) {
        int n = questions.length / 2;
        int ans = 0;
        int totalSize = 0;
        Map<Integer, Integer> map = new HashMap<> ();
        PriorityQueue<Integer> queue = new PriorityQueue<> ((o1, o2) -> o2 - o1);

        for (int question : questions) {
            map.put (question, map.getOrDefault (question, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet ()) {
            queue.add (entry.getValue ());
        }

        while (!queue.isEmpty () && totalSize < n) {
            totalSize += queue.remove ();
            ans++;
        }

        return ans;
    }
}
