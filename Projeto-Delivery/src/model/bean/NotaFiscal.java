/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author TeixeiraAdmin
 */
public class NotaFiscal {
    
    private String Data;
    private int IDPedido;
    private String Funcionario;
    private String NomeCliente;
    private String CPFCliente;
    private String NomeItem;
    private int ValorTotal;

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public int getIDPedido() {
        return IDPedido;
    }

    public void setIDPedido(int IDPedido) {
        this.IDPedido = IDPedido;
    }

    public String getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(String Funcionario) {
        this.Funcionario = Funcionario;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String NomeItem) {
        this.NomeItem = NomeItem;
    }

    public int getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(int ValorTotal) {
        this.ValorTotal = ValorTotal;
    }
    
    
}
