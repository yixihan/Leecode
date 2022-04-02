package com.yixihan.month03.day0111;

import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2022-01-11-8:25
 */
class PredictTheWinnerTest {

    PredictTheWinner test = new PredictTheWinner ();

    @Test
    void predictTheWinner1() {
        int[] nums = {1, 5, 2};

        System.out.println (test.PredictTheWinner (nums));
    }

    @Test
    void predictTheWinner2() {
        int[] nums = {1, 5, 233, 7};

        System.out.println (test.PredictTheWinner (nums));
    }
}