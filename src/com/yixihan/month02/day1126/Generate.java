package com.yixihan.month02.day1126;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * @author : yixihan
 * @create : 2021-11-26-9:37
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();


        for (int i = 0; i < numRows; i++) {

            if (i == 0) {
                result.add(Collections.singletonList(1));
                continue;
            }
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    temp.add(1);
                } else {
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(temp);

        }

        return result;
    }
}
