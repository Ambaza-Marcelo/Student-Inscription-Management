/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Departement;
import Logic_UI.Faculte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author utilisateur
 */
public class Manager_Departement_UI implements ActionListener {

     
    private Faculte facultID;
    private String nom_dep;
    private Inscription_UI fen;
    
    public Manager_Departement_UI(Inscription_UI el){
        this.fen=el;
 
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
       
        facultID=(Faculte)fen.getFaculte().getSelectedItem();
       this.nom_dep=fen.getNom_dep().getText();
       Departement dep_=new Departement(facultID,this.nom_dep);
    
        dep_.enregistrer_Departement();
        JOptionPane.showMessageDialog(null, dep_.getInfo());
    


    }
    
    
}
