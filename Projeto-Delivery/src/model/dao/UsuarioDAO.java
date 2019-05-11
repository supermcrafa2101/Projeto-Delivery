/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author rafael
 */
public class UsuarioDAO {

    public boolean checarLogin(String login, String senha, Usuario funcionario) {
        // Abrindo conexao e preparando o mysql
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;

        try {
            // Comando mysql checando se existe o conjunto login e senha
            stmt = con.prepareStatement("SELECT * FROM Login WHERE login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();
            // Caso exista, bool "check" será true
            if (rs.next()) {
                check = true;

            }

            stmt = con.prepareStatement("Select NomeCompleto From Login WHERE login = ?");
            stmt.setString(1, login);
            rs = stmt.executeQuery();

            if (rs.next()) {
                funcionario.setNomeCompleto(rs.getString("NomeCompleto"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).
                    log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return check;
    }

    public void registrarUsuario(Usuario novoUsuario) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String loginusado = "";
        try {
            stmt = con.prepareStatement("Select * from Login where login = ?");
            stmt.setString(1, novoUsuario.getLogin());
            rs = stmt.executeQuery();

            if (rs.next()) {
                loginusado = (rs.getString("login"));
            }
            System.out.println(loginusado);
            if ("".equals(loginusado)) {
                stmt = con.prepareStatement(
                        "INSERT INTO Login "
                        + "(login, senha, NomeCompleto, CPFUsuario) "
                        + "VALUES "
                        + "(?,?,?,?)"
                );
                stmt.setString(1, novoUsuario.getLogin());
                stmt.setString(2, novoUsuario.getSenha());
                stmt.setString(3, novoUsuario.getNomeCompleto());
                stmt.setString(4, novoUsuario.getCPFUsuario());
                stmt.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuario registrado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "O login ja esta em uso, escolha outro!");
            }
        } catch (SQLIntegrityConstraintViolationException ex) {
            JOptionPane.showMessageDialog(null, "O CPF inserido já foi cadastrado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

}
