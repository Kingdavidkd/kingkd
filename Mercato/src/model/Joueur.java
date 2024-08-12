package model;

public class Joueur {
    private int id_joueur;
    private String nom_joueur,date_naissance,sexe,nationalite,email,post,contrat;
    private int id_club,id_ligue;

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public void setNom_joueur(String nom_joueur) {
        this.nom_joueur = nom_joueur;
    }

    public void setDate_naissance(String date_naissance) {
        this.date_naissance = date_naissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public void setContrat(String contrat) {
        this.contrat = contrat;
    }

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public void setId_ligue(int id_ligue) {
        this.id_ligue = id_ligue;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public String getNom_joueur() {
        return nom_joueur;
    }

    public String getDate_naissance() {
        return date_naissance;
    }

    public String getSexe() {
        return sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public String getEmail() {
        return email;
    }

    public String getPost() {
        return post;
    }

    public String getContrat() {
        return contrat;
    }

    public int getId_club() {
        return id_club;
    }

    public int getId_ligue() {
        return id_ligue;
    }

    public Joueur(int id_joueur, String nom_joueur, String date_naissance, String sexe, String nationalite, String email, String post, String contrat, int id_club, int id_ligue) {
        this.id_joueur = id_joueur;
        this.nom_joueur = nom_joueur;
        this.date_naissance = date_naissance;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.email = email;
        this.post = post;
        this.contrat = contrat;
        this.id_club = id_club;
        this.id_ligue = id_ligue;
    }
    
    public Joueur(){}
}
