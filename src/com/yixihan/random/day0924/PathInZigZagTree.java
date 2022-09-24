package com.yixihan.random.day0924;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
 * <p>
 * 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
 * <p>
 * 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
 * <p>
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
 * <p>
 * 输入：label = 14
 * 输出：[1,3,4,14]
 * <p>
 * 输入：label = 26
 * 输出：[1,2,6,10,26]
 *
 * @author : yixihan
 * @date : 2022-09-24-11:02
 */
public class PathInZigZagTree {

    public List<Integer> pathInZigZagTree(int label) {
        // i 行 : 左右和为3 ^ 2 ^ i - 1; i 偶数：正, i 奇数 : 反
        List<Integer> ans = new ArrayList<> (20);
        int l = findLine (label);
        if (l % 2 == 1) {
            label = 3 * (int) Math.pow (2, l) - 1 - label;
        }
        for (int i = l; i >= 0; i--) {
            ans.add (i % 2 == 1 ? 3 * (int) Math.pow (2, i) - 1 - label : label);
            label /= 2;
        }
        Collections.reverse (ans);
        return ans;
    }

    public int findLine(int label) {
        // 判断 label 位于哪一行
        int k = 2;
        for (int i = 0; ; i++) {
            if (k > label) {
                return i;
            }
            k *= 2;
        }
    }
}
