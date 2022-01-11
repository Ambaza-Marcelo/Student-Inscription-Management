/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package window;

import Logic_UI.Annee_Academique;
import Logic_UI.Classes;
import Logic_UI.Departement;
import Logic_UI.Etudiant;
import Logic_UI.Faculte;
import Logic_UI.Inscription;
import Logic_UI.db_Mysql;
import Logic_UI.departement_class;
import Manager_UI.Manager_Ann_Academ_UI;
import Manager_UI.Manager_Depart_Classe_Ev;
import Manager_UI.Manager_Depart_Classe_UI;
import Manager_UI.Manager_Departement_Ev;
import Manager_UI.Manager_Departement_UI;
import Manager_UI.Manager_Etudiant_UI;
import Manager_UI.Manager_Ev_DepartCombo;
import Manager_UI.Manager_Faculte_Ev;
import Manager_UI.Manager_Faculte_UI;
import Manager_UI.Manager_Inscription_UI;
import Manager_UI.Manager_Update_Faculte_UI;
import Manager_UI.Manager_classe_UI;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author AC Tech
 */
public class Inscription_UI extends javax.swing.JFrame {

    /**
     * Creates new form Inscription_UI
     */
    public Inscription_UI() {
        initComponents();
        this.setLocationRelativeTo(null);
 
        //afficher les facultes
        afficher_faculte();
        //afficher les classes
        liste_classe();
        //afficher la liste des etudiants provenant dans la base de donnees
        liste_etudiant();
        //
        liste_departement();
        //
        liste_departement_classe();
        //autocharger les facultes dans le combo box
        Faculte.Loading_Faculty(faculte);
        //autocharger les departements dans le combo box de la fenetre departement classe
        Faculte.Loading_Faculty(fac);
        //autocharger les departements dans le combo box
        Departement.Loading_Departemnt(dep, -1);
        //Auto chargement des classes dans le combo box
        Classes.loading_classes(cl, -1);
        //Auto chargement des facultes dans le combo box de la fenetre inscription UI
        Faculte.Loading_Faculty(faculteI);
        //Auto chargement des departements dans le combo box de la fenetre inscription UI
        Departement.Loading_Departemnt(departementI, -1);
        //Auto chargement des classes dans le combo box de la fenetre Inscription UI
        Classes.loading_classes(classeI, -1);
        //Auto chargement des etudiants dans le combo box de la fenetre Inscription UI
        Etudiant.loading_etudiants(etudiantI);
        //
        Annee_Academique.Loading_Annee_Academique(annee_academique);
        
        enreg_annee.addActionListener(new Manager_Ann_Academ_UI(this));
        
        dep.addItemListener(new Manager_Ev_DepartCombo(this));
        fac.addItemListener(new Manager_Faculte_Ev(this));
        //enregistrer les facultes dans la base de donnees
        enreg_faculte.addActionListener(new Manager_Faculte_UI(this));
        //enregistrer les departements dans la base de donnees
        enreg_departement.addActionListener(new Manager_Departement_UI(this));
        //enregistrer les classes dans la base de donnees
        enreg_classe.addActionListener(new Manager_classe_UI(this));
        //enregistrer l'Etudiant dans la base de donnees
        enreg_etudiant.addActionListener(new Manager_Etudiant_UI(this));
        //Enregistrement des departements et classes dans la base de donnees
        enreg_dep_classe.addActionListener(new Manager_Depart_Classe_UI(this));
        //
        valider_inscription.addActionListener(new Manager_Inscription_UI(this));
        
    }
    
    Departement depId;
    //afficher la liste des facultes
    public void afficher_faculte(){
        ResultSet les_facultes = db_Mysql.interrogerBD("select * from faculte");
        liste_faculte.setModel(DbUtils.resultSetToTableModel(les_facultes));
    }

    //afficher la liste des classes
    public void liste_classe(){
        ResultSet classes = db_Mysql.interrogerBD("select * from classes");
        liste_classe.setModel(DbUtils.resultSetToTableModel(classes));
    }
    
    //afficher la liste des etudiants
    
    public void liste_etudiant(){
        ResultSet etudiants = db_Mysql.interrogerBD("select * from etudiant");
        liste_etudiant.setModel(DbUtils.resultSetToTableModel(etudiants));
    }
    
    public void liste_departement(){
        ResultSet dep = db_Mysql.interrogerBD("select departement.departId, faculte.nom,departement.nom from departement inner join faculte on faculte.faculId=departement.faculID order by departId");
        liste_departement.setModel(DbUtils.resultSetToTableModel(dep));
    }
    
    public void liste_departement_classe(){
        ResultSet depClasses = db_Mysql.interrogerBD("select departement_classes.departClID,departement.nom,classes.nom from((departement_classes inner join departement on departement_classes.departID = departement.departId) inner join classes on departement_classes.classeID = classes.classeId) order by departClID");
        liste_departement_classe.setModel(DbUtils.resultSetToTableModel(depClasses));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        nom_faculte = new javax.swing.JTextField();
        nom = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        code_faculte = new javax.swing.JTextField();
        enreg_faculte = new javax.swing.JButton();
        mod_faculte = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        liste_faculte = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        faculte = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        nom_dep = new javax.swing.JTextField();
        enreg_departement = new javax.swing.JButton();
        mod_departement = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        liste_departement = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        nom_classe = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        enreg_classe = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        liste_classe = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        fac = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        dep = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cl = new javax.swing.JComboBox<>();
        enreg_dep_classe = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        liste_departement_classe = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        etud_nom = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        etud_prenom = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        etud_tel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        etud_matricule = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        etud_mail = new javax.swing.JTextField();
        enreg_etudiant = new javax.swing.JButton();
        effacer_etud = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        liste_etudiant = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        annee = new javax.swing.JTextField();
        enreg_annee = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        faculteI = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        classeI = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        departementI = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        annee_academique = new javax.swing.JComboBox<>();
        etudiantI = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        valider_inscription = new javax.swing.JButton();
        modifier_inscription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nom.setText("Nom");

        code.setText("Code");

        enreg_faculte.setText("ENREGISTRER FACULTE");
        enreg_faculte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enreg_faculteActionPerformed(evt);
            }
        });

        mod_faculte.setText("MODIFIER FACULTE");
        mod_faculte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mod_faculteActionPerformed(evt);
            }
        });

        liste_faculte.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FACULTE ID", "NOM FACULTE", "CODE FACULTE"
            }
        ));
        liste_faculte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liste_faculteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(liste_faculte);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(enreg_faculte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mod_faculte))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nom)
                            .addComponent(code))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nom_faculte)
                            .addComponent(code_faculte, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nom)
                                .addComponent(nom_faculte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(code)
                                .addComponent(code_faculte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(enreg_faculte)
                                .addComponent(mod_faculte)))))
                .addContainerGap(306, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("FACULTE", jPanel1);

        jLabel2.setText("NOM FACULTE");

        faculte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("NOM DEPARTEMENT");

        enreg_departement.setText("Enregistrer Département");
        enreg_departement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enreg_departementActionPerformed(evt);
            }
        });

        mod_departement.setText("Modifier Département");

        liste_departement.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Departement", "NOM FACULTE", "NOM DEPARTEMENT"
            }
        ));
        jScrollPane2.setViewportView(liste_departement);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(enreg_departement)
                        .addGap(18, 18, 18)
                        .addComponent(mod_departement, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(faculte, 0, 174, Short.MAX_VALUE)
                            .addComponent(nom_dep))))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(faculte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(nom_dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enreg_departement)
                            .addComponent(mod_departement))))
                .addContainerGap(302, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("DEPARTEMENT", jPanel2);

        jLabel1.setText("NOM CLASSE");

        jButton1.setText("MODIFIER CLASSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        enreg_classe.setText("ENREGISTRER CLASSE");
        enreg_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enreg_classeActionPerformed(evt);
            }
        });

        liste_classe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CLASSE", "NOM CLASSE"
            }
        ));
        jScrollPane3.setViewportView(liste_classe);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(enreg_classe)
                        .addGap(28, 28, 28)
                        .addComponent(jButton1))
                    .addComponent(nom_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nom_classe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(enreg_classe)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(311, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("CLASSES", jPanel3);

        fac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("FACULTES");

        jLabel5.setText("DEPARTEMENTS");

        dep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("CLASSES");

        cl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        enreg_dep_classe.setText("ENREGISTRER");
        enreg_dep_classe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enreg_dep_classeActionPerformed(evt);
            }
        });

        liste_departement_classe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(liste_departement_classe);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel11))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(dep, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(cl, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(enreg_dep_classe, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fac, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(fac, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(enreg_dep_classe)
                        .addGap(551, 551, 551))))
        );

        jTabbedPane1.addTab("DEPARTEMENT-CLASSES", jPanel4);

        jLabel10.setText("Nom");

        jLabel9.setText("Prenom");

        jLabel8.setText("Telephone");

        jLabel7.setText("Matricule");

        jLabel6.setText("E-mail");

        enreg_etudiant.setText("Enregistrer l'étudiant");
        enreg_etudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enreg_etudiantActionPerformed(evt);
            }
        });

        effacer_etud.setText("Effacer");
        effacer_etud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                effacer_etudActionPerformed(evt);
            }
        });

        liste_etudiant.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        liste_etudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID CLIENT", "NOM", "PRENOM", "TEL", "MATRICULE", "MAIL"
            }
        ));
        liste_etudiant.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                liste_etudiantMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(liste_etudiant);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
                        .addGap(130, 130, 130))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(etud_prenom))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(etud_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(etud_tel))
                                .addGroup(jPanel5Layout.createSequentialGroup()
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(etud_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(etud_matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(enreg_etudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(effacer_etud, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etud_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(etud_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(etud_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etud_matricule, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etud_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(effacer_etud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enreg_etudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(189, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ETUDIANTS", jPanel5);

        jLabel17.setText("Annnee Academique");

        enreg_annee.setText("Enregistrer");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel17)
                .addGap(55, 55, 55)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(enreg_annee, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(annee))
                .addContainerGap(651, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(annee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addComponent(enreg_annee)
                .addContainerGap(576, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Annee Academique", jPanel7);

        faculteI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("FACULTE");

        classeI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("CLASSE");

        departementI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel14.setText("DEPARTEMENT");

        jLabel15.setText("ANNEE ACADEMIQUE");

        annee_academique.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        etudiantI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("ETUDIANT");

        valider_inscription.setText("Valider Inscription");
        valider_inscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valider_inscriptionActionPerformed(evt);
            }
        });

        modifier_inscription.setText("Modifier Inscription");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(classeI, 0, 323, Short.MAX_VALUE)
                            .addComponent(faculteI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(etudiantI, 0, 323, Short.MAX_VALUE))
                        .addGap(91, 91, 91)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(departementI, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(annee_academique, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(149, 149, 149))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(valider_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(modifier_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(406, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(departementI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel14))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(faculteI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(classeI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(annee_academique, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etudiantI, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(62, 62, 62)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modifier_inscription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(valider_inscription, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(456, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("INSCRIPTION", jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void valider_inscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valider_inscriptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valider_inscriptionActionPerformed

    private void effacer_etudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_effacer_etudActionPerformed
        // TODO add your handling code here:

        etud_nom.setText("");
        etud_prenom.setText("");
        etud_tel.setText("");
        etud_matricule.setText("");
        etud_mail.setText("");
    }//GEN-LAST:event_effacer_etudActionPerformed

    private void enreg_etudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enreg_etudiantActionPerformed
        // TODO add your handling code here:
        liste_etudiant();
    }//GEN-LAST:event_enreg_etudiantActionPerformed

    private void enreg_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enreg_classeActionPerformed
        // TODO add your handling code here:
        liste_classe();
    }//GEN-LAST:event_enreg_classeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void mod_faculteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mod_faculteActionPerformed
        // TODO add your handling code here:
        if(nom_faculte.getText().isEmpty() || code_faculte.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "manque des donnees");
        }else{
            //mod_faculte.addActionListener(new Manager_Update_Faculte_UI(this));
        }
    }//GEN-LAST:event_mod_faculteActionPerformed

    private void enreg_faculteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enreg_faculteActionPerformed
        // TODO add your handling code here:
        afficher_faculte();
    }//GEN-LAST:event_enreg_faculteActionPerformed

    private void liste_faculteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liste_faculteMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)liste_faculte.getModel();
        int index = liste_faculte.getSelectedRow();
        nom_faculte.setText(model.getValueAt(index, 1).toString());
        code_faculte.setText(model.getValueAt(index, 2).toString());
        //faculteID.setText(model.getValueAt(index, 0).toString());
    }//GEN-LAST:event_liste_faculteMouseClicked

    private void enreg_dep_classeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enreg_dep_classeActionPerformed
        // TODO add your handling code here:
        liste_departement_classe();
    }//GEN-LAST:event_enreg_dep_classeActionPerformed

    private void enreg_departementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enreg_departementActionPerformed
        // TODO add your handling code here:
        liste_departement();
    }//GEN-LAST:event_enreg_departementActionPerformed

    private void liste_etudiantMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_liste_etudiantMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)liste_etudiant.getModel();
        int index = liste_etudiant.getSelectedRow();
        etud_nom.setText(model.getValueAt(index, 1).toString());
        etud_prenom.setText(model.getValueAt(index, 2).toString());
        etud_tel.setText(model.getValueAt(index, 3).toString());
        etud_matricule.setText(model.getValueAt(index, 4).toString());
        etud_mail.setText(model.getValueAt(index, 5).toString());
    }//GEN-LAST:event_liste_etudiantMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inscription_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inscription_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inscription_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inscription_UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inscription_UI().setVisible(true);
            }
        });
    }
    
    static Faculte choix_fac=null;

    public static void setChoix_fac(Faculte choix_fac) {
        Inscription_UI.choix_fac = choix_fac;
    }
    
    //les getters pour la faculte
    public JTextField getCode_faculte() {
        return code_faculte;
    }

    public JButton getEnreg_faculte() {
        return enreg_faculte;
    }

    public JButton getMod_faculte() {
        return mod_faculte;
    }

    public JTextField getNom_faculte() {
        return nom_faculte;
    }
    //les getters pour le departement
    
    public JButton getEnreg_departement() {
        return enreg_departement;
    }

    public JComboBox getFaculte() {
        return faculte;
    }

    public JButton getMod_departement() {
        return mod_departement;
    }

    public JTextField getNom_dep() {
        return nom_dep;
    }

    public JTable getTab_Dep() {
        return liste_departement;
    }
    
    //les getters pour la classe
    
    public JButton getEnreg_classe() {
        return enreg_classe;
    }

    public JTextField getNom_classe() {
        return nom_classe;
    }
    
    //les getters pour l'etudiant
    
    public JButton getEffacer_etud() {
        return effacer_etud;
    }

    public JButton getEnreg_etudiant() {
        return enreg_etudiant;
    }

    public JTextField getEtud_mail() {
        return etud_mail;
    }

    public JTextField getEtud_matricule() {
        return etud_matricule;
    }

    public JTextField getEtud_nom() {
        return etud_nom;
    }

    public JTextField getEtud_prenom() {
        return etud_prenom;
    }

    public JTextField getEtud_tel() {
        return etud_tel;
    }
    
    //les getters pour le departement classe
    
    public JComboBox<String> getCl() {
        return cl;
    }

    public JComboBox<String> getDep() {
        return dep;
    }

    public JButton getEnreg_dep_classe() {
        return enreg_dep_classe;
    }

    public JComboBox<String> getFac() {
        return fac;
    }
    
    //les getters pour l'inscription
    
    public JComboBox<String> getAnnee_academique() {
        return annee_academique;
    }

    public JComboBox<String> getClasseI() {
        return classeI;
    }

    public JComboBox<String> getDepartementI() {
        return departementI;
    }

    public JComboBox<String> getEtudiantI() {
        return etudiantI;
    }

    public JComboBox<String> getFaculteI() {
        return faculteI;
    }

    public JButton getModifier_inscription() {
        return modifier_inscription;
    }

    public JButton getValider_inscription() {
        return valider_inscription;
    }

    public JTextField getAnnee() {
        return annee;
    }

    public JButton getEnreg_annee() {
        return enreg_annee;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField annee;
    private javax.swing.JComboBox<String> annee_academique;
    private javax.swing.JComboBox<String> cl;
    private javax.swing.JComboBox<String> classeI;
    private javax.swing.JLabel code;
    private javax.swing.JTextField code_faculte;
    private javax.swing.JComboBox<String> dep;
    private javax.swing.JComboBox<String> departementI;
    private javax.swing.JButton effacer_etud;
    private javax.swing.JButton enreg_annee;
    private javax.swing.JButton enreg_classe;
    private javax.swing.JButton enreg_dep_classe;
    private javax.swing.JButton enreg_departement;
    private javax.swing.JButton enreg_etudiant;
    private javax.swing.JButton enreg_faculte;
    private javax.swing.JTextField etud_mail;
    private javax.swing.JTextField etud_matricule;
    private javax.swing.JTextField etud_nom;
    private javax.swing.JTextField etud_prenom;
    private javax.swing.JTextField etud_tel;
    private javax.swing.JComboBox<String> etudiantI;
    private javax.swing.JComboBox<String> fac;
    private javax.swing.JComboBox faculte;
    private javax.swing.JComboBox<String> faculteI;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable liste_classe;
    private javax.swing.JTable liste_departement;
    private javax.swing.JTable liste_departement_classe;
    private javax.swing.JTable liste_etudiant;
    private javax.swing.JTable liste_faculte;
    private javax.swing.JButton mod_departement;
    private javax.swing.JButton mod_faculte;
    private javax.swing.JButton modifier_inscription;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nom_classe;
    private javax.swing.JTextField nom_dep;
    private javax.swing.JTextField nom_faculte;
    private javax.swing.JButton valider_inscription;
    // End of variables declaration//GEN-END:variables
}
