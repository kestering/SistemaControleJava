package DAO;

import model.ModelUsuario;
import conexoes.MySQL;
import java.util.ArrayList;

/**
 *
 * @author Thiago K.
 */
public class DAOUsuario extends MySQL {

    /**
     * grava Usuario
     *
     * @param pModelUsuario
     * @return int
     */
    public int salvarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectaBanco();
            return this.insertSQL(
                    "INSERT INTO usuario ("
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + ") VALUES ("
                    + "'" + pModelUsuario.getNome_usuario() + "',"
                    + "'" + pModelUsuario.getLogin_usuario() + "',"
                    + "'" + pModelUsuario.getSenha_usuario() + "'"
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
     * recupera Usuario
     *
     * @param pIdUsuario
     * @return ModelUsuario
     */
    public ModelUsuario getUsuarioDAO(int pIdUsuario) {
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectaBanco();
            this.executarSQL(
                    "SELECT "
                    + "idUsuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " usuario"
                    + " WHERE"
                    + " idUsuario = '" + pIdUsuario + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setNome_usuario(this.getResultSet().getString(2));
                modelUsuario.setLogin_usuario(this.getResultSet().getString(3));
                modelUsuario.setSenha_usuario(this.getResultSet().getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fechaBanco();
        }
        return modelUsuario;
    }

    /**
     * recupera uma lista de Usuario
     *
     * @return ArrayList
     */
    public ArrayList<ModelUsuario> getListaUsuarioDAO() {
        ArrayList<ModelUsuario> listamodelUsuario = new ArrayList();
        ModelUsuario modelUsuario = new ModelUsuario();
        try {
            this.conectaBanco();
            this.executarSQL(
                    "SELECT "
                    + "idUsuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " usuario"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelUsuario = new ModelUsuario();
                modelUsuario.setIdUsuario(this.getResultSet().getInt(1));
                modelUsuario.setNome_usuario(this.getResultSet().getString(2));
                modelUsuario.setLogin_usuario(this.getResultSet().getString(3));
                modelUsuario.setSenha_usuario(this.getResultSet().getString(4));
                listamodelUsuario.add(modelUsuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fechaBanco();
        }
        return listamodelUsuario;
    }

    /**
     * atualiza Usuario
     *
     * @param pModelUsuario
     * @return boolean
     */
    public boolean atualizarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "UPDATE usuario SET "
                    + "idUsuario = '" + pModelUsuario.getIdUsuario() + "',"
                    + "nome_usuario = '" + pModelUsuario.getNome_usuario() + "',"
                    + "login_usuario = '" + pModelUsuario.getLogin_usuario() + "',"
                    + "senha_usuario = '" + pModelUsuario.getSenha_usuario() + "'"
                    + " WHERE "
                    + "idUsuario = '" + pModelUsuario.getIdUsuario() + "'"
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
     * exclui Usuario
     *
     * @param pIdUsuario
     * @return boolean
     */
    public boolean excluirUsuarioDAO(int pIdUsuario) {
        try {
            this.conectaBanco();
            return this.updateSQL(
                    "DELETE FROM usuario "
                    + " WHERE "
                    + "pk_id_usuario = '" + pIdUsuario + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();
        }
    }

    public boolean getValidarUsuarioDAO(ModelUsuario pModelUsuario) {
        try {
            this.conectaBanco();
            this.executarSQL(
                    "SELECT "
                    + "idUsuario,"
                    + "nome_usuario,"
                    + "login_usuario,"
                    + "senha_usuario"
                    + " FROM"
                    + " usuario"
                    + " WHERE"
                    + " login_usuario = '"+pModelUsuario.getSenha_usuario()+"'"
                    + ";"
            );
            if (getResultSet().next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fechaBanco();
        }

    }
}
