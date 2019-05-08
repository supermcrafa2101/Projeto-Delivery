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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Usuario;

/**
 *
 * @author rafael
 */
public class UsuarioDAO {

    public boolean checarLogin(String login, String senha) {
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

        try {
            stmt = con.prepareStatement(
                    "INSERT INTO Login "
                    + "(login, senha) "
                    + "VALUES "
                    + "(?,?)"
            );
            stmt.setString(1, novoUsuario.getLogin());
            stmt.setString(2, novoUsuario.getSenha());
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Usuario registrado com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }

    }

}
