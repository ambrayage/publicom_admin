/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publicom2.model;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    // public Utilisateur get(Integer idUser) {
    //}
    public List<Utilisateur> getAll() throws SQLException {

        ArrayList<Utilisateur> users = new ArrayList<Utilisateur>();
        String query = "SELECT * FROM utilisateur";

        try {
            Statement statement = this.connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int idUser = resultSet.getInt("IDUTILISATEUR");
                String usernameUser = resultSet.getString("IDENTIFIANTUTILISATEUR");
                String passwordUser = resultSet.getString("MOTDEPASSEUTILISATEUR");
                String nameUser = resultSet.getString("NOMUTILISATEUR");
                String firstNameUser = resultSet.getString("PRENOMUTILISATEUR");
                Utilisateur user = new Utilisateur(idUser, usernameUser, passwordUser, nameUser, firstNameUser);
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }

    // public void update(Utilisateur oneUser){
    //}
    // public void delete(Integer idUser){
    //}
    // public void delete(Utilisateur oneUser){
    //}
}
