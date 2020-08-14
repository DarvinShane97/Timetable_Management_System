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
public class YearSemDao {
    
    DBconnect dbConnection = new DBconnect();
    
    public boolean addYearSem(String yearsem,String shortCode){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `year_semester`(`year_sem`,`yr_shortCode`) VALUES ('"+yearsem+"','"+shortCode+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editYearSemester(int id, String yearSem,String shortCode){
            
        PreparedStatement st;
        String editQuery = "UPDATE `year_semester` SET `year_sem`=?, `yr_shortCode`=? WHERE `yr_id`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setString(1, yearSem);
            st.setString(2, shortCode);
            st.setInt(3, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteYearSemester(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `year_semester` WHERE `yr_id`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllYearSemesters(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `year_semester` ORDER BY yr_id ASC";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
        
    }
    
    public void searchYearSemesters(JTable table,String shortCode){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `yr_id`, `year_sem`, `yr_shortCode` FROM `year_semester` WHERE `yr_shortCode` LIKE '%" + shortCode + "%'";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[3];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
    }
}
