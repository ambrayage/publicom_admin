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
        this.dao = new UtilisateurDAO();
    }
    
    public void GoToAddView(){
        this.mainVue.setVisible(false);
        AddView addView = new AddView();
        addView.setVisible(true);
    }
    
    public void GoToUpdateView(){
        this.mainVue.setVisible(false);
        UpdateUser updateView = new UpdateUser();
        updateView.setVisible(true);
    }
}
