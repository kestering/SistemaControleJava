/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexoes.MySQL;
import java.util.ArrayList;
import model.ModelProdutos;
import model.ModelProdutosVendasProdutos;
import model.ModelVendasProdutos;


/**
 *
 * @author thiag
 */
public class DAOProdutosVendasProdutos extends MySQL{
    
    public ArrayList<ModelProdutosVendasProdutos> getListaProdutosVendasProdutosDAO(int pCodigoVenda){
        ArrayList<ModelProdutosVendasProdutos> listaModelProdutosVendasProdutos = new ArrayList<>();
        ModelProdutosVendasProdutos modelProdutosVendasProdutos = new ModelProdutosVendasProdutos ();
        ModelProdutos modelProdutos = new ModelProdutos();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectaBanco();
            this.executarSQL("SELECT produto.idProduto, "
                    + "produto.estoque_produto, "
                    + "produto.nome_produto, "
                    + "produto.valor_produto, "
                    
                    + "vendas_produtos.FK_idProduto, "
                    + "vendas_produtos.FK_idVendas, "
                    + "vendas_produtos.idVendas_Produtos, "
                    + "vendas_produtos.quantidade_vendaproduto, "
                    + "vendas_produtos.valor_vendaproduto "
                    
                    + "FROM vendas_produtos "
                    + "INNER JOIN produto ON produto.idProduto = vendas_produtos.FK_idProduto "
                    + "WHERE vendas_produtos.FK_idVendas = '"+pCodigoVenda+"'"
                    );
            
            
                    while(this.getResultSet().next()){
                        modelProdutosVendasProdutos = new ModelProdutosVendasProdutos();
                        modelProdutos = new ModelProdutos();
                        modelVendasProdutos = new ModelVendasProdutos();
                        
                        modelProdutos.setIdProduto(this.getResultSet().getInt(1));
                        modelProdutos.setEstoque_produto(this.getResultSet().getInt(2));
                        modelProdutos.setNome_produto(this.getResultSet().getString(3));
                        modelProdutos.setValor_protudo(this.getResultSet().getDouble(4));
                        
                        modelVendasProdutos.setIdProduto(this.getResultSet().getInt(5));
                        modelVendasProdutos.setIdVendas(this.getResultSet().getInt(6));
                        modelVendasProdutos.setIdVendas_Produtos(this.getResultSet().getInt(7));
                        modelVendasProdutos.setQuantidade_vendaproduto(this.getResultSet().getInt(8));
                        modelVendasProdutos.setValor_vendaproduto(this.getResultSet().getInt(9));
                        
                        modelProdutosVendasProdutos.setModelProdutos(modelProdutos);
                        modelProdutosVendasProdutos.setModelVendasProdutos(modelVendasProdutos);
                        
                        listaModelProdutosVendasProdutos.add(modelProdutosVendasProdutos);
                        
                    }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        
        return listaModelProdutosVendasProdutos;
    }
    
}
