package com.yixihan.month05.day0311;

/**
 * @author : yixihan
 * @create : 2022-03-11-21:37
 */
public class Main {
    static User user1 = new User();
    User user2 = new User();
    static class User {
        static User user3 = new User();
        User user4 = new User();
    }

    public static void main (String[] argv) {
        User user5 = new User();
    }
}
