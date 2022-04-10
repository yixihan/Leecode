package com.yixihan.competition.week288;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : yixihan
 * @create : 2022-04-10-10:37
 */
public class MinimizeResult {

    public String minimizeResult(String expression) {

        int minSum = Integer.MAX_VALUE;
        int[] minWay = new int[2];
        String[] splits = expression.split ("\\+");
        List<int[]> list1 = new ArrayList<>();
        List<int[]> list2 = new ArrayList<>();

        for (int i = 0; i < splits[0].length (); i++) {
            if (i == 0) {
                list1.add (new int[]{0, Integer.parseInt (splits[0].substring (i))});
                continue;
            }
            list1.add (new int[]{Integer.parseInt (splits[0].substring (0, i)),
                    Integer.parseInt (splits[0].substring (i))});
        }

        for (int i = 0; i < splits[1].length (); i++) {
            if (i == 0) {
                list2.add (new int[]{0, Integer.parseInt (splits[1].substring (i))});
                continue;
            }
            list2.add (new int[]{Integer.parseInt (splits[1].substring (0, i)),
                    Integer.parseInt (splits[1].substring (i))});
        }

        for (int i = 0; i < list1.size (); i++) {
            for (int j = 0; j < list2.size (); j++) {
                int[] tmp1 = list1.get (i);
                int[] tmp2 = list2.get (j);
                int sum;
                System.out.println (Arrays.toString (list1.get (i)));
                System.out.println (Arrays.toString (list2.get (j)));
                if (tmp1[0] != 0 && tmp2[0] != 0) {
                    sum = tmp1[0] * (tmp1[1] + tmp2[0]) * tmp2[1];
                } else if (tmp1[0] != 0) {
                    sum = tmp1[0] * (tmp1[1] + tmp2[1]);
                } else if (tmp2[0] != 0) {
                    sum = (tmp1[1] + tmp2[0]) * tmp2[1];
                } else {
                    sum = tmp1[1] + tmp2[1];
                }

                System.out.println (sum + "\n");

                if (minSum > sum) {
                    minSum = sum;
                    minWay = new int[]{i, j};
                }
            }
        }
        System.out.println (minSum);
        System.out.println (Arrays.toString (list1.get (minWay[0])));
        System.out.println (Arrays.toString (list2.get (minWay[1])));

        StringBuilder sb = new StringBuilder ();
        if (list1.get (minWay[0])[0] != 0) {
            sb.append (list1.get (minWay[0])[0]);
        }
        sb.append ("(").append (list1.get (minWay[0])[1]).append ("+");

        if (list2.get (minWay[1])[0] != 0) {
            sb.append (list2.get (minWay[1])[0]).append (")").append (list2.get (minWay[1])[1]);;
        } else {
            sb.append (list2.get (minWay[1])[1]).append (")");
        }

        return sb.toString ();
    }

    static class Main {
        public static void main(String[] args) {
            MinimizeResult minimizeResult = new MinimizeResult ();
            System.out.println (minimizeResult.minimizeResult ("9+29"));
//            System.out.println (minimizeResult.minimizeResult ("12+34"));
//            System.out.println (minimizeResult.minimizeResult ("999+999"));
        }
    }
}
