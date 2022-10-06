package com.yixihan.month12.day1006;

/**
 * 给定一个由 0 和 1 组成的数组 arr ，将数组分成  3 个非空的部分 ，使得所有这些部分表示相同的二进制值。
 * <p>
 * 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来：
 * <p>
 * arr[0], arr[1], ..., arr[i] 为第一部分；
 * arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分；
 * arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。
 * 这三个部分所表示的二进制值相等。
 * 如果无法做到，就返回 [-1, -1]。
 * <p>
 * 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。
 * 此外，前导零也是被允许的，所以 [0,1,1] 和 [1,1] 表示相同的值。
 * <p>
 * 输入：arr = [1,0,1,0,1]
 * 输出：[0,3]
 * <p>
 * 输入：arr = [1,1,0,1,1]
 * 输出：[-1,-1]
 * <p>
 * 输入：arr = [1,1,0,0,1]
 * 输出：[0,2]
 *
 * @author yixihan
 * @date 2022-10-06-12:26
 */
public class Solution {

    public int[] threeEqualParts(int[] arr) {
        int[] fail = new int[]{-1, -1};
        // 检查总数
        int n = arr.length, cnt = 0;
        for (int i = 0; i < n; i++) cnt += arr[i];
        if (cnt == 0) return new int[]{0, 2};
        if (cnt % 3 != 0) return fail;
        // 检查间隔相对位
        int t = cnt / 3;
        int[][] ins = new int[3][t];
        for (int i = 0, j = -1, k = 0, p = 0, idx = 0; i < n; i++) {
            if (arr[i] == 0) continue;
            if (j != -1) ins[p][idx++] = i - j;
            if (++k == t) {
                j = -1;
                k = 0;
                p++;
                idx = 0;
            } else {
                j = i;
            }
        }
        for (int i = 0; i < t; i++) {
            if (ins[0][i] == ins[1][i] && ins[0][i] == ins[2][i] && ins[1][i] == ins[2][i]) continue;
            return fail;
        }
        // 构造答案（l1 和 l2 分别为能够划分出最左边 t 个 1 的 左右端点；r1 和 r2 分别为能够划分出最右边 t 个 1 的左右端点）
        int l1 = -1, l2 = -1, r1 = -1, r2 = -1;
        for (int i = 0, k = 0; i < n; i++) {
            k += arr[i];
            if (k == t) {
                if (l1 == -1) l1 = i;
            } else if (k == t + 1) {
                l2 = i - 1;
                break;
            }
        }
        for (int i = n - 1, k = 0; i >= 0; i--) {
            k += arr[i];
            if (k == t) {
                if (r2 == -1) r2 = i;
            } else if (k == t + 1) {
                r1 = i + 1;
                break;
            }
        }
        int d = 0; // d 为最右边一段的后缀 0 的数量
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 1) break;
            d++;
        }
        if (l1 + d > l2 || r1 + d > r2) return fail;
        return new int[]{l1 + d, r1 + d};
    }
}
