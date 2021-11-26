package DAO;

import conexoes.MySQL;
import java.util.ArrayList;
import model.ModelProdutos;

public class DaoProdutos extends MySQL {

    /**
     * Cadastrar um produto no banco
     *
     * @param pModelProdutos
     * @return
     */
    public int salvarProdutosDAO(ModelProdutos pModelProdutos) {
        try {
            this.conectaBanco();
            return this.insertSQL("INSERT INTO produto ("
                    + "nome_produto,"
                    + "valor_produto,"
                    + "estoque_produto"
                    + ") VALUES("
                    + "'" + pModelProdutos.getNome_produto() + "',"
                    + "'" + pModelProdutos.getValor_protudo() + "',"
                    + "'" + pModelProdutos.getEstoque_produto() + "'"
                    + "); "
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fechaBanco();
        }

    }

    /**
     * Excluir um produto do banco
     *
     * @param pIdProduto
     * @return Bollean
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "DELETE FROM produto WHERE idProduto = '" + pIdProduto + "'"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();

        }

    }

    /**
     * Alterar prduto do banco
     *
     * @param pModelProduto
     * @return
     */
    public boolean alterarProdutoDAO(ModelProdutos pModelProduto) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "UPDATE produto SET "
                    + "nome_produto = '" + pModelProduto.getNome_produto() + "',"
                    + "valor_produto = '" + pModelProduto.getValor_protudo() + "',"
                    + "estoque_produto = '" + pModelProduto.getEstoque_produto() + "' "
                    + "WHERE idProduto = '" + pModelProduto.getIdProduto() + "'"
            );

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();

        }

    }

    /**
     * Retornar um produto pelo código
     *
     * @param pIdProduto
     * @return
     */
    public ModelProdutos retornarProdutoDAO(int pIdProduto) {
        ModelProdutos modelProduto = new ModelProdutos();
        try {
            this.conectaBanco();
            this.executarSQL("SELECT "
                    + "idProduto,"
                    + "nome_produto, "
                    + "valor_produto, "
                    + "estoque_produto "
                    + "FROM produto WHERE idProduto = '" + pIdProduto + "';");
            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNome_produto(this.getResultSet().getString(2));
                modelProduto.setValor_protudo(this.getResultSet().getDouble(3));
                modelProduto.setEstoque_produto(this.getResultSet().getInt(4));

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            this.fechaBanco();

        }
        return modelProduto;

    }

    public ModelProdutos retornarProdutoDAO(String pNomeProduto) {
        ModelProdutos modelProduto = new ModelProdutos();
        try {
            this.conectaBanco();
            this.executarSQL("SELECT "
                    + "idProduto,"
                    + "nome_produto, "
                    + "valor_produto, "
                    + "estoque_produto "
                    + "FROM produto WHERE nome_produto = '" + pNomeProduto + "';");
            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNome_produto(this.getResultSet().getString(2));
                modelProduto.setValor_protudo(this.getResultSet().getDouble(3));
                modelProduto.setEstoque_produto(this.getResultSet().getInt(4));

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            this.fechaBanco();

        }
        return modelProduto;

    }

    /**
     * Retornar uma lista completa de produtos
     *
     * @return
     */
    public ArrayList<ModelProdutos> retornarListaProdutoDAO() {
        ArrayList<ModelProdutos> listaModelProduto = new ArrayList<>();
        ModelProdutos modelProduto = new ModelProdutos();
        try {
            this.conectaBanco();
            this.executarSQL("SELECT "
                    + "idProduto,"
                    + "nome_produto, "
                    + "valor_produto, "
                    + "estoque_produto "
                    + "FROM produto;");
            while (this.getResultSet().next()) {
                modelProduto = new ModelProdutos();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setNome_produto(this.getResultSet().getString(2));
                modelProduto.setValor_protudo(this.getResultSet().getDouble(3));
                modelProduto.setEstoque_produto(this.getResultSet().getInt(4));
                listaModelProduto.add(modelProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fechaBanco();
        }
        return listaModelProduto;
    }

    public boolean alterarEstoqueProdutoDAO(ArrayList<ModelProdutos> pListaModelProdutos) {
        try {
            this.conectaBanco();
            for (int i = 0; i < pListaModelProdutos.size(); i++) {
                this.updateSQL(
                        "UPDATE produto SET "
                        + "estoque_produto = '" + pListaModelProdutos.get(i).getEstoque_produto() + "' "
                        + "WHERE idProduto = '" + pListaModelProdutos.get(i).getIdProduto() + "'"
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
