package com.yixihan.month03.day1217.Linux;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author : yixihan
 * @create : 2021-12-17-20:46
 */
public class Client {

    private Socket socket;


    public Client() throws IOException {
        Scanner sc = new Scanner (System.in);
        System.out.println ("请输入要连接的主机名 : (输入完请换行)");
        String host = sc.nextLine ();
        System.out.println ("请输入要连接的端口号 : (输入完请换行)");
        int port = sc.nextInt ();

        socket = new Socket (host, port);
        System.out.println ("客户端启动!!!");
    }

    public static void main(String[] args) {
        try {
            new Client ().run ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    private void run () {
        Thread sendHandler = new Thread (new SendHandler ());
        Thread receiveHandler = new Thread (new ReceiveHandler ());

        sendHandler.start ();
        receiveHandler.start ();
    }


    class SendHandler implements Runnable {

        @Override
        public void run() {
            sendMsg ();
        }
    }

    class ReceiveHandler implements Runnable {

        @Override
        public void run() {
            receivedMsg ();
        }
    }

    private void sendMsg (){
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

    private void receivedMsg (){
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
}
