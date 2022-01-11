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
 * @author utilisateur
 */
public class departement_class {
    
    private int depart_clId;
    private Departement depart_Id;
    private Classes classe_Id;
    private String info;
    
    public departement_class() {
        
    }
    
    public departement_class(Departement depart_Id,Classes classe_Id){
        this.depart_Id=depart_Id;
        this.classe_Id=classe_Id;
        
    }
    
    public departement_class(int departClID){
        this.depart_clId = departClID;
    }
    
    public String toString(){
        return this.depart_clId+","+this.depart_Id+" "+this.classe_Id;
    }
    
    public static void Loading_dep_class(JComboBox dest,int clID){
        ResultSet res = db_Mysql.interrogerBD("select * from departement_classes where departClID ="+clID);
        dest.removeAllItems();
        dest.addItem(new departement_class());
        
        if(res != null){
            Departement dep;
            Classes cl;
            try {
                while(res.next()){
                    try {
                        dest.addItem(new departement_class(res.getInt("depart_clId")));
                    } catch (SQLException ex) {
                        Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(departement_class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void Enregistrer(){
        
        if(this.depart_Id.getDepartID() <= 0){
             
            this.info="Désolé, il faut selectionner le département!!!";
            return;
        }
        
         if(this.classe_Id.getClasseId() <= 0){
             
            this.info="Désolé, il faut selectionner la classe!!!";
            return;
        }
        
        
        if(db_Mysql.updateBD("insert into departement_classes (departID,classeID) values("+this.depart_Id.getDepartID()+","+this.classe_Id.getClasseId()+")")>0){
            setInfo("insertion reussi");
            }else setInfo("desolé échec");
    }
    
    
    public void depId_a_partir_ClassId()
    {
        
        
    }

    public int getDepart_clId() {
        return depart_clId;
    }

    public Departement getDepart_Id() {
        return depart_Id;
    }

    public Classes getClasse_Id() {
        return classe_Id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    

    
}
