package com.yixihan.month01.day1029;

/**
 * 给你一个整数数组 distance 。
 *
 * 从 X-Y 平面上的点 (0,0) 开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3] 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 *
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 *
 * 输入：distance = [2,1,1,2]
 * 输出：true
 *
 * 输入：distance = [1,2,3,4]
 * 输出：false
 *
 * 输入：distance = [1,1,1,1]
 * 输出：true
 *
 * @author : yixihan
 * @create : 2021-10-29-22:49
 */
public class IsSelfCrossing {
    public boolean isSelfCrossing(int[] distance) {
        int len = distance.length;
        if(len < 4) {
            return false;
        }

        // 要相交，最少需要四条边，所以从i=3开始遍历
        for(int i=3;i<len;i++) {
            // i和i-3相交的场景（连续四条边） 即 向北走要大于等于等于向南走且向东走要大于等于向西走
            if(distance[i] >= distance[i-2] && distance[i-3] >= distance[i-1]) {
                return true;
            }
            // i和i-4相交的场景（连续五条边）
            if(i >= 4 && distance[i]+distance[i-4] >= distance[i-2] && distance[i-1] == distance[i-3]) {
                return true;
            }
            // i和i-5相交的场景（连续六条边）
            if(i>=5 && distance[i-1] <= distance[i-3] && distance[i-1]+distance[i-5] >= distance[i-3]
                    && distance[i-2] > distance[i-4] && distance[i]+distance[i-4] >= distance[i-2]) {
                return true;
            }
        }
        return false;
    }
}
