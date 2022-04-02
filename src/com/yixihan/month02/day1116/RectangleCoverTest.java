package com.yixihan.month02.day1116;


import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2021-11-16-10:59
 */
public class RectangleCoverTest {

    RectangleCover cover = new RectangleCover();

    @Test
    public void isRectangleCover() {
        int[][] arr = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(cover.isRectangleCover(arr));
    }

    @Test
    public void isRectangleCover2() {

        int[][] arr = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
        System.out.println(cover.isRectangleCover(arr));
    }
}