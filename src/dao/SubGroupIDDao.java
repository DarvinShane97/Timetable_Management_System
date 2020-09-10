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
public class SubGroupIDDao {
    DBconnect dbConnection = new DBconnect();
    
    public boolean addSubGroupID(String grpID, String subGrpNo, String subGrp_id){
     
        PreparedStatement st; 
        String addQuery = "INSERT INTO `sub_group_ids`(`group_ID`,`subGrp_No`,`subGrp_ID`) VALUES ('"+grpID+"','"+subGrpNo+"','"+subGrp_id+"')";
        try {
            st = DBconnect.createConnection().prepareStatement(addQuery); 
            return (st.executeUpdate() > 0);
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
                  
    }
    
    public boolean editSubGroupID(int id, String grpID, String subGrpNo, String subGrp_id){
            
        PreparedStatement st;
        String editQuery = "UPDATE `sub_group_ids` SET `group_ID`=?, `subGrp_No`=?, `subGrp_ID`=? WHERE `S_ID`=?";
        try{
            st = DBconnect.createConnection().prepareStatement(editQuery);
            st.setString(1, grpID);
            st.setString(2, subGrpNo);
            st.setString(3, subGrp_id);
            st.setInt(4, id);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
               return false;
        }
    }
    
    public boolean deleteSubGroupID(int id){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `sub_group_ids` WHERE `S_ID`=?";
 
        try{
            st = DBconnect.createConnection().prepareStatement(deleteQuery);
            st.setInt(1, id);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
          
    }
    
    public void loadAllSubGroupIDs(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `sub_group_ids` ORDER BY S_ID ASC";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
        
    }
    
    public void searchSubGroupID(JTable table,String subGroupID){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT `S_ID`, `group_ID`, `subGrp_No`, `subGrp_ID` FROM `sub_group_ids` WHERE `subGrp_ID` LIKE '%" + subGroupID + "%'";
        
        try{
            ps = DBconnect.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               System.out.println(ex);
        }
    }
}
