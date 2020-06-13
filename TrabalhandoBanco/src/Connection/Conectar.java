package Connection;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Conectar {

    public Connection con;
    public Statement stmt;
    public ResultSet rs;

    String url = "jdbc:mysql://localhost:3306/agenda";
    String user = "root";
    String password = "";
    String driver = "com.mysql.jdbc.Driver";

    public void openConnection() {

        try {

            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de Dados!", "ERRO", JOptionPane.ERROR_MESSAGE, null);

        }
    }

}
