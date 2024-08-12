package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class Factory_Club {
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
    
    public static void insertclub(Club a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into club(id_club,nom_club,annee,id_ligue,pays,president,general,sportif,entraineur,stade,capacite,email) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, a.getId_club());
            pstmet.setString(2, a.getNom_club());
            pstmet.setString(3, a.getAnnee());
            pstmet.setInt(4, a.getId_ligue());
            pstmet.setString(5, a.getPays());
            pstmet.setString(6, a.getPresident());
            pstmet.setString(7, a.getGeneral());
            pstmet.setString(8, a.getSportif());
            pstmet.setString(9, a.getEntraineur());
            pstmet.setString(10, a.getStade());
            pstmet.setInt(11, a.getCapacite());
            pstmet.setString(12, a.getEmail());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ArrayList <Club> viewclub(){
        ArrayList <Club> list_club = new ArrayList();
        Club a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from club");
            while(rs.next()){
                a = new Club();
                a.setId_club(rs.getInt("id_club"));
                a.setNom_club(rs.getString("nom_club"));
                a.setAnnee(rs.getString("annee"));
                a.setId_ligue(rs.getInt("id_ligue"));
                a.setPays(rs.getString("pays"));
                a.setPresident(rs.getString("president"));
                a.setGeneral(rs.getString("general"));
                a.setSportif(rs.getString("sportif"));
                a.setEntraineur(rs.getString("entraineur"));
                a.setStade(rs.getString("stade"));
                a.setCapacite(rs.getInt("capacite"));
                a.setEmail(rs.getString("email"));
                list_club.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }
        return list_club;
    }
    
     public static Club searchclub(int id_club){
        Club a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from club where id_club='"+id_club+"'");
            while(rs.next()){
                a = new Club();
                a.setId_club(rs.getInt("id_club"));
                a.setNom_club(rs.getString("nom_club"));
                a.setAnnee(rs.getString("annee"));
                a.setId_ligue(rs.getInt("id_ligue"));
                a.setPays(rs.getString("pays"));
                a.setPresident(rs.getString("president"));
                a.setGeneral(rs.getString("general"));
                a.setSportif(rs.getString("sportif"));
                a.setEntraineur(rs.getString("entraineur"));
                a.setStade(rs.getString("stade"));
                a.setCapacite(rs.getInt("capacite"));
                a.setEmail(rs.getString("email"));
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
            return null;
        }
    }
     
     public static void deleteclub(Club a){ 
        Club ag = null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from club where id_club='"+a.getId_club()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            
        }
    }
     
     public static void updateagent(int id_club, String nom_club, String annee, int id_ligue, String pays, String president, String general, String sportif, String entraineur, String stade, int capacite, String email){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update club set nom_club='"+nom_club+"',annee='"+annee+"',id_ligue='"+id_ligue+"',pays='"+pays+"',president='"+president+"',general='"+general+"',sportif='"+sportif+"',entraineur='"+entraineur+"',stade='"+stade+"',capacite='"+capacite+"',email='"+email+"' where id_club='"+id_club+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){

            }
    }
}
