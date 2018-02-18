/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cheatforum;

import business.db4o.DB4OUtil;
import business.network.Network;
import business.system.ConfigureABusiness;
import business.system.EcoSystem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yupei
 */
public class Server implements Runnable {

    private ServerSocket ss;
    private EcoSystem system;
    private InputStreamReader inputStreamReader;
    private BufferedReader bufferedReader;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();

    public Server() {

    }

    public void run() {

        try {
            //让服务器端程序开始监听来自4242端口的客户端请求  
            if (ss == null) {
                ss = new ServerSocket(4245);
                System.out.println("System server started...");

            }

            //服务器无穷的循环等待客户端的请求  
            int i = 0;
            while (true) {
                /* 
             *accept()方法会在等待用户的socket连接时闲置着，当用户链接 
             *上来时，此方法会返回一个socket(在不同的端口上)以便与客户端 
             *通信。Socket与ServerSocket的端口不同，因此ServerSocket可以 
             *空闲出来等待其他客户端 
                 */
                //这个方法会停下来等待要求到达之后再继续  
                Socket s = ss.accept();
                inputStreamReader = new InputStreamReader(s.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                String request = bufferedReader.readLine();
               // System.out.println(request + " 111");
//                System.out.println("接收到了客户端的请求:" + request);
                if (i == 0) {

                    //system = ConfigureABusiness.configure();
                    system = dB4OUtil.retrieveSystem();

                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    out.writeObject(system);
                    out.flush();

                    PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                    String advice = "First time link, sending System...";
                    printWriter.println(advice);

                    printWriter.close();

                    for (Network n : system.getNetworkDirectory().getNetworkList()) {
                        System.out.println(n.getName());

                    }
//                    System.out.println(system.getNetworkDirectory().getNetworkList().get(0).getStateDirectory().getStateList().get(0).getCityDirectory().getCityList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().get(0).getUserAccountDirectory().getUserAccountList().get(0).getPassword());
//                    
                } else if ("1".equals(request)) {
                    
                    ObjectInputStream in = new ObjectInputStream(s.getInputStream());
                    EcoSystem s2 = (EcoSystem) in.readObject();

                    this.system = s2;
                    //System.out.println(system.getNetworkDirectory().getNetworkList().get(0).getStateDirectory().getStateList().get(0).getCityDirectory().getCityList().get(0).getEnterpriseDirectory().getEnterpriseList().get(0).getOrganizationDirectory().getOrganizationList().get(0).getUserAccountDirectory().getUserAccountList().get(0).getPassword());

                    PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                    String advice = "Recive your data!";
                    printWriter.println(advice);
                    printWriter.flush();

                    dB4OUtil.storeSystem(system);
//                    inputStreamReader = new InputStreamReader(s.getInputStream());
//                    bufferedReader = new BufferedReader(inputStreamReader);
//                    String request2 = bufferedReader.readLine();
//                    System.out.println("接收到了client的System" + request2);
//                   
//                     printWriter.close();
                    //bufferedReader.close();
                    in.close();

                } else if (i > 0) {
                    ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
                    out.writeObject(system);
                    out.flush();

                    PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                    String advice = "System refresh";
                    printWriter.println(advice);
                    printWriter.close();

//                    System.out.println("系统更新已发送");
                }
                i++;
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
