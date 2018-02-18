/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.main;

import Util.Util;
import business.city.City;
import business.system.EcoSystem;
import business.enterprise.Enterprise;
import business.network.Network;
import business.order.Order;
import business.organization.Organization;
import business.person.Person;
import business.product.Product;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import business.product.Product;
import business.product.Product.Category;
import business.state.State;
import business.usermessage.Message;
import java.awt.CardLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;
import userinterface.buy.ProductDetailsJPanel;
import userinterface.buy.SearchResultJPanel;
import userinterface.buy.ViewBuyerOrdersJPanel;
import userinterface.seller.SellerWorkAreaJPanel;
import userinterface.useraccount.UpdateUserAccount;
import userinterface.usermessage.AllReceviedMessagesJPanel;

/**
 *
 * @author kkkevinxx
 */
public class WelcomPageJPanel extends javax.swing.JPanel {

    /**
     * Creates new form WelcomPageJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system;
    UserAccount userAccount;
    Organization organization;
    Enterprise enterprise;
    ArrayList<Product> tempP;

    public WelcomPageJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
        this.tempP = new ArrayList<>();

        cbCategory.removeAllItems();
        for (Category c : Category.values()) {
            cbCategory.addItem(c);
        }

        populatePictures();

    }

    public void populatePictures() {
        tempP.clear();
        int[] aa = new int[6];
        String[] ss = {"Electronics", "Furniture", "DailyUse", "Food", "Clothing", "Traffic"};

        int tempI;
        String tempS;

        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            //System.out.println("test1");
                            for (Person person : oo.getPersonDirectory().getPersonList()) {
                                //System.out.println("test2");
                                for (Order order : person.getOrderDirectory().getOrderList()) {
                                    //System.out.println("test3");
                                    if (order.getOrderStatus().equals("Delivered") || order.getOrderStatus().equals("Shipped")) {
                                        //System.out.println("test4");
                                        if (order.getProduct().getCatagory().equals("Electronics")) {

                                            aa[0]++;
                                        } else if (order.getProduct().getCatagory().equals("Furniture")) {
                                            aa[1]++;
                                        } else if (order.getProduct().getCatagory().equals("DailyUse")) {
                                            aa[2]++;
                                        } else if (order.getProduct().getCatagory().equals("Food")) {
                                            aa[3]++;
                                        } else if (order.getProduct().getCatagory().equals("Clothing")) {
                                            aa[4]++;
                                        } else if (order.getProduct().getCatagory().equals("Traffic")) {
                                            aa[5]++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < aa.length; i++) {
            for (int j = i + 1; j < aa.length; j++) {
                if (aa[i] < aa[j]) {
                    tempI = aa[i];
                    aa[i] = aa[j];
                    aa[j] = tempI;

                    tempS = ss[i];
                    ss[i] = ss[j];
                    ss[j] = tempS;
                }
            }
        }

//        System.out.println(ss[0] + ss[1] + ss[2]);
//        System.out.println(aa[0]);
//        System.out.println(aa[1]);
//        System.out.println(aa[2]);
//        System.out.println(aa[3]);
//        System.out.println(aa[4]);
        //ArrayList<Product> tempP = new ArrayList<>();
        double ratingFinal;
        int ratCountt;
        ArrayList<Double> ratingD = new ArrayList<>();
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {

                            for (UserAccount uaa : oo.getUserAccountDirectory().getUserAccountList()) {
                                ratCountt = 0;
                                ratingFinal = 0.0;
                                //System.out.println(uaa.getUsername()+"-" + ratingFinal + "--" + ratCountt);
                                for (Order or : uaa.getPerson().getOrderDirectory().getOrderList()) {
                                    if (or.getSeller().equals(uaa) && or.getOrderStatus().equals("Delivered") && or.getRating() != 0) {
                                        ratingFinal = ratingFinal + or.getRating();
                                        ratCountt++;
                                        //ratingFinal = ratingFinal / 2;
                                        //System.out.println(ratingFinal + "--" + ratCountt);
                                    }
                                }
                                ratingFinal = ratingFinal / ratCountt;
                                ratingD.add(ratingFinal);
                            }

                        }
                    }
                }
            }
        }

        ArrayList<Organization> tempOrg = new ArrayList<>();
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            tempOrg.add(oo);
                        }
                    }
                }
            }
        }

//        for(Double dd:ratingD){
//            System.out.println(dd);
//        }
//        for(UserAccount usera: tempUser){
//            System.out.println(usera);
//        }
//        
        Double tempRR;
        Organization tempOO;
        for (int i = 0; i < ratingD.size(); i++) {
            for (int j = i + 1; j < tempOrg.size(); j++) {
                if (ratingD.get(i) < ratingD.get(j)) {
                    tempRR = ratingD.get(i);
                    ratingD.set(i, ratingD.get(j));
                    ratingD.set(j, tempRR);

                    tempOO = tempOrg.get(i);
                    tempOrg.set(i, tempOrg.get(j));
                    tempOrg.set(j, tempOO);
                }
            }
        }

        int cc = 0;
        ArrayList<Product> allProList = new ArrayList<>();
        if (cc < 100) {
            for (Organization orgg : tempOrg) {
                for (Product product : orgg.getProductDirectory().getProductList()) {
                    if ((!product.getUserAccount().equals(userAccount)) && product.getStatus().equals("OK")) {
                        allProList.add(product);
                        cc++;
                    }
                }
            }

            Collections.shuffle(allProList);
            int tempPI = 0;
            for (Product ppp : allProList) {
                if (ppp.getCatagory().equals(ss[0]) && tempPI < 5) {
                    tempP.add(ppp);
                    tempPI++;
                } else if (ppp.getCatagory().equals(ss[1]) && tempPI >= 5 && tempPI < 9) {
                    tempP.add(ppp);
                    tempPI++;
                } else if (ppp.getCatagory().equals(ss[2]) && tempPI >= 9 && tempPI < 12) {
                    tempP.add(ppp);
                    tempPI++;
                }
            }

            Collections.shuffle(tempP);
            lblP1.setIcon(Util.FillLabelLittle(tempP.get(0).getImagePath()));
            lblP2.setIcon(Util.FillLabelLittle(tempP.get(1).getImagePath()));
            lblP3.setIcon(Util.FillLabelLittle(tempP.get(2).getImagePath()));
            lblP4.setIcon(Util.FillLabelLittle(tempP.get(3).getImagePath()));
            btnP1.setText(tempP.get(0).getProductName());
            btnP2.setText(tempP.get(1).getProductName());
            btnP3.setText(tempP.get(2).getProductName());
            btnP4.setText(tempP.get(3).getProductName());
            lblP1.setToolTipText(tempP.get(0).getImagePath());
            lblP2.setToolTipText(tempP.get(1).getImagePath());
            lblP3.setToolTipText(tempP.get(2).getImagePath());
            lblP4.setToolTipText(tempP.get(3).getImagePath());

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

        jLabel1 = new javax.swing.JLabel();
        lblP1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbCategory = new javax.swing.JComboBox();
        btnSearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        lblP2 = new javax.swing.JLabel();
        lblP3 = new javax.swing.JLabel();
        lblP4 = new javax.swing.JLabel();
        btnP1 = new javax.swing.JButton();
        btnP2 = new javax.swing.JButton();
        btnP3 = new javax.swing.JButton();
        btnP4 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Recommandations For You! ~");

        lblP1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/orange-1154559_960_720.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel6.setText("What do you want?");

        cbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnRefresh.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/Right.jpg"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/orange-1154559_960_720.png"))); // NOI18N

        lblP3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/orange-1154559_960_720.png"))); // NOI18N

        lblP4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/orange-1154559_960_720.png"))); // NOI18N

        btnP1.setText("P1");
        btnP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP1ActionPerformed(evt);
            }
        });

        btnP2.setText("jButton1");
        btnP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP2ActionPerformed(evt);
            }
        });

        btnP3.setText("jButton1");
        btnP3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP3ActionPerformed(evt);
            }
        });

        btnP4.setText("jButton1");
        btnP4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnP4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblP1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblP2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblP3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnP1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnP2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnP3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblP4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnP4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearch)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnP1)
                            .addComponent(btnP3)
                            .addComponent(btnP2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnP4)))
                .addGap(74, 74, 74)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        Category c = (Category) cbCategory.getSelectedItem();
        SearchResultJPanel searchResultJPanel = new SearchResultJPanel(userProcessContainer, system, userAccount, organization, c);
        userProcessContainer.add("searchResultJPanel", searchResultJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        if ((btnP1.getText().equals(tempP.get(8).getProductName())) && (lblP1.getToolTipText().equals(tempP.get(8).getImagePath()))) {
            lblP1.setIcon(Util.FillLabelLittle(tempP.get(0).getImagePath()));
            lblP2.setIcon(Util.FillLabelLittle(tempP.get(1).getImagePath()));
            lblP3.setIcon(Util.FillLabelLittle(tempP.get(2).getImagePath()));
            lblP4.setIcon(Util.FillLabelLittle(tempP.get(3).getImagePath()));
            btnP1.setText(tempP.get(0).getProductName());
            btnP2.setText(tempP.get(1).getProductName());
            btnP3.setText(tempP.get(2).getProductName());
            btnP4.setText(tempP.get(3).getProductName());
            lblP1.setToolTipText(tempP.get(0).getImagePath());
            lblP2.setToolTipText(tempP.get(1).getImagePath());
            lblP3.setToolTipText(tempP.get(2).getImagePath());
            lblP4.setToolTipText(tempP.get(3).getImagePath());
            return;
        } else if (btnP1.getText().equals(tempP.get(0).getProductName()) && (lblP1.getToolTipText().equals(tempP.get(0).getImagePath()))) {
            lblP1.setIcon(Util.FillLabelLittle(tempP.get(4).getImagePath()));
            lblP2.setIcon(Util.FillLabelLittle(tempP.get(5).getImagePath()));
            lblP3.setIcon(Util.FillLabelLittle(tempP.get(6).getImagePath()));
            lblP4.setIcon(Util.FillLabelLittle(tempP.get(7).getImagePath()));
            btnP1.setText(tempP.get(4).getProductName());
            btnP2.setText(tempP.get(5).getProductName());
            btnP3.setText(tempP.get(6).getProductName());
            btnP4.setText(tempP.get(7).getProductName());
            lblP1.setToolTipText(tempP.get(4).getImagePath());
            lblP2.setToolTipText(tempP.get(5).getImagePath());
            lblP3.setToolTipText(tempP.get(6).getImagePath());
            lblP4.setToolTipText(tempP.get(7).getImagePath());
            return;

        } else if (btnP1.getText().equals(tempP.get(4).getProductName()) && (lblP1.getToolTipText().equals(tempP.get(4).getImagePath()))) {
            lblP1.setIcon(Util.FillLabelLittle(tempP.get(8).getImagePath()));
            lblP2.setIcon(Util.FillLabelLittle(tempP.get(9).getImagePath()));
            lblP3.setIcon(Util.FillLabelLittle(tempP.get(10).getImagePath()));
            lblP4.setIcon(Util.FillLabelLittle(tempP.get(11).getImagePath()));
            btnP1.setText(tempP.get(8).getProductName());
            btnP2.setText(tempP.get(9).getProductName());
            btnP3.setText(tempP.get(10).getProductName());
            btnP4.setText(tempP.get(11).getProductName());
            lblP1.setToolTipText(tempP.get(8).getImagePath());
            lblP2.setToolTipText(tempP.get(9).getImagePath());
            lblP3.setToolTipText(tempP.get(10).getImagePath());
            lblP4.setToolTipText(tempP.get(11).getImagePath());
            return;
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP1ActionPerformed
        try {
            // TODO add your handling code here:
            Product pp = null;
            for (Network network : system.getNetworkDirectory().getNetworkList()) {
                for (State state : network.getStateDirectory().getStateList()) {
                    for (City city : state.getCityDirectory().getCityList()) {
                        for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                for (Product product : oo.getProductDirectory().getProductList()) {
                                    if (product.getProductName().equals(btnP1.getText()) && product.getImagePath().equals(lblP1.getToolTipText())
                                            && product.getStatus().equals("OK") && (!product.getUserAccount().equals(userAccount))) {
                                        pp = product;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ProductDetailsJPanel productDetailsJPanel = new ProductDetailsJPanel(userProcessContainer, userAccount, pp, system);
            userProcessContainer.add("ProductDetailsJPanel", productDetailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(WelcomPageJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnP1ActionPerformed

    private void btnP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP2ActionPerformed
        try {
            // TODO add your handling code here:
            Product pp = null;
            for (Network network : system.getNetworkDirectory().getNetworkList()) {
                for (State state : network.getStateDirectory().getStateList()) {
                    for (City city : state.getCityDirectory().getCityList()) {
                        for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                for (Product product : oo.getProductDirectory().getProductList()) {
                                    if (product.getProductName().equals(btnP2.getText()) && product.getImagePath().equals(lblP2.getToolTipText())
                                            && product.getStatus().equals("OK") && (!product.getUserAccount().equals(userAccount))) {
                                        pp = product;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ProductDetailsJPanel productDetailsJPanel = new ProductDetailsJPanel(userProcessContainer, userAccount, pp, system);
            userProcessContainer.add("ProductDetailsJPanel", productDetailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(WelcomPageJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnP2ActionPerformed

    private void btnP3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP3ActionPerformed
        try {
            // TODO add your handling code here:
            Product pp = null;
            for (Network network : system.getNetworkDirectory().getNetworkList()) {
                for (State state : network.getStateDirectory().getStateList()) {
                    for (City city : state.getCityDirectory().getCityList()) {
                        for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                for (Product product : oo.getProductDirectory().getProductList()) {
                                    if (product.getProductName().equals(btnP3.getText()) && product.getImagePath().equals(lblP3.getToolTipText())
                                            && product.getStatus().equals("OK") && (!product.getUserAccount().equals(userAccount))) {
                                        pp = product;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ProductDetailsJPanel productDetailsJPanel = new ProductDetailsJPanel(userProcessContainer, userAccount, pp, system);
            userProcessContainer.add("ProductDetailsJPanel", productDetailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(WelcomPageJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnP3ActionPerformed

    private void btnP4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnP4ActionPerformed
        try {
            // TODO add your handling code here:
            Product pp = null;
            for (Network network : system.getNetworkDirectory().getNetworkList()) {
                for (State state : network.getStateDirectory().getStateList()) {
                    for (City city : state.getCityDirectory().getCityList()) {
                        for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                                for (Product product : oo.getProductDirectory().getProductList()) {
                                    if (product.getProductName().equals(btnP4.getText()) && product.getImagePath().equals(lblP4.getToolTipText())
                                            && product.getStatus().equals("OK") && (!product.getUserAccount().equals(userAccount))) {
                                        pp = product;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            ProductDetailsJPanel productDetailsJPanel = new ProductDetailsJPanel(userProcessContainer, userAccount, pp, system);
            userProcessContainer.add("ProductDetailsJPanel", productDetailsJPanel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        } catch (IOException ex) {
            Logger.getLogger(WelcomPageJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnP4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnP1;
    private javax.swing.JButton btnP2;
    private javax.swing.JButton btnP3;
    private javax.swing.JButton btnP4;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox cbCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblP1;
    private javax.swing.JLabel lblP2;
    private javax.swing.JLabel lblP3;
    private javax.swing.JLabel lblP4;
    // End of variables declaration//GEN-END:variables
}
