package com.yixihan.random.day0805;

/**
 * 有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。
 * <p>
 * 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。
 * 学生的答案用一个二维整数数组 students 表示，其中 students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。
 * 导师的答案用一个二维整数数组 mentors 表示，其中 mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。
 * <p>
 * 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。
 * <p>
 * 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
 * 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。
 * <p>
 * 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。
 * <p>
 * 输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
 * 输出：8
 * 解释：按下述方式分配学生和导师：
 * - 学生 0 分配给导师 2 ，兼容性评分为 3 。
 * - 学生 1 分配给导师 0 ，兼容性评分为 2 。
 * - 学生 2 分配给导师 1 ，兼容性评分为 3 。
 * 最大兼容性评分和为 3 + 2 + 3 = 8 。
 * <p>
 * 输入：students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
 * 输出：0
 * 解释：任意学生与导师配对的兼容性评分都是 0 。
 *
 * @author : yixihan
 * @create : 2022-08-05-13:27
 */
public class MaxCompatibilitySum {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int m = mentors.length;
        int n = mentors[0].length;
        // 压缩学生答案
        int[] sa = this.answer (m, n, students);
        // 压缩导师答案
        int[] ma = this.answer (m, n, mentors);
        // 最大状态数量，可用状态数量
        int limit = 1 << m;
        Integer[] dp = new Integer[limit];
        // n道题，学生答案sa，导师答案ma，匹配完状态limit -1，当前已经匹配的导师状态0，当前匹配学生索引0，缓存。
        return helper (n, sa, ma, limit - 1, 0, 0, dp);
    }

    private int helper(int n, int[] sa, int[] ma, int limit, int used, int index, Integer[] dp) {
        if (limit == used) {
            return 0;
        }
        if (dp[used] != null) {
            return dp[used];
        }
        int comp = 0;
        int stu = sa[index];
        for (int i = 0; i < ma.length; i++) {
            int pos = 1 << i;
            // i导师可以参与当前匹配
            if ((used & pos) == 0) {
                // 匹配得分
                int score = this.score (stu, ma[i], n);
                // i导师匹配index学生的最大得分 == 后续最大得分 + 当前得分。
                comp = Math.max (comp, helper (n, sa, ma, limit, used | pos, index + 1, dp) + score);
            }
        }
        dp[used] = comp;
        return comp;
    }

    // n题情况下， 学生和导师得分情况
    private int score(int student, int mentor, int n) {
        int compare = student ^ mentor;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((compare & (1 << i)) == 0) {
                ans++;
            }
        }
        return ans;
    }

    // 压缩答案
    private int[] answer(int m, int n, int[][] arr) {
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int answer = 0;
            for (int j = 0; j < n; j++) {
                answer |= arr[i][j] << j;
            }
            ans[i] = answer;
        }
        return ans;
    }

}
