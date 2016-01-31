package by.perevertkin.mobile;

import by.perevertkin.application.DBConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import oracle.adfmf.util.Utility;
import by.perevertkin.application.DBConnectionFactory;

public class DBAdapter {
    
          public DBAdapter() {
            super();
          }
    
    protected boolean executeUpdate(String query) {
       boolean success = false;
       try {
         Connection conn = DBConnectionFactory.getConnection();
         Statement stmt = conn.createStatement();
         int rowCount = stmt.executeUpdate(query);

         if (rowCount > 0) {
           success = true;
           Utility.ApplicationLogger.severe("RowCount=" + rowCount + ", Query=" + query);
         }

       } catch (Exception e) {
         Utility.ApplicationLogger.severe(e.getMessage());
         e.printStackTrace();
         throw new RuntimeException(e);

       } finally {
         DBConnectionFactory.closeConnection();
       }
       return success;
     }

     protected ResultSet executeQuery(String query) {
       ResultSet result = null;

       try {
         Connection conn = DBConnectionFactory.getConnection();
         Statement stmt = conn.createStatement();
         result = stmt.executeQuery(query);

       } catch (Exception ex) {
         Utility.ApplicationLogger.severe(ex.getMessage());
         ex.printStackTrace();
         throw new RuntimeException(ex);

       } finally {
         DBConnectionFactory.closeConnection();
       }

       return result;
     }
    }
