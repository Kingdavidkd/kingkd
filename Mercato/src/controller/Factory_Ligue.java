package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class Factory_Ligue {
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
    
    public static void insertligue(Ligue a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into ligue(id_ligue,nom_ligue,annee,pays,president,general,clubs,email,phone) values(?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, a.getId_ligue());
            pstmet.setString(2, a.getNom_ligue());
            pstmet.setString(3, a.getAnnee());
            pstmet.setString(4, a.getPays());
            pstmet.setString(5, a.getPresident());
            pstmet.setString(6, a.getGeneral());
            pstmet.setInt(7, a.getClubs());
            pstmet.setString(8, a.getEmail());
            pstmet.setString(9, a.getPhone());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ArrayList <Ligue> viewligue(){
        ArrayList <Ligue> list_ligue = new ArrayList();
        Ligue a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from ligue");
            while(rs.next()){
                a = new Ligue();
                a.setId_ligue(rs.getInt("id_ligue"));
                a.setNom_ligue(rs.getString("nom_ligue"));
                a.setAnnee(rs.getString("annee"));
                a.setPays(rs.getString("pays"));
                a.setPresident(rs.getString("president"));
                a.setGeneral(rs.getString("general"));
                a.setClubs(rs.getInt("clubs"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                list_ligue.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }
        return list_ligue;
    }
    
    public static Ligue searchligue(int id_ligue){
        Ligue a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from ligue where id_ligue='"+id_ligue+"'");
            while(rs.next()){
                a = new Ligue();
                a.setId_ligue(rs.getInt("id_ligue"));
                a.setNom_ligue(rs.getString("nom_ligue"));
                a.setAnnee(rs.getString("annee"));
                a.setPays(rs.getString("pays"));
                a.setPresident(rs.getString("president"));
                a.setGeneral(rs.getString("general"));
                a.setClubs(rs.getInt("clubs"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
            return null;
        }   
    }
    
    public static void deleteligue(Ligue a){ 
        Ligue ag = null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from ligue where id_ligue='"+a.getId_ligue()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            
        }
    }
    
    public static void updateligue(int id_ligue, String nom_ligue, String annee, String pays, String president, String general, int clubs, String email, String phone){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update ligue set nom_ligue='"+nom_ligue+"',annee='"+annee+"',pays='"+pays+"',president='"+president+"',general='"+general+"',email='"+email+"',phone='"+phone+"' where id_ligue='"+id_ligue+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){

            }
    }
}
