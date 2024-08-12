package view;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.*;
import controller.*;

public class Frm_Joueur extends JFrame implements ActionListener{
    JLabel lid_joueur,lnom_joueur,ldate_naissance,lsexe,lnationalite,lpost,lcontrat,lid_club,lemail,lid_ligue;
    JTextField tid_joueur,tnom_joueur,tdate_naissance,tcontrat,temail,trech;
    JComboBox nationalite;
    JComboBox club;
    JComboBox ligue;
    JComboBox post;
    JRadioButton gnm,gnf;
    JButton enr,vis,init,del,rech,upd;
    ButtonGroup gnr;
    String g;
    String[] posts={"Attaquant","Milieu","Defenseur","Gardien"};
    String[] igihugu={"France","Espagnol","Poland","Angleterre","Argentine","Portugal","Italie","Allemagne","Sweden","Brazil","Uruguay"};
    ArrayList <Club> list_club= new ArrayList();
    ArrayList <Ligue> list_ligue= new ArrayList();
    ArrayList <Joueur> list_joueur = new ArrayList();
    JTable tbagent;
    private final DefaultTableModel model;
    Joueur joueur = new Joueur();
    Joueur a = null;
    int index = 0;
    int ind =0;
    public Frm_Joueur(){
        lid_joueur=new JLabel("ID joueur");
        lid_joueur.setBounds(10,30,100,30);
        this.getContentPane().add(lid_joueur);
        
        tid_joueur=new JTextField("");
        tid_joueur.setBounds(120,30,200,30);
        this.getContentPane().add(tid_joueur);
        
        lnom_joueur=new JLabel("Nom joueur");
        lnom_joueur.setBounds(10,70,100,30);
        this.getContentPane().add(lnom_joueur);
        
        tnom_joueur=new JTextField("");
        tnom_joueur.setBounds(120,70,200,30);
        this.getContentPane().add(tnom_joueur);
        
        ldate_naissance=new JLabel("Naissance");
        ldate_naissance.setBounds(10, 110, 100, 30);
        this.getContentPane().add(ldate_naissance);
        
        tdate_naissance=new JTextField("");
        tdate_naissance.setBounds(120, 110, 200, 30);
        this.getContentPane().add(tdate_naissance);
        
        lsexe=new JLabel("Genre");
        lsexe.setBounds(10,150,100,30);
        this.getContentPane().add(lsexe);
        
        gnm=new JRadioButton("Masculin");
        gnm.setBounds(120,150,100,30);
        this.getContentPane().add(gnm);
        
        gnf=new JRadioButton("Feminin");
        gnf.setBounds(220,150,150,30);
        this.getContentPane().add(gnf);
        
        gnr = new ButtonGroup();
        gnr.add(gnm);
        gnr.add(gnf);
        
        lnationalite=new JLabel("Nationalite");
        lnationalite.setBounds(10,190,100,30);
        this.getContentPane().add(lnationalite);
        
        nationalite=new JComboBox(igihugu);
        nationalite.setBounds(120,190,200,30);
        this.getContentPane().add(nationalite);
        
        lemail=new JLabel("Email");
        lemail.setBounds(10,230,100,30);
        this.getContentPane().add(lemail);
        
        temail=new JTextField("");
        temail.setBounds(120, 230, 200, 30);
        this.getContentPane().add(temail);
        
        lpost=new JLabel("Post");
        lpost.setBounds(10,270,100,30);
        this.getContentPane().add(lpost);
        
        post=new JComboBox(posts);
        post.setBounds(120,270,200,30);
        this.getContentPane().add(post);
        
        lcontrat=new JLabel("Contrat");
        lcontrat.setBounds(10,310,100,30);
        this.getContentPane().add(lcontrat);
        
        tcontrat=new JTextField("");
        tcontrat.setBounds(120, 310, 200, 30);
        this.getContentPane().add(tcontrat);
        
        lid_club=new JLabel("Club");
        lid_club.setBounds(10,350,100,30);
        this.getContentPane().add(lid_club);
        
        club=new JComboBox();
        list_club=Factory_Club.viewclub();
        for(Club c:list_club){
            club.addItem(c.getNom_club());
        }
        club.setBounds(120,350,150,30);
        club.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            ind=club.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(club);
        
        lid_ligue=new JLabel("Ligue");
        lid_ligue.setBounds(10,390,100,30);
        this.getContentPane().add(lid_ligue);
        
        ligue=new JComboBox();
        list_ligue=Factory_Ligue.viewligue();
        for(Ligue c:list_ligue){
            ligue.addItem(c.getNom_ligue());
        }
        ligue.setBounds(120,390,150,30);
        ligue.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=ligue.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(ligue);
        
        enr=new JButton("Save");
        enr.setBounds(10,450,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("View");
        vis.setBounds(120,450,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Reset");
        init.setBounds(230,450,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Delete");
        del.setBounds(340,450,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Update");
        upd.setBounds(450,450,100,30);
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
        model.addColumn("ID joueur");
        model.addColumn("Nom joueur");
        model.addColumn("Date naissance");
        model.addColumn("Sexe");
        model.addColumn("Nationalite");
        model.addColumn("Email");
        model.addColumn("Post");
        model.addColumn("Contrat");
        model.addColumn("ID club");
        model.addColumn("ID ligue");
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int id_joueur = Integer.valueOf(tid_joueur.getText());
            String nom_joueur = tnom_joueur.getText();
            String date_naissance = tdate_naissance.getText();
            if(gnm.isSelected()){
                g = "Masculin";
            }
            else if(gnf.isSelected()){
                g = "Feminin";
            }
            String nation = String.valueOf(nationalite.getSelectedItem());
            String email = temail.getText();
            String postt = String.valueOf(post.getSelectedItem());
            String contrat = tcontrat.getText();
            int clubs = list_club.get(ind).getId_club();
            int ligues = list_ligue.get(index).getId_ligue();
            
            a = new Joueur(id_joueur,nom_joueur,date_naissance,g,nation,email,postt,contrat,clubs,ligues);
            Factory_Joueur.insertjoueur(a);
            afficher();
            effacer();
        }
        else if(e.getSource()==vis){
            afficher();
        }
        else if(e.getSource()==init){
            effacer();
        }
        else if(e.getSource()==del){
            if(joueur !=null){
                String msg="Voulez-vous reelement supprimer "+joueur.getNom_joueur()+" de la liste des joueurs";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory_Joueur.deletejoueur(joueur);
                    afficher();
                    effacer();
                }
            }
        }
        
        else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(trech.getText());
            joueur = Factory_Joueur.searchjoueur(ct);
            if(joueur!=null){
                recupInfo(joueur);
            }
        }
            else if(e.getSource()==upd){ 
            int id_joueur = Integer.valueOf(tid_joueur.getText());
            String nom_joueur = tnom_joueur.getText();
            String date_naissance = tdate_naissance.getText();
            if(gnm.isSelected()){
                g = "Masculin";
            }
            else if(gnf.isSelected()){
                g = "Feminin";
            }
            String nation = String.valueOf(nationalite.getSelectedItem());
            String email = temail.getText();
            String postt = String.valueOf(post.getSelectedItem());
            String contrat = tcontrat.getText();
            int clubs = list_club.get(ind).getId_club();
            int ligues = list_ligue.get(index).getId_ligue();
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory_Joueur.updatejoueur(id_joueur,nom_joueur,date_naissance,g,nation,email,postt,contrat,clubs,ligues);
                afficher();
                effacer();
            }
        }
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        list_joueur= Factory_Joueur.viewjoueur();
        for(Joueur t:list_joueur){
            model.addRow(new Object[]{
                   t.getId_joueur(),t.getNom_joueur(),t.getDate_naissance(),t.getSexe(),t.getNationalite(),t.getEmail(),t.getPost(),t.getContrat(),t.getId_club(),t.getId_ligue()}
            );
    }
    tbagent = new JTable(model);
    JScrollPane p =new JScrollPane(tbagent);
    p.setBounds(30,520,800,100);
    this.getContentPane().add(p);
}   
       public void recupInfo(Joueur t){
        tid_joueur.setText(String.valueOf(t.getId_joueur()));
        tnom_joueur.setText(String.valueOf(t.getNom_joueur()));
        tdate_naissance.setText(t.getDate_naissance());
        if(t.getSexe().equalsIgnoreCase(gnm.getText())) gnm.setSelected(true);else gnf.setSelected(true);
        nationalite.setSelectedItem(t.getNationalite());
        temail.setText(String.valueOf(t.getEmail()));
        post.setSelectedItem(t.getPost());
        tcontrat.setText(String.valueOf(t.getContrat()));
        club.setSelectedItem(t.getId_club());
        ligue.setSelectedItem(t.getId_ligue());
       }
       
       public void effacer(){
        tid_joueur.setText("");
        tnom_joueur.setText("");
        tdate_naissance.setText("");
        nationalite.setSelectedItem("");
        temail.setText("");
        post.setSelectedItem("");
        tcontrat.setText("");
        club.setSelectedItem("");
        ligue.setSelectedItem("");
    }

}
