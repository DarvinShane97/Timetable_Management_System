/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import db.DBconnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class ProgrammeDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addProgramme(String programme){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `student_programmes`(`programme_name`) VALUES ('"+programme+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editProgramme(int id, String programme){
            
        PreparedStatement st;
        String editQuery = "UPDATE `student_programmes` SET `programme_name`=? WHERE `programme_id`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setString(1, programme);
            st.setInt(2, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteProgramme(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `student_programmes` WHERE `programme_id`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllProgrammes(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `student_programmes` ORDER BY programme_id ASC";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[2];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
        
    }
    
    public void searchProgramme(JTable table,String programme){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `programme_id`, `programme_name` FROM `student_programmes` WHERE `programme_name` LIKE '%" + programme + "%'";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[2];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
    }
}
