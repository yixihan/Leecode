package com.yixihan.bishi.tonghuashun.q1;

import java.util.Objects;

/**
 * @author : yixihan
 * @create : 2022-09-05-14:19
 */
public class Main {

    public static void main(String[] args) {
        System.out.println ((int) 'a' - (int) 'A');
        System.out.println ((int) 'A');
        System.out.println ((int) 'Z');

        System.out.println (toLowerCase ("AFAEIHFGOAUEGHEOAFG"));
        System.out.println (formatMoney (202009092));
    }

    public static String toLowerCase(String str) {
        char[] arr = str.toCharArray ();

        for (int i = 0; i < str.length (); i++) {
            if (arr[i] >= 'A' && arr[i] <= 'Z') {
                arr[i] += 32;
            }
        }

        return new String (arr);
    }

    public static String formatMoney(int money) {
        char[] arr = String.valueOf (money).toCharArray ();
        StringBuilder sb = new StringBuilder ();
        int cnt = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append (arr[i]);
            cnt++;
            if (cnt == 3) {
                cnt = 0;
                sb.append (",");
            }
        }

        if (sb.charAt (sb.length () - 1) == ',') {
            sb.deleteCharAt (sb.length () - 1);
        }

        return sb.reverse ().toString ();
    }


    class x {
        private String qsCode;
        private String qsId;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof x)) return false;
            x x = (x) o;
            return Objects.equals (qsCode, x.qsCode) && Objects.equals (qsId, x.qsId);
        }

        @Override
        public int hashCode() {
            return Objects.hash (qsCode, qsId);
        }
    }
}
