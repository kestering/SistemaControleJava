package model;
/**
*
* @author Thiago K.
*/
public class ModelVendasProdutos {

    private int idVendas_Produtos;
    private int idProduto;
    private int idVendas;
    private double valor_vendaproduto;
    private int quantidade_vendaproduto;

    /**
    * Construtor
    */
    public ModelVendasProdutos(){}

    /**
    * seta o valor de idVendas_Produtos
    * @param pIdVendas_Produtos
    */
    public void setIdVendas_Produtos(int pIdVendas_Produtos){
        this.idVendas_Produtos = pIdVendas_Produtos;
    }
    /**
    * @return pk_idVendas_Produtos
    */
    public int getIdVendas_Produtos(){
        return this.idVendas_Produtos;
    }

    /**
    * seta o valor de idProduto
    * @param pIdProduto
    */
    public void setIdProduto(int pIdProduto){
        this.idProduto = pIdProduto;
    }
    /**
    * @return fk_idProduto
    */
    public int getIdProduto(){
        return this.idProduto;
    }

    /**
    * seta o valor de idVendas
    * @param pIdVendas
    */
    public void setIdVendas(int pIdVendas){
        this.idVendas = pIdVendas;
    }
    /**
    * @return fk_idVendas
    */
    public int getIdVendas(){
        return this.idVendas;
    }

    /**
    * seta o valor de valor_vendaproduto
    * @param pValor_vendaproduto
    */
    public void setValor_vendaproduto(double pValor_vendaproduto){
        this.valor_vendaproduto = pValor_vendaproduto;
    }
    /**
    * @return valor_vendaproduto
    */
    public double getValor_vendaproduto(){
        return this.valor_vendaproduto;
    }

    /**
    * seta o valor de quantidade_vendaproduto
    * @param pQuantidade_vendaproduto
    */
    public void setQuantidade_vendaproduto(int pQuantidade_vendaproduto){
        this.quantidade_vendaproduto = pQuantidade_vendaproduto;
    }
    /**
    * @return quantidade_vendaproduto
    */
    public int getQuantidade_vendaproduto(){
        return this.quantidade_vendaproduto;
    }

    @Override
    public String toString(){
        return "ModelVendasProdutos {" + "::idVendas_Produtos = " + this.idVendas_Produtos + "::idProduto = " + this.idProduto + "::idVendas = " + this.idVendas + "::valor_vendaproduto = " + this.valor_vendaproduto + "::quantidade_vendaproduto = " + this.quantidade_vendaproduto +  "}";
    }
}