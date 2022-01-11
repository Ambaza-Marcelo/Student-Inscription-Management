/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.departement_class;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Departement_Ev implements ItemListener{

    Inscription_UI win;
    
    public Manager_Departement_Ev(Inscription_UI w){
     this.win=w;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e==null) return;
        
        Departement dep=(Departement)this.win.getDep().getSelectedItem();
        if(dep==null) return;
        Classes.loading_classes(this.win.getCl(), dep.getDepartID());
        departement_class depart_cl=new departement_class();
    }
    
}
