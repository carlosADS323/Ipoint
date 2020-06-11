package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static Connection conn;
    private static final String Driver = "com.mysql.jdbc.Driver";
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/dados";

    public static Connection getConexao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Conexao() {
        conn = null;
        try {
            Class.forName(Driver);
            conn = (Connection) DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Conexão com Banco de Dados estabelecida com sucesso!");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erro ao conectar com Banco de Dados!" + e);
        }

    }

    public Connection getConnection() {
        return conn;
    }

    public void desconectar() {
        conn = null;
        if (conn == null) {
            System.out.println("Conexão com Banco de Dados finalizada com sucesso!");
        }
    }

}