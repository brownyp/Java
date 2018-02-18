/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.seller;

import Util.Util;
import business.order.Order;
import business.product.Product;
import business.useraccount.UserAccount;
import business.usermessage.Message;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;

/**
 *
 * @author kkkevinxx
 */
public class ViewSellOrderDetailsJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    UserAccount userAccount;

    Order soldOrder;

    public ViewSellOrderDetailsJPanel(JPanel userProcessContainer, UserAccount userAccount, Order soldOrder) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.soldOrder = soldOrder;

        txtExpress.setText(soldOrder.getExpress());
        txtOrderDate.setText(soldOrder.getOrderDate());
        txtOrderStatus.setText(soldOrder.getOrderStatus());
        txtReAddress.setText(soldOrder.getRecipientAddress());
        txtReName.setText(soldOrder.getRecipientName());
        txtRePhone.setText(soldOrder.getRecipientPhone());
        lblProductName.setText(soldOrder.getProduct().getProductName());
        lblBuyerName.setText("Bought by " + soldOrder.getBuyer().getUsername());
        lblImage.setIcon(Util.FillLabel(soldOrder.getProduct().getImagePath()));
        
        if(soldOrder.getOrderStatus().equals("Shipped") || soldOrder.getOrderStatus().equals("Delivered") || soldOrder.getOrderStatus().equals("Terminated")){
            btnShip.setEnabled(false);
            btnTerminated.setEnabled(false);
            btnFinished.setEnabled(false);
        }
        if(soldOrder.getExpress().equals("N/A (Face to Face)")){
            btnShip.setEnabled(false);
        }else{
            btnFinished.setEnabled(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRePhone = new javax.swing.JTextField();
        lblBuyerName = new javax.swing.JLabel();
        txtReName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtOrderStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtOrderDate = new javax.swing.JTextField();
        lblProductName = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtExpress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReAddress = new javax.swing.JTextArea();
        btnShip = new javax.swing.JButton();
        btnTerminated = new javax.swing.JButton();
        btnFinished = new javax.swing.JButton();

        txtRePhone.setEditable(false);
        txtRePhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRePhoneActionPerformed(evt);
            }
        });

        lblBuyerName.setText("<Bought by xxx>");

        txtReName.setEditable(false);
        txtReName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtReNameActionPerformed(evt);
            }
        });

        jLabel4.setText("Recipient Address:");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel3.setText("Recipient Phone:");

        txtOrderStatus.setEditable(false);
        txtOrderStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderStatusActionPerformed(evt);
            }
        });

        jLabel1.setText("Recipient Name:");

        txtOrderDate.setEditable(false);
        txtOrderDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOrderDateActionPerformed(evt);
            }
        });

        lblProductName.setText("<Product Name>");

        jLabel7.setText("Order Status:");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/buy/14.jpg"))); // NOI18N

        jLabel6.setText("Order Date:");

        jLabel5.setText("Express:");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("View Order Details");

        txtExpress.setEditable(false);
        txtExpress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtExpressActionPerformed(evt);
            }
        });

        txtReAddress.setEditable(false);
        txtReAddress.setColumns(20);
        txtReAddress.setLineWrap(true);
        txtReAddress.setRows(5);
        txtReAddress.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtReAddress);

        btnShip.setText("Shipped");
        btnShip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShipActionPerformed(evt);
            }
        });

        btnTerminated.setText("Terminated Order");
        btnTerminated.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminatedActionPerformed(evt);
            }
        });

        btnFinished.setText("Finished");
        btnFinished.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuyerName, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtReName)
                            .addComponent(txtRePhone)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                            .addComponent(txtExpress)
                            .addComponent(txtOrderDate)
                            .addComponent(txtOrderStatus)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnTerminated, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnShip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFinished, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProductName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtReName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtRePhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtExpress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBuyerName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnShip)
                    .addComponent(btnFinished))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminated)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtRePhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRePhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRePhoneActionPerformed

    private void txtReNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtReNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtReNameActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ViewSellerOrdersJPanel viewSellerOrdersJPanel = (ViewSellerOrdersJPanel) component;
        viewSellerOrdersJPanel.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtOrderStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderStatusActionPerformed

    private void txtOrderDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOrderDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOrderDateActionPerformed

    private void txtExpressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtExpressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExpressActionPerformed

    private void btnShipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShipActionPerformed
        // TODO add your handling code here:
        Date nowDate = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String soldDate = sdf2.format(nowDate);
        soldOrder.getProduct().setSoldDate(soldDate);
        soldOrder.setOrderStatus("Shipped");
        soldOrder.getProduct().setStatus("Sold");
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

        btnShip.setEnabled(false);
        btnTerminated.setEnabled(false);
    }//GEN-LAST:event_btnShipActionPerformed

    private void btnTerminatedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminatedActionPerformed
        // TODO add your handling code here:
        String inputValue = JOptionPane.showInputDialog(null, "Send message to " + soldOrder.getBuyer().getUsername());
        if (inputValue.length() >= 1) {
            String content = "Your order is terminated!\n" + inputValue;
            soldOrder.setOrderStatus("Terminated");
            soldOrder.getProduct().setStatus("OK");
            JOptionPane.showMessageDialog(null, "Terminated! \nAlready noticed customer");

            UserAccount sender = userAccount;
            UserAccount receicer = soldOrder.getBuyer();
            Product product = soldOrder.getProduct();
            Date nowTime = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String sentTime = sdf1.format(nowTime);
            String status = "Unread";
            Message responseM = null;

            Message m = soldOrder.getBuyer().getMessageDirectory().createMessage(content, status, sentTime, sender, receicer, product, responseM);
            userAccount.getMessageDirectory().getMessageList().add(m);
            
            btnShip.setEnabled(false);
            btnFinished.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Please input something!", "Warning", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnTerminatedActionPerformed

    private void btnFinishedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishedActionPerformed
        // TODO add your handling code here:
        Date nowDate = new Date();
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        String soldDate = sdf2.format(nowDate);
        soldOrder.getProduct().setSoldDate(soldDate);
        soldOrder.setOrderStatus("Shipped");
        soldOrder.getProduct().setStatus("Sold");
        JOptionPane.showMessageDialog(null, "Face to face finished!");
        btnTerminated.setEnabled(false);
        //Send message
//        String content = "Your item is on the way!\nDo not reply this message";
//        UserAccount sender = userAccount;
//        UserAccount receicer = soldOrder.getBuyer();
//        Product product = soldOrder.getProduct();
//        Date nowTime = new Date();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String sentTime = sdf1.format(nowTime);
//        String status = "Unread";
//        Message responseM = null;
//
//        Message m = soldOrder.getBuyer().getMessageDirectory().createMessage(content, status, sentTime, sender, receicer, product, responseM);

    }//GEN-LAST:event_btnFinishedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFinished;
    private javax.swing.JButton btnShip;
    private javax.swing.JButton btnTerminated;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuyerName;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JTextField txtExpress;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtOrderStatus;
    private javax.swing.JTextArea txtReAddress;
    private javax.swing.JTextField txtReName;
    private javax.swing.JTextField txtRePhone;
    // End of variables declaration//GEN-END:variables
}
