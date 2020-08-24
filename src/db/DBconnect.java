package db;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author acer
 */
public class DBconnect {
    public static Connection createConnection(){
    
        Connection connection = null;
        
        MysqlDataSource mds = new MysqlDataSource();
        
        mds.setServerName("localhost");
        mds.setPortNumber(3306);
        mds.setUser("root");
        mds.setPassword("");
        mds.setDatabaseName("timetable_management_system");
        
        try {
            connection = (Connection) mds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DBconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return connection;
    }

    public PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

