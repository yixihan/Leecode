package com.yixihan.month02.day1125;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : yixihan
 * @create : 2021-11-25-16:04
 */
class FindRestaurantTest {

    FindRestaurant test = new FindRestaurant();

    @Test
    void findRestaurant() {
        String[] arr1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] arr2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = test.findRestaurant(arr1, arr2);

        System.out.println(Arrays.toString(restaurant));
    }
}