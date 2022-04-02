package com.yixihan.data_structure_2.day3;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 * @author : yixihan
 * @create : 2022-03-26-7:51
 */
public class GetRow {
    public List<Integer> getRow(int rowIndex) {

        List<Integer> result = new ArrayList<> ();
        long temp = 1;

        for (int i = 0; i <= rowIndex; i++) {
            result.add ((int) temp);
            temp = temp * (rowIndex - i) / (i + 1);
        }

        return result;
    }
}
