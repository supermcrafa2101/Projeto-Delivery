
package model.bean;

/**
 *
 * @author rafael
 */
public class Usuario {
    
    private String login;
    private String senha;
    private String NomeCompleto;
    private String CPFUsuario;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getNomeCompleto() {
        return NomeCompleto;
    }

    public void setNomeCompleto(String NomeCompleto) {
        this.NomeCompleto = NomeCompleto;
    }

    public String getCPFUsuario() {
        return CPFUsuario;
    }

    public void setCPFUsuario(String CPFUsuario) {
        this.CPFUsuario = CPFUsuario;
    }
    
}
