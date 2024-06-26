/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.publicom2.vue;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.publicom2.controller.MainViewController;
import java.awt.Color;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import publicom2.model.Utilisateur;

/**
 *
 * @author a.guillauma
 */
public class MainVue extends javax.swing.JFrame {

    /**
     * Creates new form MainVue
     */
    //Controlleur de cette vue
    private MainViewController controller;
    //Modèle de la table de la liste des utilisateurs
    private DefaultTableModel modelTable;

    public MainVue() throws Exception{
        //Initialise les composants de la vue
        initComponents();
        //Instance du controlleur
        this.controller = new MainViewController( this);
        //Model de la table
        this.modelTable = (DefaultTableModel)this.tableUserList.getModel();
        //Initialise les colonnes de la table
        this.modelTable.addColumn("ID");
        this.modelTable.addColumn("Identifiant");
        this.modelTable.addColumn("Nom");
        this.modelTable.addColumn("Prenom");
        //Ajoute les utilisateurs
        this.addUserTableUser();
        //Initialise les évenements de selection de la table
        this.evenementSelectionTableUser();
        
        //Definit l'editeur de la table à null
        //Les cellules ne sont donc plus editable
        this.tableUserList.setDefaultEditor(Object.class, null);
        
        this.getContentPane().setBackground(new Color(205,133,63));
    }
    
    public void addUserTableUser() throws Exception{
        //Définit le nombre de ligne de la table à 0
        //De ce fait, la table est reinitialisée
        //Utile après le dialogue DeleteUserDialog pour actualiser la table
        this.modelTable.setRowCount(0);
        //Ajoute les lignes pour chaque utilisateur dans la liste donnée par le controlleur
        for (Utilisateur user : this.controller.listUser()){
            this.modelTable.addRow(new String[] {Integer.toString(user.getIdUser()),user.getUsernameUser(), user.getNameUser(), user.getFirstNameUser()});
        }
    }
    
    //Fonction pour activer un bouton si une ligne est selectionnée
    //et désactiver un bouton si aucune ligne n'est selectionnée
    public void evenementSelectionTableUser(){
        //Evenement Selection des lignes
        //Récupération du modèle de selection de la table
        var modelTableSelection = this.tableUserList.getSelectionModel();
        //Ajout d'un évenement au modèle de selection de la table
        modelTableSelection.addListSelectionListener(new ListSelectionListener(){
            //Fonction appelée lors de l'activation de l'évenement
            public void valueChanged(ListSelectionEvent e){
                //Si aucune ligne n'est selectionnée
                if(modelTableSelection.isSelectionEmpty()){
                    //..Desactiver les boutons modifier et suppression
                    buttonUpdateUser.setEnabled(false);
                    buttonDeleteUser.setEnabled(false);
                }
                //Sinon
                else{
                    //..Activer les boutons modifier et suppression
                    buttonUpdateUser.setEnabled(true);
                    buttonDeleteUser.setEnabled(true);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelUserList = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUserList = new javax.swing.JTable();
        buttonUpdateUser = new javax.swing.JButton();
        buttonDeleteUser = new javax.swing.JButton();
        buttonAddUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des utilisateurs");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(51, 51, 255));
        setResizable(false);

        labelUserList.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        labelUserList.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelUserList.setText("Liste des utilisateurs");
        labelUserList.setToolTipText("");
        labelUserList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 0), 2));
        jScrollPane1.setForeground(new java.awt.Color(102, 51, 0));

        tableUserList.setBackground(new java.awt.Color(153, 102, 0));
        tableUserList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 51, 0), 2, true));
        tableUserList.setModel(new DefaultTableModel()
        );
        jScrollPane1.setViewportView(tableUserList);

        buttonUpdateUser.setBackground(new java.awt.Color(255, 204, 153));
        buttonUpdateUser.setText("Modifier l'utilisateur");
        buttonUpdateUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 153, 0), 2, true));
        buttonUpdateUser.setEnabled(false);
        buttonUpdateUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonUpdateUserMouseClicked(evt);
            }
        });
        buttonUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateUserActionPerformed(evt);
            }
        });

        buttonDeleteUser.setBackground(new java.awt.Color(255, 153, 153));
        buttonDeleteUser.setText("Supprimer l'utilisateur");
        buttonDeleteUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 0, 0), 2, true));
        buttonDeleteUser.setEnabled(false);
        buttonDeleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDeleteUserMouseClicked(evt);
            }
        });

        buttonAddUser.setBackground(new java.awt.Color(153, 255, 153));
        buttonAddUser.setText("Ajouter un nouvel utilisateur");
        buttonAddUser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 0), 2, true));
        buttonAddUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonAddUserMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(labelUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(buttonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(buttonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(buttonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(labelUserList, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonUpdateUser, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonDeleteUser, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAddUser, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonAddUserMouseClicked
        this.controller.goToAddView();
    }//GEN-LAST:event_buttonAddUserMouseClicked

    private void buttonUpdateUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonUpdateUserMouseClicked
        //Si le bouton est activé
        if (this.buttonUpdateUser.isEnabled()) {
            this.controller.goToUpdateView();
        }
    }//GEN-LAST:event_buttonUpdateUserMouseClicked

    private void buttonUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonUpdateUserActionPerformed

    private void buttonDeleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDeleteUserMouseClicked
        //Si le bouton est activé
        if (this.buttonDeleteUser.isEnabled()){
            try{
            this.controller.goToDeleteDialog();
            }
            catch(Exception exception){
                
            }
        }
        
    }//GEN-LAST:event_buttonDeleteUserMouseClicked
    
    public Utilisateur getSelectedUser(){
        int id =  Integer.parseInt(this.modelTable.getValueAt(this.tableUserList.getSelectedRow(), 0).toString());
        String identifiant =  this.modelTable.getValueAt(this.tableUserList.getSelectedRow(), 1).toString();
        String nom =  this.modelTable.getValueAt(this.tableUserList.getSelectedRow(), 2).toString();
        String prenom =  this.modelTable.getValueAt(this.tableUserList.getSelectedRow(), 3).toString();
        
        return new Utilisateur(id,identifiant,null, nom, prenom);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainVue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainVue().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(MainVue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddUser;
    private javax.swing.JButton buttonDeleteUser;
    private javax.swing.JButton buttonUpdateUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelUserList;
    private javax.swing.JTable tableUserList;
    // End of variables declaration//GEN-END:variables
}
