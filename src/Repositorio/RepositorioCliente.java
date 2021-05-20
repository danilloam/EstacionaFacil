/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import ClassesBasicas.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


/**
 *
 * @author Danillo, Alexandre
 */
public class RepositorioCliente extends RepositorioConectaDB {

    Statement stm;
    ResultSet ret;

    public void Cadastrar(Cliente cliente) throws ExceptionGeral, SQLException {
        boolean retorno = false;
        String sql = "Select * from Cliente where cpf_cliente = '" + cliente.getCpf() + "'";
        stm = conectar();
        ret = stm.executeQuery(sql);
        while (ret.next()) {
            retorno = true;
            break;
        }
        desconectar();
        if (retorno == true) {
            throw new ExceptionGeral("Já existe um cliente cadastrado com este cpf.");

        } else {
            /*
             * Informa se a placa foi cadastrada no sistema
             */
            String sqlplaca = "Select * from Veiculo where Placa = '" + cliente.getVeiculo().getPlaca() + "'";
            stm = conectar();
            ret = stm.executeQuery(sqlplaca);
            while (ret.next()) {
                retorno = true;
                break;
            }
            desconectar();
            if (retorno == true) {
                throw new ExceptionGeral(" Já existe um registro ativo para esta placa.");

            } else {
                try {

                    String sqlCliente = "insert into Cliente(cpf_cliente,nome_cliente,endereco_cliente,numero_cliente,complemento_cliente,bairro_cliente,cidade_cliente,telefone_cliente)values('" + cliente.getCpf() + "', '" + cliente.getNome() + "','" + cliente.getEndereco() + "'," + cliente.getNumero() + ",'" + cliente.getComplemento() + "','" + cliente.getBairro() + "','" + cliente.getCidade() + "','" + cliente.getTelefone() + "')";
                    conectar().execute(sqlCliente);
                    desconectar();

                } catch (SQLException e) {
                    throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Cliente: " + e.getMessage());
                }
                try {

                    String sqlVeiculo = "insert into Veiculo(cpf_cliente,placa,tipo)values('" + cliente.getCpf() + "', '" + cliente.getVeiculo().getPlaca() + "','" + cliente.getVeiculo().getModelo() + "')";
                    conectar().execute(sqlVeiculo);
                    desconectar();

                } catch (SQLException e) {
                    throw new ExceptionGeral("Ocorreu um erro de inserção na tabela Veiculo: " + e.getMessage());
                }

                desconectar();
            }
        }
    }

    public void Alterar(Cliente cliente) throws ExceptionGeral, SQLException {
        boolean retorno = false;
        String sql = "Select * from Cliente where cpf_cliente = '" + cliente.getCpf() + "'";
        stm = conectar();
        ret = stm.executeQuery(sql);
        while (ret.next()) {
            retorno = true;
            break;
        }
        desconectar();
        if (retorno == false) {
            throw new ExceptionGeral("Não existe nenhum cliente cadastrado com este cpf.");

        } else {
            try {

                String sqlalterarCliente = "update Cliente set nome_cliente='" + cliente.getNome() + "',endereco_cliente='" + cliente.getEndereco() + "',numero_cliente=" + cliente.getNumero() + ",complemento_cliente='" + cliente.getComplemento() + "',bairro_cliente='" + cliente.getBairro() + "',cidade_cliente='" + cliente.getCidade() + "',telefone_cliente='" + cliente.getTelefone() + "'where cpf_cliente='" + cliente.getCpf() + "';";
                conectar().execute(sqlalterarCliente);
                desconectar();

            } catch (SQLException e) {
                throw new ExceptionGeral("Ocorreu um erro de Alteração na tabela Cliente: " + e.getMessage());
            }
        }
    }

    public void Remover(Cliente cliente) throws ExceptionGeral, SQLException {
    }

    public ArrayList<Cliente> Listar() throws ExceptionGeral, SQLException {
        ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
        try {
            conectar();
            PreparedStatement pstm = RepositorioConectaDB.getConnection().prepareStatement("Select * from Cliente");
            ret = pstm.executeQuery();
            while (ret.next()) {

                Cliente cliente = new Cliente();
                cliente.setCpf(ret.getString(1));
                cliente.setNome(ret.getString(2));
                cliente.setEndereco(ret.getString(3));
                cliente.setNumero(ret.getInt(4));
                cliente.setComplemento(ret.getString(5));
                cliente.setBairro(ret.getString(6));
                cliente.setCidade(ret.getString(7));
                cliente.setTelefone(ret.getString(8));
                listaCliente.add(cliente);
            }
            desconectar();
        } catch (SQLException e) {

            throw new ExceptionGeral("Ocorreu um erro no retorno de cliente: " + e.getMessage());

        }
        return listaCliente;
    }

    public ArrayList<Cliente> Select(Cliente filtro) throws SQLException, ExceptionGeral {
        ArrayList<Cliente> listafiltro = new ArrayList<Cliente>();
        boolean retorno = false;
        String sqlFiltro = "Select* from cliente where cpf_cliente = '" + filtro.getCpf() + "'";
        stm = conectar();
        ret = stm.executeQuery(sqlFiltro);
        while (ret.next()) {
            retorno = true;
            break;
        }
        desconectar();
        if (!retorno) {
            throw new ExceptionGeral(" Não existe nenhum cadastro ativo para o CPF informado.");
        } else {

            String sql = "Select * from Cliente where cpf_cliente = '" + filtro.getCpf() + "'";
            stm = conectar();
            ret = stm.executeQuery(sql);
            if (ret.next()) {
            }
            Cliente cliente = new Cliente();
            cliente.setCpf(ret.getString(1));
            cliente.setNome(ret.getString(2));
            cliente.setEndereco(ret.getString(3));
            cliente.setNumero(ret.getInt(4));
            cliente.setComplemento(ret.getString(5));
            cliente.setBairro(ret.getString(6));
            cliente.setCidade(ret.getString(7));
            cliente.setTelefone(ret.getString(8));
            listafiltro.add(cliente);
        }
        desconectar();
        return listafiltro;
    }
}
