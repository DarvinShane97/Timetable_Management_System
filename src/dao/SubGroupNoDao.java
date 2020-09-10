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
public class SubGroupNoDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addSubGroupNumber(int subGroupNo){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `sub_group_numbers`(`sub_group_number`) VALUES ('"+subGroupNo+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editSubGroupNumber(int id, int subGroupNo){
            
        PreparedStatement st;
        String editQuery = "UPDATE `sub_group_numbers` SET `sub_group_number`=? WHERE `s_id`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setInt(1, subGroupNo);
            st.setInt(2, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteSubGroupNumber(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `sub_group_numbers` WHERE `s_id`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllSubGroupNumbers(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `sub_group_numbers` ORDER BY s_id ASC";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[2];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
        
    }
    
    public void searchSubGroupNumber(JTable table,int subGroupNo){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `s_id`, `sub_group_number` FROM `sub_group_numbers` WHERE `sub_group_number` LIKE '%" + subGroupNo + "%'";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[2];
                row[0] = rs.getInt(1);
                row[1] = rs.getInt(2);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
    }
}
