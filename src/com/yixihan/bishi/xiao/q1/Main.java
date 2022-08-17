package com.yixihan.bishi.xiao.q1;

import sun.text.resources.FormatData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author : yixihan
 * @create : 2022-08-16-16:29
 */
public class Main {

    public static void main(String[] args) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd hh:mm");
        Date inTime = format.parse ("2022-01-03 8:40");
        Date outTime = format.parse ("2022-01-07 16:30");

        System.out.println (getCnt ());

    }

    private static int getCost (Date inTime, Date outTime) {
        int disTime = Math.toIntExact (outTime.getTime () - inTime.getTime ());
        int parkTime = disTime % 3600000 == 0 ? disTime / 3600000 : disTime / 3600000 + 1;
        if (parkTime <= 3) {
            return 5;
        } else {
            parkTime -= 3;
            return 5 + (parkTime / 24 * 20) + (Math.min ((parkTime % 24), 20));
        }

    }

//    private static int getCnt () {
//        List<Integer> list = new ArrayList<> ();
//        for (int i = 0; i * i < 10; i++) {
//            list.add (i * i);
//        }
//        System.out.println (list);
//        Set<Integer> set = new HashSet<> ();
//        for (int i : list) {
//            if (i == 0) {
//                continue;
//            }
//            for (int j : list) {
//                for (int k : list) {
//                    int num = k + j * 10 + i * 100;
//                    System.out.println (num);
//                    set.add (num);
//                }
//            }
//        }
//
//        return set.size ();
//    }

//    private static int getCnt () {
//        int cnt = 0;
//
//        for (int i = 1; i < 10; i++) {
//            for (int j = 1; j < 10; j++) {
//                for (int k = 1; k < 10; k++) {
//                    if (i * j * k == 20) {
//                        cnt++;
//                        System.out.println (i + ", " + j + ", " + k);
//                    }
//                }
//            }
//        }
//
//        return cnt;
//    }

//    private static int getCnt () {
//        int cnt = 0;
//
//        for (int i = 1; i < 199; i++) {
//            for (int j = i + 1; j <= 199; j++) {
//                if (i + j > 199) {
//                    cnt++;
//                    System.out.println (i + ", " + j);
//                }
//            }
//        }
//
//        return cnt;
//    }


//    private static int getCnt () {
//        int cnt = 0;
//
//        for (int i = 1; i <= 1997; i++) {
//            if (i % 22 == 0) {
//                System.out.println (i);
//                cnt++;
//            }
//        }
//
//        return cnt;
//    }

    private static int getCnt () {
        int cnt = 0;

        for (int i = 0; i < 6; i++) {
            for (int j = i + 1; j < 6; j++) {
                cnt++;
            }
        }

        return cnt;
    }

}
