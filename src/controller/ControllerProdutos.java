
package controller;

import DAO.DaoProdutos;
import java.util.ArrayList;
import model.ModelProdutos;

public class ControllerProdutos {
    
    private DaoProdutos daoProdutos = new DaoProdutos();
    
    /**
     * Salvar produtos Controller
     * @param pModelProdutos
     * @return 
     */
    public int salvarProdutoController(ModelProdutos pModelProdutos){
        return this.daoProdutos.salvarProdutosDAO(pModelProdutos);
        
    }
    
    /**
     * Excluir produto Controller
     * @param pCodigo
     * @return 
     */
    public boolean excluirProdutoController (int pCodigo){
        return this.daoProdutos.excluirProdutoDAO(pCodigo);
        
    }
    
    /**
     * Altera produto Controller
     * @param pModelProdutos
     * @return 
     */
    public boolean alterarProdutoController (ModelProdutos pModelProdutos){
        return this.daoProdutos.alterarProdutoDAO(pModelProdutos);
    }
    
    /**
     * Retorna protudo Controller
     * @param pCodigo
     * @return 
     */
    public ModelProdutos retornarProdutoController (int pCodigo){
        return this.daoProdutos.retornarProdutoDAO(pCodigo);
    }
    
        public ModelProdutos retornarProdutoController (String pNomeProduto){
        return this.daoProdutos.retornarProdutoDAO(pNomeProduto);
    }
    
     /**
      * Retorna lista produto Controller 
      * @return 
      */
    public ArrayList<ModelProdutos> retornarListaProdutoController(){
        return this.daoProdutos.retornarListaProdutoDAO();
        
    }

    public boolean alterarEstoqueProdutoController(ArrayList<ModelProdutos> pListaModelProdutos) {
        return this.daoProdutos.alterarEstoqueProdutoDAO(pListaModelProdutos);
        
    }
}
