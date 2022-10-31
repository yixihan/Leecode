package com.yixihan.sunday.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author yixihan
 * @date 2022-10-28-17:43
 */
public class SundayTest {

//    @Test
    public void testSunday01() {
        String haystack = "aeuaefgaldiahfiahilfhaeualdfhaeifjilarhaighaeudgalfhouhvnodai";
        String needle = "aldfha";

        Assertions.assertEquals (24, SundayUtils.strStr (haystack, needle));
    }

    //    @Test
    public void testSunday02() {
        String haystack = "aifhoeaifafeonlklafhoaieryaoiclkasjdpofhdacfoagfbcajsdhlsadhasilcne";
        String needle = "lklafh";

        Assertions.assertEquals (14, SundayUtils.strStr (haystack, needle));
    }

    //    @Test
    public void testSunday03() {
        String haystack = "apfpihPIHUHIpdvhaouhpPAHPpfpihPDIHADPihfivpiafiheouahsfIHOHDSPIfhsvheg";
        String needle = "ihPDIH";

        Assertions.assertEquals (28, SundayUtils.strStr (haystack, needle));
    }

    StringBuilder sb = new StringBuilder ();
    String needle = "YixihanInNewHopeAt20221028";
    String haystack;

    {
        try {
            FileReader reader = new FileReader ("data.txt");
            char[] buffer = new char[1024];

            while (reader.read (buffer) != -1) {
                sb.append (buffer);
            }
            haystack = sb.toString ();
        } catch (IOException e) {
            throw new RuntimeException (e);
        }
    }

    @Test
    public void testSundaySpeed() throws Exception {
        int sum = 0;

        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis ();
            SundayUtils.strStr (haystack, needle);
            long end = System.currentTimeMillis ();
            sum += (end - start);
        }
        System.out.println ("Sunday 算法, 共计耗时 : " + (sum / 100) + "ms");
    }

    @Test
    public void testKMPSpeed() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis ();
            KMPUtils.strStr (haystack, needle);
            long end = System.currentTimeMillis ();
            sum += (end - start);
        }
        System.out.println ("KMP 算法, 共计耗时 : " + (sum / 100) + "ms");
    }

    @Test
    public void testBFSpeed() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            long start = System.currentTimeMillis ();
            BFUtils.strStr (haystack, needle);
            long end = System.currentTimeMillis ();
            sum += (end - start);
        }
        System.out.println ("BF 算法, 共计耗时 : " + (sum / 100) + "ms");
    }

}
