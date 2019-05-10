package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.bean.Pedido;


/**
 *
 * @author rafael
 */
public class PedidoDAO {

    public void create(Pedido objpedido) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO pedido "
                    + "(IDItem,NomeCliente,NomeItem,Valor,CPFCliente) "
                    + "VALUES "
                    + "(?,?,?,?,?)");

            stmt.setInt(1, objpedido.getIDItem());
            stmt.setString(2, objpedido.getNomeCliente());
            stmt.setString(3, objpedido.getNomeItem());
            stmt.setInt(4, objpedido.getValor());
            stmt.setString(5, objpedido.getCPFCliente());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "Erro! \n" + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Pedido> read() {
        // Abrindo conexao e preparando o mysql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pedido> listPedido = new ArrayList<>();

        try {
            // Comando mysql para pegar todos os registros/linhas
            stmt = con.prepareStatement("SELECT * FROM Pedido");
            rs = stmt.executeQuery();
            // Enquanto houver conteudo na lista,adicionara em 'rs'
            while (rs.next()) {

                Pedido objpedido = new Pedido();

                // Adicionando os valores de cada coluna de cada endereço
                objpedido.setID(rs.getInt("ID"));
                objpedido.setIDItem(rs.getInt("IDItem"));
                objpedido.setNomeCliente(rs.getString("NomeCliente"));
                objpedido.setCPFCliente(rs.getString("CPFCliente"));
                objpedido.setNomeItem(rs.getString("NomeItem"));
                objpedido.setValor(rs.getInt("Valor"));
                objpedido.setDataPedido(rs.getString("DataeHora"));

                listPedido.add(objpedido);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listPedido;
    }

    public void delete(Pedido objpedido) {
        // Metodo que deleta uma pessoa

        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Codigo que sera executado em sql
            stmt = con.prepareStatement(
                    "DELETE FROM Pedido WHERE ID = ?");
            stmt.setInt(1, objpedido.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void searchPessoaNome(Pedido objpedido) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT Nome FROM Pessoa WHERE CPF = ?");
            stmt.setString(1, (objpedido.getCPFCliente()));
            rs = stmt.executeQuery();
            while (rs.next()) {
                objpedido.setNomeCliente(rs.getString("Nome"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }


    public void searchProdutoNome(Pedido objpedido) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT Nome FROM produto WHERE ID = ?");
            stmt.setInt(1, objpedido.getIDItem());
            rs = stmt.executeQuery();
            while (rs.next()) {
                objpedido.setNomeItem(rs.getString("Nome"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }

    public void searchValorProduto(Pedido objpedido) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {

            stmt = con.prepareStatement("SELECT Preco FROM Produto WHERE ID = ?");
            stmt.setInt(1, objpedido.getIDItem());
            rs = stmt.executeQuery();
            while (rs.next()) {
                objpedido.setValor(rs.getInt("Preco"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
}
