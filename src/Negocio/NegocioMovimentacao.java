/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import ClassesBasicas.Movimentacao;
import Interface.InterfaceMovimentacao;
import Repositorio.ExceptionGeral;
import Repositorio.RepositorioMovimentacao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Danillo
 */
public class NegocioMovimentacao implements InterfaceMovimentacao {

    private RepositorioMovimentacao repositorio = new RepositorioMovimentacao();

    @Override
    public void Entrada(Movimentacao veiculo) throws Exception {
        if (veiculo == null) {
            throw new Exception("A movimentação não foi instanciada");
        }
        if (veiculo.getPlaca() == null | veiculo.getPlaca().trim().equals("")) {
            throw new Exception("A placa não foi informada");
        }
        this.repositorio.Entrada(veiculo);
    }

    @Override
    public void Saida(Movimentacao veiculo) throws Exception {
        if (veiculo == null) {
            throw new Exception("A movimentação não foi instanciada");
        }
        if (veiculo.getPlaca() == null | veiculo.getPlaca().trim().equals("")) {
            throw new Exception("A placa não foi informada");
        }
        this.repositorio.Saida(veiculo);
    }
 public ArrayList<Movimentacao> ListarMovimentacao() throws Exception {
       return this.repositorio.Listar();
    }

}
