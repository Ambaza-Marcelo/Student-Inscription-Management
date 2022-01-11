/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Etudiant;
import Logic_UI.Inscription;
import Logic_UI.departement_class;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Inscription_UI implements ActionListener{

    private departement_class depClassID;
    private Etudiant etudID;
    private Inscription_UI win;
    private String annee_academique;
    
    public Manager_Inscription_UI(Inscription_UI insc){
        this.win = insc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        annee_academique = (String)win.getAnnee_academique().getSelectedItem();
        depClassID = (departement_class)win.getDepartementI().getSelectedItem();
        etudID = (Etudiant)win.getEtudiantI().getSelectedItem();
        Inscription in = new Inscription(annee_academique,depClassID,etudID);
        in.valider_inscription();
        JOptionPane.showMessageDialog(null, in.getInfo());
    }
    
}
