/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author AC Tech
 */
public class Inscription {
    private int inscrID;
    private String annee_academique,info;
    private departement_class depclassID;
    private Etudiant etudiantID;
    
    
    public Inscription(String annee_academique,departement_class dep_cl,Etudiant etud){
        this.annee_academique = annee_academique;
        this.depclassID = dep_cl;
        this.etudiantID = etud;
    }

    public Inscription(int inscID){
        this.inscrID  =inscID;
    }
     public int getInscrID() {
        return inscrID;
    }

    public String getAnnee_academique() {
        return annee_academique;
    }

    public departement_class getDepclassID() {
        return depclassID;
    }

    public Etudiant getEtudiantID() {
        return etudiantID;
    }

    public String getInfo() {
        return info;
    }
    

    public Inscription() {
        
    }
    
    public static void Loading_Departemnt(JComboBox dest,int etudID){
        
        ResultSet result=db_Mysql.interrogerBD("select * from inscription where inscID="+etudID);
        dest.removeAllItems();
        dest.addItem(new Inscription());
        if(result != null){
            departement_class depClass;
            Etudiant etud;
            try {
                while(result.next()){
                    try {
                        dest.addItem(new Inscription(result.getInt("inscID")));
                    } catch (SQLException ex) {
                        Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    
    public void valider_inscription(){
        //this.annee_academique = "2020-2021";
        if(this.depclassID.getDepart_clId() <=0){
            this.info ="Desole ,il faut selectionner le departement classe";
            return;
        }
        if(this.etudiantID.getEtudID() <=0){
            this.info = "Desole,il faut selectionner l'etudiant";
            return;
        }
       if(db_Mysql.updateBD("insert into inscription(annee_academique,depclassID,etudiantID) values('"+this.annee_academique+"','"+this.depclassID.getDepart_clId()+"','"+this.etudiantID.getEtudID()+"')") > 0)
            setInfo ("L'inscription est validee avec succes");
       else
            setInfo("erreur d'inscription");
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
   
    
    
}
