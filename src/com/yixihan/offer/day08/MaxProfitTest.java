package com.yixihan.offer.day08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-02-28-13:06
 */
class MaxProfitTest {

    @Test
    void maxProfit1() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println (new MaxProfit ().maxProfit (prices));
    }

    @Test
    void maxProfit2() {
        int[] prices = {7,6,4,3,1};
        System.out.println (new MaxProfit ().maxProfit (prices));
    }
}