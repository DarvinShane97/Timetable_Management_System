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
public class TagsDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addTag(String tag){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `tags`(`tag_name`) VALUES ('"+tag+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editTag(int id, String tag){
            
        PreparedStatement st;
        String editQuery = "UPDATE `tags` SET `tag_name`=? WHERE `tag_id`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setString(1, tag);
            st.setInt(2, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteTag(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `tags` WHERE `tag_id`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllTags(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `tags` ORDER BY tag_id ASC";
        
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
    
    public void searchTag(JTable table,String tag){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `tag_id`, `tag_name` FROM `tags` WHERE `tag_name` LIKE '%" + tag + "%'";
        
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
