/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import business.system.EcoSystem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author yupei
 */
public class Threadsystem implements Runnable {
    public EcoSystem system;
    public Threadsystem()
    {
    }
    
    
    int i = 0;
    public void run() {
       
        while(true){
        try {
            
            Socket client = new Socket("127.0.0.1", 4245);
            
            //通过printWriter 来向服务器发送消息
            PrintWriter printWriter = new PrintWriter(client.getOutputStream());
//            System.out.println("数据库静默更新第"+i+"次");
            
            //发送消息
            printWriter.println("First link.");
            printWriter.flush();
            
            //InputStreamReader是低层和高层串流之间的桥梁
            //client.getInputStream()从Socket取得输入串流
            InputStreamReader streamReader = new InputStreamReader(client.getInputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            
            EcoSystem s1 = (EcoSystem) in.readObject();
            system=s1;
           
            //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder
//            BufferedReader reader = new BufferedReader(streamReader);
//            String advice = reader.readLine();
//            
//            JOptionPane.showMessageDialog(null, advice);
//            reader.close();
            in.close();     
             
          
           
        } catch (IOException ex) {
            Logger.getLogger(Threadsystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Threadsystem.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Threadsystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public EcoSystem getSystem()
    {
        return system;
    }
}
