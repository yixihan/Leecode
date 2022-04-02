package com.yixihan.month02.day1123;


import org.junit.jupiter.api.Test;

/**
 * @author : yixihan
 * @create : 2021-11-23-0:43
 */
public class BuddyStringsTest {

    BuddyStrings test = new BuddyStrings();

    @Test
    public void buddyStrings() {
        System.out.println(test.buddyStrings("ab", "ba"));
        System.out.println(test.buddyStrings("ab", "ab"));
        System.out.println(test.buddyStrings("aa", "aa"));
        System.out.println(test.buddyStrings("aaaabv", "aaaavb"));
        System.out.println(test.buddyStrings("aaaabv", "aaaavb"));
        System.out.println(test.buddyStrings("aaaabvav", "aaaavbva"));
    }
}