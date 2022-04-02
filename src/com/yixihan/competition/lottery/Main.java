package com.yixihan.competition.lottery;

import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2022-03-27-9:30
 */
public class Main {

    public static final int PRICE = 160;
    public static final int TEN_PRICE = 1600;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = getAns (n);

        System.out.println (ans);
    }

    private static int getAns(int n) {

        int ans = 0;
        if (n < TEN_PRICE) {
            return n / PRICE;
        }
        int star = 0;

        while (n > TEN_PRICE){
            ans += 10;
            n -= TEN_PRICE;
            star += 3;
        }

        int last = n / PRICE;
        ans += last;
        star += last / 3;

        while (star >= 50) {
            ans += 1;
            star -= 47;
        }
        ans += star / 5;

        return ans;
    }
}
