/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Classes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author AC Tech
 */
public class Manager_classe_UI implements ActionListener{
    private Inscription_UI win;
    public Manager_classe_UI(Inscription_UI insc){
        this.win= insc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e != null){
            Classes cl = new Classes(-1,win.getNom_classe().getText());
            cl.enregistrer_Classes();
            JOptionPane.showMessageDialog(null, cl.getInfo());
        }
    }
    
}
