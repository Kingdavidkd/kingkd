package model;

public class Agent {
    private int id_agent;
    private String nom_agent,date_naissance,sexe,nationalite,num,certification,expiration,email,phone;
    private int id_joueur;

    public void setId_agent(int id_agent) {
        this.id_agent = id_agent;
    }

    public void setNom_agent(String nom_agent) {
        this.nom_agent = nom_agent;
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

    public void setNum(String num) {
        this.num = num;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public int getId_agent() {
        return id_agent;
    }

    public String getNom_agent() {
        return nom_agent;
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

    public String getNum() {
        return num;
    }

    public String getCertification() {
        return certification;
    }

    public String getExpiration() {
        return expiration;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public Agent(int id_agent, String nom_agent, String date_naissance, String sexe, String nationalite, String num, String certification, String expiration, String email, String phone, int id_joueur) {
        this.id_agent = id_agent;
        this.nom_agent = nom_agent;
        this.date_naissance = date_naissance;
        this.sexe = sexe;
        this.nationalite = nationalite;
        this.num = num;
        this.certification = certification;
        this.expiration = expiration;
        this.email = email;
        this.phone = phone;
        this.id_joueur = id_joueur;
    }
    
    public Agent(){}
}
