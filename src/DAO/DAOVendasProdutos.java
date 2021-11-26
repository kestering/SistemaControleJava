package DAO;

import model.ModelVendasProdutos;
import conexoes.MySQL;
import java.util.ArrayList;

/**
 *
 * @author Thiago K.
 */
public class DAOVendasProdutos extends MySQL {

    /**
     * grava VendasProdutos
     *
     * @param pModelVendasProdutos
     * @return int
     */
    public int salvarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectaBanco();
            return this.insertSQL(
                    "INSERT INTO Vendas_Produtos ("
                    + "FK_idVendas,"
                    + "FK_idProduto,"
                    + "valor_vendaproduto,"
                    + "quantidade_vendaproduto"
                    + ") VALUES ("
                    + "'" + pModelVendasProdutos.getIdVendas() + "',"
                    + "'" + pModelVendasProdutos.getIdProduto() + "',"
                    + "'" + pModelVendasProdutos.getValor_vendaproduto() + "',"
                    + "'" + pModelVendasProdutos.getQuantidade_vendaproduto() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fechaBanco();
        }
    }

    /**
     * recupera VendasProdutos
     *
     * @param pIdVendas_Produtos
     * @return ModelVendasProdutos
     */
    public ModelVendasProdutos getVendasProdutosDAO(int pIdVendas_Produtos) {
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectaBanco();
            this.executarSQL(
                    "SELECT "
                    + "idVendas_Produtos,"
                    + "FK_idProduto,"
                    + "FK_idVendas,"
                    + "valor_vendaproduto,"
                    + "quantidade_vendaproduto"
                    + " FROM"
                    + " Vendas_Produtos"
                    + " WHERE"
                    + " idVendas_Produtos = '" + pIdVendas_Produtos + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos.setIdVendas_Produtos(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setValor_vendaproduto(this.getResultSet().getDouble(4));
                modelVendasProdutos.setQuantidade_vendaproduto(this.getResultSet().getInt(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fechaBanco();
        }
        return modelVendasProdutos;
    }

    /**
     * recupera uma lista de VendasProdutos
     *
     * @return ArrayList
     */
    public ArrayList<ModelVendasProdutos> getListaVendasProdutosDAO() {
        ArrayList<ModelVendasProdutos> listamodelVendasProdutos = new ArrayList();
        ModelVendasProdutos modelVendasProdutos = new ModelVendasProdutos();
        try {
            this.conectaBanco();
            this.executarSQL(
                    "SELECT "
                    + "idVendas_Produtos,"
                    + "FK_idProduto,"
                    + "FK_idVendas,"
                    + "valor_vendaproduto,"
                    + "quantidade_vendaproduto"
                    + " FROM"
                    + " Vendas_Produtos"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelVendasProdutos = new ModelVendasProdutos();
                modelVendasProdutos.setIdVendas_Produtos(this.getResultSet().getInt(1));
                modelVendasProdutos.setIdProduto(this.getResultSet().getInt(2));
                modelVendasProdutos.setIdVendas(this.getResultSet().getInt(3));
                modelVendasProdutos.setValor_vendaproduto(this.getResultSet().getDouble(4));
                modelVendasProdutos.setQuantidade_vendaproduto(this.getResultSet().getInt(5));
                listamodelVendasProdutos.add(modelVendasProdutos);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fechaBanco();
        }
        return listamodelVendasProdutos;
    }

    /**
     * atualiza VendasProdutos
     *
     * @param pModelVendasProdutos
     * @return boolean
     */
    public boolean atualizarVendasProdutosDAO(ModelVendasProdutos pModelVendasProdutos) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "UPDATE Vendas_Produtos SET "
                    + "idVendas_Produtos = '" + pModelVendasProdutos.getIdVendas_Produtos() + "',"
                    + "FK_idProduto = '" + pModelVendasProdutos.getIdProduto() + "',"
                    + "FK_idVendas = '" + pModelVendasProdutos.getIdVendas() + "',"
                    + "valor_vendaproduto = '" + pModelVendasProdutos.getValor_vendaproduto() + "',"
                    + "quantidade_vendaproduto = '" + pModelVendasProdutos.getQuantidade_vendaproduto() + "'"
                    + " WHERE "
                    + "idVendas_Produtos = '" + pModelVendasProdutos.getIdVendas_Produtos() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();
        }
    }

    /**
     * exclui VendasProdutos
     *
     * @param pIdVendas_Produtos
     * @return boolean
     */
    public boolean excluirVendasProdutosDAO(int pIdVendas_Produtos) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "DELETE FROM Vendas_Produto "
                    + " WHERE "
                    + "idVendas_Produtos = '" + pIdVendas_Produtos + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();
        }
    }

    public boolean salvarVendasProdutosDAO(ArrayList<ModelVendasProdutos> pListaModelVendasProdutos) {
        try {
            this.conectaBanco();
            int cont = pListaModelVendasProdutos.size();
            for (int i = 0; i < cont; i++) {

                this.insertSQL(
                        "INSERT INTO Vendas_Produtos ("
                        + "FK_idVendas,"
                        + "FK_idProduto,"
                        + "valor_vendaproduto,"
                        + "quantidade_vendaproduto"
                        + ") VALUES ("
                        + "'" + pListaModelVendasProdutos.get(i).getIdVendas()+ "',"
                        + "'" + pListaModelVendasProdutos.get(i).getIdProduto()+ "',"
                        + "'" + pListaModelVendasProdutos.get(i).getValor_vendaproduto() + "',"
                        + "'" + pListaModelVendasProdutos.get(i).getQuantidade_vendaproduto() + "'"
                        + "); "
                );
            }
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();
        }
    }
}
