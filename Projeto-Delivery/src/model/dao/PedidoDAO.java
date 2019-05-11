package model.dao;

import connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import model.bean.Pedido;
import model.bean.Pessoa;
import model.bean.Produto;

/**
 *
 * @author rafael
 */
public class PedidoDAO {
    
    public void create(Pessoa objpessoa,Produto objproduto) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO pedido "
                    + "(IDItem,NomeCliente,NomeItem,Valor,CPFCliente,Endereco,Telefone) "
                    + "VALUES "
                    + "(?,?,?,?,?,?,?)");
            
            stmt.setInt(1, objproduto.getID());
            stmt.setString(2, objpessoa.getNome());
            stmt.setString(3, objproduto.getNome());
            stmt.setInt(4, objproduto.getPreco());
            stmt.setString(5, objpessoa.getCPF());
            stmt.setString(6, objpessoa.getEndereco());
            stmt.setString(7, objpessoa.getTelefone());
            
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
            
            stmt = con.prepareStatement("SELECT * FROM Pedido");
            rs = stmt.executeQuery();
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
                objpedido.setEndereco(rs.getString("Endereco"));
                objpedido.setTelefone(rs.getString("Telefone"));
                
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
    
    public Pedido readUmPedido(int iddopedido, Pedido objPedido) {
        // Abrindo conexao e preparando o mysql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Pedido WHERE ID = ?");
            stmt.setInt(1, iddopedido);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                objPedido.setID(rs.getInt("ID"));
                objPedido.setDataPedido(rs.getString("DataeHora"));
                objPedido.setNomeCliente(rs.getString("NomeCliente"));
                objPedido.setCPFCliente(rs.getString("CPFCliente"));
                objPedido.setEndereco(rs.getString("Endereco"));
                objPedido.setTelefone(rs.getString("Telefone"));
                objPedido.setNomeItem(rs.getString("NomeItem"));
                objPedido.setValor(rs.getInt("Valor"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return objPedido;
    }
    
    public void delete(Pedido objpedido) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
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
    
    public Pessoa searchPessoa(String CPFSelecionado, Pessoa objpessoa) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoa WHERE CPF = ?");
            stmt.setString(1, CPFSelecionado);
            rs = stmt.executeQuery();
            while (rs.next()) {
                objpessoa.setNome(rs.getString("Nome"));
                objpessoa.setCPF(rs.getString("CPF"));
                objpessoa.setEndereco(rs.getString("Endereco"));
                objpessoa.setTelefone(rs.getString("Telefone"));
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar: " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return objpessoa;
    }
    
    public void searchProduto(int pedidoSelecionado,Produto objproduto) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            
            stmt = con.prepareStatement("SELECT * FROM produto WHERE ID = ?");
            stmt.setInt(1, pedidoSelecionado);
            rs = stmt.executeQuery();
            while (rs.next()) {
                objproduto.setID(rs.getInt("ID"));
                objproduto.setNome(rs.getString("Nome"));
                objproduto.setTipo(rs.getString("Tipo"));
                objproduto.setPreco(rs.getInt("Preco"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao procurar: " + ex);
            
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
}
