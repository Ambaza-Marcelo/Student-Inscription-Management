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
public class Etudiant {
    
    private int etudID;
    private String nom;
    private String prenom;
    private String tel;
    private String matricule;
    private String mail,info;
    
    public Etudiant(String nom,String prenom,String tel,String matricule,String mail){
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.matricule = matricule;
        this.mail = mail;
    }

    public String getInfo() {
        return info;
    }
    
    public int getEtudID() {
        return etudID;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMail() {
        return mail;
    }
    
    public String toString(){
        if(nom == null || nom.trim().equalsIgnoreCase(""))
            return "choisir Etudiants";
        else
            return this.nom+" "+this.prenom;
    }
    
    public Etudiant(){
        
    }
    public static void loading_etudiants(JComboBox etud){
        etud.removeAllItems();
        etud.addItem(new Etudiant("Choisir Etudiats","","","",""));
        String annee_academiqueId = null;
        ResultSet res = db_Mysql.interrogerBD("select * from etudiant where IDEtudiant not in(select IDEtudiant from inscription where annee_academiqueId='"+annee_academiqueId+"')");
        if(res != null){
            try {
                while(res.next()){
                    try {
                        etud.addItem(new Etudiant(res.getString("nom"),res.getString("prenom"),res.getString("tel"),res.getString("matricule"),res.getString("mail")));
                    } catch (SQLException ex) {
                        Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Etudiant.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void enregistrer_etudiant(){
        if(nom == null || nom.trim().equalsIgnoreCase("")){
            this.info = "Desole, le nom est vide";
        }
        else if(prenom == null || prenom.trim().equalsIgnoreCase("")){
            this.info = "Desole,le prenom est vide";
        }
        else if(tel == null || tel.trim().equalsIgnoreCase("")){
            this.info = "Desole,le telephone est vide";
        }
        else if(matricule == null || matricule.trim().equalsIgnoreCase("")){
            this.info = "Desole,le matricule est vide ";
        }
        else if(mail == null || mail.trim().equalsIgnoreCase("")){
            this.info = "Desole,le mail est vid";
        }
        else{
            if(db_Mysql.updateBD("insert into etudiant(nom,prenom,tel,matricule,mail) values('"+this.nom+"','"+this.prenom+"','"+this.tel+"','"+this.matricule+"','"+this.mail+"')")>0)
                this.info = "enregistrement d'etudiant avec succes";
            else
                this.info = "erreur d'enregistrement";
        }
    }
}
