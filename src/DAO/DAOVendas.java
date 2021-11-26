package DAO;

import model.ModelVendas;
import conexoes.MySQL;
import java.util.ArrayList;
/**
*
* @author Thiago K.
*/
public class DAOVendas extends MySQL {

    /**
    * grava Vendas
    * @param pModelVendas
    * @return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectaBanco();
            return this.insertSQL(
                "INSERT INTO Vendas ("
                    + "FK_idCliente,"
                    + "data_vendas,"
                    + "valor_vendas,"
                    + "valorTotal_vendas,"
                    + "desconto_vendas"
                + ") VALUES ("
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getData_vendas() + "',"
                    + "'" + pModelVendas.getValor_vendas() + "',"
                    + "'" + pModelVendas.getValorTotal_vendas() + "',"
                    + "'" + pModelVendas.getDesconto_vendas() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fechaBanco();
        }
    }

    /**
    * recupera Vendas
    * @param pIdVendas
    * @return ModelVendas
    */
    public ModelVendas getVendasDAO(int pIdVendas){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectaBanco();
            this.executarSQL(
                "SELECT "
                    + "idVendas,"
                    + "fk_idCliente,"
                    + "data_vendas,"
                    + "valor_vendas,"
                    + "valorTotal_vendas,"
                    + "desconto_vendas"
                 + " FROM"
                     + " Vendas"
                 + " WHERE"
                     + " idVendas = '" + pIdVendas + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setData_vendas(this.getResultSet().getDate(3));
                modelVendas.setValor_vendas(this.getResultSet().getDouble(4));
                modelVendas.setValorTotal_vendas(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_vendas(this.getResultSet().getDouble(6));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * @return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectaBanco();
            this.executarSQL(
                "SELECT "
                    + "idVendas,"
                    + "fk_idCliente,"
                    + "data_vendas,"
                    + "valor_vendas,"
                    + "valorTotal_vendas,"
                    + "desconto_vendas"
                 + " FROM"
                     + " Vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setData_vendas(this.getResultSet().getDate(3));
                modelVendas.setValor_vendas(this.getResultSet().getDouble(4));
                modelVendas.setValorTotal_vendas(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_vendas(this.getResultSet().getDouble(6));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectaBanco();
            return this.updateSQL(
                "UPDATE Vendas SET "
                    + "idVendas = '" + pModelVendas.getIdVendas() + "',"
                    + "fk_idCliente = '" + pModelVendas.getCliente() + "',"
                    + "data_vendas = '" + pModelVendas.getData_vendas() + "',"
                    + "valor_vendas = '" + pModelVendas.getValor_vendas() + "',"
                    + "valor_total_vendas = '" + pModelVendas.getValorTotal_vendas() + "',"
                    + "desconto_vendas = '" + pModelVendas.getDesconto_vendas() + "'"
                + " WHERE "
                    + "idVendas = '" + pModelVendas.getIdVendas() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fechaBanco();
        }
    }

    /**
    * exclui Vendas
    * @param pIdVendas
    * @return boolean
    */
    public boolean excluirVendasDAO(int pIdVendas){
        try {
            this.conectaBanco();
            return this.updateSQL(
                "DELETE FROM Vendas "
                + " WHERE "
                    + "idVendas = '" + pIdVendas + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fechaBanco();
        }
    }
}