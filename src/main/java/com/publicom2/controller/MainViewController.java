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
import java.util.List;
/**
 *
 * @author a.guillauma
 */
public class MainViewController {
    
    //Variable
    //DAO de la utilisateur
    private UtilisateurDAO dao;
    //Vue de la liste des utilisateurs
    private MainVue mainVue;
    
    //Constructeur
    /* Paramètre :
        mainView : vue de la liste des utilisateurs
    */
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
        //Créer la fenêtre d'ajout d'un utilisateur
        AddView addView = new AddView();
        //Rend visible la fenêtre d'ajout d'un utilisateur
        addView.setVisible(true);
        //Supprime la fenêtre précédente
        this.mainVue.dispose();
    }
    
    public void goToUpdateView(){
        //Créer la fenêtre de modification d'un utilisateur
        UpdateUser updateView = new UpdateUser(this.mainVue.getSelectedUser());
        //Rend visible la fenêtre de modification d'un utilisateur
        updateView.setVisible(true);
        //Supprime la fenêtre précédente
        this.mainVue.dispose();
    }
    
    public void goToDeleteDialog() throws Exception{
        //Créer le dialogue de suppression d'un utilisateur
        DeleteUserDialog deleteUserDialog = new DeleteUserDialog(this.mainVue, true);
        //Affiche le dialogue
        deleteUserDialog.setVisible(true);
        
        this.mainVue.addUserTableUser();
    }
    
    public List<Utilisateur> listUser() throws Exception{
        //Renvoie la liste des utilisateurs à la vue
        return this.dao.getAll();
    }
}
