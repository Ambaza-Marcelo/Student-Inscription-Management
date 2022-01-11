/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.Etudiant;
import window.Inscription_UI;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author utilisateur
 */
public class Manager_Ev_EtudCombo implements ItemListener {

    Inscription_UI win=null;
    public Manager_Ev_EtudCombo(Inscription_UI w){
        this.win=w;
        
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e==null) return;
       /*Etudiant etud=(Etudiant)this.win.getEtud().getSelectedItem();*/
       String ac=this.win.getAnnee().getSelectedText();
       if(ac==null) return;
       Etudiant.loading_etudiants(this.win.getEtudiantI());
    }
    
    /*InscriptionUI winIns=null;
    public Manager_Ev_DepartCombo(InscriptionUI w){
        this.winIns=w;
        
    }
    @Override
    public void insitemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e==null) return;
       Departement dep=(Departement)this.winIns.getDep().getSelectedItem();
       if(dep==null) return;
       Classes.loading_classes(winIns.getClas(), dep.getDepartID());
    }*/
    
}
