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

/**
 *
 * @author l.blee
 */
public class UtilisateurDAO {

    private Connection connexion;

    public UtilisateurDAO() throws Exception {

        this.connexion = MySQLConnection.getConnexion();

    }

    public void create(Utilisateur oneUser) throws SQLException {
        String query = "INSERT INTO utilisateur (IDENTIFIANTUTILISATEUR, MOTDEPASSEUTILISATEUR, NOMUTILISATEUR, PRENOMUTILISATEUR) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = this.connexion.prepareStatement(query)) {
            stmt.setString(1, oneUser.getUsernameUser());
            stmt.setString(2, oneUser.getPasswordUser());
            stmt.setString(3, oneUser.getNameUser());
            stmt.setString(4, oneUser.getFirstNameUser());

            stmt.executeUpdate();
        }
    }

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

    public void update(Utilisateur oneUser) throws SQLException {

        String query = "UPDATE utilisateur SET IDENTIFIANTUTILISATEUR = ? , MOTDEPASSEUTILISATEUR = ?, NOMUTILISATEUR = ?, PRENOMUTILISATEUR = ? WHERE IDUTILISATEUR = ?";

        try (PreparedStatement stmt = this.connexion.prepareStatement(query)) {

            stmt.setString(1, oneUser.getUsernameUser());
            stmt.setString(2, oneUser.getPasswordUser());
            stmt.setString(3, oneUser.getNameUser());
            stmt.setString(4, oneUser.getFirstNameUser());
            stmt.setInt(5, oneUser.getIdUser());

            stmt.executeUpdate();

            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void delete(Integer idUser) throws SQLException {

        Statement stmt = this.connexion.createStatement();

        String query = "DELETE FROM utilisateur WHERE IDUTILISATEUR = " + idUser;

        stmt.executeUpdate(query);

        stmt.close();
    }

    public void delete(Utilisateur oneUser) throws SQLException {

        Statement stmt = this.connexion.createStatement();

        String query = "DELETE FROM utilisateur WHERE IDUTILISATEUR = " + oneUser.getIdUser();

        stmt.executeUpdate(query);

        stmt.close();
    }
}
