package com.yixihan.month03.day1218;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-12-18-0:11
 */
class CountBattleshipsTest {

    CountBattleships test = new CountBattleships ();

    @Test
    void countBattleships() {

        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};

        System.out.println (test.countBattleships (board));
    }
}