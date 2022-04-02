package com.yixihan.month01.day1028;

import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * 给定正整数 N ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 *
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 *
 *
 * 输入：1
 * 输出：true
 * 输入：10
 * 输出：false
 * 输入：16
 * 输出：true
 * 输入：24
 * 输出：false
 * 输入：46
 * 输出：true
 *
 * @author : yixihan
 * @create : 2021-10-28-21:21
 */
public class ReorderedPowerOf2 {


    /**
     * 方式一 : 遍历 排序 , 先判断长度, 再判断是否相等
     */
    public boolean reorderedPowerOf2(int n) {

        boolean res = false;

        char[] nums = String.valueOf(n).toCharArray();

        Arrays.sort(nums);

        for (int i = 1; i < 1e9; i = i << 1) {
            char[] cur = Integer.toString(i).toCharArray();

            if (cur.length == nums.length) {
                Arrays.sort(cur);
                res =  Arrays.equals(cur, nums);

            }

            if (res || cur.length > nums.length) {
                break;
            }
        }
        return res;
    }


    /**
     * 方法二 : 打表
     */
    public boolean reorderedPowerOf22(int N) {
        String[] rec ={"1","2","4","8","16","23","46","128","256","125","0124","0248","0469","1289","13468",
                "23678","35566","011237","122446","224588","0145678","0122579","0134449","0368888",
                "11266777","23334455","01466788","112234778","234455668","012356789","0112344778"};
        char[] at = String.valueOf(N).toCharArray();
        Arrays.sort(at);
        String str = new String(at);
        for(String p:rec){
            if(str.equals(p)) {
                return true;
            }
        }
        return false;
    }


    @Test
    public void test () {
        System.out.println(reorderedPowerOf2(218));

    }

}
