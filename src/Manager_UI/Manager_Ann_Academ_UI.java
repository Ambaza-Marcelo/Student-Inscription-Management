/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;
import Logic_UI.Annee_Academique;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author PC
 */
public class Manager_Ann_Academ_UI implements ActionListener {
     private Inscription_UI win=null;
     
       public Manager_Ann_Academ_UI(Inscription_UI insc){
        this.win=insc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Annee_Academique an_ac=new Annee_Academique(win.getAnnee().getText());
       an_ac.enregistrer_Annee_DB();
       JOptionPane.showMessageDialog(win, an_ac.getInfo());
    }

    
}
