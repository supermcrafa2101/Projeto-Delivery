package model.bean;

/**
 *
 * @author rafael
 */
public class Pedido {

    private int ID;
    private int IDItem;
    private String NomeCliente;
    private String NomeItem;
    private String CPFCliente;
    private int Valor;
    private String DataPedido;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDItem() {
        return IDItem;
    }

    public void setIDItem(int IDItem) {
        this.IDItem = IDItem;
    }

    public String getNomeCliente() {
        return NomeCliente;
    }

    public void setNomeCliente(String NomeCliente) {
        this.NomeCliente = NomeCliente;
    }

    public String getNomeItem() {
        return NomeItem;
    }

    public void setNomeItem(String NomeItem) {
        this.NomeItem = NomeItem;
    }

    public String getCPFCliente() {
        return CPFCliente;
    }

    public void setCPFCliente(String CPFCliente) {
        this.CPFCliente = CPFCliente;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public String getDataPedido() {
        return DataPedido;
    }

    public void setDataPedido(String DataPedido) {
        this.DataPedido = DataPedido;
    }

    
    @Override
    public String toString() {
        return getNomeCliente();
    }

}
