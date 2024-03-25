/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicom2.controller;
import com.publicom2.vue.UpdateUser;
import com.publicom2.vue.MainVue;
import publicom2.model.Utilisateur;
import publicom2.model.UtilisateurDAO;

/**
 *
 * @author a.guillauma
 */
public class UpdateViewController {
    
    //Vue de modification d'un utilisateur
    private UpdateUser updateView;
    private UtilisateurDAO utilisateurDAO;
    
    //Constructeur
    /* Paramètre :
    updateView : vue de modification d'un utilisateur
    */
    public UpdateViewController(UpdateUser updateView){
        this.updateView = updateView;
        try {
        this.utilisateurDAO = new UtilisateurDAO();
        }catch(Exception exception){
            System.out.println(exception);
        }
    }
    
    //Modifie l'utilisateur grâce au DAO Utilisateur
    /* Paramètre :
    user : utilisateur avec l'id inchangé et l'identifiant, nom, prenom et mot de passe modifié
    */
    public void acceptUpdateUser(Utilisateur user) throws Exception{
        //Demande au DAO Utilisateur de modifier l'utilisateur
        this.utilisateurDAO.update(user);
    }
    
    //Ouvre la vue mainVue puis ferme la vue updateView
    public void backToMainView() throws Exception{
        //Création de la fenêtre de liste des utilisateurs
        MainVue mainView = new MainVue();
        //Rend visible la fenêtre de liste des utilisateurs
        mainView.setVisible(true);
        //Ferme la fenêtre d'ajout d'un utilisateur
        this.updateView.dispose();
    }
}
