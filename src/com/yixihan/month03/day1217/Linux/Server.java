package com.yixihan.month03.day1217.Linux;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2021-12-17-21:00
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket socket;

    public Server () throws IOException {
        Scanner sc = new Scanner (System.in);
        System.out.println ("请输入被连接的端口号 : (输入完请换行)");
        int port = sc.nextInt ();
        serverSocket = new ServerSocket(port);
        System.out.println ("服务器启动!!!");
    }

    public static void main(String[] args) {
        try {
            new Server ().run ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private void run () throws IOException {
        socket = serverSocket.accept ();
        Thread sendHandler = new Thread (new SendHandler ());
        Thread printHandler = new Thread (new PrintHandler ());

        sendHandler.start ();
        printHandler.start ();

    }

    class PrintHandler implements Runnable {

        @Override
        public void run() {
            printMsg ();
        }
    }

    class SendHandler implements Runnable {

        @Override
        public void run() {
            sendReceipt ();
        }
    }

    private void printMsg () {
        try {
            InputStream is = socket.getInputStream ();
            byte[] buffer = new byte[1];
            int len;

            while ((len = is.read (buffer)) != -1) {
                Thread.sleep (30);
                String val = new String (buffer, 0, len);
                System.out.print (val);
            }
            System.out.println ();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace ();
        }
    }

    private void sendReceipt () {
        try {
            OutputStream os = socket.getOutputStream ();
            FileInputStream fis = new FileInputStream ("love.txt");
            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read (buffer)) != -1) {
                os.write (buffer, 0, len);
            }

            // 关闭数据的输出
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace ();
        }

    }
}
