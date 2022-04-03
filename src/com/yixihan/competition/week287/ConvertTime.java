package com.yixihan.competition.week287;

/**
 * @author : yixihan
 * @create : 2022-04-03-10:56
 */
public class ConvertTime {
    public int convertTime(String current, String correct) {
        String[] splits1 = current.split (":");
        String[] splits2 = correct.split (":");
        int hour = Integer.parseInt (splits2[0]) - Integer.parseInt (splits1[0]);
        int minute = Integer.parseInt (splits2[1]) - Integer.parseInt (splits1[1]) + hour * 60;

        int ans = 0;
        for (int i = minute; i > 0; ) {
            if (i >= 60) {
                i -= 60;
                ans++;
            } else if (i >= 15) {
                i -= 15;
                ans++;
            } else if (i >= 5) {
                i -= 5;
                ans++;
            } else {
                i -= 1;
                ans++;
            }
        }
        return ans;
    }

    static class Main {
        public static void main(String[] args) {
            System.out.println (new ConvertTime ().convertTime ("09:41", "10:34"));
        }
    }
}
