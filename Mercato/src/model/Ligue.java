package model;

public class Ligue {
    private int id_ligue;
    private String nom_ligue,annee,pays,president,general;
    private int clubs;
    private String email,phone;

    public void setId_ligue(int id_ligue) {
        this.id_ligue = id_ligue;
    }

    public void setNom_ligue(String nom_ligue) {
        this.nom_ligue = nom_ligue;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public void setClubs(int clubs) {
        this.clubs = clubs;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId_ligue() {
        return id_ligue;
    }

    public String getNom_ligue() {
        return nom_ligue;
    }

    public String getAnnee() {
        return annee;
    }

    public String getPays() {
        return pays;
    }

    public String getPresident() {
        return president;
    }

    public String getGeneral() {
        return general;
    }

    public int getClubs() {
        return clubs;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Ligue(int id_ligue, String nom_ligue, String annee, String pays, String president, String general, int clubs, String email, String phone) {
        this.id_ligue = id_ligue;
        this.nom_ligue = nom_ligue;
        this.annee = annee;
        this.pays = pays;
        this.president = president;
        this.general = general;
        this.clubs = clubs;
        this.email = email;
        this.phone = phone;
    }
    
    public Ligue(){}
}
