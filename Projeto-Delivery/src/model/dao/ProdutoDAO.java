package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.bean.Produto;

/**
 *
 * @author rafael
 */
public class ProdutoDAO {

    public void create(Produto objProduto) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "INSERT INTO Produto "
                    + "(Nome,Tipo,Preco) "
                    + "VALUES "
                    + "(?,?,?)");

            stmt.setString(1, objProduto.getNome());
            stmt.setString(2, objProduto.getTipo());
            stmt.setInt(3, objProduto.getPreco());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        
        } catch (java.lang.NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Insira apenas numeros no valor!");
        
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro! \n" + ex);
        
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Produto> read() {
        // Abrindo conexao e preparando o mysql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produto> listProduto = new ArrayList<>();

        try {
            // Comando mysql para pegar todos os registros/linhas
            stmt = con.prepareStatement("SELECT * FROM Produto");
            rs = stmt.executeQuery();
            // Enquanto houver conteudo na lista,adicionara em 'rs'
            while (rs.next()) {

                Produto objProduto = new Produto();

                // Adicionando os valores de cada coluna de cada endereço
                objProduto.setID(rs.getInt("ID"));
                objProduto.setNome(rs.getString("Nome"));
                objProduto.setTipo(rs.getString("Tipo"));
                objProduto.setPreco(rs.getInt("Preco"));

                listProduto.add(objProduto);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listProduto;
    }

    public void update(Produto objProduto) {
        // Metodo que atualiza os dados no banco de dados
        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Codigo que sera executado em sql
            stmt = con.prepareStatement(
                    "UPDATE Produto "
                    + "SET "
                    + "Nome = ?,"
                    + "Tipo = ?,"
                    + "Preco = ? "
                    + "WHERE ID = ?");
            // (X,Y) Sendo x a posição da coluna na tabela e
            //             y o valor indicado no campo
            stmt.setString(1, objProduto.getNome());
            stmt.setString(2, objProduto.getTipo());
            stmt.setInt(3, objProduto.getPreco());
            stmt.setInt(4, objProduto.getID());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Produto objProduto) {
        // Metodo que deleta uma pessoa

        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Codigo que sera executado em sql
            stmt = con.prepareStatement(
                    "DELETE FROM Produto WHERE ID = ?");
            stmt.setInt(1, objProduto.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
