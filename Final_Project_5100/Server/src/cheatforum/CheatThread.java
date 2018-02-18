/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheatforum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author yupei
 */
public class CheatThread implements Runnable {

    private ServerSocket ss;
    private ExecutorService exec;
    private Map<String, PrintWriter> storeInfo;

    public CheatThread() {
        storeInfo = new HashMap<String, PrintWriter>();
        exec = Executors.newCachedThreadPool();
    }

    private void putIn(String key, PrintWriter value) {
        synchronized (this) {
            storeInfo.put(key, value);
        }
    }

    private synchronized void remove(String key) {
        storeInfo.remove(key);
        System.out.println("Active users: " + storeInfo.size());
    }

    private synchronized void sendToAll(String message) {
        for (PrintWriter out : storeInfo.values()) {
            out.println(message);
        }
    }

    private synchronized void sendToSomeone(String name, String message) {
        PrintWriter pw = storeInfo.get(name); //将对应客户端的聊天信息取出作为私聊内容发送出去  
        if (pw != null) {
            pw.println(message);
        }
    }

    public void run() {

        try {

            if (ss == null) {

                ss = new ServerSocket(7432);
                System.out.println("Forum server started...");

                while (true) {

                    System.out.println("Waiting... ... ");
                    Socket socket = ss.accept();
                    /* 
            * 启动一个线程，由线程来处理客户端的请求，这样可以再次监听 
            * 下一个客户端的连接 
                     */
                    exec.execute(new ListenrClient(socket)); //通过线程池来分配线程  
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ListenrClient implements Runnable {

        private Socket socket;
        private String name;

        public ListenrClient(Socket socket) {
            this.socket = socket;
        }

        // 创建内部类来获取昵称  
        private String getName() throws Exception {
            try {
                //服务端的输入流读取客户端发送来的昵称输出流  
                BufferedReader bReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), "UTF-8"));
                //服务端将昵称验证结果通过自身的输出流发送给客户端  
                PrintWriter ipw = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

                //读取客户端发来的昵称  
                while (true) {
                    String nameString = bReader.readLine();
                    if ((nameString.trim().length() == 0) || storeInfo.containsKey(nameString)) {
                        ipw.println("FAIL");
                    } else {
                        ipw.println("OK");
                        return nameString;
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }

        @Override
        public void run() {
            try {
                /* 
                * 通过客户端的Socket获取客户端的输出流 
                * 用来将消息发送给客户端 
                 */
                PrintWriter pw = new PrintWriter(
                        new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);

                /* 
                * 将客户昵称和其所说的内容存入共享集合HashMap中 
                 */
                name = getName();
                putIn(name, pw);
                Thread.sleep(100);

                // 服务端通知所有客户端，某用户上线  
                sendToAll("[System]: " + name + " online");
                sendToAll("Actice users: "+String.valueOf(storeInfo.size()));
                

                /* 
                * 通过客户端的Socket获取输入流 
                * 读取客户端发送来的信息 
                 */
                BufferedReader bReader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), "UTF-8"));
                String msgString;

                while ((msgString = bReader.readLine()) != null) {
                    // 遍历所有输出流，将该客户端发送的信息转发给所有客户端  
                    
                    sendToAll(name + "：" + msgString);
                }
            } catch (Exception e) {
                // e.printStackTrace();  
            } finally {
                remove(name);
                // 通知所有客户端，某某客户已经下线  
                sendToAll("[System]: " + name + " offline");

                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
