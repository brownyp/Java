/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.useraccount;

import Util.Util;
import business.city.City;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.person.Person;
import business.role.UserRole;
import business.state.State;
import business.system.EcoSystem;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author yupei
 */
public class UpdateUserAccount extends javax.swing.JPanel {

    /**
     * Creates new form UpdateUserAccount
     */
    JPanel userProcessContainer;
    UserAccount userAccount;
    Organization organization;
    EcoSystem system;

    public UpdateUserAccount(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Organization organization) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.organization = organization;
        this.system = system;

        populateCBCountry();

        Person p = organization.getPersonDirectory().getPersonList().get(0);
        UserAccount u = organization.getUserAccountDirectory().getUserAccountList().get(0);
        txtPersonName.setText(p.getName());
        txtUserName.setText(u.getUsername());
        //txtPassword.setText(u.getPassword());
        txtEmail.setText(p.getEmail());
        txtPhoneNumber.setText(p.getPhoneNumber());
        cbCountry.setSelectedItem(p.getCountry());
        cbState.setSelectedItem(p.getState());
        cbCity.setSelectedItem(p.getCity());
        cbUniversity.setSelectedItem(p.getUniversity());
        txtZipcode.setText(p.getZipCode());
    }

    public void populateCBCountry() {
        cbCountry.removeAllItems();
        for (Network n : system.getNetworkDirectory().getNetworkList()) {
            cbCountry.addItem(n);
        }
    }

    public void populateCBState(Network n) {

        cbState.removeAllItems();
        for (State s : n.getStateDirectory().getStateList()) {
            cbState.addItem(s);
        }
    }

    public void populateCBCity(State s) {

        cbCity.removeAllItems();
        for (City c : s.getCityDirectory().getCityList()) {
            cbCity.addItem(c);
        }
    }

    public void populateCBUniversity(City c) {
        cbUniversity.removeAllItems();
        for (Enterprise e : c.getEnterpriseDirectory().getEnterpriseList()) {
            cbUniversity.addItem(e);
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

        jLabel11 = new javax.swing.JLabel();
        lblPicture = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();
        txtUserName = new javax.swing.JTextField();
        txtPersonName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtZipcode = new javax.swing.JTextField();
        cbUniversity = new javax.swing.JComboBox();
        cbCity = new javax.swing.JComboBox();
        cbState = new javax.swing.JComboBox();
        cbCountry = new javax.swing.JComboBox();
        btnUpload = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnSignUp = new javax.swing.JButton();

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Update Account Information");

        lblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/userinterface/main/Person.jpg"))); // NOI18N

        jLabel9.setText("Person Name:");

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        jLabel7.setText("E-mail:");

        jLabel6.setText("Phone Number:");

        txtPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneNumberActionPerformed(evt);
            }
        });

        jLabel3.setText("Country:");

        jLabel10.setText("State:");

        jLabel4.setText("City:");

        jLabel8.setText("University:");

        jLabel5.setText("Zip Code:");

        cbUniversity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbUniversity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUniversityActionPerformed(evt);
            }
        });

        cbCity.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCityActionPerformed(evt);
            }
        });

        cbState.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbState.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStateActionPerformed(evt);
            }
        });

        cbCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCountryActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnSignUp.setText("Update");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
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
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtEmail))
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtPassword))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(104, 104, 104)
                                            .addComponent(txtPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancel)
                                .addGap(18, 18, 18)
                                .addComponent(btnSignUp)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbCity, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbState, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCountry, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpload)
                .addGap(202, 202, 202))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPersonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbUniversity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtZipcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSignUp)
                    .addComponent(btnCancel))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneNumberActionPerformed

    private void cbUniversityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUniversityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbUniversityActionPerformed

    private void cbCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCityActionPerformed
        // TODO add your handling code here:
        City city = (City) cbCity.getSelectedItem();
        if (city != null) {
            populateCBUniversity(city);
        }
    }//GEN-LAST:event_cbCityActionPerformed

    private void cbStateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStateActionPerformed
        // TODO add your handling code here:
        State state = (State) cbState.getSelectedItem();
        if (state != null) {
            populateCBCity(state);
        }
    }//GEN-LAST:event_cbStateActionPerformed

    private void cbCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCountryActionPerformed
        // TODO add your handling code here:
        Network network = (Network) cbCountry.getSelectedItem();
        if (network != null) {
            populateCBState(network);
        }
    }//GEN-LAST:event_cbCountryActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int save = file.showSaveDialog(null);

        if (save == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            lblPicture.setToolTipText(path);
            lblPicture.setIcon(Util.FillLabel(path));
            System.out.println(path);
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "Confirm to Cancel?", null, JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            userProcessContainer.remove(this);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.previous(userProcessContainer);
        } else {
            return;
        }
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
        if (txtEmail.getText().length() < 1 || txtPassword.getText().length() < 1 || txtPersonName.getText().length() < 1 || txtPhoneNumber.getText().length() < 1 || txtUserName.getText().length() < 1 || txtZipcode.getText().length() < 1) {
            JOptionPane.showMessageDialog(null, "Please complete blanks", "Warning", WARNING_MESSAGE);
            return;
        }

        Pattern pattern0 = Pattern.compile("[0-9-+]*");
        Pattern pattern1 = Pattern.compile("^[A-Za-z]+$");
        Pattern pattern2 = Pattern.compile("^[A-Za-zd]+([-_.][A-Za-zd]+)*@([A-Za-zd]+[-.])+edu$");
        Matcher num = pattern0.matcher(txtPhoneNumber.getText());
        Matcher num1 = pattern0.matcher(txtZipcode.getText());
        Matcher letter = pattern1.matcher(txtPersonName.getText());
        Matcher emailM = pattern2.matcher(txtEmail.getText());
        if (!num.matches() || !num1.matches()) {
            JOptionPane.showMessageDialog(null, "Wrong Number!", "Error", ERROR_MESSAGE);
            return;
        }
        if (!letter.matches()) {
            JOptionPane.showMessageDialog(null, "Only English Letters!", "Error", ERROR_MESSAGE);
            return;
        }
        if (!emailM.matches()) {
            JOptionPane.showMessageDialog(null, "Only Education Account!", "Error", ERROR_MESSAGE);
            return;
        }

        //Same UserName
        for (UserAccount sysu : system.getUserAccountDirectory().getUserAccountList()) {
            if (txtUserName.getText().equals(sysu.getUsername()) && !txtUserName.getText().equals(userAccount.getUsername())) {
                JOptionPane.showMessageDialog(null, "Same User Name!", "Error", ERROR_MESSAGE);
                return;
            }
        }
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (UserAccount eu : enterprise.getUserAccountDirectory().getUserAccountList()) {
                            if (txtUserName.getText().equals(eu.getUsername()) && !txtUserName.getText().equals(userAccount.getUsername())) {
                                JOptionPane.showMessageDialog(null, "Same User Name!", "Error", ERROR_MESSAGE);
                                return;
                            }
                        }
                    }
                }
            }
        }
        for (Network network : system.getNetworkDirectory().getNetworkList()) {
            for (State state : network.getStateDirectory().getStateList()) {
                for (City city : state.getCityDirectory().getCityList()) {
                    for (Enterprise enterprise : city.getEnterpriseDirectory().getEnterpriseList()) {
                        for (Organization oo : enterprise.getOrganizationDirectory().getOrganizationList()) {
                            for (UserAccount ou : oo.getUserAccountDirectory().getUserAccountList()) {
                                if (txtUserName.getText().equals(ou.getUsername()) && !txtUserName.getText().equals(userAccount.getUsername())) {
                                    JOptionPane.showMessageDialog(null, "Same User Name!", "Error", ERROR_MESSAGE);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }

        String personName = txtPersonName.getText();
        String country = String.valueOf(cbCountry.getSelectedItem());
        String state = String.valueOf(cbState.getSelectedItem());
        String city = String.valueOf(cbCity.getSelectedItem());
        String university = String.valueOf(cbUniversity.getSelectedItem());
        String phoneNumber = txtPhoneNumber.getText();
        String zipCode = txtZipcode.getText();
        String email = txtEmail.getText();
        String picturePath = lblPicture.getToolTipText();
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        Person p = organization.getPersonDirectory().getPersonList().get(0);
        UserAccount u = organization.getUserAccountDirectory().getUserAccountList().get(0);
        p.setName(personName);
        p.setCountry(country);
        p.setState(state);
        p.setCity(city);
        p.setUniversity(university);
        p.setPhoneNumber(phoneNumber);
        p.setZipCode(zipCode);
        p.setEmail(email);
        p.setPicturePath(picturePath);
        u.setUsername(userName);
        u.setPassword(password);
        JOptionPane.showMessageDialog(null, "Update Successfully!");


    }//GEN-LAST:event_btnSignUpActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnUpload;
    private javax.swing.JComboBox cbCity;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JComboBox cbState;
    private javax.swing.JComboBox cbUniversity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblPicture;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtPersonName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtZipcode;
    // End of variables declaration//GEN-END:variables
}
