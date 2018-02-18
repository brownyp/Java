/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.usermessage;

import business.organization.Organization;
import business.product.Product;
import business.useraccount.UserAccount;
import business.usermessage.Message;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import userinterface.sysadmin.SystemAdminWorkAreaJPanel;

/**
 *
 * @author kkkevinxx
 */
public class SentMessageDetailsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Message message;
    ArrayList<Message> tempM;
    boolean click0 = true;

    public SentMessageDetailsJPanel(JPanel userProcessContainer, Message message) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.message = message;

        tempM = new ArrayList<Message>();
        if (message.getResponseM() != null) {
            Message m1 = message.getResponseM();
            while (m1 != null) {
                m1 = m1.getResponseM();
                tempM.add(m1);
            }
        }
//        System.out.println(tempM.get(0).getContent());
//        System.out.println(tempM.get(1).getContent());

        populateTextArea();
    }

    public void insertDocument(String text, Color txtColor)//根据传入的颜色及文字，将文字插入文本域
    {

        SimpleAttributeSet set = new SimpleAttributeSet();
        StyleConstants.setForeground(set, txtColor);//设置文字颜色
        StyleConstants.setFontSize(set, 12);//设置字体大小
        Document doc = txtMessageDetails.getStyledDocument();
        try {
            doc.insertString(doc.getLength(), text, set);//插入文字
        } catch (Exception e) {
            System.out.println("wrong text");
        }
    }

    public void populateTextArea() {
        if (tempM.size() > 1) {
            Collections.reverse(tempM);
            txtMessageDetails.removeAll();
            for (int i = 1; i < tempM.size(); i++) {

                insertDocument(tempM.get(i).getSender().getUsername() + " " + tempM.get(i).getSentTime() + "\n", tempM.get(i).getSender().equals(message.getReceiver()) ? Color.BLUE : Color.GREEN);
                insertDocument(tempM.get(i).getContent() + "\n\n", Color.DARK_GRAY);
            }
        }
        if (message.getResponseM() != null) {
            insertDocument(message.getResponseM().getSender().getUsername() + " " + message.getResponseM().getSentTime()
                    + "\n", message.getResponseM().getSender().equals(message.getReceiver()) ? Color.BLUE : Color.GREEN);
            insertDocument(message.getResponseM().getContent() + "\n\n", Color.DARK_GRAY);
        }
        insertDocument(message.getSender().getUsername() + " " + message.getSentTime()
                + "\n", Color.GREEN);
        insertDocument(message.getContent() + "\n\n", Color.DARK_GRAY);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtReply = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMessageDetails = new javax.swing.JTextPane();

        jLabel1.setFont(new java.awt.Font("微软雅黑", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sent Message Details");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        txtReply.setColumns(20);
        txtReply.setLineWrap(true);
        txtReply.setRows(5);
        txtReply.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtReply);

        jLabel2.setText("Send:");

        jScrollPane3.setViewportView(txtMessageDetails);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSend))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSend))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        AllSentMessagesJPanel allSentMessagesJPanel = (AllSentMessagesJPanel) component;
        allSentMessagesJPanel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Replied successfully");
        Message mt = message;

        boolean click1 = false;

        String content = txtReply.getText();
        UserAccount sender = mt.getSender();
        UserAccount recevier = mt.getReceiver();
        Product product = mt.getProduct();

        Date nowTime = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sentTime = sdf.format(nowTime);

        String status = "Unread";
        Message responseM = null;
        if (click0) {
            responseM = mt;
            Message messageR = mt.getReceiver().getMessageDirectory().createMessage(content, status, sentTime, sender, recevier, product, responseM);
            mt.getSender().getMessageDirectory().getMessageList().add(messageR);
            click0 = false;
        } else {
            int i = mt.getReceiver().getMessageDirectory().getMessageList().size() - 1;
            responseM = mt.getReceiver().getMessageDirectory().getMessageList().get(i);
            Message messageR = mt.getReceiver().getMessageDirectory().createMessage(content, status, sentTime, sender, recevier, product, responseM);
            mt.getSender().getMessageDirectory().getMessageList().add(messageR);
        }

        insertDocument(mt.getSender().getUsername() + " " + sentTime + "\n", Color.GREEN);
        insertDocument(content + "\n\n", Color.DARK_GRAY);

        txtReply.setText("");
    }//GEN-LAST:event_btnSendActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane txtMessageDetails;
    private javax.swing.JTextArea txtReply;
    // End of variables declaration//GEN-END:variables
}
