/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author yupei
 */
public class ThreadChat implements Runnable {

    static private Socket clientSocket;
    Data d = new Data();
    private boolean flag = true;

    public ThreadChat() throws IOException {
        clientSocket = new Socket("127.0.0.1", 7432);//169.254.136.70 172.20.10.14
        d.inData();
    }

    private void setName(String a) throws Exception {
        PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
        BufferedReader br = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
        while (true) {
            pw.println(a);
            String pass = br.readLine();
            if (pass != null && (!pass.equals("OK"))) {
                System.out.println("Same user name, please input again: ");
                break;
            } else {
                System.out.println("User name " + d.getName() + " set success, you can chat now.");
                break;
            }
        }
    }

    public void run() {

        Data a = new Data();
        a.inData();
        try {

            setName(d.getName());
            
            // 接收服务器端发送过来的信息的线程启动  
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ListenrServser());

            // 建立输出流，给服务端发信息  
            PrintWriter pw = new PrintWriter(
                    new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"), true);
            String tempa = "";

            while (true) {

                if (a.inData() != null && !a.inData().equals(tempa)) {
                    pw.println(a.inData());
                    tempa = a.inData();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    class ListenrServser implements Runnable {

        @Override
        public void run() {

            try {
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
                String msgString;

                while ((msgString = br.readLine()) != null) {
                    d.outData(msgString);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public void setstop() {

        flag = false;
        
    }

}
