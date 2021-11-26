
package model;



public class ModelProdutos {
    
    private int idProduto;
    private String nome_produto;
    private double valor_produto;
    private int estoque_produto;

    /**
     * @return the idProduto
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * @param idProduto the idProduto to set
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * @return the nome_produto
     */    public String getNome_produto() {
        return nome_produto;
    }

    /**
     * @param nome_produto the nome_produto to set
     */
    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    /**
     * @return the valor_protudo
     */
    public double getValor_protudo() {
        return valor_produto;
    }

    /**
     * @param valor_protudo the valor_protudo to set
     */
    public void setValor_protudo(double valor_protudo) {
        this.valor_produto = valor_protudo;
    }

    /**
     * @return the estoque_produto
     */
    public int getEstoque_produto() {
        return estoque_produto;
    }

    /**
     * @param estoque_produto the estoque_produto to set
     */
    public void setEstoque_produto(int estoque_produto) {
        this.estoque_produto = estoque_produto;
    }
    
    
}
