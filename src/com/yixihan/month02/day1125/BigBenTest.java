package com.yixihan.month02.day1125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-25-21:09
 */
class BigBenTest {

    BigBen test = new BigBen();

    @Test
    void bigBen() {

        String[] arr = {
                "xun zhang zhai ju lao diao chong, xiao yue dang lian gua yu gong.",
                "tian sheng wo cai bi you yong, qian jin san jin huan fu lai.",
                "xue zhui rou zhi leng wei rong, an xiao chen jing shu wei long.",
                "zuo ye xing chen zuo ye feng, hua lou xi pan gui tang dong.",
                "ren xian gui hua luo, ye jing chun shan kong."
        };

        test.bigBen(arr);
    }
}