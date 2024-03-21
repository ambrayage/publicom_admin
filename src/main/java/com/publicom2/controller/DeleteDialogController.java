/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.DeleteUserDialog;
import com.publicom2.vue.MainVue;
import publicom2.model.Utilisateur;
import publicom2.model.UtilisateurDAO;

/**
 *
 * @author a.guillauma
 */
public class DeleteDialogController{
    
    //Vue pour supprimer un utilisateur
    private DeleteUserDialog deleteUserDialog;
    private UtilisateurDAO utilisateurDAO;
    private Utilisateur selectedUser;
    
    //Constructeur
    /* Paramètre :
        deleteView : dialogue de suppression d'un utilisateur
    */
    public DeleteDialogController(DeleteUserDialog deleteUserDialog) throws Exception{
        this.deleteUserDialog = deleteUserDialog;
        this.utilisateurDAO = new UtilisateurDAO();
        
        MainVue mainVue = (MainVue)this.deleteUserDialog.getParent();
        this.selectedUser =  mainVue.getSelectedUser();
    }
    
    public String getNameSelectedUserForDelete(){
        return this.selectedUser.getUsernameUser();
    }
    
    public void acceptDeleteDialog() throws Exception{
        this.utilisateurDAO.delete(this.selectedUser);
        this.deleteUserDialog.dispose();
    }
    
    public void closeDeleteDialog(){
        //Supprimer le dialogue de suppression d'un utilisateur
        this.deleteUserDialog.dispose();
    }
}
