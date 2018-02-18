/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.Logistic;

import Util.Util;
import business.order.Order;
import business.product.Product;
import business.system.EcoSystem;
import business.useraccount.UserAccount;
import business.usermessage.Message;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.seller.ViewSellOrderDetailsJPanel;
import business.logistic.FedexPackages;
import java.awt.CardLayout;
import java.awt.Component;
import userinterface.seller.ViewSellerOrdersJPanel;
import business.logistic.Package;
import userinterface.main.RegisterJFrame;

/**
 *
 * @author HP
 */
public class CreateFedexJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    Order soldOrder;
    UserAccount userAccount;
    EcoSystem system;
    Util Util = new Util();

    /**
     * Creates new form CreateFedex
     */
    public CreateFedexJPanel(JPanel userProcessContainer, Order soldOrder, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.soldOrder = soldOrder;
        this.system = system;
        //生成订单号，赋给订单并显示
        //  int trackTemp=rd(24567829, 67458908);
        int trackTemp = Package.counter;
        txtTrackingNum.setText(String.valueOf(trackTemp));

        txtTo.setText(soldOrder.getRecipientAddress());
        txtTel.setText(soldOrder.getRecipientPhone());
        txtRecipientName.setText(soldOrder.getRecipientName());
        
        Date nowDate = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String soldDate = sdf2.format(nowDate);
        txtTime.setText(soldDate);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtTrackingNum = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTo = new javax.swing.JTextArea();
        jScrollPanel2 = new javax.swing.JScrollPane();
        txtPickUP = new javax.swing.JTextArea();
        txtTime = new javax.swing.JTextField();
        btnSchedule = new javax.swing.JButton();
        txtRecipientName = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jLabel2.setText("Tracking Number:");

        jLabel3.setText("Where to :");

        jLabel4.setText("Where to pick up:");

        jLabel5.setText("Pick Up Time:");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Your Fedex Service ");

        txtTrackingNum.setEditable(false);
        txtTrackingNum.setEnabled(false);

        txtTo.setEditable(false);
        txtTo.setColumns(20);
        txtTo.setRows(5);
        jScrollPane1.setViewportView(txtTo);

        txtPickUP.setColumns(20);
        txtPickUP.setRows(5);
        jScrollPanel2.setViewportView(txtPickUP);

        txtTime.setEditable(false);

        btnSchedule.setText("Schedule A Pickup!");
        btnSchedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScheduleActionPerformed(evt);
            }
        });

        txtRecipientName.setEditable(false);
        txtRecipientName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRecipientNameActionPerformed(evt);
            }
        });

        jLabel6.setText("Recipient:");

        txtTel.setEditable(false);
        txtTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelActionPerformed(evt);
            }
        });

        jLabel7.setText("Tel:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtTrackingNum, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addComponent(txtRecipientName))
                    .addComponent(jScrollPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTel)
                            .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSchedule))
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTrackingNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtRecipientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnSchedule)
                .addContainerGap(57, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnScheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScheduleActionPerformed
        if (txtPickUP.getText().equals("") || txtTime.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Complete your form");
            return;
        }
        
        
        
        
        Date nowDate = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String soldDate = sdf2.format(nowDate);

        Package p = system.getFps().addFedexPackage();
        p.setExpress("Fedex");
        p.setRecipientName(soldOrder.getRecipientName());
        p.setRecipientAddress(soldOrder.getRecipientAddress());
        p.setSenderName(userAccount.getPerson().getName());
        p.setSenderAddress(txtPickUP.getText());
        p.setStatus("Schedule For Carrier Pickup");

        p.addLocation(soldDate, txtPickUP.getText());
        soldOrder.setTrackingNum(String.valueOf(p.getTrackingNum()));

        soldOrder.getProduct().setSoldDate(soldDate);
        soldOrder.setOrderStatus("Shipped");
        soldOrder.getProduct().setStatus("Sold");
        soldOrder.getBuyer().getPerson().getOrderDirectory().getOrderList();
//        try {
//            Util.SendSystem(system);
//        } catch (IOException ex) {
//            Logger.getLogger(RegisterJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(RegisterJFrame.class.getName()).log(Level.SEVERE, null, ex);
//        }
        JOptionPane.showMessageDialog(null, "Shipped! \nAlready noticed customer");

        //Send message
        String content = "Your item is on the way!\nDo not reply this message";
        UserAccount sender = userAccount;
        UserAccount receicer = soldOrder.getBuyer();
        Product product = soldOrder.getProduct();
        Date nowTime = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String sentTime = sdf1.format(nowTime);
        String status = "Unread";
        Message responseM = null;

        Message m = soldOrder.getBuyer().getMessageDirectory().createMessage(content, status, sentTime, sender, receicer, product, responseM);

        try {
            Util.SendSystem(system);
        } catch (IOException ex) {
            Logger.getLogger(CreateFedexJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreateFedexJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreateFedexJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnSchedule.setEnabled(false);

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewSellOrderDetailsJPanel viewSellerOrderDetailsJPanel = (ViewSellOrderDetailsJPanel) component;
        viewSellerOrderDetailsJPanel.backExpress();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_btnScheduleActionPerformed

    private void txtRecipientNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRecipientNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRecipientNameActionPerformed

    private void txtTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSchedule;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPanel2;
    private javax.swing.JTextArea txtPickUP;
    private javax.swing.JTextField txtRecipientName;
    private javax.swing.JTextField txtTel;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextArea txtTo;
    private javax.swing.JTextField txtTrackingNum;
    // End of variables declaration//GEN-END:variables
}