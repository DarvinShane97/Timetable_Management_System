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
public class GroupNoDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addGroupNumber(int groupNo){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `group_numbers`(`group_number`) VALUES ('"+groupNo+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editGroupNumber(int id, int groupNo){
            
        PreparedStatement st;
        String editQuery = "UPDATE `group_numbers` SET `group_number`=? WHERE `g_id`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setInt(1, groupNo);
            st.setInt(2, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteGroupNumber(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `group_numbers` WHERE `g_id`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllGroupNumbers(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `group_numbers` ORDER BY g_id ASC";
        
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
    
    public void searchGroupNumber(JTable table,int groupNo){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `g_id`, `group_number` FROM `group_numbers` WHERE `group_number` LIKE '%" + groupNo + "%'";
        
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
