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
public class GroupIDDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addGroupID(String yearSem, String programme, String groupNo, String grpID){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `group_ids`(`yearSem`,`programme`,`grp_No`,`grp_ID`) VALUES ('"+yearSem+"','"+programme+"','"+groupNo+"','"+grpID+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editGroupID(int id, String yearSem, String programme, String groupNo, String grpID){
            
        PreparedStatement st;
        String editQuery = "UPDATE `group_ids` SET `yearSem`=?, `programme`=?, `grp_No`=?, `grp_ID`=? WHERE `ID`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setString(1, yearSem);
            st.setString(2, programme);
            st.setString(3, groupNo);
            st.setString(4, grpID);
            st.setInt(5, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteGroupID(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `group_ids` WHERE `ID`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllGroupIDs(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `group_ids` ORDER BY ID ASC";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
        
    }
    
    public void searchGroupID(JTable table,String groupID){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `ID`, `yearSem`, `programme`, `grp_No`, `grp_ID` FROM `group_ids` WHERE `grp_ID` LIKE '%" + groupID + "%'";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[5];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
    }
}
