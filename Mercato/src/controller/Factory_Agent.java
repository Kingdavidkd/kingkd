package controller;

import java.sql.*;
import java.util.ArrayList;
import model.*;

public class Factory_Agent {
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
    
    public static void insertagent(Agent a){
        try{
            conn = getConnection();
            pstmet = conn.prepareStatement("insert into agent(id_agent,nom_agent,date_naissance,sexe,nationalite,num,certification,expiration,email,phone,id_joueur) values(?,?,?,?,?,?,?,?,?,?,?)");
            pstmet.setInt(1, a.getId_agent());
            pstmet.setString(2, a.getNom_agent());
            pstmet.setString(3, a.getDate_naissance());
            pstmet.setString(4, a.getSexe());
            pstmet.setString(5, a.getNationalite());
            pstmet.setString(6, a.getNum());
            pstmet.setString(7, a.getCertification());
            pstmet.setString(8, a.getExpiration());
            pstmet.setString(9, a.getEmail());
            pstmet.setString(10, a.getPhone());
            pstmet.setInt(11, a.getId_joueur());
            pstmet.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public static ArrayList <Agent> viewagent(){
        ArrayList <Agent> list_agent = new ArrayList();
        Agent a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from agent");
            while(rs.next()){
                a = new Agent();
                a.setId_agent(rs.getInt("id_agent"));
                a.setNom_agent(rs.getString("nom_agent"));
                a.setDate_naissance(rs.getString("date_naissance"));
                a.setSexe(rs.getString("sexe"));
                a.setNationalite(rs.getString("nationalite"));
                a.setNum(rs.getString("num"));
                a.setCertification(rs.getString("certification"));
                a.setExpiration(rs.getString("expiration"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setId_joueur(rs.getInt("id_joueur"));
                list_agent.add(a);
            }
            conn.close();
            stm.close();
        }
        catch(Exception e){
            
        }
        return list_agent;
    }
    
    public static Agent searchagent(int id_agent){
        Agent a= null;
        try{
            conn = getConnection();
            stm = conn.createStatement();
            rs = stm.executeQuery("select * from agent where id_agent='"+id_agent+"'");
            while(rs.next()){
                a = new Agent();
                a.setId_agent(rs.getInt("id_agent"));
                a.setNom_agent(rs.getString("nom_agent"));
                a.setDate_naissance(rs.getString("date_naissance"));
                a.setSexe(rs.getString("sexe"));
                a.setNationalite(rs.getString("nationalite"));
                a.setNum(rs.getString("num"));
                a.setCertification(rs.getString("certification"));
                a.setExpiration(rs.getString("expiration"));
                a.setEmail(rs.getString("email"));
                a.setPhone(rs.getString("phone"));
                a.setId_joueur(rs.getInt("id_joueur"));
            }
            conn.close();
            stm.close();
            return a;
        }
        catch(Exception e){
            return null;
        }
    }
    
    public static void deleteagent(Agent a){ 
        Agent ag = null;
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String req="delete from agent where id_agent='"+a.getId_agent()+"'";
            stm.executeUpdate(req);
            conn.close();
            stm.close();
        }
        catch(Exception ex){
            
        }
    }
    
    public static void updateagent(int id_agent, String nom_agent, String date_naissance, String sexe, String nationalite, String num, String certification, String expiration, String email, String phone, int id_joueur){
        try{
            conn=getConnection();
            stm=conn.createStatement();
            String re=("update agent set nom_agent='"+nom_agent+"',date_naissance='"+date_naissance+"',sexe='"+sexe+"',nationalite='"+nationalite+"',num='"+num+"',certification='"+certification+"',expiration='"+expiration+"',email='"+email+"',phone='"+phone+"',id_joueur='"+id_joueur+"' where id_agent='"+id_agent+"'");
            stm.executeUpdate(re);
            conn.close();
            }
            catch(SQLException ex){

            }
    }
}
