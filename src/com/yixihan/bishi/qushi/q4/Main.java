package com.yixihan.bishi.qushi.q4;

import java.io.*;

/**
 * @author : yixihan
 * @create : 2022-08-12-15:00
 */
public class Main {

    volatile char[] str = new char[1000];
    volatile int index = 0;

    class CustomThread implements Runnable {

        int[] letters = new int[26];

        @Override
        public void run() {
            synchronized (CustomThread.class) {
                char c = str[index];
                index++;
                letters[c - 'a']++;

                if (verify ()) {
                    try {
                        printf ();
                    } catch (IOException e) {
                        e.printStackTrace ();
                    }
                }
            }
        }

        private void printf() throws IOException {
            for (int i = 0; i < letters.length; i++) {
                letters[i]--;
            }

            FileWriter os = new FileWriter (new File ("file.txt"));
            os.write ("abcdefghijklmnopqrstuvwxyz");
            os.flush ();
            os.close ();
        }

        private boolean verify () {
            for (int c : letters) {
                if (c <= 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
