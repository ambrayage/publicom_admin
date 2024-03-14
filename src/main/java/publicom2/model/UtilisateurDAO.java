/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publicom2.model;

import java.sql.Connection;

/**
 *
 * @author l.blee
 */
public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {

        this.connexion = MySQLConnection.getConnexion();

    }
    
   // public Utilisateur create(Utilisateur oneUser) {
        
        
    //}
    
    

}
