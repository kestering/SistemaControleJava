package DAO;

import model.ModelCliente;
import conexoes.MySQL;
import java.util.ArrayList;
/**
*
* @author Thiago K.
*/
public class DAOCliente extends MySQL {

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectaBanco();
            return this.insertSQL(
                "INSERT INTO cliente ("
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                + ") VALUES ("                 
                    + "'" + pModelCliente.getNomeCliente() + "',"
                    + "'" + pModelCliente.getEnderecoCliente() + "',"
                    + "'" + pModelCliente.getBairroCliente() + "',"
                    + "'" + pModelCliente.getCidadeCliente() + "',"
                    + "'" + pModelCliente.getUfCliente() + "',"
                    + "'" + pModelCliente.getCepCliente() + "',"
                    + "'" + pModelCliente.getTelefoneCliente() + "'"
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
    * recupera Cliente
    * @param pIdCliente
    * @return ModelCliente
    */
    public ModelCliente getClienteDAO(int pIdCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectaBanco();
            this.executarSQL(
                "SELECT "
                    + "idCliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " cliente"
                 + " WHERE"
                     + " idCliente = '" + pIdCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setUfCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return modelCliente;
    }
    
       public ModelCliente getClienteDAO(String pNomeCliente){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectaBanco();
            this.executarSQL(
                "SELECT "
                    + "idCliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " cliente"
                 + " WHERE"
                     + " nome_cliente = '" + pNomeCliente + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setUfCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return modelCliente;
    }

    /**
    * recupera uma lista de Cliente
        * @return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteDAO(){
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectaBanco();
            this.executarSQL("SELECT "
                    + "idCliente,"
                    + "nome_cliente,"
                    + "endereco_cliente,"
                    + "bairro_cliente,"
                    + "cidade_cliente,"
                    + "uf_cliente,"
                    + "cep_cliente,"
                    + "telefone_cliente"
                 + " FROM"
                     + " cliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
                modelCliente.setIdCliente(this.getResultSet().getInt(1));
                modelCliente.setNomeCliente(this.getResultSet().getString(2));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(3));
                modelCliente.setBairroCliente(this.getResultSet().getString(4));
                modelCliente.setCidadeCliente(this.getResultSet().getString(5));
                modelCliente.setUfCliente(this.getResultSet().getString(6));
                modelCliente.setCepCliente(this.getResultSet().getString(7));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(8));
                listamodelCliente.add(modelCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return listamodelCliente;
    }
    
    

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectaBanco();
            return this.updateSQL(
                "UPDATE cliente SET "
                    + "idCliente = '" + pModelCliente.getIdCliente() + "',"
                    + "nome_cliente = '" + pModelCliente.getNomeCliente() + "',"
                    + "endereco_cliente = '" + pModelCliente.getEnderecoCliente() + "',"
                    + "bairro_cliente = '" + pModelCliente.getBairroCliente() + "',"
                    + "cidade_cliente = '" + pModelCliente.getCidadeCliente() + "',"
                    + "uf_cliente = '" + pModelCliente.getUfCliente() + "',"
                    + "cep_cliente = '" + pModelCliente.getCepCliente() + "',"
                    + "telefone_cliente = '" + pModelCliente.getTelefoneCliente() + "'"
                + " WHERE "
                    + "idCliente = '" + pModelCliente.getIdCliente() + "'"
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
    * exclui Cliente
    * @param pIdCliente
    * @return boolean
    */
    public boolean excluirClienteDAO(int pIdCliente){
        try {
            this.conectaBanco();
            return this.updateSQL(
                "DELETE FROM cliente "
                + " WHERE "
                    + "idCliente = '" + pIdCliente + "'"
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