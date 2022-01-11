/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Etudiant;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_Etudiant_UI implements ActionListener{
    
    private Inscription_UI win = null;
    
    public Manager_Etudiant_UI(Inscription_UI et){
        this.win = et;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Etudiant et = new Etudiant(win.getEtud_nom().getText(),win.getEtud_prenom().getText(),win.getEtud_tel().getText(),win.getEtud_matricule().getText(),win.getEtud_mail().getText());
        et.enregistrer_etudiant();
        JOptionPane.showMessageDialog(null, et.getInfo());
    }
}
