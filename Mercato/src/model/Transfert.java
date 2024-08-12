package model;

public class Transfert {
    private int id_transfert,id_joueur;
    private String origine,destination,type,montant,date_transfert;
    private int id_agent;

    public void setId_transfert(int id_transfert) {
        this.id_transfert = id_transfert;
    }

    public void setId_joueur(int id_joueur) {
        this.id_joueur = id_joueur;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public void setDate_transfert(String date_transfert) {
        this.date_transfert = date_transfert;
    }

    public void setId_agent(int id_agent) {
        this.id_agent = id_agent;
    }

    public int getId_transfert() {
        return id_transfert;
    }

    public int getId_joueur() {
        return id_joueur;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public String getType() {
        return type;
    }

    public String getMontant() {
        return montant;
    }

    public String getDate_transfert() {
        return date_transfert;
    }

    public int getId_agent() {
        return id_agent;
    }

    public Transfert(int id_transfert, int id_joueur, String origine, String destination, String type, String montant, String date_transfert, int id_agent) {
        this.id_transfert = id_transfert;
        this.id_joueur = id_joueur;
        this.origine = origine;
        this.destination = destination;
        this.type = type;
        this.montant = montant;
        this.date_transfert = date_transfert;
        this.id_agent = id_agent;
    }
    
    public Transfert(){}
}
