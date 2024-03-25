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
        //Récupere le dialogue DeleteUserDialog
        this.deleteUserDialog = deleteUserDialog;
        //Instance du DAO Utilisateur
        this.utilisateurDAO = new UtilisateurDAO();
        
        //Récupere la mainVue qui est le parent du dialogue DeleteUserDialog
        MainVue mainVue = (MainVue)this.deleteUserDialog.getParent();
        //Récupere l'utilisateur selectionné dans la mainVue
        this.selectedUser =  mainVue.getSelectedUser();
    }
    
    //Récupere l'identifiant de l'utilisateur
    public String getNameSelectedUserForDelete(){
        return this.selectedUser.getUsernameUser();
    }
    
    //Supprime l'utilisateur grâce au DAO Utilisateur
    public void acceptDeleteDialog() throws Exception{
        //Demande au DAO Utilisateur de supprimer l'utilisateur en lui donnant l'utilisateur selectionné dans la mainVue
        this.utilisateurDAO.delete(this.selectedUser);
        //Ferme le dialogue DeleteUserDialog
        this.deleteUserDialog.dispose();
    }
    
    //Ferme le dialogue DeleteUserDialog
    public void closeDeleteDialog(){
        //Supprimer le dialogue de suppression d'un utilisateur
        this.deleteUserDialog.dispose();
    }
}
