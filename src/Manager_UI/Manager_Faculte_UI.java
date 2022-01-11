/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager_UI;

import Logic_UI.Faculte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import window.Inscription_UI;

/**
 *
 * @author utilisateur
 */
public class Manager_Faculte_UI  implements ActionListener{

    private Inscription_UI win=null;
    
    public Manager_Faculte_UI(Inscription_UI el){
        this.win=el;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
       Faculte el=new Faculte(win.getNom_faculte().getText(),win.getCode_faculte().getText());
       el.enregistrer_Fac_DB();
       JOptionPane.showMessageDialog(null, el.getInfo());
    }
    
    
}
