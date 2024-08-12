package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class Factory_Joueur {
    private static Connection conn = null;
    private static Statement stm;
    private static PreparedStatement pstmet = null;
    private static ResultSet rs = null;
    
    public static Connection getConnection(){
        String serveur = "localhost";
        int port = 3306;
        String database = "mercato_java";
        String username = "root";
        String password = "";
        
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://"+serveur+":"+port+"/"+database+"?characterEnconding=latinl";
            conn = DriverManager.getConnection(url,username,password);
            System.out.println("Connected");
            return conn;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static void insertjoueur(Joueur a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into joueur(id_joueur,nom_joueur,date_naissance,sexe,nationalite,email,post,contrat,id_club,id_ligue) values(?,?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, a.getId_joueur());
            pstmet.setString(2, a.getNom_joueur());
            pstmet.setString(3, a.getDate_naissance());
            pstmet.setString(4, a.getSexe());
            pstmet.setString(5, a.getNationalite());
            pstmet.setString(6, a.getEmail());
            pstmet.setString(7, a.getPost());
            pstmet.setString(8, a.getContrat());
            pstmet.setInt(9, a.getId_club());
            pstmet.setInt(10, a.getId_ligue());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ArrayList <Joueur> viewjoueur(){
        ArrayList <Joueur> list_joueur = new ArrayList();
        Joueur a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from joueur");
            while(rs.next()){
                a = new Joueur();
                a.setId_joueur(rs.getInt("id_joueur"));
                a.setNom_joueur(rs.getString("nom_joueur"));
                a.setDate_naissance(rs.getString("date_naissance"));
                a.setSexe(rs.getString("sexe"));
                a.setNationalite(rs.getString("nationalite"));
                a.setEmail(rs.getString("email"));
                a.setPost(rs.getString("post"));
                a.setContrat(rs.getString("contrat"));
                a.setId_club(rs.getInt("id_club"));
                a.setId_ligue(rs.getInt("id_ligue"));
                list_joueur.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }
        return list_joueur;
    }
    
    public static Joueur searchjoueur(int id_joueur){
        Joueur a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from joueur where id_joueur='"+id_joueur+"'");
            while(rs.next()){
                a = new Joueur();
                a.setId_joueur(rs.getInt("id_joueur"));
                a.setNom_joueur(rs.getString("nom_joueur"));
                a.setDate_naissance(rs.getString("date_naissance"));
                a.setSexe(rs.getString("sexe"));
                a.setNationalite(rs.getString("nationalite"));
                a.setEmail(rs.getString("email"));
                a.setPost(rs.getString("post"));
                a.setContrat(rs.getString("contrat"));
                a.setId_club(rs.getInt("id_club"));
                a.setId_ligue(rs.getInt("id_ligue"));
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
            return null;
        } 
    }
    
    public static void deletejoueur(Joueur a){ 
        Joueur ag = null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from joueur where id_joueur='"+a.getId_joueur()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            
        }
    }
    
    public static void updatejoueur(int id_joueur, String nom_joueur, String date_naissance, String sexe, String nationalite, String email, String post, String contrat, int id_club, int id_ligue){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update joueur set nom_joueur='"+nom_joueur+"',date_naissance='"+date_naissance+"',sexe='"+sexe+"',nationalite='"+nationalite+"',email='"+email+"',post='"+post+"',contrat='"+contrat+"',id_club='"+id_club+"',id_ligue='"+id_ligue+"' where id_joueur='"+id_joueur+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){

            }
    }
}
