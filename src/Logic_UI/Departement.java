/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic_UI;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

/**
 *
 * @author utilisateur
 */
public class Departement {
   
    private int departID;
    private Faculte faculID;
    private String nom,info;
   
    public Departement(int departID,Faculte fac,String no){
     this.departID=departID;
     this.faculID=fac;
     this.nom=no;
    }
  public static Departement[][] charger_Depart_Tableau(){
      List<Departement> el=null;
      Faculte fac=null;
      ResultSet result=db_Mysql.interrogerBD("select * from departement order by faculID,nom");
    
      if(result!=null)
      {   el=new ArrayList<Departement>();
          try {
              
              while(result.next()){
                  //eviter le gaspillage de la memoire
                  //on va réutiliser l'object precedent
                if(fac==null)
                    fac=Faculte.get_Fac_A_Parti_ID(result.getInt("faculID"));
                else  if(fac.getFaculID()!=result.getInt("faculID"))
                        fac=Faculte.get_Fac_A_Parti_ID(result.getInt("faculID"));
                
                 el.add(new Departement(result.getInt("departID"),fac,result.getString("nom")));
                
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Departement.class.getName()).log(Level.SEVERE, null, ex);
          }
               
          }
      
      Departement [][]data=null;
      
      if(el!=null &&el.size()>0){
      
          data=new Departement[el.size()][3];
          int  j=0;
          for(Departement d:el){
             
              for(int i=0;i<3;i++)
                  data[j][i]=d;
              j++;
          
          }
          
      }
      
//      System.out.println("Data:"+data.length);
      return data;
  }  
    
  public String toString(){
        
      if(nom==null||nom.trim().equalsIgnoreCase(""))
          return "choisir départements";
      return nom;    
  }
    public Departement(){}

    public Faculte getFaculID() {
        return faculID;
    }
    
    
    public static void Loading_Departemnt(JComboBox dest,int facID){
        
        ResultSet result=db_Mysql.interrogerBD("select * from departement where faculID="+facID);
        dest.removeAllItems();
        dest.addItem(new Departement());
         //
        // System.out.println("select * from departement where faculID="+facID);
        if(result!=null)
        try {
            
            while(result.next()){
                   dest.addItem(new Departement(result.getInt("departID"),result.getString("nom")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Departement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getDepartID() {
        return departID;
    }

    public String getNom() {
        return nom;
    }
    
    
 public Departement(int deprtID,String nom)    
  {
    this.departID=deprtID;
    this.nom=nom;
  }
  public Departement(Faculte fac,String nom)    
  {
    this.faculID=fac;
    this.nom=nom;
  }

    public String getInfo() {
        return info;
    }
    
  public void enregistrer_Departement(){
     
      if(db_Mysql.updateBD("insert into departement(nom,faculID) values('"+this.nom+"',"+this.faculID.getFaculID()+")")>0)
          this.info="Felicitation, l'operation effectuée avec succes";
      else 
          this.info="Désolé, l'echec de l'operation!!";
  }
  
  public void Modifier_Departement(){
     //controle des données
      if(db_Mysql.updateBD("update departement set nom='"+this.nom+"',faculID="+this.faculID.getFaculID()+" where departID="+this.departID)>0)
          this.info="Felicitation, l'operation effectuée avec succes";
      else 
          this.info="Désolé, l'echec de l'operation!!";
  }
  
}
