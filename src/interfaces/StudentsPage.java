/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dao.GroupIDDao;
import dao.GroupNoDao;
import dao.ProgrammeDao;
import dao.SubGroupIDDao;
import dao.SubGroupNoDao;
import dao.YearSemDao;
import db.DBconnect;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author acer
 */
public class StudentsPage extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1t
     */
    
    PreparedStatement pst;
    YearSemDao yearSem = new YearSemDao();
    DBconnect dbConnection = new DBconnect();
    Connection con = null;
    ResultSet rs = null;
    
    ProgrammeDao stProgramme = new ProgrammeDao();
    GroupNoDao groupNo = new GroupNoDao();
    SubGroupNoDao subGroupNo = new SubGroupNoDao();
    GroupIDDao groupIDs = new GroupIDDao();
    SubGroupIDDao subGrpIDs = new SubGroupIDDao();
    
    public StudentsPage() {
        initComponents();
        viewTab.setBackground(Color.GRAY);
        viewFrame.setVisible(true);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(false); 
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(false);
        con = DBconnect.createConnection();
        
        year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
        yearSem.loadAllYearSemesters(year_sem_table);
        
        programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
        stProgramme.loadAllProgrammes(programme_table);
        
        grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
        groupNo.loadAllGroupNumbers(grp_no_table);
        
        subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
        subGroupNo.loadAllSubGroupNumbers(subgrp_no_table);
        
        grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(grp_id_table);
        
        subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(subgrp_id_table);
        
        view_stGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(view_stGrp_table);
        
        view_stSubGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(view_stSubGrp_table);
        
        
        
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }
    
    public void fill_grp_id_year_combo() {

        try {
            String sql = "SELECT * FROM year_semester";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            grp_id_year_combo.addItem("Please Select");
            
            while (rs.next()) {
                String empid = rs.getString("yr_shortCode");
                grp_id_year_combo.addItem(empid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill_grp_id_programme_combo() {

        try {
            String sql = "SELECT * FROM student_programmes";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            grp_id_programme_combo.addItem("Please Select");

            while (rs.next()) {
                String empid = rs.getString("programme_name");
                grp_id_programme_combo.addItem(empid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill_grp_id_grpNo_combo() {

        try {
            String sql = "SELECT * FROM group_numbers";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            grp_id_grpNo_combo.addItem("Please Select");

            while (rs.next()) {
                String empid = rs.getString("group_number");
                grp_id_grpNo_combo.addItem(empid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill_subgrp_id_grp_combo() {

        try {
            String sql = "SELECT * FROM group_ids";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            subgrp_id_grp_combo.addItem("Please Select");

            while (rs.next()) {
                String empid = rs.getString("grp_ID");
                subgrp_id_grp_combo.addItem(empid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill_subgrp_id_grpNo_combo() {

        try {
            String sql = "SELECT * FROM sub_group_numbers";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            subgrp_id_grpNo_combo.addItem("Please Select");

            while (rs.next()) {
                String empid = rs.getString("sub_group_number");
                subgrp_id_grpNo_combo.addItem(empid);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsPage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        yearTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        programmeTab = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        viewTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        notavailableTab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        groupTab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        subgroupTab = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        allPanels = new javax.swing.JPanel();
        viewFrame = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        view_stSubGrp_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        view_stGrp_table = new javax.swing.JTable();
        view_stDrp_rfshBtn = new javax.swing.JButton();
        view_stSubDrp_rfshBtn = new javax.swing.JButton();
        view_stGrp_srchTxt = new javax.swing.JTextField();
        view_stGrp_srchBtn = new javax.swing.JButton();
        view_stSubGrp_srchTxt = new javax.swing.JTextField();
        view_stSubGrp_srchBtn = new javax.swing.JButton();
        yearFrame = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        year_sem_combo = new javax.swing.JComboBox<String>();
        jLabel11 = new javax.swing.JLabel();
        year_sem_addBtn = new javax.swing.JButton();
        year_sem_editBtn = new javax.swing.JButton();
        year_sem_deleteBtn = new javax.swing.JButton();
        year_sem_clearBtn = new javax.swing.JButton();
        year_sem_id = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        year_sem_tbl_srchTxt = new javax.swing.JTextField();
        year_sem_tbl_srchBtn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        year_sem_table = new javax.swing.JTable();
        year_sem_tbl_rfshBtn = new javax.swing.JButton();
        programmeFrame = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        programme_addBtn = new javax.swing.JButton();
        programme_editBtn = new javax.swing.JButton();
        programme_deleteBtn = new javax.swing.JButton();
        programme_add_txt = new javax.swing.JTextField();
        programme_clearBtn = new javax.swing.JButton();
        programme_id = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        programme_tbl_srchTxt = new javax.swing.JTextField();
        programme_tbl_srchBtn = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        programme_table = new javax.swing.JTable();
        programme_tbl_rfshBtn = new javax.swing.JButton();
        groupFrame = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        grp_no_table = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        grp_no_addBtn = new javax.swing.JButton();
        grp_no_editBtn = new javax.swing.JButton();
        grp_no_deleteBtn = new javax.swing.JButton();
        grp_no_table_rfshBtn = new javax.swing.JButton();
        grp_no_clearBtn = new javax.swing.JButton();
        grp_no_tbl_srchTxt = new javax.swing.JTextField();
        grp_no_tbl_srchBtn = new javax.swing.JButton();
        grp_no_add_spinner = new javax.swing.JSpinner();
        groupNo_IDtxt = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        grp_id_table = new javax.swing.JTable();
        grp_id_year_combo = new javax.swing.JComboBox<String>();
        grp_id_programme_combo = new javax.swing.JComboBox<String>();
        grp_id_grpNo_combo = new javax.swing.JComboBox<String>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        grp_id_addBtn = new javax.swing.JButton();
        grp_id_editBtn = new javax.swing.JButton();
        grp_id_deleteBtn = new javax.swing.JButton();
        grp_id_table_rfshBtn = new javax.swing.JButton();
        grp_id_clearBtn = new javax.swing.JButton();
        grp_id_tbl_srchTxt = new javax.swing.JTextField();
        grp_id_tbl_srchBtn = new javax.swing.JButton();
        grp_id_grpNo_IDtxt = new javax.swing.JLabel();
        groupIdRowTxt = new javax.swing.JLabel();
        subgroupFrame = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        subgrp_no_table = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        subgrp_no_addBtn = new javax.swing.JButton();
        subgrp_no_editBtn = new javax.swing.JButton();
        subgrp_no_deleteBtn = new javax.swing.JButton();
        subgrp_no_table_rfshBtn = new javax.swing.JButton();
        subgrp_no_clearBtn = new javax.swing.JButton();
        subgrp_no_tbl_srchTxt = new javax.swing.JTextField();
        subgrp_no_tbl_srchBtn = new javax.swing.JButton();
        subgrp_no_add_spinner = new javax.swing.JSpinner();
        subgroupNo_IDtxt = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        subgrp_id_table = new javax.swing.JTable();
        subgrp_id_grp_combo = new javax.swing.JComboBox<String>();
        subgrp_id_grpNo_combo = new javax.swing.JComboBox<String>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        subgrp_id_addBtn = new javax.swing.JButton();
        subgrp_id_editBtn = new javax.swing.JButton();
        subgrp_id_deleteBtn = new javax.swing.JButton();
        subgrp_id_table_rfshBtn = new javax.swing.JButton();
        subgrp_id_clearBtn = new javax.swing.JButton();
        subgrp_id_tbl_srchTxt = new javax.swing.JTextField();
        subgrp_id_tbl_srchBtn = new javax.swing.JButton();
        subGroupIdRowTxt = new javax.swing.JLabel();
        sub_grp_id_grpNo_IDtxt = new javax.swing.JLabel();
        notavailableFrame = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 90, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/header_image.png"))); // NOI18N
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 0, 1250, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel28.setFont(new java.awt.Font("Algerian", 1, 29)); // NOI18N
        jLabel28.setText("STUDENTS MANAGEMENT");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 482, 0, 492);
        jPanel3.add(jLabel28, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        yearTab.setBackground(new java.awt.Color(51, 153, 255));
        yearTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearTabMouseClicked(evt);
            }
        });
        yearTab.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel2.setText("Year & Semester");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 29, 13, 30);
        yearTab.add(jLabel2, gridBagConstraints);

        programmeTab.setBackground(new java.awt.Color(51, 153, 255));
        programmeTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programmeTabMouseClicked(evt);
            }
        });
        programmeTab.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel3.setText("Programme");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 62, 13, 54);
        programmeTab.add(jLabel3, gridBagConstraints);

        viewTab.setBackground(new java.awt.Color(51, 153, 255));
        viewTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTabMouseClicked(evt);
            }
        });
        viewTab.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel1.setText("View Students");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 29, 13, 30);
        viewTab.add(jLabel1, gridBagConstraints);

        notavailableTab.setBackground(new java.awt.Color(51, 153, 255));
        notavailableTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notavailableTabMouseClicked(evt);
            }
        });
        notavailableTab.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel6.setText("Not Available Time");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 13, 15);
        notavailableTab.add(jLabel6, gridBagConstraints);

        groupTab.setBackground(new java.awt.Color(51, 153, 255));
        groupTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                groupTabMouseClicked(evt);
            }
        });
        groupTab.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel4.setText("Group No. & ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 35, 13, 40);
        groupTab.add(jLabel4, gridBagConstraints);

        subgroupTab.setBackground(new java.awt.Color(51, 153, 255));
        subgroupTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subgroupTabMouseClicked(evt);
            }
        });
        subgroupTab.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 24)); // NOI18N
        jLabel5.setText("Sub Group No. & ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 13, 12);
        subgroupTab.add(jLabel5, gridBagConstraints);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(yearTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(programmeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(notavailableTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(groupTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(viewTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subgroupTab, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(viewTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(yearTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(programmeTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(groupTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(subgroupTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(notavailableTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        allPanels.setBackground(new java.awt.Color(51, 255, 255));
        allPanels.setLayout(new javax.swing.OverlayLayout(allPanels));

        viewFrame.setBackground(new java.awt.Color(204, 204, 255));

        jPanel5.setBackground(new java.awt.Color(0, 0, 51));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Students Tables");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 16;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 361, 0, 462);
        jPanel5.add(jLabel7, gridBagConstraints);

        view_stSubGrp_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        view_stSubGrp_table.setModel(new javax.swing.table.DefaultTableModel(
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
        view_stSubGrp_table.setRowHeight(28);
        jScrollPane1.setViewportView(view_stSubGrp_table);

        view_stGrp_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        view_stGrp_table.setModel(new javax.swing.table.DefaultTableModel(
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
        view_stGrp_table.setRowHeight(28);
        jScrollPane2.setViewportView(view_stGrp_table);

        view_stDrp_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        view_stDrp_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_stDrp_rfshBtn.setText("REFRESH");
        view_stDrp_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_stDrp_rfshBtnActionPerformed(evt);
            }
        });

        view_stSubDrp_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        view_stSubDrp_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_stSubDrp_rfshBtn.setText("REFRESH");
        view_stSubDrp_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_stSubDrp_rfshBtnActionPerformed(evt);
            }
        });

        view_stGrp_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N

        view_stGrp_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        view_stGrp_srchBtn.setText("SEARCH");
        view_stGrp_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_stGrp_srchBtnActionPerformed(evt);
            }
        });

        view_stSubGrp_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N

        view_stSubGrp_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        view_stSubGrp_srchBtn.setText("SEARCH");
        view_stSubGrp_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_stSubGrp_srchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewFrameLayout = new javax.swing.GroupLayout(viewFrame);
        viewFrame.setLayout(viewFrameLayout);
        viewFrameLayout.setHorizontalGroup(
            viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewFrameLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(view_stDrp_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(viewFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewFrameLayout.createSequentialGroup()
                                .addComponent(view_stGrp_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(view_stGrp_srchBtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewFrameLayout.createSequentialGroup()
                                .addComponent(view_stSubGrp_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(view_stSubGrp_srchBtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewFrameLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(view_stSubDrp_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        viewFrameLayout.setVerticalGroup(
            viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewFrameLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(view_stGrp_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(view_stGrp_srchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_stDrp_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(viewFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(viewFrameLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(view_stSubGrp_srchTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                    .addComponent(view_stSubGrp_srchBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_stSubDrp_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        allPanels.add(viewFrame);

        yearFrame.setBackground(new java.awt.Color(0, 0, 51));

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jPanel8.setBackground(new java.awt.Color(0, 0, 51));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Sitka Text", 3, 28)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Year & Semester");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel8.add(jLabel8, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel10.setText("Year &");

        year_sem_combo.setFont(new java.awt.Font("Sitka Text", 0, 22)); // NOI18N
        year_sem_combo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Please Select", "Year 1 Semester 1", "Year 1 Semester 2", "Year 2 Semester 1", "Year 2 Semester 2", "Year 3 Semester 1", "Year 3 Semester 2", "Year 4 Semester 1", "Year 4 Semester 2" }));
        year_sem_combo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_comboActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel11.setText("Semester");

        year_sem_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        year_sem_addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        year_sem_addBtn.setText("ADD");
        year_sem_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_addBtnActionPerformed(evt);
            }
        });

        year_sem_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        year_sem_editBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        year_sem_editBtn.setText("EDIT");
        year_sem_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_editBtnActionPerformed(evt);
            }
        });

        year_sem_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        year_sem_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        year_sem_deleteBtn.setText("DELETE");
        year_sem_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_deleteBtnActionPerformed(evt);
            }
        });

        year_sem_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        year_sem_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        year_sem_clearBtn.setText("CLEAR");
        year_sem_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(year_sem_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year_sem_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year_sem_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(year_sem_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(year_sem_combo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(year_sem_id, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(year_sem_id, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(year_sem_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addComponent(year_sem_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(year_sem_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(year_sem_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(year_sem_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 255));

        jPanel9.setBackground(new java.awt.Color(0, 0, 51));

        jLabel9.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Year & Semester Details");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(361, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        year_sem_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N

        year_sem_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        year_sem_tbl_srchBtn.setText("SEARCH");
        year_sem_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_tbl_srchBtnActionPerformed(evt);
            }
        });

        year_sem_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        year_sem_table.setModel(new javax.swing.table.DefaultTableModel(
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
        year_sem_table.setRowHeight(28);
        year_sem_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                year_sem_tableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(year_sem_table);

        year_sem_tbl_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        year_sem_tbl_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        year_sem_tbl_rfshBtn.setText("REFRESH");
        year_sem_tbl_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_sem_tbl_rfshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(year_sem_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(year_sem_tbl_srchBtn))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(year_sem_tbl_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year_sem_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(year_sem_tbl_srchBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(year_sem_tbl_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout yearFrameLayout = new javax.swing.GroupLayout(yearFrame);
        yearFrame.setLayout(yearFrameLayout);
        yearFrameLayout.setHorizontalGroup(
            yearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(yearFrameLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        yearFrameLayout.setVerticalGroup(
            yearFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        allPanels.add(yearFrame);

        programmeFrame.setBackground(new java.awt.Color(0, 0, 51));

        jPanel10.setBackground(new java.awt.Color(204, 204, 255));

        jPanel12.setBackground(new java.awt.Color(0, 0, 51));
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel12.setFont(new java.awt.Font("Sitka Text", 3, 28)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Programme");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel12.add(jLabel12, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel14.setText("Programme");

        programme_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        programme_addBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programme_addBtn.setText("ADD");
        programme_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_addBtnActionPerformed(evt);
            }
        });

        programme_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        programme_editBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programme_editBtn.setText("EDIT");
        programme_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_editBtnActionPerformed(evt);
            }
        });

        programme_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        programme_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programme_deleteBtn.setText("DELETE");
        programme_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_deleteBtnActionPerformed(evt);
            }
        });

        programme_add_txt.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N

        programme_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        programme_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programme_clearBtn.setText("CLEAR");
        programme_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_clearBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(programme_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programme_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programme_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(programme_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(programme_add_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(programme_id, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(programme_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(programme_add_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addComponent(programme_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(programme_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(programme_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(programme_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));

        jPanel14.setBackground(new java.awt.Color(0, 0, 51));

        jLabel15.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Programmes Details");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        programme_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 22)); // NOI18N

        programme_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        programme_tbl_srchBtn.setText("SEARCH");
        programme_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_tbl_srchBtnActionPerformed(evt);
            }
        });

        programme_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        programme_table.setModel(new javax.swing.table.DefaultTableModel(
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
        programme_table.setRowHeight(28);
        programme_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programme_tableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(programme_table);

        programme_tbl_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        programme_tbl_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programme_tbl_rfshBtn.setText("REFRESH");
        programme_tbl_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programme_tbl_rfshBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(programme_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(programme_tbl_srchBtn))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(programme_tbl_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programme_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programme_tbl_srchBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(programme_tbl_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout programmeFrameLayout = new javax.swing.GroupLayout(programmeFrame);
        programmeFrame.setLayout(programmeFrameLayout);
        programmeFrameLayout.setHorizontalGroup(
            programmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(programmeFrameLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        programmeFrameLayout.setVerticalGroup(
            programmeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        allPanels.add(programmeFrame);

        groupFrame.setBackground(new java.awt.Color(0, 0, 51));

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));

        jPanel16.setBackground(new java.awt.Color(0, 0, 51));
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jLabel13.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Group Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel16.add(jLabel13, gridBagConstraints);

        jPanel19.setBackground(new java.awt.Color(0, 0, 51));

        jLabel17.setFont(new java.awt.Font("Sitka Text", 3, 22)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Group Number Details");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        grp_no_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        grp_no_table.setModel(new javax.swing.table.DefaultTableModel(
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
        grp_no_table.setRowHeight(28);
        grp_no_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grp_no_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(grp_no_table);

        jLabel19.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel19.setText("Group Number");

        grp_no_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_no_addBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_no_addBtn.setText("ADD");
        grp_no_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_addBtnActionPerformed(evt);
            }
        });

        grp_no_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_no_editBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_no_editBtn.setText("EDIT");
        grp_no_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_editBtnActionPerformed(evt);
            }
        });

        grp_no_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_no_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_no_deleteBtn.setText("DELETE");
        grp_no_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_deleteBtnActionPerformed(evt);
            }
        });

        grp_no_table_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_no_table_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_no_table_rfshBtn.setText("REFRESH");
        grp_no_table_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_table_rfshBtnActionPerformed(evt);
            }
        });

        grp_no_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_no_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_no_clearBtn.setText("CLEAR");
        grp_no_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_clearBtnActionPerformed(evt);
            }
        });

        grp_no_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        grp_no_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        grp_no_tbl_srchBtn.setText("SEARCH");
        grp_no_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_no_tbl_srchBtnActionPerformed(evt);
            }
        });

        grp_no_add_spinner.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        grp_no_add_spinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(grp_no_addBtn)
                        .addGap(9, 9, 9)
                        .addComponent(grp_no_editBtn)
                        .addGap(13, 13, 13)
                        .addComponent(grp_no_deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grp_no_clearBtn))
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(groupNo_IDtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(grp_no_add_spinner)))))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grp_no_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(grp_no_tbl_srchBtn)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(grp_no_table_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(groupNo_IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_no_add_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_no_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_no_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_no_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_no_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(grp_no_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_no_tbl_srchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(grp_no_table_rfshBtn)
                .addGap(7, 7, 7))
        );

        jPanel17.setBackground(new java.awt.Color(204, 204, 255));

        jPanel18.setBackground(new java.awt.Color(0, 0, 51));
        jPanel18.setLayout(new java.awt.GridBagLayout());

        jLabel16.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Group ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel18.add(jLabel16, gridBagConstraints);

        jPanel20.setBackground(new java.awt.Color(0, 0, 51));

        jLabel18.setFont(new java.awt.Font("Sitka Text", 3, 22)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Group ID Details");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        grp_id_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        grp_id_table.setModel(new javax.swing.table.DefaultTableModel(
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
        grp_id_table.setRowHeight(28);
        grp_id_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grp_id_tableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(grp_id_table);

        grp_id_year_combo.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        grp_id_year_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));
        grp_id_year_combo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                grp_id_year_comboMouseClicked(evt);
            }
        });

        grp_id_programme_combo.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        grp_id_programme_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));

        grp_id_grpNo_combo.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        grp_id_grpNo_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));

        jLabel21.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel21.setText("Programme");

        jLabel22.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel22.setText("Year & Semester");

        jLabel23.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel23.setText("Group Number");

        grp_id_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_id_addBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_id_addBtn.setText("ADD");
        grp_id_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_addBtnActionPerformed(evt);
            }
        });

        grp_id_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_id_editBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_id_editBtn.setText("EDIT");
        grp_id_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_editBtnActionPerformed(evt);
            }
        });

        grp_id_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_id_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_id_deleteBtn.setText("DELETE");
        grp_id_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_deleteBtnActionPerformed(evt);
            }
        });

        grp_id_table_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_id_table_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_id_table_rfshBtn.setText("REFRESH");
        grp_id_table_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_table_rfshBtnActionPerformed(evt);
            }
        });

        grp_id_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        grp_id_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        grp_id_clearBtn.setText("CLEAR");
        grp_id_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_clearBtnActionPerformed(evt);
            }
        });

        grp_id_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        grp_id_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        grp_id_tbl_srchBtn.setText("SEARCH");
        grp_id_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grp_id_tbl_srchBtnActionPerformed(evt);
            }
        });

        grp_id_grpNo_IDtxt.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(grp_id_grpNo_IDtxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grp_id_year_combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_programme_combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_grpNo_combo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupIdRowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(grp_id_addBtn)
                        .addGap(8, 8, 8)
                        .addComponent(grp_id_editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grp_id_deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(grp_id_clearBtn)))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(grp_id_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(grp_id_tbl_srchBtn))
                            .addGroup(jPanel17Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(grp_id_table_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142))))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_id_tbl_srchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(grp_id_table_rfshBtn)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(groupIdRowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_id_year_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_id_programme_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_id_grpNo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)
                        .addComponent(grp_id_grpNo_IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(grp_id_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grp_id_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
<<<<<<< HEAD
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
=======
                        .addContainerGap(26, Short.MAX_VALUE))))
>>>>>>> 292a7cc2d1be83f17397746b09e846846eededea
        );

        javax.swing.GroupLayout groupFrameLayout = new javax.swing.GroupLayout(groupFrame);
        groupFrame.setLayout(groupFrameLayout);
        groupFrameLayout.setHorizontalGroup(
            groupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        groupFrameLayout.setVerticalGroup(
            groupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupFrameLayout.createSequentialGroup()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        allPanels.add(groupFrame);

        subgroupFrame.setBackground(new java.awt.Color(0, 0, 51));

        jPanel21.setBackground(new java.awt.Color(204, 204, 255));

        jPanel22.setBackground(new java.awt.Color(0, 0, 51));
        jPanel22.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Sub Group Number");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel22.add(jLabel20, gridBagConstraints);

        jPanel23.setBackground(new java.awt.Color(0, 0, 51));

        jLabel24.setFont(new java.awt.Font("Sitka Text", 3, 22)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Sub Group Number Details");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        subgrp_no_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subgrp_no_table.setModel(new javax.swing.table.DefaultTableModel(
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
        subgrp_no_table.setRowHeight(28);
        subgrp_no_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subgrp_no_tableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(subgrp_no_table);

        jLabel25.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel25.setText("Sub Group Number");

        subgrp_no_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_no_addBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_no_addBtn.setText("ADD");
        subgrp_no_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_addBtnActionPerformed(evt);
            }
        });

        subgrp_no_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_no_editBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_no_editBtn.setText("EDIT");
        subgrp_no_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_editBtnActionPerformed(evt);
            }
        });

        subgrp_no_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_no_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_no_deleteBtn.setText("DELETE");
        subgrp_no_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_deleteBtnActionPerformed(evt);
            }
        });

        subgrp_no_table_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_no_table_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_no_table_rfshBtn.setText("REFRESH");
        subgrp_no_table_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_table_rfshBtnActionPerformed(evt);
            }
        });

        subgrp_no_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_no_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_no_clearBtn.setText("CLEAR");
        subgrp_no_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_clearBtnActionPerformed(evt);
            }
        });

        subgrp_no_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        subgrp_no_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        subgrp_no_tbl_srchBtn.setText("SEARCH");
        subgrp_no_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_no_tbl_srchBtnActionPerformed(evt);
            }
        });

        subgrp_no_add_spinner.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addComponent(subgrp_no_addBtn)
                                .addGap(9, 9, 9)
                                .addComponent(subgrp_no_editBtn)
                                .addGap(13, 13, 13)
                                .addComponent(subgrp_no_deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(subgrp_no_clearBtn))
                            .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel21Layout.createSequentialGroup()
                                    .addComponent(jLabel25)
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(subgrp_no_add_spinner)
                                        .addComponent(subgroupNo_IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7)
                                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subgrp_no_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(subgrp_no_tbl_srchBtn))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addGap(0, 480, Short.MAX_VALUE)
                        .addComponent(subgrp_no_table_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 166, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(subgroupNo_IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_no_add_spinner, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subgrp_no_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_no_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_no_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_no_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subgrp_no_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_no_tbl_srchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subgrp_no_table_rfshBtn)
                .addGap(7, 7, 7))
        );

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));

        jPanel25.setBackground(new java.awt.Color(0, 0, 51));
        jPanel25.setLayout(new java.awt.GridBagLayout());

        jLabel26.setFont(new java.awt.Font("Sitka Text", 3, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Sub Group ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.ipady = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 36, 0, 43);
        jPanel25.add(jLabel26, gridBagConstraints);

        jPanel26.setBackground(new java.awt.Color(0, 0, 51));

        jLabel27.setFont(new java.awt.Font("Sitka Text", 3, 22)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Sub Group ID Details");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        subgrp_id_table.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        subgrp_id_table.setModel(new javax.swing.table.DefaultTableModel(
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
        subgrp_id_table.setRowHeight(28);
        subgrp_id_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subgrp_id_tableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(subgrp_id_table);

        subgrp_id_grp_combo.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        subgrp_id_grp_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));

        subgrp_id_grpNo_combo.setFont(new java.awt.Font("Sitka Text", 0, 20)); // NOI18N
        subgrp_id_grpNo_combo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Please Select" }));

        jLabel29.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel29.setText("Group ID");

        jLabel30.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N
        jLabel30.setText("Sub Group Number");

        subgrp_id_addBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_id_addBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_id_addBtn.setText("ADD");
        subgrp_id_addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_addBtnActionPerformed(evt);
            }
        });

        subgrp_id_editBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_id_editBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_id_editBtn.setText("EDIT");
        subgrp_id_editBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_editBtnActionPerformed(evt);
            }
        });

        subgrp_id_deleteBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_id_deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_id_deleteBtn.setText("DELETE");
        subgrp_id_deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_deleteBtnActionPerformed(evt);
            }
        });

        subgrp_id_table_rfshBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_id_table_rfshBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_id_table_rfshBtn.setText("REFRESH");
        subgrp_id_table_rfshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_table_rfshBtnActionPerformed(evt);
            }
        });

        subgrp_id_clearBtn.setBackground(new java.awt.Color(51, 153, 255));
        subgrp_id_clearBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        subgrp_id_clearBtn.setText("CLEAR");
        subgrp_id_clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_clearBtnActionPerformed(evt);
            }
        });

        subgrp_id_tbl_srchTxt.setFont(new java.awt.Font("Times New Roman", 0, 20)); // NOI18N

        subgrp_id_tbl_srchBtn.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        subgrp_id_tbl_srchBtn.setText("SEARCH");
        subgrp_id_tbl_srchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subgrp_id_tbl_srchBtnActionPerformed(evt);
            }
        });

        sub_grp_id_grpNo_IDtxt.setFont(new java.awt.Font("Sitka Text", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(subgrp_id_addBtn)
                        .addGap(8, 8, 8)
                        .addComponent(subgrp_id_editBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subgrp_id_deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(subgrp_id_clearBtn))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(subgrp_id_grp_combo, 0, 160, Short.MAX_VALUE)
                            .addComponent(subgrp_id_grpNo_combo, 0, 160, Short.MAX_VALUE)
                            .addComponent(subGroupIdRowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sub_grp_id_grpNo_IDtxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel24Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(subgrp_id_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(subgrp_id_tbl_srchBtn)))
                        .addContainerGap())
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(subgrp_id_table_rfshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subgrp_id_tbl_srchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_id_tbl_srchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subgrp_id_table_rfshBtn)
                        .addGap(16, 16, 16))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(subGroupIdRowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subgrp_id_grp_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_id_grpNo_combo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, 0)
                        .addComponent(sub_grp_id_grpNo_IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(subgrp_id_addBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_id_editBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_id_deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(subgrp_id_clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout subgroupFrameLayout = new javax.swing.GroupLayout(subgroupFrame);
        subgroupFrame.setLayout(subgroupFrameLayout);
        subgroupFrameLayout.setHorizontalGroup(
            subgroupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        subgroupFrameLayout.setVerticalGroup(
            subgroupFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subgroupFrameLayout.createSequentialGroup()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        allPanels.add(subgroupFrame);

        javax.swing.GroupLayout notavailableFrameLayout = new javax.swing.GroupLayout(notavailableFrame);
        notavailableFrame.setLayout(notavailableFrameLayout);
        notavailableFrameLayout.setHorizontalGroup(
            notavailableFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1050, Short.MAX_VALUE)
        );
        notavailableFrameLayout.setVerticalGroup(
            notavailableFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
        );

        allPanels.add(notavailableFrame);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(allPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(allPanels, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(true);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(false); 
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(false);
        
        viewTab.setBackground(Color.GRAY);
        yearTab.setBackground(new Color(51,153,255));
        programmeTab.setBackground(new Color(51,153,255));
        groupTab.setBackground(new Color(51,153,255));
        subgroupTab.setBackground(new Color(51,153,255));
        notavailableTab.setBackground(new Color(51,153,255));
        
    }//GEN-LAST:event_viewTabMouseClicked

    private void yearTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(false);
        yearFrame.setVisible(true);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(false);
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(false);
        
        viewTab.setBackground(new Color(51,153,255));
        yearTab.setBackground(Color.GRAY);
        programmeTab.setBackground(new Color(51,153,255));
        groupTab.setBackground(new Color(51,153,255));
        subgroupTab.setBackground(new Color(51,153,255));
        notavailableTab.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_yearTabMouseClicked

    private void programmeTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programmeTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(false);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(true);
        groupFrame.setVisible(false);
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(false);
        
        viewTab.setBackground(new Color(51,153,255));
        yearTab.setBackground(new Color(51,153,255));
        programmeTab.setBackground(Color.GRAY);
        groupTab.setBackground(new Color(51,153,255));
        subgroupTab.setBackground(new Color(51,153,255));
        notavailableTab.setBackground(new Color(51,153,255));
    }//GEN-LAST:event_programmeTabMouseClicked

    private void groupTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(false);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(true);
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(false);
        
        viewTab.setBackground(new Color(51,153,255));
        yearTab.setBackground(new Color(51,153,255));
        programmeTab.setBackground(new Color(51,153,255));
        groupTab.setBackground(Color.GRAY);
        subgroupTab.setBackground(new Color(51,153,255));
        notavailableTab.setBackground(new Color(51,153,255));
        
        grp_id_year_combo.removeAllItems();
        grp_id_programme_combo.removeAllItems();
        grp_id_grpNo_combo.removeAllItems();
        fill_grp_id_year_combo();
        fill_grp_id_programme_combo();
        fill_grp_id_grpNo_combo();
    }//GEN-LAST:event_groupTabMouseClicked

    private void subgroupTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subgroupTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(false);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(false);
        subgroupFrame.setVisible(true);
        notavailableFrame.setVisible(false);
        
        viewTab.setBackground(new Color(51,153,255));
        yearTab.setBackground(new Color(51,153,255));
        programmeTab.setBackground(new Color(51,153,255));
        groupTab.setBackground(new Color(51,153,255));
        subgroupTab.setBackground(Color.GRAY);
        notavailableTab.setBackground(new Color(51,153,255));
        
        subgrp_id_grp_combo.removeAllItems();
        subgrp_id_grpNo_combo.removeAllItems();
        fill_subgrp_id_grp_combo();
        fill_subgrp_id_grpNo_combo();
    }//GEN-LAST:event_subgroupTabMouseClicked

    private void notavailableTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notavailableTabMouseClicked
        // TODO add your handling code here:
        viewFrame.setVisible(false);
        yearFrame.setVisible(false);
        programmeFrame.setVisible(false);
        groupFrame.setVisible(false);
        subgroupFrame.setVisible(false);
        notavailableFrame.setVisible(true);
        
        viewTab.setBackground(new Color(51,153,255));
        yearTab.setBackground(new Color(51,153,255));
        programmeTab.setBackground(new Color(51,153,255));
        groupTab.setBackground(new Color(51,153,255));
        subgroupTab.setBackground(new Color(51,153,255));
        notavailableTab.setBackground(Color.GRAY);
    }//GEN-LAST:event_notavailableTabMouseClicked

    private void view_stSubDrp_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_stSubDrp_rfshBtnActionPerformed
        // TODO add your handling code here:
        view_stSubGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(view_stSubGrp_table);
        view_stSubGrp_srchTxt.setText("");
    }//GEN-LAST:event_view_stSubDrp_rfshBtnActionPerformed

    private void year_sem_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_addBtnActionPerformed
        // TODO add your handling code here:
        if(year_sem_combo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Input Field is Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(year_sem_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "Please select Year and Semester", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Year and Semester ?");
            
            if(x == 0){
                String yearNsem = (String) year_sem_combo.getSelectedItem();
                String ysShortCode = null;
                
                if(yearNsem.equalsIgnoreCase("Year 1 Semester 1") ){
                   ysShortCode = "Y1.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 1 Semester 2") ){
                   ysShortCode = "Y1.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 2 Semester 1") ){
                   ysShortCode = "Y2.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 2 Semester 2") ){
                   ysShortCode = "Y2.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 3 Semester 1") ){
                   ysShortCode = "Y3.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 3 Semester 2") ){
                   ysShortCode = "Y3.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 4 Semester 1") ){
                   ysShortCode = "Y4.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 4 Semester 2") ){
                   ysShortCode = "Y4.S2";
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Inputs are invalid", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    if(yearSem.addYearSem(yearNsem,ysShortCode)){
                    JOptionPane.showMessageDialog(rootPane, "Year and Semester Added Successfully", "Add Year and Semester", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Year and Semester", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        year_sem_id.setText("");
        year_sem_combo.setSelectedItem("Please Select");
              
        year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
        yearSem.loadAllYearSemesters(year_sem_table);
    }//GEN-LAST:event_year_sem_addBtnActionPerformed

    private void year_sem_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_editBtnActionPerformed
        // TODO add your handling code here:
        if(year_sem_combo.getSelectedItem().equals("") || year_sem_id.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(year_sem_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "Please select Year and Semester", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Year and Semester ?");
            
            if(x == 0){
                int id = Integer.valueOf(year_sem_id.getText());
                String yearNsem = (String) year_sem_combo.getSelectedItem();
                String ysShortCode = null;
                
                if(yearNsem.equalsIgnoreCase("Year 1 Semester 1") ){
                   ysShortCode = "Y1.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 1 Semester 2") ){
                   ysShortCode = "Y1.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 2 Semester 1") ){
                   ysShortCode = "Y2.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 2 Semester 2") ){
                   ysShortCode = "Y2.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 3 Semester 1") ){
                   ysShortCode = "Y3.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 3 Semester 2") ){
                   ysShortCode = "Y3.S2";
                }
                else if(yearNsem.equalsIgnoreCase("Year 4 Semester 1") ){
                   ysShortCode = "Y4.S1";
                }
                else if(yearNsem.equalsIgnoreCase("Year 4 Semester 2") ){
                   ysShortCode = "Y4.S2";
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Inputs are invalid", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                }
                
                try {
                    if(yearSem.editYearSemester(id,yearNsem,ysShortCode)){
                    JOptionPane.showMessageDialog(rootPane, "Year and Semester Edit Successfully", "Edit Year and Semester", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Updated", "Edit Year and Semester", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        year_sem_id.setText("");
        year_sem_combo.setSelectedItem("Please Select");
        
        year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
        yearSem.loadAllYearSemesters(year_sem_table);
    }//GEN-LAST:event_year_sem_editBtnActionPerformed

    private void year_sem_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_year_sem_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) year_sem_table.getModel();      
        
        int rIndex = year_sem_table.getSelectedRow();
        year_sem_id.setText(model.getValueAt(rIndex, 0).toString());
        year_sem_combo.setSelectedItem(model.getValueAt(rIndex, 1).toString());
    }//GEN-LAST:event_year_sem_tableMouseClicked

    private void year_sem_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(year_sem_combo.getSelectedItem().equals("") || year_sem_id.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(year_sem_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "Please select Year and Semester", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Year and Semester ?");
            
            if(x == 0){
                int id = Integer.valueOf(year_sem_id.getText());               
                try {
                    if(yearSem.deleteYearSemester(id)){
                    JOptionPane.showMessageDialog(rootPane, "Year and Semester Delete Successfully", "Delete Year and Semester", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Year and Semester", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        year_sem_id.setText("");
        year_sem_combo.setSelectedItem("Please Select");
        
        year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
        yearSem.loadAllYearSemesters(year_sem_table);
        
    }//GEN-LAST:event_year_sem_deleteBtnActionPerformed

    private void year_sem_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_clearBtnActionPerformed
        // TODO add your handling code here:
        year_sem_id.setText("");
        year_sem_combo.setSelectedItem("Please Select");
    }//GEN-LAST:event_year_sem_clearBtnActionPerformed

    private void year_sem_tbl_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_tbl_rfshBtnActionPerformed
        // TODO add your handling code here:
        year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
        yearSem.loadAllYearSemesters(year_sem_table);
        year_sem_tbl_srchTxt.setText("");
    }//GEN-LAST:event_year_sem_tbl_rfshBtnActionPerformed

    private void year_sem_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String yearS = year_sem_tbl_srchTxt.getText();
            year_sem_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Short Code"}));
            yearSem.searchYearSemesters(year_sem_table,yearS);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_year_sem_tbl_srchBtnActionPerformed

<<<<<<< HEAD
    private void programme_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_addBtnActionPerformed
        // TODO add your handling code here:
        if(programme_add_txt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Input Field is Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Programme ?");
            
            if(x == 0){
                String programme = programme_add_txt.getText();
                
                try {
                    if(stProgramme.addProgramme(programme)){
                    JOptionPane.showMessageDialog(rootPane, "Programme Added Successfully", "Add Programme", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Programme", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        programme_id.setText("");
        programme_add_txt.setText("");
              
        programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
        stProgramme.loadAllProgrammes(programme_table);
    }//GEN-LAST:event_programme_addBtnActionPerformed

    private void programme_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programme_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) programme_table.getModel();      
        
        int rIndex = programme_table.getSelectedRow();
        programme_id.setText(model.getValueAt(rIndex, 0).toString());
        programme_add_txt.setText(model.getValueAt(rIndex, 1).toString());
    }//GEN-LAST:event_programme_tableMouseClicked

    private void programme_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_editBtnActionPerformed
        // TODO add your handling code here:
        if(programme_add_txt.getText().equals("") || programme_id.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Programme ?");
            
            if(x == 0){
                int id = Integer.valueOf(programme_id.getText());
                String programme = programme_add_txt.getText();
                
                try {
                    if(stProgramme.editProgramme(id,programme)){
                    JOptionPane.showMessageDialog(rootPane, "Programme Edit Successfully", "Edit Programme", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Updated", "Edit Programme", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        programme_id.setText("");
        programme_add_txt.setText("");
              
        programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
        stProgramme.loadAllProgrammes(programme_table);
    }//GEN-LAST:event_programme_editBtnActionPerformed

    private void programme_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(programme_add_txt.getText().equals("") || programme_id.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Programme ?");
            
            if(x == 0){
                int id = Integer.valueOf(programme_id.getText());               
                try {
                    if(stProgramme.deleteProgramme(id)){
                    JOptionPane.showMessageDialog(rootPane, "Programme Delete Successfully", "Delete Programme", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Programme", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        programme_id.setText("");
        programme_add_txt.setText("");
              
        programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
        stProgramme.loadAllProgrammes(programme_table);
    }//GEN-LAST:event_programme_deleteBtnActionPerformed

    private void programme_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_clearBtnActionPerformed
        // TODO add your handling code here:
        programme_id.setText("");
        programme_add_txt.setText("");
    }//GEN-LAST:event_programme_clearBtnActionPerformed

    private void programme_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String programme = programme_tbl_srchTxt.getText();
            programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
            stProgramme.searchProgramme(programme_table,programme);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_programme_tbl_srchBtnActionPerformed

    private void programme_tbl_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programme_tbl_rfshBtnActionPerformed
        // TODO add your handling code here:
        programme_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Programme"}));
        stProgramme.loadAllProgrammes(programme_table);
        programme_tbl_srchTxt.setText("");
    }//GEN-LAST:event_programme_tbl_rfshBtnActionPerformed

    private void grp_no_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_addBtnActionPerformed
        // TODO add your handling code here:
        if(grp_no_add_spinner.getValue().equals("") || grp_no_add_spinner.getValue().equals(0)){
            JOptionPane.showMessageDialog(rootPane, "Input Field is Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Group Number ?");
            
            if(x == 0){
                int groupnumber = (int) grp_no_add_spinner.getValue();
                
                try {
                    if(groupNo.addGroupNumber(groupnumber)){
                    JOptionPane.showMessageDialog(rootPane, "Group Number Added Successfully", "Add Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        grp_no_add_spinner.setValue(0);
              
        grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
        groupNo.loadAllGroupNumbers(grp_no_table);
    }//GEN-LAST:event_grp_no_addBtnActionPerformed

    private void grp_no_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_editBtnActionPerformed
        // TODO add your handling code here:
        if(grp_no_add_spinner.getValue().equals("") || grp_no_add_spinner.getValue().equals(0)){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Group Number ?");
            
            if(x == 0){
                int id = Integer.valueOf(groupNo_IDtxt.getText());
                int group_no = (int) grp_no_add_spinner.getValue();
                
                try {
                    if(groupNo.editGroupNumber(id,group_no)){
                    JOptionPane.showMessageDialog(rootPane, "Group Number Edit Successfully", "Edit Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Updated", "Edit Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        groupNo_IDtxt.setText("");
        grp_no_add_spinner.setValue(0);
              
        grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
        groupNo.loadAllGroupNumbers(grp_no_table);     
        
    }//GEN-LAST:event_grp_no_editBtnActionPerformed

    private void grp_no_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grp_no_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) grp_no_table.getModel();      
        
        int rIndex = grp_no_table.getSelectedRow();
        groupNo_IDtxt.setText(model.getValueAt(rIndex, 0).toString());
        grp_no_add_spinner.setValue(model.getValueAt(rIndex, 1));   
    }//GEN-LAST:event_grp_no_tableMouseClicked

    private void grp_no_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(groupNo_IDtxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Group Number ?");
            
            if(x == 0){
                int id = Integer.valueOf(groupNo_IDtxt.getText());               
                try {
                    if(groupNo.deleteGroupNumber(id)){
                    JOptionPane.showMessageDialog(rootPane, "Group Number Delete Successfully", "Delete Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        groupNo_IDtxt.setText("");
        grp_no_add_spinner.setValue(0);
              
        grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
        groupNo.loadAllGroupNumbers(grp_no_table);
    }//GEN-LAST:event_grp_no_deleteBtnActionPerformed

    private void grp_no_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_clearBtnActionPerformed
        // TODO add your handling code here:
        groupNo_IDtxt.setText("");
        grp_no_add_spinner.setValue(0);
    }//GEN-LAST:event_grp_no_clearBtnActionPerformed

    private void grp_no_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            int srch_grpNo = Integer.valueOf(grp_no_tbl_srchTxt.getText());
            grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
            groupNo.searchGroupNumber(grp_no_table,srch_grpNo);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_grp_no_tbl_srchBtnActionPerformed

    private void grp_no_table_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_no_table_rfshBtnActionPerformed
        // TODO add your handling code here:
        grp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group Number"}));
        groupNo.loadAllGroupNumbers(grp_no_table);
        grp_no_tbl_srchTxt.setText("");
    }//GEN-LAST:event_grp_no_table_rfshBtnActionPerformed

    private void subgrp_no_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_addBtnActionPerformed
        // TODO add your handling code here:
        if(subgrp_no_add_spinner.getValue().equals("") || subgrp_no_add_spinner.getValue().equals(0)){
            JOptionPane.showMessageDialog(rootPane, "Input Field is Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Sub Group Number ?");
            
            if(x == 0){
                int subGroupnumber = (int) subgrp_no_add_spinner.getValue();
                
                try {
                    if(subGroupNo.addSubGroupNumber(subGroupnumber)){
                    JOptionPane.showMessageDialog(rootPane, "Sub Group Number Added Successfully", "Add Sub Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Sub Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        subgrp_no_add_spinner.setValue(0);
              
        subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
        subGroupNo.loadAllSubGroupNumbers(subgrp_no_table);
    }//GEN-LAST:event_subgrp_no_addBtnActionPerformed

    private void subgrp_no_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subgrp_no_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) subgrp_no_table.getModel();      
        
        int rIndex = subgrp_no_table.getSelectedRow();
        subgroupNo_IDtxt.setText(model.getValueAt(rIndex, 0).toString());
        subgrp_no_add_spinner.setValue(model.getValueAt(rIndex, 1));  
    }//GEN-LAST:event_subgrp_no_tableMouseClicked

    private void subgrp_no_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_editBtnActionPerformed
        // TODO add your handling code here:
        if(subgrp_no_add_spinner.getValue().equals("") || subgrp_no_add_spinner.getValue().equals(0)){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Sub Group Number ?");
            
            if(x == 0){
                int id = Integer.valueOf(subgroupNo_IDtxt.getText());
                int subGroup_no = (int) subgrp_no_add_spinner.getValue();
                
                try {
                    if(subGroupNo.editSubGroupNumber(id,subGroup_no)){
                    JOptionPane.showMessageDialog(rootPane, "Sub Group Number Edit Successfully", "Edit Sub Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } 
                catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Updated", "Edit Sub Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        subgroupNo_IDtxt.setText("");
        subgrp_no_add_spinner.setValue(0);
              
        subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
        subGroupNo.loadAllSubGroupNumbers(subgrp_no_table); 
    }//GEN-LAST:event_subgrp_no_editBtnActionPerformed

    private void subgrp_no_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(subgroupNo_IDtxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Sub Group Number ?");
            
            if(x == 0){
                int id = Integer.valueOf(subgroupNo_IDtxt.getText());               
                try {
                    if(subGroupNo.deleteSubGroupNumber(id)){
                    JOptionPane.showMessageDialog(rootPane, "Sub Group Number Delete Successfully", "Delete Sub Group Number", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Sub Group Number", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        subgroupNo_IDtxt.setText("");
        subgrp_no_add_spinner.setValue(0);
              
        subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
        subGroupNo.loadAllSubGroupNumbers(subgrp_no_table);
    }//GEN-LAST:event_subgrp_no_deleteBtnActionPerformed

    private void subgrp_no_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_clearBtnActionPerformed
        // TODO add your handling code here:
        subgroupNo_IDtxt.setText("");
        subgrp_no_add_spinner.setValue(0);
    }//GEN-LAST:event_subgrp_no_clearBtnActionPerformed

    private void subgrp_no_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            int srch_subgrpNo = Integer.valueOf(subgrp_no_tbl_srchTxt.getText());
            subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
            subGroupNo.searchSubGroupNumber(subgrp_no_table,srch_subgrpNo);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_subgrp_no_tbl_srchBtnActionPerformed

    private void subgrp_no_table_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_no_table_rfshBtnActionPerformed
        // TODO add your handling code here:
        subgrp_no_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Sub Group Number"}));
        subGroupNo.loadAllSubGroupNumbers(subgrp_no_table);
        subgrp_no_tbl_srchTxt.setText("");
    }//GEN-LAST:event_subgrp_no_table_rfshBtnActionPerformed

    private void grp_id_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_addBtnActionPerformed
        // TODO add your handling code here:
        if(grp_id_year_combo.getSelectedItem().equals("") || grp_id_programme_combo.getSelectedItem().equals("") || grp_id_grpNo_combo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(grp_id_year_combo.getSelectedItem().equals("Please Select") || grp_id_programme_combo.getSelectedItem().equals("Please Select") || grp_id_grpNo_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Group ID ?");
            
            if(x == 0){
                String yearSem = (String) grp_id_year_combo.getSelectedItem();
                String programme = (String) grp_id_programme_combo.getSelectedItem();
                String groupNo = (String) grp_id_grpNo_combo.getSelectedItem();

                String groupID = yearSem +"."+programme +"."+ groupNo;
                
                try {
                    if(groupIDs.addGroupID(yearSem,programme,groupNo,groupID)){
                    JOptionPane.showMessageDialog(rootPane, "Group ID Added Successfully", "Add Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        grp_id_grpNo_IDtxt.setText("");
        grp_id_year_combo.setSelectedItem("Please Select");
        grp_id_programme_combo.setSelectedItem("Please Select");
        grp_id_grpNo_combo.setSelectedItem("Please Select");
              
        grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(grp_id_table);
        
    }//GEN-LAST:event_grp_id_addBtnActionPerformed

    private void grp_id_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grp_id_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) grp_id_table.getModel();      
        
        int rIndex = grp_id_table.getSelectedRow();
        
        groupIdRowTxt.setText(model.getValueAt(rIndex, 0).toString());
        grp_id_year_combo.setSelectedItem(model.getValueAt(rIndex, 1).toString());
        grp_id_programme_combo.setSelectedItem(model.getValueAt(rIndex, 2).toString());
        grp_id_grpNo_combo.setSelectedItem(model.getValueAt(rIndex, 3).toString());
        grp_id_grpNo_IDtxt.setText(model.getValueAt(rIndex, 4).toString());
        
    }//GEN-LAST:event_grp_id_tableMouseClicked

    private void grp_id_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_editBtnActionPerformed
        // TODO add your handling code here:
        if(groupIdRowTxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(grp_id_year_combo.getSelectedItem().equals("") || grp_id_programme_combo.getSelectedItem().equals("") || grp_id_grpNo_combo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(grp_id_year_combo.getSelectedItem().equals("Please Select") || grp_id_programme_combo.getSelectedItem().equals("Please Select") || grp_id_grpNo_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Group ID ?");
            
            if(x == 0){
                int id = Integer.valueOf(groupIdRowTxt.getText());
                String yearSem = (String) grp_id_year_combo.getSelectedItem();
                String programme = (String) grp_id_programme_combo.getSelectedItem();
                String groupNo = (String) grp_id_grpNo_combo.getSelectedItem();

                String groupID = yearSem +"."+programme +"."+ groupNo;
                
                try {
                    if(groupIDs.editGroupID(id, yearSem, programme, groupNo, groupID)){
                    JOptionPane.showMessageDialog(rootPane, "Group ID Edit Successfully", "Edit Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Edit Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        groupIdRowTxt.setText("");
        grp_id_grpNo_IDtxt.setText("");
        grp_id_year_combo.setSelectedItem("Please Select");
        grp_id_programme_combo.setSelectedItem("Please Select");
        grp_id_grpNo_combo.setSelectedItem("Please Select");
              
        grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(grp_id_table);
    }//GEN-LAST:event_grp_id_editBtnActionPerformed

    private void grp_id_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(groupIdRowTxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Group ID ?");
            
            if(x == 0){
                int id = Integer.valueOf(groupIdRowTxt.getText());               
                try {
                    if(groupIDs.deleteGroupID(id)){
                    JOptionPane.showMessageDialog(rootPane, "Group ID Delete Successfully", "Delete Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        groupIdRowTxt.setText("");
        grp_id_grpNo_IDtxt.setText("");
        grp_id_year_combo.setSelectedItem("Please Select");
        grp_id_programme_combo.setSelectedItem("Please Select");
        grp_id_grpNo_combo.setSelectedItem("Please Select");
              
        grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(grp_id_table);
    }//GEN-LAST:event_grp_id_deleteBtnActionPerformed

    private void grp_id_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_clearBtnActionPerformed
        // TODO add your handling code here:
        groupIdRowTxt.setText("");
        grp_id_grpNo_IDtxt.setText("");
        grp_id_year_combo.setSelectedItem("Please Select");
        grp_id_programme_combo.setSelectedItem("Please Select");
        grp_id_grpNo_combo.setSelectedItem("Please Select");
    }//GEN-LAST:event_grp_id_clearBtnActionPerformed

    private void grp_id_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String srch_grpID = grp_id_tbl_srchTxt.getText();
            grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
            groupIDs.searchGroupID(grp_id_table,srch_grpID);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_grp_id_tbl_srchBtnActionPerformed

    private void grp_id_table_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_table_rfshBtnActionPerformed
        // TODO add your handling code here:
        grp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(grp_id_table);
        grp_id_tbl_srchTxt.setText("");
    }//GEN-LAST:event_grp_id_table_rfshBtnActionPerformed

    private void subgrp_id_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_addBtnActionPerformed
        // TODO add your handling code here:
        if(subgrp_id_grp_combo.getSelectedItem().equals("") || subgrp_id_grpNo_combo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(subgrp_id_grp_combo.getSelectedItem().equals("Please Select") || subgrp_id_grpNo_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Add this Sub Group ID ?");
            
            if(x == 0){
                String grpID = (String) subgrp_id_grp_combo.getSelectedItem();
                String subGrpNo = (String) subgrp_id_grpNo_combo.getSelectedItem();

                String subGroupID = grpID +"."+subGrpNo;
                
                try {
                    if(subGrpIDs.addSubGroupID(grpID,subGrpNo,subGroupID)){
                    JOptionPane.showMessageDialog(rootPane, "Sub Group ID Added Successfully", "Add Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Fill Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Add Sub Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        sub_grp_id_grpNo_IDtxt.setText("");
        subgrp_id_grpNo_combo.setSelectedItem("Please Select");
        subgrp_id_grp_combo.setSelectedItem("Please Select");
              
        subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(subgrp_id_table);
    }//GEN-LAST:event_subgrp_id_addBtnActionPerformed

    private void subgrp_id_editBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_editBtnActionPerformed
        // TODO add your handling code here:
        if(subGroupIdRowTxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(subgrp_id_grp_combo.getSelectedItem().equals("") || subgrp_id_grpNo_combo.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else if(subgrp_id_grp_combo.getSelectedItem().equals("Please Select") || subgrp_id_grpNo_combo.getSelectedItem().equals("Please Select")){
            JOptionPane.showMessageDialog(rootPane, "One Or More Fields Are Empty", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Edit this Sub Group ID ?");
            
            if(x == 0){
                int id = Integer.valueOf(subGroupIdRowTxt.getText());
                String grpID = (String) subgrp_id_grp_combo.getSelectedItem();
                String subGrpNo = (String) subgrp_id_grpNo_combo.getSelectedItem();

                String subGroupID = grpID +"."+subGrpNo;
                
                try {
                    if(subGrpIDs.editSubGroupID(id, grpID, subGrpNo, subGroupID)){
                        JOptionPane.showMessageDialog(rootPane, "Sub Group ID Edit Successfully", "Efit ub Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Edit Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (HeadlessException e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Inserted", "Edit Sub Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        subGroupIdRowTxt.setText("");
        sub_grp_id_grpNo_IDtxt.setText("");
        subgrp_id_grpNo_combo.setSelectedItem("Please Select");
        subgrp_id_grp_combo.setSelectedItem("Please Select");
              
        subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(subgrp_id_table);
    }//GEN-LAST:event_subgrp_id_editBtnActionPerformed

    private void subgrp_id_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subgrp_id_tableMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) subgrp_id_table.getModel();      
        
        int rIndex = subgrp_id_table.getSelectedRow();
        
        subGroupIdRowTxt.setText(model.getValueAt(rIndex, 0).toString());
        subgrp_id_grp_combo.setSelectedItem(model.getValueAt(rIndex, 1).toString());
        subgrp_id_grpNo_combo.setSelectedItem(model.getValueAt(rIndex, 2).toString());
        sub_grp_id_grpNo_IDtxt.setText(model.getValueAt(rIndex, 3).toString());
    }//GEN-LAST:event_subgrp_id_tableMouseClicked

    private void subgrp_id_deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_deleteBtnActionPerformed
        // TODO add your handling code here:
        if(subGroupIdRowTxt.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Please select row in the table OR Invalid Data", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            int x = JOptionPane.showConfirmDialog(null, "Do You Want To Delete this Sub Group ID ?");
            
            if(x == 0){
                int id = Integer.valueOf(subGroupIdRowTxt.getText());               
                try {
                    if(subGrpIDs.deleteSubGroupID(id)){
                    JOptionPane.showMessageDialog(rootPane, "Sub Group ID Delete Successfully", "Delete Sub Group ID", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Already exists or inavid data. Please check...", "Delete Details Error", JOptionPane.ERROR_MESSAGE);
                    }  
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Data Not Deleted", "Delete Sub Group ID", JOptionPane.WARNING_MESSAGE);
            }
            
        }
        
        subGroupIdRowTxt.setText("");
        sub_grp_id_grpNo_IDtxt.setText("");
        subgrp_id_grpNo_combo.setSelectedItem("Please Select");
        subgrp_id_grp_combo.setSelectedItem("Please Select");
              
        subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(subgrp_id_table);
    }//GEN-LAST:event_subgrp_id_deleteBtnActionPerformed

    private void subgrp_id_clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_clearBtnActionPerformed
        // TODO add your handling code here:
        subGroupIdRowTxt.setText("");
        sub_grp_id_grpNo_IDtxt.setText("");
        subgrp_id_grpNo_combo.setSelectedItem("Please Select");
        subgrp_id_grp_combo.setSelectedItem("Please Select");
    }//GEN-LAST:event_subgrp_id_clearBtnActionPerformed

    private void subgrp_id_tbl_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_tbl_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String srch_subGrpID = subgrp_id_tbl_srchTxt.getText();
            subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
            subGrpIDs.searchSubGroupID(subgrp_id_table,srch_subGrpID);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_subgrp_id_tbl_srchBtnActionPerformed

    private void subgrp_id_table_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subgrp_id_table_rfshBtnActionPerformed
        // TODO add your handling code here:
        subgrp_id_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
        subGrpIDs.loadAllSubGroupIDs(subgrp_id_table);
        subgrp_id_tbl_srchTxt.setText("");
    }//GEN-LAST:event_subgrp_id_table_rfshBtnActionPerformed

    private void view_stGrp_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_stGrp_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String srch_grpID = view_stGrp_srchTxt.getText();
            view_stGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
            groupIDs.searchGroupID(view_stGrp_table,srch_grpID);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_view_stGrp_srchBtnActionPerformed

    private void view_stDrp_rfshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_stDrp_rfshBtnActionPerformed
        // TODO add your handling code here:
        view_stGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Year and Semester","Programme","Group Number","Group ID"}));
        groupIDs.loadAllGroupIDs(view_stGrp_table);
        view_stGrp_srchTxt.setText("");
    }//GEN-LAST:event_view_stDrp_rfshBtnActionPerformed

    private void view_stSubGrp_srchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_stSubGrp_srchBtnActionPerformed
        // TODO add your handling code here:
        try {
            String srch_sub_grpID = view_stSubGrp_srchTxt.getText();
            view_stSubGrp_table.setModel(new DefaultTableModel(null, new Object[]{"ID","Group ID","Sub Group Number","Sub Group ID"}));
            subGrpIDs.searchSubGroupID(view_stSubGrp_table,srch_sub_grpID);
            
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_view_stSubGrp_srchBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
        homePage.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void grp_id_year_comboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_grp_id_year_comboMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_grp_id_year_comboMouseClicked

=======
    private void year_sem_comboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_sem_comboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_year_sem_comboActionPerformed

    private void grp_id_addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grp_id_addBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grp_id_addBtnActionPerformed

>>>>>>> 292a7cc2d1be83f17397746b09e846846eededea
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
            java.util.logging.Logger.getLogger(StudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentsPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentsPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allPanels;
    private javax.swing.JPanel groupFrame;
    private javax.swing.JLabel groupIdRowTxt;
    private javax.swing.JLabel groupNo_IDtxt;
    private javax.swing.JPanel groupTab;
    private javax.swing.JButton grp_id_addBtn;
    private javax.swing.JButton grp_id_clearBtn;
    private javax.swing.JButton grp_id_deleteBtn;
    private javax.swing.JButton grp_id_editBtn;
    private javax.swing.JLabel grp_id_grpNo_IDtxt;
    private javax.swing.JComboBox<String> grp_id_grpNo_combo;
    private javax.swing.JComboBox<String> grp_id_programme_combo;
    private javax.swing.JTable grp_id_table;
    private javax.swing.JButton grp_id_table_rfshBtn;
    private javax.swing.JButton grp_id_tbl_srchBtn;
    private javax.swing.JTextField grp_id_tbl_srchTxt;
    private javax.swing.JComboBox<String> grp_id_year_combo;
    private javax.swing.JButton grp_no_addBtn;
    private javax.swing.JSpinner grp_no_add_spinner;
    private javax.swing.JButton grp_no_clearBtn;
    private javax.swing.JButton grp_no_deleteBtn;
    private javax.swing.JButton grp_no_editBtn;
    private javax.swing.JTable grp_no_table;
    private javax.swing.JButton grp_no_table_rfshBtn;
    private javax.swing.JButton grp_no_tbl_srchBtn;
    private javax.swing.JTextField grp_no_tbl_srchTxt;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JPanel notavailableFrame;
    private javax.swing.JPanel notavailableTab;
    private javax.swing.JPanel programmeFrame;
    private javax.swing.JPanel programmeTab;
    private javax.swing.JButton programme_addBtn;
    private javax.swing.JTextField programme_add_txt;
    private javax.swing.JButton programme_clearBtn;
    private javax.swing.JButton programme_deleteBtn;
    private javax.swing.JButton programme_editBtn;
    private javax.swing.JLabel programme_id;
    private javax.swing.JTable programme_table;
    private javax.swing.JButton programme_tbl_rfshBtn;
    private javax.swing.JButton programme_tbl_srchBtn;
    private javax.swing.JTextField programme_tbl_srchTxt;
    private javax.swing.JLabel subGroupIdRowTxt;
    private javax.swing.JLabel sub_grp_id_grpNo_IDtxt;
    private javax.swing.JPanel subgroupFrame;
    private javax.swing.JLabel subgroupNo_IDtxt;
    private javax.swing.JPanel subgroupTab;
    private javax.swing.JButton subgrp_id_addBtn;
    private javax.swing.JButton subgrp_id_clearBtn;
    private javax.swing.JButton subgrp_id_deleteBtn;
    private javax.swing.JButton subgrp_id_editBtn;
    private javax.swing.JComboBox<String> subgrp_id_grpNo_combo;
    private javax.swing.JComboBox<String> subgrp_id_grp_combo;
    private javax.swing.JTable subgrp_id_table;
    private javax.swing.JButton subgrp_id_table_rfshBtn;
    private javax.swing.JButton subgrp_id_tbl_srchBtn;
    private javax.swing.JTextField subgrp_id_tbl_srchTxt;
    private javax.swing.JButton subgrp_no_addBtn;
    private javax.swing.JSpinner subgrp_no_add_spinner;
    private javax.swing.JButton subgrp_no_clearBtn;
    private javax.swing.JButton subgrp_no_deleteBtn;
    private javax.swing.JButton subgrp_no_editBtn;
    private javax.swing.JTable subgrp_no_table;
    private javax.swing.JButton subgrp_no_table_rfshBtn;
    private javax.swing.JButton subgrp_no_tbl_srchBtn;
    private javax.swing.JTextField subgrp_no_tbl_srchTxt;
    private javax.swing.JPanel viewFrame;
    private javax.swing.JPanel viewTab;
    private javax.swing.JButton view_stDrp_rfshBtn;
    private javax.swing.JButton view_stGrp_srchBtn;
    private javax.swing.JTextField view_stGrp_srchTxt;
    private javax.swing.JTable view_stGrp_table;
    private javax.swing.JButton view_stSubDrp_rfshBtn;
    private javax.swing.JButton view_stSubGrp_srchBtn;
    private javax.swing.JTextField view_stSubGrp_srchTxt;
    private javax.swing.JTable view_stSubGrp_table;
    private javax.swing.JPanel yearFrame;
    private javax.swing.JPanel yearTab;
    private javax.swing.JButton year_sem_addBtn;
    private javax.swing.JButton year_sem_clearBtn;
    private javax.swing.JComboBox<String> year_sem_combo;
    private javax.swing.JButton year_sem_deleteBtn;
    private javax.swing.JButton year_sem_editBtn;
    private javax.swing.JLabel year_sem_id;
    private javax.swing.JTable year_sem_table;
    private javax.swing.JButton year_sem_tbl_rfshBtn;
    private javax.swing.JButton year_sem_tbl_srchBtn;
    private javax.swing.JTextField year_sem_tbl_srchTxt;
    // End of variables declaration//GEN-END:variables
}
