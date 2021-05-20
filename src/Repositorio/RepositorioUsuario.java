/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import ClassesBasicas.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Danillo, Alexandre
 */
public class RepositorioUsuario extends RepositorioConectaDB {

    public boolean VerificaLogin(Usuario filtro) throws ExceptionGeral, SQLException {
boolean retorno = false;
            String sql = "Select * from usuario where login = '" + filtro.getLogin() + "' and senha='" + filtro.getSenha() + "'";
            Statement stm = conectar();
            ResultSet ret = stm.executeQuery(sql);
            while (ret.next()) {
                retorno = true;
                break;
            } 
            
            desconectar();
            return retorno;
            
    }
}