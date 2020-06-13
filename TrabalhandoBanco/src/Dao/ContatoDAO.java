package Dao;

import Connection.ConnectionFactory;
import java.sql.*;
import java.util.*;
import Dao.ContatoDAO;
import Controle.Contato;
import javax.swing.JOptionPane;

public class ContatoDAO {

    public void create(Contato p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO tabela(nome, ddd, tel) VALUES (?, ?, ?)");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDdd());
            stmt.setString(3, p.getTel());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "SALVO COM SUCESSO!");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR!" + err);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public List<Contato> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Contato> listaContatos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM tabela");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Contato contato = new Contato();
                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setDdd(rs.getString("ddd"));
                contato.setTel(rs.getString("tel"));
                listaContatos.add(contato);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ERRO DE LEITURA" + err);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return listaContatos;
    }

    public void update(Contato p) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE tabela SET nome = ?, ddd = ?, tel = ? WHERE id = ?");
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDdd());
            stmt.setString(3, p.getTel());
            stmt.setInt(4, p.getId());
            stmt.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR" + err);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }
    
    public void delete(Contato c){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt = con.prepareStatement("DELETE FROM tabela WHERE id = ?");
            stmt.setInt(1, c.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "DELETADO COM SUCESSO!");
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR!" + err);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List <Contato> readForDesc (String desc) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List <Contato> contato = new ArrayList<>();
        try{
            stmt = con.prepareStatement("SELECT * FROM tabela WHERE nome LIKE ?");
            stmt.setString(1, "%" + desc + "%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Contato cont = new Contato();
                cont.setId(rs.getInt("id"));
                cont.setNome(rs.getString("nome"));
                cont.setDdd(rs.getString("ddd"));
                cont.setTel(rs.getString("tel"));
                contato.add(cont);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, "Erro de Leitura " + err);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return contato;
    }
}
