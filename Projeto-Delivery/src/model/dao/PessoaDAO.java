package model.dao;

import connection.ConnectionFactory;
import model.bean.Pessoa;
import connection.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;

/**
 *
 * @author rafael
 */
public class PessoaDAO {

    public void create(Pessoa objPessoa) {
        // Metodo que cria uma pessoa com base no 'objPessoa' no banco de dados

        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                    "INSERT INTO Pessoa "
                    + "(Nome,CPF,Endereco,Telefone) "
                    + "VALUES "
                    + "(?,?,?,?)");
            // (X,Y) Sendo x a posição do value
            stmt.setString(1, objPessoa.getNome());
            stmt.setString(2, objPessoa.getCPF());
            stmt.setString(3, objPessoa.getEndereco());
            stmt.setString(4, objPessoa.getTelefone());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void update(Pessoa objPessoa) {
        // Metodo que atualiza os dados no banco de dados
        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Codigo que sera executado em sql
            stmt = con.prepareStatement(
                    "UPDATE Pessoa "
                    + "SET "
                    + "Nome = ?,"
                    + "CPF = ?,"
                    + "Endereco = ?,"
                    + "Telefone = ? "
                    + "WHERE ID = ?");
            // (X,Y) Sendo x a posição da coluna na tabela e
            //             y o valor indicado no campo
            stmt.setString(1, objPessoa.getNome());
            stmt.setString(2, objPessoa.getCPF());
            stmt.setString(3, objPessoa.getEndereco());
            stmt.setString(4, objPessoa.getTelefone());
            stmt.setInt(5, objPessoa.getID());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public void delete(Pessoa objPessoa) {
        // Metodo que deleta uma pessoa

        // Abre conexao e preparando o mysql.
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            // Codigo que sera executado em sql
            stmt = con.prepareStatement(
                    "DELETE FROM Pessoa WHERE ID = ?");
            stmt.setInt(1, objPessoa.getID());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Removido com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Pessoa> read() {
        // Abrindo conexao e preparando o mysql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Pessoa> listPessoa = new ArrayList<>();

        try {
            // Comando mysql para pegar todos os registros/linhas
            stmt = con.prepareStatement("SELECT * FROM Pessoa");
            rs = stmt.executeQuery();
            // Enquanto houver conteudo na lista,adicionara em 'rs'
            while (rs.next()) {

                Pessoa objPessoa = new Pessoa();

                // Adicionando os valores de cada coluna de cada endereço
                // objPessoa.setID(rs.getInt("ID"));
                objPessoa.setID(rs.getInt("ID"));
                objPessoa.setNome(rs.getString("Nome"));
                objPessoa.setCPF(rs.getString("CPF"));
                objPessoa.setEndereco(rs.getString("Endereco"));
                objPessoa.setTelefone(rs.getString("Telefone"));

                listPessoa.add(objPessoa);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return listPessoa;
    }


}
