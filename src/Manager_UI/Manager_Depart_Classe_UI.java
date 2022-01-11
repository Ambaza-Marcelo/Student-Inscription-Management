/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.departement_class;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Depart_Classe_UI implements ActionListener{
    private Departement departID;
    private Classes clID;
    private Inscription_UI win;
    public Manager_Depart_Classe_UI(Inscription_UI insc){
        this.win = insc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e != null){
            departID = (Departement)win.getDep().getSelectedItem();
            clID = (Classes)win.getCl().getSelectedItem();
            departement_class depClass = new departement_class(departID,clID);
            depClass.Enregistrer();
            JOptionPane.showMessageDialog(null, depClass.getInfo());
        }
    }
    
}
