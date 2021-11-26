 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import conexoes.MySQL;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author thiag
 */
public class DAOVendasCliente extends MySQL{
    
    public ArrayList<ModelVendasCliente> getListaVendasClientes(){
        ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectaBanco();
            this.executarSQL(
                "SELECT "
                    + "Vendas.idVendas,"
                    + "Vendas.fk_idCliente,"   
                    + "Vendas.data_vendas,"
                    + "Vendas.valor_vendas,"
                    + "Vendas.valorTotal_vendas,"
                    + "Vendas.desconto_vendas,"
                    + "cliente.idCliente,"    
                    + "cliente.nome_cliente,"    
                    + "cliente.endereco_cliente,"    
                    + "cliente.bairro_cliente,"    
                    + "cliente.cidade_cliente,"    
                    + "cliente.uf_cliente,"    
                    + "cliente.cep_cliente,"    
                    + "cliente.telefone_cliente"    
                 + " FROM "
                     + " Vendas INNER JOIN cliente "
                        + "ON cliente.idCliente = Vendas.FK_idCliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getInt(2));
                modelVendas.setData_vendas(this.getResultSet().getDate(3));
                modelVendas.setValor_vendas(this.getResultSet().getDouble(4));
                modelVendas.setValorTotal_vendas(this.getResultSet().getDouble(5));
                modelVendas.setDesconto_vendas(this.getResultSet().getDouble(6));
                               
                modelCliente.setIdCliente(this.getResultSet().getInt(7));
                modelCliente.setNomeCliente(this.getResultSet().getString(8));
                modelCliente.setEnderecoCliente(this.getResultSet().getString(9));
                modelCliente.setBairroCliente(this.getResultSet().getString(10));
                modelCliente.setCidadeCliente(this.getResultSet().getString(11));
                modelCliente.setUfCliente(this.getResultSet().getString(12));
                modelCliente.setCepCliente(this.getResultSet().getString(13));
                modelCliente.setTelefoneCliente(this.getResultSet().getString(14));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                
                listaModelVendasClientes.add(modelVendasCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fechaBanco();
        }
        return listaModelVendasClientes;
    }
    
}
