/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import publicom2.model.UtilisateurDAO;
import publicom2.model.Utilisateur;

import com.publicom2.vue.MainVue;
import com.publicom2.vue.AddView;
import com.publicom2.vue.UpdateUser;
import com.publicom2.vue.DeleteUserDialog;
/**
 *
 * @author a.guillauma
 */
public class MainViewController {
    
    //Variable
    private UtilisateurDAO dao;
    private MainVue mainVue;
    
    //Constructeur
    public MainViewController(MainVue mainVue){
        this.mainVue = mainVue;
        try
        {
        this.dao = new UtilisateurDAO();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void addsUserTableUserMainView(){
        try{
            for (Utilisateur utilisateur : this.dao.getAll()){
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void goToAddView(){
        AddView addView = new AddView();
        addView.setVisible(true);
        this.mainVue.dispose();
    }
    
    public void goToUpdateView(){
        UpdateUser updateView = new UpdateUser();
        updateView.setVisible(true);
        this.mainVue.dispose();
    }
    
    public void goToDeleteDialog(){
        DeleteUserDialog deleteUserDialog = new DeleteUserDialog(this.mainVue, true);
        deleteUserDialog.setVisible(true);
    }
}
