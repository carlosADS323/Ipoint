package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectionFactory {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/agenda";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    public Connection con;
    public Statement stmt;
    public ResultSet rs;
    
    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão");
        }
    }
    
 

    public static void closeConnection(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException err) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, err);

        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt) {
        closeConnection(con);
        try {
            if (stmt != null);
            stmt.close();
        } catch (SQLException err) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, err);

        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        closeConnection(con, stmt);
        try {
            if (rs != null);
            rs.close();
        } catch (SQLException err) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, err);
        }
    }

  
   

}