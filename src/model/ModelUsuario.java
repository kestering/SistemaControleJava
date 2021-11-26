package model;
/**
*
* @author Thiago K.
*/
public class ModelUsuario {

    private int idUsuario;
    private String nome_usuario;
    private String login_usuario;
    private String senha_usuario;

    /**
    * Construtor
    */
    public ModelUsuario(){}

    /**
    * seta o valor de idUsuario
    * @param pIdUsuario
    */
    public void setIdUsuario(int pIdUsuario){
        this.idUsuario = pIdUsuario;
    }
    /**
    * @return pk_idUsuario
    */
    public int getIdUsuario(){
        return this.idUsuario;
    }

    /**
    * seta o valor de nome_usuario
    * @param pNome_usuario
    */
    public void setNome_usuario(String pNome_usuario){
        this.nome_usuario = pNome_usuario;
    }
    /**
    * @return nome_usuario
    */
    public String getNome_usuario(){
        return this.nome_usuario;
    }

    /**
    * seta o valor de login_usuario
    * @param pLogin_usuario
    */
    public void setLogin_usuario(String pLogin_usuario){
        this.login_usuario = pLogin_usuario;
    }
    /**
    * @return login_usuario
    */
    public String getLogin_usuario(){
        return this.login_usuario;
    }

    /**
    * seta o valor de senha_usuario
    * @param pSenha_usuario
    */
    public void setSenha_usuario(String pSenha_usuario){
        this.senha_usuario = pSenha_usuario;
    }
    /**
    * @return senha_usuario
    */
    public String getSenha_usuario(){
        return this.senha_usuario;
    }

    @Override
    public String toString(){
        return "ModelUsuario {" + "::idUsuario = " + this.idUsuario + "::nome_usuario = " + this.nome_usuario + "::login_usuario = " + this.login_usuario + "::senha_usuario = " + this.senha_usuario +  "}";
    }
}