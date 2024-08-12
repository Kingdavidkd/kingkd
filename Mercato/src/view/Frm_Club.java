package view;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.*;
import controller.*;

public class Frm_Club extends JFrame implements ActionListener{
    JLabel lid_club,lnom_club,lannee,lligue,lpays,lpresident,lgeneral,lsportif,lentraineur,lstade,lcapacite,lemail;
    JTextField tid_club,tnom_club,tannee,tpresident,tgeneral,tsportif,tentraineur,tstade,tcapacite,temail,trech;
    JComboBox nationalite;
    JComboBox ligue;
    JButton enr,vis,init,del,rech,upd;
    String[] igihugu={"France","Espagne","Poland","Angleterre","Argentine","Portugal","Italie","Allemagne","Brazil","Uruguay"};
    ArrayList <Ligue> list_ligue= new ArrayList();
    ArrayList <Club> list_club= new ArrayList();
    JTable tbagent;
    private final DefaultTableModel model;
    Club club = new Club();
    Club a = null;
    int index = 0;
    public Frm_Club(){
        lid_club=new JLabel("ID club");
        lid_club.setBounds(10,30,100,30);
        this.getContentPane().add(lid_club);
        
        tid_club=new JTextField("");
        tid_club.setBounds(120,30,200,30);
        this.getContentPane().add(tid_club);
        
        lnom_club=new JLabel("Nom club");
        lnom_club.setBounds(10,70,100,30);
        this.getContentPane().add(lnom_club);
        
        tnom_club=new JTextField("");
        tnom_club.setBounds(120,70,200,30);
        this.getContentPane().add(tnom_club);
        
        lannee=new JLabel("Annee d'existence");
        lannee.setBounds(10, 110, 100, 30);
        this.getContentPane().add(lannee);
        
        tannee=new JTextField("");
        tannee.setBounds(120, 110, 200, 30);
        this.getContentPane().add(tannee);
        
        lligue=new JLabel("Ligue");
        lligue.setBounds(10,150,100,30);
        this.getContentPane().add(lligue);
        
        ligue=new JComboBox();
        list_ligue=Factory_Ligue.viewligue();
        for(Ligue c:list_ligue){
            ligue.addItem(c.getNom_ligue());
        }
        ligue.setBounds(120,150,150,30);
        ligue.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=ligue.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(ligue);
        
        lpays=new JLabel("Pays");
        lpays.setBounds(10,190,100,30);
        this.getContentPane().add(lpays);
        
        nationalite=new JComboBox(igihugu);
        nationalite.setBounds(120,190,200,30);
        this.getContentPane().add(nationalite);
        
        lpresident=new JLabel("President");
        lpresident.setBounds(10,230,100,30);
        this.getContentPane().add(lpresident);
        
        tpresident=new JTextField("");
        tpresident.setBounds(120, 230, 200, 30);
        this.getContentPane().add(tpresident);
        
        lgeneral=new JLabel("General");
        lgeneral.setBounds(10,270,100,30);
        this.getContentPane().add(lgeneral);
        
        tgeneral=new JTextField("");
        tgeneral.setBounds(120, 270, 200, 30);
        this.getContentPane().add(tgeneral);
        
        lsportif=new JLabel("Sportif");
        lsportif.setBounds(10,310,100,30);
        this.getContentPane().add(lsportif);
        
        tsportif=new JTextField("");
        tsportif.setBounds(120, 310, 200, 30);
        this.getContentPane().add(tsportif);
        
        lentraineur=new JLabel("Entraineur");
        lentraineur.setBounds(10,350,100,30);
        this.getContentPane().add(lentraineur);
        
        tentraineur=new JTextField("");
        tentraineur.setBounds(120, 350, 200, 30);
        this.getContentPane().add(tentraineur);
        
        lstade=new JLabel("Stade");
        lstade.setBounds(10,390,100,30);
        this.getContentPane().add(lstade);
        
        tstade=new JTextField("");
        tstade.setBounds(120, 390, 200, 30);
        this.getContentPane().add(tstade);
        
        lcapacite=new JLabel("Capacite");
        lcapacite.setBounds(10,430,100,30);
        this.getContentPane().add(lcapacite);
        
        tcapacite=new JTextField("");
        tcapacite.setBounds(120, 430, 200, 30);
        this.getContentPane().add(tcapacite);
        
        lemail=new JLabel("Email");
        lemail.setBounds(10,470,100,30);
        this.getContentPane().add(lemail);
        
        temail=new JTextField("");
        temail.setBounds(120, 470, 200, 30);
        this.getContentPane().add(temail);
        
        enr=new JButton("Save");
        enr.setBounds(10,520,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("View");
        vis.setBounds(120,520,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Reset");
        init.setBounds(230,520,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Delete");
        del.setBounds(340,520,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Update");
        upd.setBounds(450,520,100,30);
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
        model.addColumn("ID club");
        model.addColumn("Nom club");
        model.addColumn("Date d'existence");
        model.addColumn("Ligue");
        model.addColumn("Pays");
        model.addColumn("President");
        model.addColumn("General");
        model.addColumn("Sportif");
        model.addColumn("Entraineur");
        model.addColumn("Stade");
        model.addColumn("Capacite");
        model.addColumn("email");
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int id_agent = Integer.valueOf(tid_club.getText());
            String nom_agent = tnom_club.getText();
            String date_naissance = tannee.getText();
            int ligues = list_ligue.get(index).getId_ligue();
            String nation = String.valueOf(nationalite.getSelectedItem());
            String num = tpresident.getText();
            String certification = tgeneral.getText();
            String expiration = tsportif.getText();
            String entraineur = tentraineur.getText();
            String phone = tstade.getText();
            int capacite = Integer.valueOf(tcapacite.getText());
            String email = temail.getText();
            
            a = new Club(id_agent,nom_agent,date_naissance,ligues,nation,num,certification,expiration,entraineur,phone,capacite,email);
            Factory_Club.insertclub(a);
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
            if(club !=null){
                String msg="Voulez-vous reelement supprimer "+club.getNom_club()+" de la liste des clubs";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory_Club.deleteclub(club);
                    afficher();
                    effacer();
                }
            }
        }
            else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(trech.getText());
            club = Factory_Club.searchclub(ct);
            if(club!=null){
                recupInfo(club);
            }
        }
            else if(e.getSource()==upd){ // les boutons modifier avec toutes ses fonctions
            int id_agent = Integer.valueOf(tid_club.getText());
            String nom_agent = tnom_club.getText();
            String date_naissance = tannee.getText();
            int ligues = list_ligue.get(index).getId_ligue();
            String nation = String.valueOf(nationalite.getSelectedItem());
            String num = tpresident.getText();
            String certification = tgeneral.getText();
            String expiration = tsportif.getText();
            String entraineur = tentraineur.getText();
            String phone = tstade.getText();
            int capacite = Integer.valueOf(tcapacite.getText());
            String email = temail.getText();
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory_Club.updateagent(id_agent,nom_agent,date_naissance,ligues,nation,num,certification,expiration,entraineur,phone,capacite,email);
                afficher();
                effacer();
            }
        }
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        list_club= Factory_Club.viewclub();
        for(Club t:list_club){
            model.addRow(new Object[]{
                   t.getId_club(),t.getNom_club(),t.getAnnee(),t.getId_ligue(),t.getPays(),t.getPresident(),t.getGeneral(),t.getSportif(),t.getEntraineur(),t.getStade(),t.getCapacite(),t.getEmail()}
            );
    }
    tbagent = new JTable(model);
    JScrollPane p =new JScrollPane(tbagent);
    p.setBounds(30,580,800,100);
    this.getContentPane().add(p);
}   
       public void recupInfo(Club t){
        tid_club.setText(String.valueOf(t.getId_club()));
        tnom_club.setText(String.valueOf(t.getNom_club()));
        tannee.setText(t.getAnnee());
        ligue.setSelectedItem(t.getId_ligue());
        nationalite.setSelectedItem(t.getPays());
        tpresident.setText(String.valueOf(t.getPresident()));
        tgeneral.setText(String.valueOf(t.getGeneral()));
        tsportif.setText(String.valueOf(t.getSportif()));
        tentraineur.setText(String.valueOf(t.getEntraineur()));
        tstade.setText(String.valueOf(t.getStade()));
        tcapacite.setText(String.valueOf(t.getCapacite()));
        temail.setText(t.getEmail());
       }
       
       public void effacer(){
        tid_club.setText("");
        tnom_club.setText("");
        tannee.setText("");
        tpresident.setText("");
        tgeneral.setText("");
        tsportif.setText("");
        tentraineur.setText("");
        tstade.setText("");
        tcapacite.setText("");
        temail.setText("");
    }
}
