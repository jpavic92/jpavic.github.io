/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.gui;

import hr.algebra.utils.MessageUtils;
import hr.cinestar.dal.Repository;
import hr.cinestar.dal.RepositoryFactory;
import hr.cinestar.model.User;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Josip
 */
public class SignInPanel extends javax.swing.JPanel {
    
    private Repository repo;
    
    private List<JTextField> validationFields;
    private List<JLabel> errorLabels;
    private final LoginForm parent;
    private int userExists;

    /**
     * Creates new form SignInPanel
     * @param parent
     */
    public SignInPanel(JFrame parent) {
        initComponents();
        this.parent = (LoginForm)parent;
        init();
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
        tfUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSignIn = new javax.swing.JButton();
        lblRegister = new javax.swing.JLabel();
        lblUsernameError = new javax.swing.JLabel();
        lblPasswordError = new javax.swing.JLabel();
        pfPassword = new javax.swing.JPasswordField();

        setPreferredSize(new java.awt.Dimension(630, 420));

        jLabel1.setText("Username:");

        tfUsername.setName("username"); // NOI18N
        tfUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SignInPanel.this.keyReleased(evt);
            }
        });

        jLabel2.setText("Password:");

        btnSignIn.setText("Sign in");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        lblRegister.setForeground(new java.awt.Color(0, 0, 255));
        lblRegister.setText("Register");
        lblRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRegisterMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblRegisterMouseReleased(evt);
            }
        });

        lblUsernameError.setForeground(new java.awt.Color(255, 0, 0));

        lblPasswordError.setForeground(new java.awt.Color(255, 0, 0));

        pfPassword.setName("password"); // NOI18N
        pfPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SignInPanel.this.keyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRegister)
                        .addGap(18, 18, 18)
                        .addComponent(btnSignIn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pfPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSignIn)
                            .addComponent(lblRegister)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
       handleInput();
    }//GEN-LAST:event_btnSignInActionPerformed

    private void lblRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseEntered
        lblRegister.setForeground(Color.ORANGE);
    }//GEN-LAST:event_lblRegisterMouseEntered

    private void lblRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseExited
        lblRegister.setForeground(Color.blue);
    }//GEN-LAST:event_lblRegisterMouseExited

    private void lblRegisterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegisterMouseReleased
       parent.setRegisterPanel();
    }//GEN-LAST:event_lblRegisterMouseReleased

    private void keyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyReleased
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            handleInput();
        }
         else{
             String componentName = evt.getComponent().getName();
             if (null != componentName) switch (componentName) {
                 case "username":
                     lblUsernameError.setText(validationFields.get(0).getText().isEmpty() ? "X" : "");
                     break;
                 case "password":
                     lblPasswordError.setText(validationFields.get(1).getText().isEmpty() ? "X" : "");
                     break;
                 default:
                     break;
             }
         }
    }//GEN-LAST:event_keyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblPasswordError;
    private javax.swing.JLabel lblRegister;
    private javax.swing.JLabel lblUsernameError;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables

    private void init() {
        initValidation();
        initRepo();
    }

    private void initValidation() {
        validationFields = Arrays.asList(tfUsername, pfPassword);
        errorLabels = Arrays.asList(lblUsernameError, lblPasswordError);
    }

    private boolean formValid() {
        boolean ok = true;
        
        for (int i = 0; i < validationFields.size(); i++) {
            ok &= !validationFields.get(i).getText().isEmpty();
            errorLabels.get(i).setText(validationFields.get(i).getText().isEmpty() ? "X" : "");
        }
        
        return ok;
    }

    private void initRepo() {
        repo = RepositoryFactory.getRepository();
    }

    private boolean authenticateUser() throws Exception {
        User user = new User(tfUsername.getText().trim(), pfPassword.getPassword());
        userExists = repo.userExits(user);
        return userExists == 0 ? false : true;
    }
    private void handleInput() {
        if(!formValid()){
            return;
        }
        
        try {
            if (authenticateUser()) {
                if (userExists == 2) {
                    new UserFrame().setVisible(true);
                    parent.dispose();
                    
                }
                else{
                    new AdminFrame().setVisible(true);
                    parent.dispose();
                }
            }
            else MessageUtils.showInformationMessage("Authenicaton failed", "Entered username or password does now match.");
        } catch (Exception ex) {
            Logger.getLogger(PersonsPanel.class.getName()).log(Level.SEVERE, null, ex);
            MessageUtils.showErrorMessage("Authentication failed", "Unable to authenticate the user.");
        }
    }
}
