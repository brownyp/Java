/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.buy;

import Util.Util;
import business.city.City;
import business.enterprise.Enterprise;
import business.network.Network;
import business.order.Order;
import business.organization.Organization;
import business.person.Person;
import business.system.EcoSystem;
import business.product.Product;
import business.product.ProductMessage;
import business.state.State;
import business.useraccount.UserAccount;
import business.usermessage.Message;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.main.RegisterJFrame;
import userinterface.main.WelcomPageJPanel;

/**
 *
 * @author yupei
 */
public class ProductDetailsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ProductDetailsJPanel
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Product product;
    EcoSystem system;
    Util Util = new Util();

    public ProductDetailsJPanel(JPanel userProcessContainer, UserAccount userAccount, Product product, EcoSystem system) throws MalformedURLException, IOException {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.product = product;
        this.system = system;

        if (product.getStatus().equals("Sold") || product.getStatus().equals("Pending")) {
            btnOrder.setEnabled(false);
        }

        lblProductName.setText(product.getProductName());
        btnContact.setText("Contact " + product.getUserAccount().getUsername());
        txtLocation.setText(product.getUserAccount().getPerson().getCountry() + "." + product.getUserAccount().getPerson().getState() + "." + product.getUserAccount().getPerson().getCity());
        txtDescription.setText(product.getDescription());
        lblCategory.setText(product.getCatagory());
        txtPrice.setText(String.valueOf(product.getProductPrice()));
        txtOriginalPrice.setText(String.valueOf(product.getProductOriginPrice()));
        lblImage.setIcon(Util.FillLabelBig(product.getImagePath()));
        lblVerified.setText(product.getVerify());
        //lblRating.setText(TOOL_TIP_TEXT_KEY);
        

        populateTable();
        populateRating();

        Component[] componentArray1 = userProcessContainer.getComponents();
        Component component1 = componentArray1[componentArray1.length - 1];
        if (component1 instanceof RecAfterOrederJPanel) {
            btnBack.setEnabled(false);
        }
        
        map(product);
    }
    
    public void map(Product p) throws FileNotFoundException, MalformedURLException, IOException {
        System.out.println(p.getLatitude());
        System.out.println(p.getLongitude());
        String latitude = String.valueOf(p.getLatitude());
        String longitude = String.valueOf(p.getLongitude());
        String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center="
                + longitude
                + ","
                + latitude
                + "&zoom=15&size=300x300&scale=3&maptype=roadmap";

        String destinationFile = "image.jpg";

        URL url = new URL(imageUrl);
        InputStream is = url.openStream();
        OutputStream os = new FileOutputStream(destinationFile);
        byte[] b = new byte[2048];
        int length;
        while ((length = is.read(b)) != -1) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();

        ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg")).getImage().getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH));

        map1.setIcon(imageIcon);
    }

    public void populateRating() {
        double ratingFinal = 0.0;
        int countt = 0;
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            for (Person person1 : oo.getPersonDirectory().getPersonList()) {
                                for (Order order1 : person1.getOrderDirectory().getOrderList()) {
                                    if (order1.getSeller().equals(product.getUserAccount()) && order1.getRating() != 0) {
                                        ratingFinal = ratingFinal + order1.getRating();
                                        countt++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        ratingFinal = ratingFinal / countt;
        lblRating.setText("Seller Rating: " + ratingFinal);
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblMessage.getModel();
        model.setRowCount(0);

        for (ProductMessage pm : product.getProductMessageDirectory().getProductMessagesList()) {
            Object[] row = new Object[3];
            row[0] = pm;
            row[1] = pm.getSenter();
            row[2] = pm.getSentDate();
            model.addRow(row);
        }
    }

    public void setOrderEnableFalse() {
        btnOrder.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblProductName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOriginalPrice = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMessage = new javax.swing.JTable();
        btnOrder = new javax.swing.JButton();
        btnLeaveMessage = new javax.swing.JButton();
        btnContact = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtLocation = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnShowMessage = new javax.swing.JButton();
        lblRating = new javax.swing.JLabel();
        map1 = new javax.swing.JLabel();
        lblVerified = new javax.swing.JLabel();

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/buy/14.jpg"))); // NOI18N
        lblImage.setPreferredSize(new java.awt.Dimension(300, 200));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Item Details");

        lblProductName.setText("<Product Name>");

        jLabel4.setText("Description");

        txtDescription.setEditable(false);
        txtDescription.setColumns(20);
        txtDescription.setLineWrap(true);
        txtDescription.setRows(5);
        txtDescription.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtDescription);

        jLabel5.setText("Price:");

        txtPrice.setEditable(false);

        jLabel6.setText("Original Price:");

        txtOriginalPrice.setEditable(false);

        jLabel7.setText("Messages:");

        tblMessage.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Content", "Senter", "Sent Time"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblMessage);
        if (tblMessage.getColumnModel().getColumnCount() > 0) {
            tblMessage.getColumnModel().getColumn(0).setPreferredWidth(400);
            tblMessage.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        btnOrder.setText("Order");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnLeaveMessage.setText("Leave Message");
        btnLeaveMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaveMessageActionPerformed(evt);
            }
        });

        btnContact.setText("Contact<seller>");
        btnContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactActionPerformed(evt);
            }
        });

        jLabel8.setText("Location:");

        txtLocation.setEditable(false);

        lblCategory.setText("<Category>");

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnShowMessage.setText("Show Message");
        btnShowMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowMessageActionPerformed(evt);
            }
        });

        lblRating.setText("<Rating>");

        map1.setSize(new java.awt.Dimension(300, 300));

        lblVerified.setText("<Verified>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblVerified, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtLocation))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtOriginalPrice)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
                            .addComponent(btnContact, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(lblRating, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOrder)
                        .addGap(11, 11, 11)))
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnShowMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLeaveMessage))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(map1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProductName)
                    .addComponent(jLabel4)
                    .addComponent(lblCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblVerified))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtOriginalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnContact))
                                    .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLeaveMessage)
                            .addComponent(btnShowMessage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(map1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed

        OrderJPanel orderJPanel = new OrderJPanel(userProcessContainer, userAccount, product, system);
        userProcessContainer.add("OrderJPanel", orderJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);

    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        if (component instanceof SearchResultJPanel) {
            SearchResultJPanel searchResultJPanel = (SearchResultJPanel) component;
            searchResultJPanel.populateWhich();
        } else if (component instanceof WelcomPageJPanel) {
            WelcomPageJPanel welcomPageJPanel = (WelcomPageJPanel) component;
            welcomPageJPanel.populatePictures();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot back!", "Warning", WARNING_MESSAGE);
            return;
        }

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactActionPerformed
        // TODO add your handling code here:
        
        
        String inputValue = JOptionPane.showInputDialog(null, "Send message to " + product.getUserAccount().getUsername());
        if(inputValue.length()<1){
            JOptionPane.showMessageDialog(null, "You need input something!");
            return;
        }
        if (inputValue.length() >= 1) {
            String content = inputValue;
            UserAccount sender = userAccount;
            UserAccount receiver = product.getUserAccount();
            Product product = this.product;

            Date nowTime = new Date();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String sentTime = sdf1.format(nowTime);

            String status = "Unread";
            Message responseM = null;

            Message m1 = userAccount.getMessageDirectory().createMessage(content, status, sentTime, sender, receiver, product, responseM);
            product.getUserAccount().getMessageDirectory().getMessageList().add(m1);
            try {
                Util.SendSystem(system);
            } catch (IOException ex) {
                Logger.getLogger(RegisterJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterJFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProductDetailsJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            JOptionPane.showMessageDialog(null, "Sent successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Please input something!", "Warning", WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnContactActionPerformed

    private void btnLeaveMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaveMessageActionPerformed
        // TODO add your handling code here:
        LeaveMessageJPanel leaveMessageJPanel = new LeaveMessageJPanel(userProcessContainer, userAccount, product,system);
        userProcessContainer.add("leaveMessageJPanel", leaveMessageJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLeaveMessageActionPerformed

    private void btnShowMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowMessageActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblMessage.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", WARNING_MESSAGE);
        } else {
            ProductMessage pm = (ProductMessage) tblMessage.getValueAt(selectedRow, 0);
            ShowMessageJPanel showMessageJPanel = new ShowMessageJPanel(userProcessContainer, pm, product);
            userProcessContainer.add("ShowMessageJPanel", showMessageJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }//GEN-LAST:event_btnShowMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnContact;
    private javax.swing.JButton btnLeaveMessage;
    private javax.swing.JButton btnOrder;
    private javax.swing.JButton btnShowMessage;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblProductName;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblVerified;
    private javax.swing.JLabel map1;
    private javax.swing.JTable tblMessage;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtLocation;
    private javax.swing.JTextField txtOriginalPrice;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
