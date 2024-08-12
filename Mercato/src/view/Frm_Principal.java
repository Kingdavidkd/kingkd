package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frm_Principal extends JFrame implements ActionListener{
    JMenuBar ba;
    JMenu md;
    JMenuItem ijoueur,iagent,iclub,iligue,itransfert;
    
    public Frm_Principal(){
        ba=new JMenuBar();
        
        md=new JMenu("Formulaires");
        
        ijoueur = new JMenuItem("Joueur");
        ijoueur.addActionListener(this);
        iagent = new JMenuItem("Agent");
        iagent.addActionListener(this);
        iclub = new JMenuItem("Club");
        iclub.addActionListener(this);
        iligue=new JMenuItem("Ligue");
        iligue.addActionListener(this);
        itransfert=new JMenuItem("Transfert");
        itransfert.addActionListener(this);
        
        ba.add(md);
        
        md.add(ijoueur);
        md.add(iagent);
        md.add(iclub);
        md.add(iligue);
        md.add(itransfert);
        
        this.getContentPane().add(ba);
        ba.setBounds(10,10,800,40);
        
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==ijoueur){
            Frm_Joueur C = new Frm_Joueur();
            C.setSize(1000,800);
            C.setTitle("Formulaire des joueurs");
            C.setVisible(true);
        }
        if(e.getSource()==iagent){
            Frm_Agent M =  new Frm_Agent();
            M.setSize(1000,800);
            M.setTitle("Formulaire des agents");
            M.setVisible(true);
        }
        else if(e.getSource()==iclub){
            Frm_Club R=  new Frm_Club();
            R.setSize(1000,800);
            R.setTitle("Formulaire des clubs");
            R.setVisible(true);
        }
        else if(e.getSource()==iligue){
            Frm_Ligue T=new Frm_Ligue();
            T.setSize(1000,800);
            T.setTitle("Formulaire des ligues");
            T.setVisible(true);
        }
        else if(e.getSource()==itransfert){
            Frm_Transfert TR = new Frm_Transfert();
            TR.setSize(1000,800);
            TR.setTitle("Formulaire des ligues");
            TR.setVisible(true);
        }
    }
}
