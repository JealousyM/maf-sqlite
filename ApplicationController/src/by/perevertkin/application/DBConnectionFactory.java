package by.perevertkin.application;

import java.sql.Connection;

import java.sql.SQLException;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.util.Utility;

public class DBConnectionFactory {
    private static Connection conn = null;
    public DBConnectionFactory() {
        super();
    }
    
    public static Connection getConnection() throws Exception {
        if (conn == null) {
          try {
            String dirRoot = AdfmfJavaUtilities.getDirectoryPathRoot(AdfmfJavaUtilities.ApplicationDirectory);
            String connStr = "jdbc:sqlite:" + dirRoot + "/dbapp.db";
            conn = new SQLite.JDBCDataSource(connStr).getConnection();
                
          } catch (SQLException e) {
              Utility.ApplicationLogger.severe(e.getMessage());
          }
        }

        return conn;
      }
    
    public static void closeConnection() {
       try {
         if (conn != null) {
           conn.close();
           conn = null;
         }
       } catch (Exception ex) {
         throw new RuntimeException(ex);
       }
     }
}
