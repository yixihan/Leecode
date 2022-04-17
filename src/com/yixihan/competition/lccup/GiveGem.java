package com.yixihan.competition.lccup;

import java.util.Arrays;

/**
 * @author : yixihan
 * @create : 2022-04-16-15:02
 */
public class GiveGem {
    public int giveGem(int[] gem, int[][] operations) {

        for (int[] operation : operations) {
            gem[operation[1]] += gem[operation[0]] / 2;
            gem[operation[0]] = gem[operation[0]] % 2 == 0 ? gem[operation[0]] / 2 : gem[operation[0]] / 2 + 1;
        }

        Arrays.sort (gem);
        return gem[gem.length - 1] - gem[0];
    }

}
