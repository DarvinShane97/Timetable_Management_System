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
public class Lecturer {
    
     DBconnect my_connection = new DBconnect();
    
      //CREATE A FUNCTION TO EDIT SUPPLIERS
      public boolean editLecturer(String employeeID, String name, String faculty, String department, String center, String building, String level, String rank){
            
             PreparedStatement st;
        
       // String editQuery = "UPDATE `supplier_table` SET `nic`=?,`company`=?,`fname`=?,`lname`=?,`phone`=?,`email`=?,`address`=? WHERE `id`=?";      
        String editQuery = "UPDATE `lecturers` SET `name`=?,`faculty`=?,`department`=?,`center`=?,`building`=?,`level`=?,`rank`=? WHERE `employee_id`=?";
                
        try{
            st = my_connection.createConnection().prepareStatement(editQuery);
            st.setString(1, name);
            st.setString(2, faculty);
            st.setString(3, department);
            st.setString(4, center);
            st.setString(5, building);
            st.setString(6, level);
            st.setString(7, rank);    
            st.setString(8, employeeID);
            
            return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
               return false;
        }
      }
    //CREATE A FUNCTION TO REMOVE CLIENT
    public boolean removeLecturer(String employeeID){
      
        PreparedStatement st; 
        String deleteQuery = "DELETE FROM `lecturers` WHERE `employee_id`=?";
 
        try{
            st = my_connection.createConnection().prepareStatement(deleteQuery);
            st.setString(1, employeeID);
          
          return (st.executeUpdate() > 0);
            
        } catch (SQLException ex) {
                return false;
        }
          
    }
    
       
    //CREATE A FUNCTION TO POPULATE THE JTABLE WITH ALL CLIENTS IN THE DATABASE
    public void fillLecturersJTable1(JTable table){
        
        PreparedStatement ps;
        ResultSet rs;
        
        String selectQuery = "SELECT * FROM `lecturers`";
        
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
