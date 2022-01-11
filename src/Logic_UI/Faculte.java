/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;
//Logic_UI.Faculte

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author utilisateur
 */
public class Faculte {

   private int faculID;
   private String code,info,nom;
   
   public static Faculte get_Fac_A_Parti_ID(int facID){
      
       ResultSet result=db_Mysql.interrogerBD("select * from faculte where faculID="+facID);
       
       if(result!=null)
           try {
               if(result.next())
                   return new Faculte(result.getInt("faculID"),result.getString("nom"),result.getString("code"));
       } catch (SQLException ex) {
           Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   
   public Faculte(){}
   public Faculte(String nom,String code){
       this.nom=nom;
       this.code=code;
   }
   
   public Faculte(int facID,String nom,String code){
       this.nom=nom;
       this.code=code;
       this.faculID=facID;
   }
   
   public String toString(){
     if(nom==null||nom.trim().equalsIgnoreCase(""))
         return "";
     return this.code+" "+this.nom;
   }
   public void enregistrer_Fac_DB(){
     
       if(nom==null||nom.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous le nom de la faculté";
         return;
       }
       if(code==null||code.trim().equalsIgnoreCase(""))
       {
         this.info="Tapez s'il vous le code de la faculté";
         return;
       }
       
       if(db_Mysql.updateBD("insert into faculte(nom,code) values('"+this.nom+"','"+this.code+"')")>0)
         this.info="Félicition,enregistrement a reussi";
       else
           this.info="Désolé, l'operation a échoué";
   }
   
   public void Modifier_Faculte(){
     //controle des données
      if(db_Mysql.updateBD("update faculte set nom='"+this.nom+"',code="+this.code+"where faculId="+this.faculID)>0)
          this.info="Felicitation, l'operation effectuée avec succes";
      else 
          this.info="Désolé, l'echec de l'operation!!";
  }
   
  public void Suprimer_Faculte(){
     //controle des données
      if(db_Mysql.updateBD("delete from faculte where faculId='"+this.faculID)>0)
          this.info="Felicitation, l'operation effectuée avec succes";
      else 
          this.info="Désolé, l'echec de l'operation!!";
  }
       
       
    public static void Loading_Faculty(javax.swing.JComboBox fac){
        
        ResultSet result=db_Mysql.interrogerBD("select * from faculte");
        
        fac.removeAllItems();
        fac.addItem(new Faculte("Chosir Faculte",""));
        if(result!=null)
        {
            try {
                while(result.next())
                {
                 fac.addItem(new Faculte(result.getInt("faculID"),result.getString("nom"),result.getString("code")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Faculte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public String getNom() {
        return nom;
    }

    public int getFaculID() {
        return faculID;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
   
   
   
   
   
}
