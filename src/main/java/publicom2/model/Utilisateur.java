/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package publicom2.model;

/**
 *
 * @author l.blee
 */
public class Utilisateur {

    private int IDUTILISATEUR;
    private String IDENTIFIANTUTILISATEUR;
    private String MOTDEPASSEUTILISATEUR;
    private String NOMUTILISATEUR;
    private String PRENOMUTILISATEUR;

    public Utilisateur(int IDUTILISATEUR, String IDENTIFIANTUTILISATEUR, String MOTDEPASSEUTILISATEUR, String NOMUTILISATEUR, String PRENOMUTILISATEUR) {

        this.IDUTILISATEUR = IDUTILISATEUR;
        this.IDENTIFIANTUTILISATEUR = IDENTIFIANTUTILISATEUR;
        this.MOTDEPASSEUTILISATEUR = MOTDEPASSEUTILISATEUR;
        this.NOMUTILISATEUR = NOMUTILISATEUR;
        this.PRENOMUTILISATEUR = PRENOMUTILISATEUR;

    }

    public Utilisateur(String IDENTIFIANTUTILISATEUR, String MOTDEPASSEUTILISATEUR, String NOMUTILISATEUR, String PRENOMUTILISATEUR) {

        this.IDENTIFIANTUTILISATEUR = IDENTIFIANTUTILISATEUR;
        this.MOTDEPASSEUTILISATEUR = MOTDEPASSEUTILISATEUR;
        this.NOMUTILISATEUR = NOMUTILISATEUR;
        this.PRENOMUTILISATEUR = PRENOMUTILISATEUR;

    }

    public int getIdUser() {

        return this.IDUTILISATEUR;

    }

    public String getUsernameUser() {

        return this.IDENTIFIANTUTILISATEUR;

    }

    public String getPasswordUser() {

        return this.MOTDEPASSEUTILISATEUR;
    }

    public String getNameUser() {

        return this.NOMUTILISATEUR;

    }

    public String getFirstNameUser() {

        return this.PRENOMUTILISATEUR;

    }

    public void setIdUser(int idUser) {

        this.IDUTILISATEUR = idUser;

    }

    public void setUsernameUser(String usernameUser) {

        this.IDENTIFIANTUTILISATEUR = usernameUser;

    }

    public void setPasswordUser(String password) {

        this.MOTDEPASSEUTILISATEUR = password;

    }

    public void setNameUser(String nameUser) {

        this.NOMUTILISATEUR = nameUser;

    }

    public void setFirstNameUser(String firstNameUser) {

        this.PRENOMUTILISATEUR = firstNameUser;

    }

}
