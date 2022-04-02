package com.yixihan.month03.day0101;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2022-01-01-17:04
 */
class SolutionTest {

    Solution test = new Solution ();

    @Test
    void construct2DArray1() {

        int[] arr = {1, 2, 3, 4};

        int[][] array = test.construct2DArray (arr, 2, 2);

        for (int[] value : array) {
            for (int val : value) {
                System.out.print (val + ", ");
            }
            System.out.println ();
        }
    }

    @Test
    void construct2DArray2() {

        int[] arr = {1, 2};

        int[][] array = test.construct2DArray (arr, 1, 1);

        for (int[] value : array) {
            for (int val : value) {
                System.out.print (val + ", ");
            }
            System.out.println ();
        }
    }


}