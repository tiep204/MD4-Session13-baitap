package ra.model.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/servlet_crud_test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dangtiep204";
    public static Connection openConnection(){
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    public static void closeConnection(Connection conn , CallableStatement call){
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (call!=null){
            try {
                call.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
