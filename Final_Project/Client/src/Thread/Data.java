/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thread;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import userinterface.forum.ForumJpanel;

/**
 *
 * @author yupei
 */
public class Data implements Serializable{

    private String a;

    public Data() {

    }

    public void outData(String a) {
        insertDocument(a + "\n", Color.BLACK);
    }

    public void insertDocument(String text, Color txtColor)//根据传入的颜色及文字，将文字插入文本域
    {

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, txtColor);//设置文字颜色
        StyleConstants.setFontSize(set, 12);//设置字体大小
        Document doc = ForumJpanel.jTextPane1.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text, set);//插入文字
        } catch (Exception e) {
            System.out.println("wrong text");
        }
    }

    public String inData() {
        ForumJpanel.jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               a = ForumJpanel.jTextField1.getText();

            }

        });
        return a;
    }
    
    public String getName(){
       String b = ForumJpanel.userAccount.getUsername();
        
        return b;
    }

}
