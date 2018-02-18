/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.buy;

import business.system.EcoSystem;
import business.city.City;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.product.Product;
import business.state.State;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.main.WelcomPageJPanel;

/**
 *
 * @author yupei
 */
public class SearchResultJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SearchResultJPanel
     */
    JPanel userProcessContainer;
    EcoSystem system;
    UserAccount userAccount;
    Organization organization;

    Product.Category category;

    public SearchResultJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Organization organization, Product.Category category) {
        initComponents();
        this.system = system;
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.category = category;

        populateWhich();

        //System.out.println(system.getProductDirectory().getProductList().size());
    }

    public void populateWhich() {
        if (!category.getValue().equals("All")) {
            populateTable();
        } else {
            populateTableAll();
        }
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0);

        for (Network n : system.getNetworkDirectory().getNetworkList()) {
            for (State s : n.getStateDirectory().getStateList()) {
                for (City c : s.getCityDirectory().getCityList()) {
                    for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            Collections.sort(o.getProductDirectory().getProductList(), Comparator.comparing(Product::getProductPrice));
                            for (Product p : o.getProductDirectory().getProductList()) {

                                if (!p.getUserAccount().equals(userAccount) && p.getCatagory().equals(category.getValue()) && !p.getStatus().equals("Sold")) {
                                    Object[] row = new Object[6];
                                    row[0] = p;
                                    row[1] = p.getCatagory();
                                    row[2] = p.getProductPrice();
                                    row[3] = p.getStatus();
                                    row[4] = p.getUserAccount();
                                    row[5] = p.getUserAccount().getPerson().getUniversity();

                                    model.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void populateTableAll() {
        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0);

        for (Network n : system.getNetworkDirectory().getNetworkList()) {
            for (State s : n.getStateDirectory().getStateList()) {
                for (City c : s.getCityDirectory().getCityList()) {
                    for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            Collections.sort(o.getProductDirectory().getProductList(), Comparator.comparing(Product::getProductPrice));
                            for (Product p : o.getProductDirectory().getProductList()) {

                                if (!p.getUserAccount().equals(userAccount) && !p.getStatus().equals("Sold")) {
                                    Object[] row = new Object[6];
                                    row[0] = p;
                                    row[1] = p.getCatagory();
                                    row[2] = p.getProductPrice();
                                    row[3] = p.getStatus();
                                    row[4] = p.getUserAccount();
                                    row[5] = p.getUserAccount().getPerson().getUniversity();

                                    model.addRow(row);
                                }
                            }
                        }
                    }
                }
            }
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
        btnViewDetails = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbSort = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblResult = new javax.swing.JTable();
        txtProductName = new javax.swing.JTextField();
        btnFind = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Search Result");

        btnViewDetails.setText("View Product details");
        btnViewDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDetailsActionPerformed(evt);
            }
        });

        jLabel2.setText("Sort By:");

        cbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Price low to high", "Price high to low", "Same University" }));
        cbSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSortActionPerformed(evt);
            }
        });

        btnBack.setText("<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        tblResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Product Name", "Category", "Price", "Status", "Seller", "University"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblResult);

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(292, 292, 292)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewDetails)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFind))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnViewDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewDetailsActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblResult.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", WARNING_MESSAGE);
        } else {
            try {
                Product product = (Product) tblResult.getValueAt(selectedRow, 0);
                ProductDetailsJPanel productDetailsJPanel = new ProductDetailsJPanel(userProcessContainer, userAccount, product, system);
                userProcessContainer.add("ProductDetailsJPanel", productDetailsJPanel);
                CardLayout layout = (CardLayout) userProcessContainer.getLayout();
                layout.next(userProcessContainer);
            } catch (IOException ex) {
                Logger.getLogger(SearchResultJPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnViewDetailsActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        WelcomPageJPanel welcomPageJPanel = (WelcomPageJPanel) component;
        welcomPageJPanel.populatePictures();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cbSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSortActionPerformed
        // TODO add your handling code here:Collections.sort(f1, Comparator.comparing(Flight::getPrice));
        if (cbSort.getSelectedItem().equals("Price low to high") && !category.getValue().equals("All")) {
            populateTable();
        } else if (cbSort.getSelectedItem().equals("Price high to low") && !category.getValue().equals("All")) {
            DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
            model.setRowCount(0);

            for (Network n : system.getNetworkDirectory().getNetworkList()) {
                for (State s : n.getStateDirectory().getStateList()) {
                    for (City c : s.getCityDirectory().getCityList()) {
                        for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                                Collections.sort(o.getProductDirectory().getProductList(), Comparator.comparing(Product::getProductPrice));
                                Collections.reverse(o.getProductDirectory().getProductList());
                                for (Product p : o.getProductDirectory().getProductList()) {
                                    if (!p.getUserAccount().equals(userAccount) && p.getCatagory().equals(category.getValue()) && !p.getStatus().equals("Sold")) {
                                        Object[] row = new Object[6];
                                        row[0] = p;
                                        row[1] = p.getCatagory();
                                        row[2] = p.getProductPrice();
                                        row[3] = p.getStatus();
                                        row[4] = p.getUserAccount();
                                        row[5] = p.getUserAccount().getPerson().getUniversity();

                                        model.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (cbSort.getSelectedItem().equals("Same University") && !category.getValue().equals("All")) {
            DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
            model.setRowCount(0);

            for (Network n : system.getNetworkDirectory().getNetworkList()) {
                for (State s : n.getStateDirectory().getStateList()) {
                    for (City c : s.getCityDirectory().getCityList()) {
                        for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {

                                for (Product p : o.getProductDirectory().getProductList()) {
                                    if (!p.getUserAccount().equals(userAccount) && p.getCatagory().equals(category.getValue()) && p.getUserAccount().getPerson().getUniversity().equals(userAccount.getPerson().getUniversity()) && !p.getStatus().equals("Sold")) {
                                        Object[] row = new Object[6];
                                        row[0] = p;
                                        row[1] = p.getCatagory();
                                        row[2] = p.getProductPrice();
                                        row[3] = p.getStatus();
                                        row[4] = p.getUserAccount();
                                        row[5] = p.getUserAccount().getPerson().getUniversity();

                                        model.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(cbSort.getSelectedItem().equals("Price low to high") && category.getValue().equals("All")){
            populateTableAll();
        }else if(cbSort.getSelectedItem().equals("Price high to low") && category.getValue().equals("All")){
            DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
            model.setRowCount(0);

            for (Network n : system.getNetworkDirectory().getNetworkList()) {
                for (State s : n.getStateDirectory().getStateList()) {
                    for (City c : s.getCityDirectory().getCityList()) {
                        for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                                Collections.sort(o.getProductDirectory().getProductList(), Comparator.comparing(Product::getProductPrice));
                                Collections.reverse(o.getProductDirectory().getProductList());
                                for (Product p : o.getProductDirectory().getProductList()) {
                                    if (!p.getUserAccount().equals(userAccount) && !p.getStatus().equals("Sold")) {
                                        Object[] row = new Object[6];
                                        row[0] = p;
                                        row[1] = p.getCatagory();
                                        row[2] = p.getProductPrice();
                                        row[3] = p.getStatus();
                                        row[4] = p.getUserAccount();
                                        row[5] = p.getUserAccount().getPerson().getUniversity();

                                        model.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(cbSort.getSelectedItem().equals("Same University") && category.getValue().equals("All")){
            DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
            model.setRowCount(0);

            for (Network n : system.getNetworkDirectory().getNetworkList()) {
                for (State s : n.getStateDirectory().getStateList()) {
                    for (City c : s.getCityDirectory().getCityList()) {
                        for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                            for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {

                                for (Product p : o.getProductDirectory().getProductList()) {
                                    if (!p.getUserAccount().equals(userAccount) && p.getUserAccount().getPerson().getUniversity().equals(userAccount.getPerson().getUniversity()) && !p.getStatus().equals("Sold")) {
                                        Object[] row = new Object[6];
                                        row[0] = p;
                                        row[1] = p.getCatagory();
                                        row[2] = p.getProductPrice();
                                        row[3] = p.getStatus();
                                        row[4] = p.getUserAccount();
                                        row[5] = p.getUserAccount().getPerson().getUniversity();

                                        model.addRow(row);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_cbSortActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String name = txtProductName.getText();
        ArrayList<Product> results = new ArrayList<>();
        Pattern pattern = Pattern.compile(name, Pattern.CASE_INSENSITIVE);
        for (Network n : system.getNetworkDirectory().getNetworkList()) {
            for (State s : n.getStateDirectory().getStateList()) {
                for (City c : s.getCityDirectory().getCityList()) {
                    for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization o : e.getOrganizationDirectory().getOrganizationList()) {
                            for (Product pro1 : o.getProductDirectory().getProductList()) {
                                Matcher matcher = pattern.matcher(pro1.getProductName());
                                if (matcher.find()) {
                                    results.add(pro1);
                                }
                            }
                        }
                    }
                }
            }
        }

        DefaultTableModel model = (DefaultTableModel) tblResult.getModel();
        model.setRowCount(0);

        for (Product pro : results) {
            Object[] row = new Object[6];
            row[0] = pro;
            row[1] = pro.getUserAccount().getPerson().getCountry() + "." + pro.getUserAccount().getPerson().getState() + "." + pro.getUserAccount().getPerson().getCity();
            row[2] = pro.getProductPrice();
            row[3] = pro.getStatus();
            row[4] = pro.getUserAccount();
            row[5] = pro.getUserAccount().getPerson().getUniversity();

            model.addRow(row);
        }
    }//GEN-LAST:event_btnFindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnViewDetails;
    private javax.swing.JComboBox<String> cbSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblResult;
    private javax.swing.JTextField txtProductName;
    // End of variables declaration//GEN-END:variables
}
