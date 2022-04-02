package com.yixihan.data_structure_1.day4;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 * @author : yixihan
 * @create : 2022-03-13-10:46
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list;

        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                list = new ArrayList<>();
                list.add (1);
                ans.add (new ArrayList<>(list));
                continue;
            } else if (i == 2) {
                list = new ArrayList<>();
                list.add (1);
                list.add (1);
                ans.add (new ArrayList<>(list));
                continue;
            }
            list = new ArrayList<> ();
            List<Integer> preList = ans.get (ans.size () - 1);

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    list.add (1);
                } else {
                    list.add (preList.get (j - 1) + preList.get (j));
                }
            }
            ans.add (new ArrayList<>(list));
        }

        return ans;
    }
}
