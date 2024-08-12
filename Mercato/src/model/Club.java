package model;

public class Club {
    private int id_club;
    private String nom_club,annee;
    private int id_ligue;
    private String pays,president,general,sportif,entraineur,stade;
    private int capacite;
    private String email;

    public void setId_club(int id_club) {
        this.id_club = id_club;
    }

    public void setNom_club(String nom_club) {
        this.nom_club = nom_club;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public void setId_ligue(int id_ligue) {
        this.id_ligue = id_ligue;
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

    public void setSportif(String sportif) {
        this.sportif = sportif;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    public void setStade(String stade) {
        this.stade = stade;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId_club() {
        return id_club;
    }

    public String getNom_club() {
        return nom_club;
    }

    public String getAnnee() {
        return annee;
    }

    public int getId_ligue() {
        return id_ligue;
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

    public String getSportif() {
        return sportif;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public String getStade() {
        return stade;
    }

    public int getCapacite() {
        return capacite;
    }

    public String getEmail() {
        return email;
    }

    public Club(int id_club, String nom_club, String annee, int id_ligue, String pays, String president, String general, String sportif, String entraineur, String stade, int capacite, String email) {
        this.id_club = id_club;
        this.nom_club = nom_club;
        this.annee = annee;
        this.id_ligue = id_ligue;
        this.pays = pays;
        this.president = president;
        this.general = general;
        this.sportif = sportif;
        this.entraineur = entraineur;
        this.stade = stade;
        this.capacite = capacite;
        this.email = email;
    }
    
    public Club(){}
}
