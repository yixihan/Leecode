package com.yixihan.month14.day1204;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 你打算做甜点，现在需要购买配料。目前共有 n 种冰激凌基料和 m 种配料可供选购。而制作甜点需要遵循以下几条规则：
 * <p>
 * 必须选择 一种 冰激凌基料。
 * 可以添加 一种或多种 配料，也可以不添加任何配料。
 * 每种类型的配料 最多两份 。
 * 给你以下三个输入：
 * <p>
 * baseCosts ，一个长度为 n 的整数数组，其中每个 baseCosts[i] 表示第 i 种冰激凌基料的价格。
 * toppingCosts，一个长度为 m 的整数数组，其中每个 toppingCosts[i] 表示 一份 第 i 种冰激凌配料的价格。
 * target ，一个整数，表示你制作甜点的目标价格。
 * 你希望自己做的甜点总成本尽可能接近目标价格 target 。
 * <p>
 * 返回最接近 target 的甜点成本。如果有多种方案，返回 成本相对较低 的一种。
 * <p>
 * 输入：baseCosts = [1,7], toppingCosts = [3,4], target = 10
 * 输出：10
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 7
 * - 选择 1 份 0 号配料：成本 1 x 3 = 3
 * - 选择 0 份 1 号配料：成本 0 x 4 = 0
 * 总成本：7 + 3 + 0 = 10 。
 * <p>
 * 输入：baseCosts = [2,3], toppingCosts = [4,5,100], target = 18
 * 输出：17
 * 解释：考虑下面的方案组合（所有下标均从 0 开始）：
 * - 选择 1 号基料：成本 3
 * - 选择 1 份 0 号配料：成本 1 x 4 = 4
 * - 选择 2 份 1 号配料：成本 2 x 5 = 10
 * - 选择 0 份 2 号配料：成本 0 x 100 = 0
 * 总成本：3 + 4 + 10 + 0 = 17 。不存在总成本为 18 的甜点制作方案。
 * <p>
 * 输入：baseCosts = [3,10], toppingCosts = [2,5], target = 9
 * 输出：8
 * 解释：可以制作总成本为 8 和 10 的甜点。返回 8 ，因为这是成本更低的方案。
 * <p>
 * 输入：baseCosts = [10], toppingCosts = [1], target = 1
 * 输出：10
 * 解释：注意，你可以选择不添加任何配料，但你必须选择一种基料。
 *
 * @author yixihan
 * @date 2022/12/4 16:42
 */
public class Solution {
    
    private List<Integer> arr = new ArrayList<> ();
    private int[] ts;
    private int inf = 1 << 30;
    
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        ts = toppingCosts;
        dfs (0, 0);
        Collections.sort (arr);
        int d = inf, ans = inf;
        
        // 选择一种冰激淋基料
        for (int x : baseCosts) {
            // 枚举子集和
            for (int y : arr) {
                // 二分查找
                int i = search (target - x - y);
                for (int j : new int[]{i, i - 1}) {
                    if (j >= 0 && j < arr.size ()) {
                        int t = Math.abs (x + y + arr.get (j) - target);
                        if (d > t || (d == t && ans > x + y + arr.get (j))) {
                            d = t;
                            ans = x + y + arr.get (j);
                        }
                    }
                }
            }
        }
        return ans;
    }
    
    private int search(int x) {
        int left = 0, right = arr.size ();
        while (left < right) {
            int mid = (left + right) >> 1;
            if (arr.get (mid) >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    private void dfs(int i, int t) {
        if (i >= ts.length) {
            arr.add (t);
            return;
        }
        dfs (i + 1, t);
        dfs (i + 1, t + ts[i]);
    }
}
