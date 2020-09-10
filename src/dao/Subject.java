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
 * @author HP
 */
public class Subject {
    
    DBconnect my_connection = new DBconnect();
    
      //CREATE A FUNCTION TO EDIT SUPPLIERS
      public boolean editSubject(String subject_code, String offered_year, String offered_semester, String subject_name, String lec_hours, String tute_hours, String lab_hours, String evaluation_hours){
            
             PreparedStatement st;
        
       // String editQuery = "UPDATE `supplier_table` SET `nic`=?,`company`=?,`fname`=?,`lname`=?,`phone`=?,`email`=?,`address`=? WHERE `id`=?";      
        String editQuery = "UPDATE `subjects` SET `offered_year`=?,`offered_semester`=?,`subject_name`=?,`no_lec_hours`=?,`no_tute_hours`=?,`no_lab_hours`=?,`no_evaluation_hours`=? WHERE `subject_code`=?";
        
        try{
            st = my_connection.createConnection().prepareStatement(editQuery);
            st.setString(1, offered_year);
            st.setString(2, offered_semester);
            st.setString(3, subject_name);
            st.setString(4, lec_hours);
            st.setString(5, tute_hours);
            st.setString(6, lab_hours);    
            st.setString(7, evaluation_hours);
            st.setString(8, subject_code);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
               return false;
        }
      }
    //CREATE A FUNCTION TO REMOVE CLIENT
    public boolean removeSubject(String subject_code){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `subjects` WHERE `subject_code`=?";
 
        try{
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            st.setString(1, subject_code);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
                return false;
        }
          
    }
    
       
    //CREATE A FUNCTION TO POPULATE THE JTABLE WITH ALL CLIENTS IN THE DATABASE
    public void fillSubjectJTable1(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `subjects`";
        
        try{
            ps = my_connection.createConnection().prepareStatement(selectQuery);
            rs = ps.executeQuery();
            
            DefaultTableModel tableModel = (DefaultTableModel)table.getModel(); 
            Object[] row;
            
            while(rs.next()){    
                row = new Object[8];
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                row[4] = rs.getString(5);
                row[5] = rs.getString(6);
                row[6] = rs.getString(7);
                row[7] = rs.getString(8);
                
                tableModel.addRow(row);
            }
         
        } catch (SQLException ex) {
               
        }
    }
}
