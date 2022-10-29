package com.yixihan.sunday.four;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.CharBuffer;
import java.util.Random;

/**
 * @author yixihan
 * @date 2022-10-28-17:43
 */
public class SundayTest {

    @Test
    public void testSunday01() {
        String haystack = "aeuaefgaldiahfiahilfhaeualdfhaeifjilarhaighaeudgalfhouhvnodai";
        String needle = "aldfha";

        Assertions.assertEquals (24, SundayUtils.strStr (haystack, needle));
    }

    @Test
    public void testSunday02() {
        String haystack = "aifhoeaifafeonlklafhoaieryaoiclkasjdpofhdacfoagfbcajsdhlsadhasilcne";
        String needle = "lklafh";

        Assertions.assertEquals (14, SundayUtils.strStr (haystack, needle));
    }

    @Test
    public void testSunday03() {
        String haystack = "apfpihPIHUHIpdvhaouhpPAHPpfpihPDIHADPihfivpiafiheouahsfIHOHDSPIfhsvheg";
        String needle = "ihPDIH";

        Assertions.assertEquals (28, SundayUtils.strStr (haystack, needle));
    }

    @Test
    public void createTxt() throws Exception {
    }

}
