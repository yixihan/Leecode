package com.yixihan.month05.day0309;

/**
 * 给你一个数组 nums，我们可以将它按一个非负整数 k 进行轮调，
 * 这样可以使数组变为 [nums[k], nums[k + 1], ... nums[nums.length - 1], nums[0], nums[1],
 * ..., nums[k-1]] 的形式。此后，任何值小于或等于其索引的项都可以记作一分。
 *
 * 例如，数组为 nums = [2,4,1,3,0]，我们按 k = 2 进行轮调后，它将变成 [1,3,0,2,4]。
 * 这将记为 3 分，因为 1 > 0 [不计分]、3 > 1 [不计分]、0 <= 2 [计 1 分]、2 <= 3 [计 1 分]，4 <= 4 [计 1 分]。
 * 在所有可能的轮调中，返回我们所能得到的最高分数对应的轮调下标 k 。如果有多个答案，返回满足条件的最小的下标 k 。
 *
 *
 * 输入：nums = [2,3,1,4,0]
 * 输出：3
 * 解释：
 * 下面列出了每个 k 的得分：
 * k = 0,  nums = [2,3,1,4,0],    score 2
 * k = 1,  nums = [3,1,4,0,2],    score 3
 * k = 2,  nums = [1,4,0,2,3],    score 3
 * k = 3,  nums = [4,0,2,3,1],    score 4
 * k = 4,  nums = [0,2,3,1,4],    score 3
 * 所以我们应当选择 k = 3，得分最高。
 *
 * 输入：nums = [1,3,0,2,4]
 * 输出：0
 * 解释：
 * nums 无论怎么变化总是有 3 分。
 * 所以我们将选择最小的 k，即 0。
 *
 * @author : yixihan
 * @create : 2022-03-09-11:54
 */
public class Solution {

    /**
     * 将A[i]向左移动到下标A[A[i]]的位置需要K = (i - A[i] + N) % N
     * 并且我们发现，A[A[i]]是第一个A[i]能得分的位置，如果这时减小K，则A[i]继续得分，如果增大K则A[i]将不得分。
     * 如果我们能够刚好把所有A[i]都移动到A[A[i]]的位置，那么我们拿到的分数肯定的是最高的，蛋式这种情况几乎不可能。
     *
     * 当我们把A[i]移动到A[A[i]]后，再向左移动一个位置（即K增加1）。A[i]的移动公式为K’ = (1 + i - A[i] + N) % N这个时候A[i]刚好不得分。
     *
     * 我们可以在这个刚好不得分的k标记一下，通过+1进行标记，这个k就是 (i - A[i] + 1 + N) % N。用一个长度为N
     * 的myK数组，对于每个元素A[i]，我们都找到其刚好不得分的k = (i - A[i] + 1 + N) % N，那么此时myK[k]就表示
     * 数组中的数字在K = k时，A数组中不得分的元素个数。
     *
     * 可以发现，如果当K = k时，A[i]刚好不得分，当K = k + 1时（左移一个）A[i]继续不得分，蛋式当K = k + 1时
     * 有一个元素开始得分了，就是在当K = k处于A[0]的元素开始得分！！！
     *
     * 因此递推公式为：myK[k + 1] += myK[k] - 1
     * @param nums
     * @return
     */
    public int bestRotation(int[] nums) {
        int length = nums.length;
        // resK 用于记录当 K = resK 时，此时 nums 数组中部分的个数最少（即 nums 数组中得分的个数最多）
        int resK = 0;
        // myK[k] 代表当 K =  k时，nums 数组中不得分的个数
        int[] myK = new int[length];

        // 1. 将 nums 数组中所有元素都向左移动 (i - nums[i] + 1 + length) % length 个位置，即K = (i - nums[i] + 1 + length) % length，此时 nums[i] 刚好不得分
        for (int i = 0; i < length; i++) {
            // 当 K = (i -  nums[i] + 1 + length) % length 时，不得分的个数自增
            myK[(i - nums[i] + 1 + length) % length] += 1;
        }

        // 2. 寻找最优的 resK（当 K = resK 时，此时 nums 数组中部分的个数最少（即 nums 数组中得分的个数最多））
        for (int i = 1; i < length; ++i) {
            // 递推式当 K = i - 1 增大到到 K = i 时
            // 在 K = i - 1 时不得分的继续不得分，但是当 K = i - 1 转换到 K = i 时，处于 nums[0] 的元素开始得分
            myK[i] += myK[i - 1] - 1;
            if (myK[i] < myK[resK]) {
                // K = resK 时，此时 nums 数组中部分的个数最少（即 nums 数组中得分的个数最多）
                resK = i;
            }
        }

        return resK;
    }
}
