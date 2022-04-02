package com.yixihan.programming_ability_2.day5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-03-27-8:44
 */
public class AddToArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        int n = num.length;
        List<Integer> ans = new ArrayList<>(n);
        int index = n - 1;

        while (index >= 0 || k > 0) {
            int val =  k % 10;
            if (index >= 0) {
                val += num[index];
                if (val >= 10) {
                    val -= 10;
                    k += 10;
                }
            }

            ans.add (val);
            index--;
            k /= 10;

        }


        Collections.reverse (ans);
        return ans;
    }
}
