package model;

import java.util.Date;

/**
*
* @author Thiago K.
*/
public class ModelVendas {

    private int idVendas;
    private int cliente;
    private Date data_vendas;
    private double valor_vendas;
    private double valorTotal_vendas;
    private double desconto_vendas;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de idVendas
    * @param pIdVendas
    */
    public void setIdVendas(int pIdVendas){
        this.idVendas = pIdVendas;
    }
    /**
    * @return pk_idVendas
    */
    public int getIdVendas(){
        return this.idVendas;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(int pCliente){
        this.cliente = pCliente;
    }
    /**
    * @return fk_cliente
    */
    public int getCliente(){
        return this.cliente;
    }

    /**
    * seta o valor de data_vendas
    * @param pData_vendas
    */
    public void setData_vendas(Date pData_vendas){
        this.data_vendas = pData_vendas;
    }
    /**
    * @return data_vendas
    */
    public Date getData_vendas(){
        return this.data_vendas;
    }

    /**
    * seta o valor de valor_vendas
    * @param pValor_vendas
    */
    public void setValor_vendas(double pValor_vendas){
        this.valor_vendas = pValor_vendas;
    }
    /**
    * @return valor_vendas
    */
    public double getValor_vendas(){
        return this.valor_vendas;
    }

    /**
    * seta o valor de valorTotal_vendas
    * @param pValorTotal_vendas
    */
    public void setValorTotal_vendas(double pValorTotal_vendas){
        this.valorTotal_vendas = pValorTotal_vendas;
    }
    /**
    * @return valorTotal_vendas
    */
    public double getValorTotal_vendas(){
        return this.valorTotal_vendas;
    }

    /**
    * seta o valor de desconto_vendas
    * @param pDesconto_vendas
    */
    public void setDesconto_vendas(double pDesconto_vendas){
        this.desconto_vendas = pDesconto_vendas;
    }
    /**
    * @return desconto_vendas
    */
    public double getDesconto_vendas(){
        return this.desconto_vendas;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idVendas = " + this.idVendas + "::cliente = " + this.cliente + "::data_vendas = " + this.data_vendas + "::valor_vendas = " + this.valor_vendas + "::valorTotal_vendas = " + this.valorTotal_vendas + "::desconto_vendas = " + this.desconto_vendas +  "}";
    }
}