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
 * @author AC Tech
 */
public class Manager_Update_Faculte_UI implements ActionListener{
    
    private Inscription_UI win = null;
    
    public Manager_Update_Faculte_UI(Inscription_UI insc){
        this.win =insc;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Faculte el=new Faculte(win.getNom_faculte().getText(),win.getCode_faculte().getText());
       el.Modifier_Faculte();
       JOptionPane.showMessageDialog(null, el.getInfo());
    }
    
}
