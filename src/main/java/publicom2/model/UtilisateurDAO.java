/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publicom2.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author l.blee
 */
public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {

        this.connexion = MySQLConnection.getConnexion();

    }

    //Créer un nouvel utilisateur
    public void create(Utilisateur oneUser) throws SQLException {
        String query = "INSERT INTO utilisateur (IDENTIFIANTUTILISATEUR, MOTDEPASSEUTILISATEUR, NOMUTILISATEUR, PRENOMUTILISATEUR) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = this.connexion.prepareStatement(query)) {
            stmt.setString(1, oneUser.getUsernameUser());
            stmt.setString(2, this.hash(oneUser.getPasswordUser()));
            stmt.setString(3, oneUser.getNameUser());
            stmt.setString(4, oneUser.getFirstNameUser());

            stmt.executeUpdate();
        }
    }

    //Retourne les informations d'un utilisateur à partir de son ID
    public Utilisateur get(Integer idUser) throws SQLException {

        Utilisateur oneUser = null;

        String query = "SELECT * FROM utilisateur Where IDUTILISATEUR = " + idUser;

        try {
            Statement statement = this.connexion.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                int id = idUser;
                String usernameUser = resultSet.getString("IDENTIFIANTUTILISATEUR");
                String passwordUser = resultSet.getString("MOTDEPASSEUTILISATEUR");
                String nameUser = resultSet.getString("NOMUTILISATEUR");
                String firstNameUser = resultSet.getString("PRENOMUTILISATEUR");
                Utilisateur user = new Utilisateur(id, usernameUser, passwordUser, nameUser, firstNameUser);
                oneUser = user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oneUser;
    }

    //Retourne la liste des utilisateurs
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

    //Modifie les informations d'un utilisateur à partir de son ID
    public void updateWithPassword(Utilisateur oneUser) throws SQLException {

        String query = "UPDATE utilisateur SET IDENTIFIANTUTILISATEUR = ? , MOTDEPASSEUTILISATEUR = ?, NOMUTILISATEUR = ?, PRENOMUTILISATEUR = ? WHERE IDUTILISATEUR = ?";

        try (PreparedStatement stmt = this.connexion.prepareStatement(query)) {

            stmt.setString(1, oneUser.getUsernameUser());
            stmt.setString(2, this.hash(oneUser.getPasswordUser()));
            stmt.setString(3, oneUser.getNameUser());
            stmt.setString(4, oneUser.getFirstNameUser());
            stmt.setInt(5, oneUser.getIdUser());

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
        //Modifie les informations d'un utilisateur à partir de son ID
    public void updateWithNoPassword(Utilisateur oneUser) throws SQLException {

        String query = "UPDATE utilisateur SET IDENTIFIANTUTILISATEUR = ? , NOMUTILISATEUR = ?, PRENOMUTILISATEUR = ? WHERE IDUTILISATEUR = ?";

        try (PreparedStatement stmt = this.connexion.prepareStatement(query)) {

            stmt.setString(1, oneUser.getUsernameUser());
            stmt.setString(2, oneUser.getNameUser());
            stmt.setString(3, oneUser.getFirstNameUser());
            stmt.setInt(4, oneUser.getIdUser());

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //Supprime un utilisateur à partir de son ID
    public void delete(Integer idUser) throws SQLException {

        Statement stmt = this.connexion.createStatement();

        String query = "DELETE FROM utilisateur WHERE IDUTILISATEUR = " + idUser;

        stmt.executeUpdate(query);

        stmt.close();
    }

    //Supprime un utilisateur à partir de son ID
    public void delete(Utilisateur oneUser) throws SQLException {

        Statement stmt = this.connexion.createStatement();

        String query = "DELETE FROM utilisateur WHERE IDUTILISATEUR = " + oneUser.getIdUser();

        stmt.executeUpdate(query);

        stmt.close();
    }
    
    //Fonction pour hasher une chaine de caractère
    public String hash(String password) {
        //Genere le sel (pour proteger le hash d'une attaque par dictionnaire multicolore)
	String salt = BCrypt.gensalt(12);
        //Hash la chaine de caractère avec le sel géneré
	return BCrypt.hashpw(password, salt);
    }
}
