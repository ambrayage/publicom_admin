/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.DeleteUserDialog;

/**
 *
 * @author a.guillauma
 */
public class DeleteDialogController {
    
    //Vue pour supprimer un utilisateur
    private DeleteUserDialog deleteUserDialog;
    
    //Constructeur
    /* Paramètre :
        deleteView : dialogue de suppression d'un utilisateur
    */
    public DeleteDialogController(DeleteUserDialog deleteUserDialog){
        this.deleteUserDialog = deleteUserDialog;
    }
    
    public void closeDeleteDialog(){
        //Supprimer le dialogue de suppression d'un utilisateur
        this.deleteUserDialog.dispose();
    }
}
