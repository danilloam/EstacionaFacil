/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * 
 */
package Negocio;

import ClassesBasicas.Usuario;
import Interface.InterfaceLogin;
import Repositorio.RepositorioUsuario;

/**
 *
 * @author Danillo
 */
public class NegocioUsuario implements InterfaceLogin {

    RepositorioUsuario repusuario = new RepositorioUsuario();

    public NegocioUsuario() {
    }

    @Override
    public boolean VerificaLogin(Usuario usuario) throws Exception {
        if (usuario.getLogin() == null | usuario.getLogin().trim().equals("")) {//Informa que o campo não pode estar vazio
            throw new Exception("Usuário ou senha inválido");
        }
        if (usuario.getSenha() == null | usuario.getSenha().trim().equals("")) {//informa que o campo não pode estar vazio
            throw new Exception("Usuário ou senha inválido");
        }
        return this.repusuario.VerificaLogin(usuario);
    }
}
