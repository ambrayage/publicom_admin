/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.AddView;
import com.publicom2.vue.MainVue;
import java.util.ArrayList;
import java.util.List;
import publicom2.model.Utilisateur;
import publicom2.model.UtilisateurDAO;

/**
 *
 * @author a.guillauma
 */
public class AddViewController {
    
    //Vue pour ajouter un utilisateur
    private AddView addView;
    
    //Constructeur
    /* Paramètre :
        addView : vue d'ajout d'un utilisateur
    */
    public AddViewController(AddView addView){
        this.addView = addView;
    }
    
    //Ouvre la vue mainVue puis ferme la vue addView
    public void backToMainView() throws Exception{
        //Créer la fenêtre de liste des utilisateurs
        MainVue mainView = new MainVue();
        //Rend visible la liste des utilisateurs
        mainView.setVisible(true);
        //Supprime la fenêtre d'ajout d'un utilisateur
        this.addView.dispose();
    }
    
    //Appelle la classe DAO pour ajouté un nouvel utilisateur
    /* Paramètre :
        oneUser : objet Utilisateur contenant toutes les informations du nouvel utilisateur
    */
    public void addUser(Utilisateur oneUser) throws Exception{
        
        //Instance du DAO Utilisateur
        UtilisateurDAO dao = new UtilisateurDAO();
        
        //Vérifie que l'utilisateur avec le même identifiant n'existe pas
        boolean identifierAlreadyExist = false;
        List<Utilisateur> listUsers = dao.getAll();
        for (Utilisateur user : listUsers){

            if (user.getUsernameUser().equals(oneUser.getUsernameUser())){
                identifierAlreadyExist = true;
            }
        }
        //Si l'identifiant existe déjà
        if (identifierAlreadyExist == true){
            this.addView.setTxtStateAddUser("L'utilisateur avec l'identifiant " + oneUser.getUsernameUser() + " existe déjà");
        }
        //Sinon
        else{
            //Demande au DAO Utilisateur d'ajouter l'utilisateur
            dao.create(oneUser);
            //Ferme la vue AddView et ouvre la vue mainVue
            this.backToMainView();
        }
    }
    
}
