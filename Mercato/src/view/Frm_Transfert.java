package view;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.table.*;
import model.*;
import controller.*;

public class Frm_Transfert extends JFrame implements ActionListener{
    JLabel lid_transfert,ljoueur,lorigine,ldestination,ltype,lmontant,ldate_transfert,lid_agent;
    JTextField tid_transfert,torigine,tdestination,ttype,tmontant,tdate_transfert,trech;
    JComboBox joueur;
    JComboBox agent;
    JComboBox type;
    String[] style={"Permanent","Pret","Libre"};
    JButton enr,vis,init,del,rech,upd;
    ArrayList <Agent> list_agent= new ArrayList();
    ArrayList <Joueur> list_joueur= new ArrayList();
    ArrayList <Transfert> list_transfert= new ArrayList();
    JTable tbagent;
    private final DefaultTableModel model;
    Transfert transfert = new Transfert();
    Transfert a = null;
    int index = 0;
    int ind = 0;
    
     public Frm_Transfert(){
        lid_transfert=new JLabel("ID transfert");
        lid_transfert.setBounds(10,30,100,30);
        this.getContentPane().add(lid_transfert);
        
        tid_transfert=new JTextField("");
        tid_transfert.setBounds(120,30,200,30);
        this.getContentPane().add(tid_transfert);
        
        ljoueur=new JLabel("Nom joueur");
        ljoueur.setBounds(10,70,100,30);
        this.getContentPane().add(ljoueur);
        
        joueur=new JComboBox();
        list_joueur=Factory_Joueur.viewjoueur();
        for(Joueur c:list_joueur){
            joueur.addItem(c.getNom_joueur());
        }
        joueur.setBounds(120,70,150,30);
        joueur.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            index=joueur.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(joueur);
        
        lorigine=new JLabel("club d'origine");
        lorigine.setBounds(10, 110, 100, 30);
        this.getContentPane().add(lorigine);
        
        torigine=new JTextField("");
        torigine.setBounds(120, 110, 200, 30);
        this.getContentPane().add(torigine);
        
        ldestination=new JLabel("Club de destination");
        ldestination.setBounds(10,150,100,30);
        this.getContentPane().add(ldestination);
        
        tdestination=new JTextField("");
        tdestination.setBounds(120, 150, 200, 30);
        this.getContentPane().add(tdestination);
        
        ltype=new JLabel("Type");
        ltype.setBounds(10,190,100,30);
        this.getContentPane().add(ltype);
        
        type=new JComboBox(style);
        type.setBounds(120,190,200,30);
        this.getContentPane().add(type);
        
        lmontant=new JLabel("Montant");
        lmontant.setBounds(10,230,100,30);
        this.getContentPane().add(lmontant);
        
        tmontant=new JTextField("");
        tmontant.setBounds(120, 230, 200, 30);
        this.getContentPane().add(tmontant);
        
        ldate_transfert=new JLabel("Date du transfert");
        ldate_transfert.setBounds(10,270,100,30);
        this.getContentPane().add(ldate_transfert);
        
        tdate_transfert=new JTextField("");
        tdate_transfert.setBounds(120, 270, 200, 30);
        this.getContentPane().add(tdate_transfert);
        
        lid_agent=new JLabel("Agent");
        lid_agent.setBounds(10,310,100,30);
        this.getContentPane().add(lid_agent);
        
        agent=new JComboBox();
        list_agent=Factory_Agent.viewagent();
        for(Agent c:list_agent){
            agent.addItem(c.getNom_agent());
        }
        agent.setBounds(120,310,150,30);
        agent.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent e){
            ind = agent.getSelectedIndex();
        }
        }
        );
        this.getContentPane().add(agent);
        
        enr=new JButton("Save");
        enr.setBounds(10,370,100,30);
        enr.addActionListener(this);
        this.getContentPane().add(enr);
        
        vis=new JButton("View");
        vis.setBounds(120,370,100,30);
        vis.addActionListener(this);
        this.getContentPane().add(vis);
        
        init=new JButton("Reset");
        init.setBounds(230,370,100,30);
        init.addActionListener(this);
        this.getContentPane().add(init);
        
        del=new JButton("Delete");
        del.setBounds(340,370,100,30);
        del.addActionListener(this);
        this.getContentPane().add(del);
        
        upd=new JButton("Update");
        upd.setBounds(450,370,100,30);
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
        model.addColumn("ID transfert");
        model.addColumn("Joueur");
        model.addColumn("Origine");
        model.addColumn("Destination");
        model.addColumn("Type");
        model.addColumn("Montant");
        model.addColumn("Date du transfert");
        model.addColumn("Agent");
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==enr){ // les boutons enregistrer avec la verification de sexe
            int id_ligue = Integer.valueOf(tid_transfert.getText());
            int joueurs = list_joueur.get(index).getId_joueur();
            String nom_ligue = torigine.getText();
            String annee = tdestination.getText();
            String president = String.valueOf(type.getSelectedItem());
            String general = tmontant.getText();
            String date = tdate_transfert.getText();
            int agents = list_agent.get(ind).getId_agent();

            a = new Transfert(id_ligue,joueurs,nom_ligue,annee,president,general,date,agents);
            Factory_Transfert.inserttransfert(a);
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
            if(transfert !=null){
                String msg="Voulez-vous reelement supprimer "+transfert.getId_transfert()+" de la liste des transferts";
                int rep=JOptionPane.showConfirmDialog(null,msg);
                if(rep==0){
                    Factory_Transfert.deletetransfert(transfert);
                    afficher();
                    effacer();
                }
            }
        }
            else if(e.getSource()==rech){   // les boutons rechercher avec toutes les fonctions 
            int ct=Integer.valueOf(trech.getText());
            transfert = Factory_Transfert.searchtransfert(ct);
            if(transfert!=null){
                recupInfo(transfert);
            }
        }
            else if(e.getSource()==upd){ // les boutons modifier avec toutes ses fonctions
            int id_ligue = Integer.valueOf(tid_transfert.getText());
            int joueurs = list_joueur.get(index).getId_joueur();
            String nom_ligue = torigine.getText();
            String annee = tdestination.getText();
            String president = String.valueOf(type.getSelectedItem());
            String general = tmontant.getText();
            String date = tdate_transfert.getText();
            int agents = list_agent.get(ind).getId_agent();
            
            if(JOptionPane.showConfirmDialog(null,"Voulez-vous modifier?","Modification",JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
                controller.Factory_Transfert.updatetransfert(id_ligue,joueurs,nom_ligue,annee,president,general,date,agents);
                afficher();
                effacer();
            }
        }
    }
       public void afficher(){
        model.setRowCount(0);//il sert initialiser le nbre de lignes car une fois omis il affiche les lignes mais en faisant des repetitions  
        list_transfert= Factory_Transfert.viewtransfert();
        for(Transfert t:list_transfert){
            model.addRow(new Object[]{
                   t.getId_transfert(),t.getId_joueur(),t.getOrigine(),t.getDestination(),t.getType(),t.getMontant(),t.getDate_transfert(),t.getId_agent()}
            );
    }
    tbagent = new JTable(model);
    JScrollPane p =new JScrollPane(tbagent);
    p.setBounds(30,500,800,100);
    this.getContentPane().add(p);
}   
       public void recupInfo(Transfert t){
        tid_transfert.setText(String.valueOf(t.getId_transfert()));
        joueur.setSelectedItem(t.getId_joueur());
        torigine.setText(String.valueOf(t.getOrigine()));
        tdestination.setText(t.getDestination());
        type.setSelectedItem(t.getType());
        tmontant.setText(String.valueOf(t.getMontant()));
        tdate_transfert.setText(String.valueOf(t.getDate_transfert()));
        agent.setSelectedItem(t.getId_agent());
       }
       
       public void effacer(){
        tid_transfert.setText("");
        torigine.setText("");
        tdestination.setText("");
        tmontant.setText("");
        tdate_transfert.setText("");
    }
}
