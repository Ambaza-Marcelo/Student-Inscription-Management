/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import window.Inscription_UI;

/**
 *
 * @author utilisateur
 */
public class Manager_Ev_DepartCombo implements ItemListener {

    Inscription_UI win=null;
    public Manager_Ev_DepartCombo(Inscription_UI w){
        this.win=w;
        
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e==null) return;
       Departement dep=(Departement)this.win.getDep().getSelectedItem();
       if(dep==null) return;
       Classes.loading_classes(win.getCl(), dep.getDepartID());
       
       
       
       
    }
    
}
