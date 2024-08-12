package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class Factory_Transfert {
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
    
    public static void inserttransfert(Transfert a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into transfert(id_transfert,id_joueur,origine,destination,type,montant,date_transfert,id_agent) values(?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, a.getId_transfert());
            pstmet.setInt(2, a.getId_joueur());
            pstmet.setString(3, a.getOrigine());
            pstmet.setString(4, a.getDestination());
            pstmet.setString(5, a.getType());
            pstmet.setString(6, a.getMontant());
            pstmet.setString(7, a.getDate_transfert());
            pstmet.setInt(8, a.getId_agent());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ArrayList <Transfert> viewtransfert(){
        ArrayList <Transfert> list_transfert = new ArrayList();
        Transfert a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from transfert");
            while(rs.next()){
                a = new Transfert();
                a.setId_transfert(rs.getInt("id_transfert"));
                a.setId_joueur(rs.getInt("id_joueur"));
                a.setOrigine(rs.getString("origine"));
                a.setDestination(rs.getString("destination"));
                a.setType(rs.getString("type"));
                a.setMontant(rs.getString("montant"));
                a.setDate_transfert(rs.getString("date_transfert"));
                a.setId_agent(rs.getInt("id_agent"));
                list_transfert.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }
        return list_transfert;
    }
    
    public static Transfert searchtransfert(int id_transfert){
        Transfert a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from transfert where id_transfert='"+id_transfert+"'");
            while(rs.next()){
                a = new Transfert();
                a.setId_transfert(rs.getInt("id_transfert"));
                a.setId_joueur(rs.getInt("id_joueur"));
                a.setOrigine(rs.getString("origine"));
                a.setDestination(rs.getString("destination"));
                a.setType(rs.getString("type"));
                a.setMontant(rs.getString("montant"));
                a.setDate_transfert(rs.getString("date_transfert"));
                a.setId_agent(rs.getInt("id_agent"));
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static void deletetransfert(Transfert a){ 
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from transfert where id_transfert='"+a.getId_transfert()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            
        }
    }
    
    public static void updatetransfert(int id_transfert, int id_joueur, String origine, String destination, String type, String montant, String date_transfert, int id_agent){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update transfert set id_joueur='"+id_joueur+"',origine='"+origine+"',destination='"+destination+"',type='"+type+"',montant='"+montant+"',date_transfert='"+date_transfert+"',id_agent='"+id_agent+"' where id_transfert='"+id_transfert+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){

            }
    }
}
