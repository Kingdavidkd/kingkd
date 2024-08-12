package view;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.*;
import controller.*;

public class Frm_Agent extends JFrame implements ActionListener{
    JLabel lid_agent,lnom_agent,ldate_naissance,lsexe,lnationalite,lnum,lcertification,lexpiration,lemail,lphone,lid_joueur;
    JTextField tid_agent,tnom_agent,tdate_naissance,tnum,tcertification,texpiration,temail,tphone,trech;
    JComboBox nationalite;
    JComboBox joueur;
    JRadioButton gnm,gnf;
    JButton enr,vis,init,del,rech,upd;
    ButtonGroup gnr;
    String g;
    String[] igihugu={"France","Espagnol","Poland","Angleterre","Argentine","Portugal","Italie","Allemagne","Sweden","Brazil","Uruguay"};
    ArrayList <Agent> list_agent= new ArrayList();
    ArrayList <Joueur> list_joueur = new ArrayList();
    JTable tbagent;
    private final DefaultTableModel model;
    Agent agent = new Agent();
    Agent a = null;
    int index = 0;
    public Frm_Agent(){
        lid_agent=new JLabel("ID agent");
        lid_agent.setBounds(10,30,100,30);
        this.getContentPane().add(lid_agent);
        
        tid_agent=new JTextField("");
        tid_agent.setBounds(120,30,200,30);
        this.getContentPane().add(tid_agent);
        
        lnom_agent=new JLabel("Nom agent");
        lnom_agent.setBounds(10,70,100,30);
        this.getContentPane().add(lnom_agent);
        
        tnom_agent=new JTextField("");
        tnom_agent.setBounds(120,70,200,30);
        this.getContentPane().add(tnom_agent);
        
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
        
        lnum=new JLabel("Numero du certificat");
        lnum.setBounds(10,230,100,30);
        this.getContentPane().add(lnum);
        
        tnum=new JTextField("");
        tnum.setBounds(120, 230, 200, 30);
        this.getContentPane().add(tnum);
        
        lcertification=new JLabel("Date du certificat");
        lcertification.setBounds(10,270,100,30);
        this.getContentPane().add(lcertification);
        
        tcertification=new JTextField("");
        tcertification.setBounds(120, 270, 200, 30);
        this.getContentPane().add(tcertification);
        
        lexpiration=new JLabel("Date d'expiration");
        lexpiration.setBounds(10,310,100,30);
        this.getContentPane().add(lexpiration);
        
        texpiration=new JTextField("");
        texpiration.setBounds(120, 310, 200, 30);
        this.getContentPane().add(texpiration);
        
        lemail=new JLabel("Email");
        lemail.setBounds(10,350,100,30);
        this.getContentPane().add(lemail);
        
        temail=new JTextField("");
        temail.setBounds(120, 350, 200, 30);
        this.getContentPane().add(temail);
        
        lphone=new JLabel("Phone");
        lphone.setBounds(10,390,100,30);
        this.getContentPane().add(lphone);
        
        tphone=new JTextField("");
        tphone.setBounds(120, 390, 200, 30);
        this.getContentPane().add(tphone);
        
        lid_joueur=new JLabel("Joueur");
        lid_joueur.setBounds(10,430,100,30);
        this.getContentPane().add(lid_joueur);
        
        joueur=new JComboBox();
        list_joueur=Factory_Joueur.viewjoueur();
        for(Joueur c:list_joueur){
            joueur.addItem(c.getNom_joueur());
        }
        joueur.setBounds(120,430,150,30);
        joueur.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=joueur.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(joueur);
        
        enr=new JButton("Save");
        enr.setBounds(10,500,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("View");
        vis.setBounds(120,500,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Reset");
        init.setBounds(230,500,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Delete");
        del.setBounds(340,500,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Update");
        upd.setBounds(450,500,100,30);
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
        model.addColumn("ID agent");
        model.addColumn("Nom agent");
        model.addColumn("Date naissance");
        model.addColumn("Sexe");
        model.addColumn("Nationalite");
        model.addColumn("Num de certification");
        model.addColumn("Date de certificat");
        model.addColumn("Date d'expiration");
        model.addColumn("Email");
        model.addColumn("Phone");
        model.addColumn("ID joueur");
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int id_agent = Integer.valueOf(tid_agent.getText());
            String nom_agent = tnom_agent.getText();
            String date_naissance = tdate_naissance.getText();
            if(gnm.isSelected()){
                g = "Masculin";
            }
            else if(gnf.isSelected()){
                g = "Feminin";
            }
            String nation = String.valueOf(nationalite.getSelectedItem());
            String num = tnum.getText();
            String certification = tcertification.getText();
            String expiration = texpiration.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            int joueurs = list_joueur.get(index).getId_joueur();
            a = new Agent(id_agent,nom_agent,date_naissance,g,nation,num,certification,expiration,email,phone,joueurs);
            Factory_Agent.insertagent(a);
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
            if(agent !=null){
                String msg="Voulez-vous reelement supprimer "+agent.getNom_agent()+" de la liste des agents";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory_Agent.deleteagent(agent);
                    afficher();
                    effacer();
                }
            }
        }
            else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(trech.getText());
            agent = Factory_Agent.searchagent(ct);
            if(agent!=null){
                recupInfo(agent);
            }
        }
            else if(e.getSource()==upd){ // les boutons modifier avec toutes ses fonctions
            int id_agent = Integer.valueOf(tid_agent.getText());
            String nom_agent = tnom_agent.getText();
            String date_naissance = tdate_naissance.getText();
            if(gnm.isSelected()){
                g = "Masculin";
            }
            else if(gnf.isSelected()){
                g = "Feminin";
            }
            String nation = String.valueOf(nationalite.getSelectedItem());
            String num = tnum.getText();
            String certification = tcertification.getText();
            String expiration = texpiration.getText();
            String email = temail.getText();
            String phone = tphone.getText();
            int joueurs = list_joueur.get(index).getId_joueur();
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory_Agent.updateagent(id_agent,nom_agent,date_naissance,g,nation,num,certification,expiration,email,phone,joueurs);
                afficher();
                effacer();
            }
        }
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        list_agent= Factory_Agent.viewagent();
        for(Agent t:list_agent){
            model.addRow(new Object[]{
                   t.getId_agent(),t.getNom_agent(),t.getDate_naissance(),t.getSexe(),t.getNationalite(),t.getNum(),t.getCertification(),t.getExpiration(),t.getEmail(),t.getPhone(),t.getId_joueur()}
            );
    }
    tbagent = new JTable(model);
    JScrollPane p =new JScrollPane(tbagent);
    p.setBounds(30,570,800,100);
    this.getContentPane().add(p);
}   
       public void recupInfo(Agent t){
        tid_agent.setText(String.valueOf(t.getId_agent()));
        tnom_agent.setText(String.valueOf(t.getNom_agent()));
        tdate_naissance.setText(t.getDate_naissance());
        if(t.getSexe().equalsIgnoreCase(gnm.getText())) gnm.setSelected(true);else gnf.setSelected(true);
        nationalite.setSelectedItem(t.getNationalite());
        tnum.setText(String.valueOf(t.getNum()));
        tcertification.setText(String.valueOf(t.getCertification()));
        texpiration.setText(String.valueOf(t.getExpiration()));
        temail.setText(String.valueOf(t.getEmail()));
        tphone.setText(String.valueOf(t.getPhone()));
        joueur.setSelectedItem(t.getId_joueur());
       }
       
       public void effacer(){
        tid_agent.setText("");
        tnom_agent.setText("");
        tdate_naissance.setText("");
        nationalite.setSelectedItem("");
        tnum.setText("");
        tcertification.setText("");
        texpiration.setText("");
        temail.setText("");
        tphone.setText("");
        joueur.setSelectedItem("");
    }
}
