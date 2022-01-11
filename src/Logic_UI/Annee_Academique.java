
package Logic_UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class Annee_Academique {
    
    private int annee_academiqueId;
    private String annee,info;
    public Annee_Academique(String an){
        this.annee=an;
    }
    public String toString()
    {
        return annee;
    }
    public Annee_Academique(){}
    
    public void enregistrer_Annee_DB(){
     
       if(annee==null||annee.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous l'année academique";
         return;
       }
       if(db_Mysql.updateBD("insert into annee_academique(annee) values('"+this.annee+"')")>0)
         this.info="Félicition,enregistrement a reussi";
       else this.info="Désolé, l'operation a échoué";
    }
     public static void Loading_Annee_Academique(javax.swing.JComboBox Annee){
        
        ResultSet result=db_Mysql.interrogerBD("select * from annee_academique");
        
        Annee.removeAllItems();
        Annee.addItem(new Annee_Academique("select Anne academique"));
        if(result!=null)
        {
            try {
                while(result.next())
                {
                 Annee.addItem(new Annee_Academique(result.getString("annee")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Annee_Academique.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }

    public int getAnnee_academiqueId() {
        return annee_academiqueId;
    }
     

    public String getAnnee() {
        return annee;
    }

    public String getInfo() {
        return info;
    }

  
    }
    
    


