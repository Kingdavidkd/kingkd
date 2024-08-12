package view;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.*;
import controller.*;

public class Frm_Ligue extends JFrame implements ActionListener{
    JLabel lid_ligue,lnom_ligue,lannee,lnationalite,lpresident,lgeneral,lclubs,lemail,lphone;
    JTextField tid_ligue,tnom_ligue,tannee,tpresident,tgeneral,tclubs,temail,tphone,trech;
    JComboBox nationalite;
    JButton enr,vis,init,del,rech,upd;
    String[] igihugu={"France","Espagne","Angleterre","Italie","Allemagne"};
    ArrayList <Ligue> list_ligue= new ArrayList();
    JTable tbagent;
    private final DefaultTableModel model;
    Ligue ligue = new Ligue();
    Ligue a = null;
    
     public Frm_Ligue(){
        lid_ligue=new JLabel("ID ligue");
        lid_ligue.setBounds(10,30,100,30);
        this.getContentPane().add(lid_ligue);
        
        tid_ligue=new JTextField("");
        tid_ligue.setBounds(120,30,200,30);
        this.getContentPane().add(tid_ligue);
        
        lnom_ligue=new JLabel("Nom ligue");
        lnom_ligue.setBounds(10,70,100,30);
        this.getContentPane().add(lnom_ligue);
        
        tnom_ligue=new JTextField("");
        tnom_ligue.setBounds(120,70,200,30);
        this.getContentPane().add(tnom_ligue);
        
        lannee=new JLabel("Naissance");
        lannee.setBounds(10, 110, 100, 30);
        this.getContentPane().add(lannee);
        
        tannee=new JTextField("");
        tannee.setBounds(120, 110, 200, 30);
        this.getContentPane().add(tannee);
        
        lnationalite=new JLabel("Pays");
        lnationalite.setBounds(10,150,100,30);
        this.getContentPane().add(lnationalite);
        
        nationalite=new JComboBox(igihugu);
        nationalite.setBounds(120,150,200,30);
        this.getContentPane().add(nationalite);
        
        lpresident=new JLabel("President");
        lpresident.setBounds(10,190,100,30);
        this.getContentPane().add(lpresident);
        
        tpresident=new JTextField("");
        tpresident.setBounds(120, 190, 200, 30);
        this.getContentPane().add(tpresident);
        
        lgeneral=new JLabel("General");
        lgeneral.setBounds(10,230,100,30);
        this.getContentPane().add(lgeneral);
        
        tgeneral=new JTextField("");
        tgeneral.setBounds(120, 230, 200, 30);
        this.getContentPane().add(tgeneral);
        
        lclubs=new JLabel("Clubs");
        lclubs.setBounds(10,270,100,30);
        this.getContentPane().add(lclubs);
        
        tclubs=new JTextField("");
        tclubs.setBounds(120, 270, 200, 30);
        this.getContentPane().add(tclubs);
        
        lemail=new JLabel("Email");
        lemail.setBounds(10,310,100,30);
        this.getContentPane().add(lemail);
        
        temail=new JTextField("");
        temail.setBounds(120, 310, 200, 30);
        this.getContentPane().add(temail);
        
        lphone=new JLabel("Phone");
        lphone.setBounds(10,350,100,30);
        this.getContentPane().add(lphone);
        
        tphone=new JTextField("");
        tphone.setBounds(120, 350, 200, 30);
        this.getContentPane().add(tphone);
        
        enr=new JButton("Save");
        enr.setBounds(10,430,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("View");
        vis.setBounds(120,430,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Reset");
        init.setBounds(230,430,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Delete");
        del.setBounds(340,430,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Update");
        upd.setBounds(450,430,100,30);
        upd.addActionListener(this);
        this.getContentPane().add(upd);
        
        trech=new JTextField("");
        trech.setBounds(350, 30, 100, 30);
        this.getContentPane().add(trech);
        
        rech=new JButton("Search");
        rech.setBounds(450,30,100,30);
        rech.addActionListener(this);
        this.getContentPane().add(rech);
        
        model=new DefaultTableModel();
        model.addColumn("ID ligue");
        model.addColumn("Nom ligue");
        model.addColumn("Annee d'existence");
        model.addColumn("Pays");
        model.addColumn("President");
        model.addColumn("General");
        model.addColumn("Clubs");
        model.addColumn("Email");
        model.addColumn("Phone");
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int id_ligue = Integer.valueOf(tid_ligue.getText());
            String nom_ligue = tnom_ligue.getText();
            String annee = tannee.getText();
            String nation = String.valueOf(nationalite.getSelectedItem());
            String president = tpresident.getText();
            String general = tgeneral.getText();
            int clubs = Integer.valueOf(tclubs.getText());
            String email = temail.getText();
            String phone = tphone.getText();

            a = new Ligue(id_ligue,nom_ligue,annee,nation,president,general,clubs,email,phone);
            Factory_Ligue.insertligue(a);
            afficher();
        }
        else if(e.getSource()==vis){
            afficher();
        }
        else if(e.getSource()==init){
            effacer();
        }
        else if(e.getSource()==del){
            if(ligue !=null){
                String msg="Voulez-vous reelement supprimer "+ligue.getNom_ligue()+" de la liste des ligues";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory_Ligue.deleteligue(ligue);
                    afficher();
                    effacer();
                }
            }
        }
            else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(trech.getText());
            ligue = Factory_Ligue.searchligue(ct);
            if(ligue!=null){
                recupInfo(ligue);
            }
        }
            else if(e.getSource()==upd){ // les boutons modifier avec toutes ses fonctions
            int id_ligue = Integer.valueOf(tid_ligue.getText());
            String nom_ligue = tnom_ligue.getText();
            String annee = tannee.getText();
            String nation = String.valueOf(nationalite.getSelectedItem());
            String president = tpresident.getText();
            String general = tgeneral.getText();
            int clubs = Integer.valueOf(tclubs.getText());
            String email = temail.getText();
            String phone = tphone.getText();
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory_Ligue.updateligue(id_ligue,nom_ligue,annee,nation,president,general,clubs,email,phone);
                afficher();
                effacer();
            }
        }
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        list_ligue= Factory_Ligue.viewligue();
        for(Ligue t:list_ligue){
            model.addRow(new Object[]{
                   t.getId_ligue(),t.getNom_ligue(),t.getAnnee(),t.getPays(),t.getPresident(),t.getGeneral(),t.getClubs(),t.getEmail(),t.getPhone()}
            );
    }
    tbagent = new JTable(model);
    JScrollPane p =new JScrollPane(tbagent);
    p.setBounds(30,500,800,100);
    this.getContentPane().add(p);
}   
       public void recupInfo(Ligue t){
        tid_ligue.setText(String.valueOf(t.getId_ligue()));
        tnom_ligue.setText(String.valueOf(t.getNom_ligue()));
        tannee.setText(t.getAnnee());
        nationalite.setSelectedItem(t.getPays());
        tpresident.setText(String.valueOf(t.getPresident()));
        tgeneral.setText(String.valueOf(t.getGeneral()));
        tclubs.setText(String.valueOf(t.getClubs()));
        temail.setText(String.valueOf(t.getEmail()));
        tphone.setText(String.valueOf(t.getPhone()));
       }
       
       public void effacer(){
        tid_ligue.setText("");
        tnom_ligue.setText("");
        tannee.setText("");
        nationalite.setSelectedItem("");
        tpresident.setText("");
        tgeneral.setText("");
        tclubs.setText("");
        temail.setText("");
        tphone.setText("");
    }
}
