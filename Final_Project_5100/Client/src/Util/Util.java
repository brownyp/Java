/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import business.system.EcoSystem;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import javax.swing.ImageIcon;

/**
 *
 * @author kkkevinxx
 */
public class Util implements Serializable {

    Socket client;

    public static ImageIcon FillLabel(String path) {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(129, 130, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }

    public static ImageIcon FillLabelLittle(String path) {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }

    public static ImageIcon FillLabelBig(String path) {
        ImageIcon personPic = new ImageIcon(path);
        Image pictureL = personPic.getImage();
        Image upPicture = pictureL.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        ImageIcon pic = new ImageIcon(upPicture);
        return pic;
    }

    public void SendSystem(EcoSystem system) throws IOException, ClassNotFoundException, InterruptedException {
        Thread t = Thread.currentThread();
        client = new Socket("127.0.0.1", 4245);
        //System.out.println("aabbbacacacaac");

        PrintWriter printWriter = new PrintWriter(client.getOutputStream());
        printWriter.println("1");
        printWriter.flush();

        //通过printWriter 来向服务器发送消息
        t.sleep(1000);
        ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
        t.sleep(1000);
        out.writeObject(system);
        t.sleep(1000);
        out.flush();
        t.sleep(1000);

        InputStreamReader inputStreamReader = new InputStreamReader(client.getInputStream());
        //System.out.println(inputStreamReader);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        // bufferedReader = new BufferedReader(inputStreamReader);
        String request1 = bufferedReader.readLine();
        //System.out.println(request1);
        System.out.println(request1);

        bufferedReader.close();
        printWriter.close();
        out.close();
        client.close();
        System.out.println("Already sent system...");
    }
}
