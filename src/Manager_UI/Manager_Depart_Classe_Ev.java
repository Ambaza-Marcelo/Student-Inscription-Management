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
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Depart_Classe_Ev implements ItemListener{

    private Inscription_UI win;
    public Manager_Depart_Classe_Ev(Inscription_UI insc){
        this.win = insc;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e==null)return;
      Departement dep=(Departement)this.win.getDep().getSelectedItem();
      Classes cl=(Classes)this.win.getCl().getSelectedItem();
      
      if(cl==null ||dep==null) {
           JOptionPane.showMessageDialog(null, "Selectionnez le departement ou la classe!!!");
    
          return;}
     departement_class dcl=new departement_class(dep,cl);
      
     dcl.Enregistrer();
     
     //actualiser les classes sur l'interface utilisateur
     
     Classes.loading_classes(this.win.getCl(), dep.getDepartID());
      JOptionPane.showMessageDialog(null, dcl.getInfo());
    }
    
}
