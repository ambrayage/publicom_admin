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
    
    private DeleteUserDialog deleteUserDialog;
    
    public DeleteDialogController(DeleteUserDialog deleteUserDialog){
        this.deleteUserDialog = deleteUserDialog;
    }
    
    public void closeDeleteDialog(){
        this.deleteUserDialog.dispose();
    }
}
