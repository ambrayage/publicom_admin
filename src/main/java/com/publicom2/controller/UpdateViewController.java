/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.UpdateUser;
import com.publicom2.vue.MainVue;

/**
 *
 * @author a.guillauma
 */
public class UpdateViewController {
    
    //Vue de modification d'un utilisateur
    private UpdateUser updateView;
    
    //Constructeur
    /* Paramètre :
    updateView : vue de modification d'un utilisateur
    */
    public UpdateViewController(UpdateUser updateView){
        this.updateView = updateView;
    }
    
    public void backToMainView() throws Exception{
        //Création de la fenêtre de liste des utilisateurs
        MainVue mainView = new MainVue();
        //Rend visible la fenêtre de liste des utilisateurs
        mainView.setVisible(true);
        //Ferme la fenêtre d'ajout d'un utilisateur
        this.updateView.dispose();
    }
}
