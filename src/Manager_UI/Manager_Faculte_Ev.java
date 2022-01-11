/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Departement;
import Logic_UI.Faculte;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Faculte_Ev implements ItemListener{

    private Inscription_UI win;
    public Manager_Faculte_Ev(Inscription_UI insc){
        this.win = insc;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        if(e==null) return;
       Faculte fac=(Faculte)this.win.getFac().getSelectedItem();
       if(fac==null)return;
       
       Departement.Loading_Departemnt(this.win.getDep(), fac.getFaculID());
    }
    
}
