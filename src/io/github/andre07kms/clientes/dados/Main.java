package io.github.andre07kms.clientes.dados;

import io.github.andre07kms.clientes.dominio.Cliente;
import io.github.andre07kms.clientes.dominio.enums.TipoSexo;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class Main {
    public static void main(String[] args) throws SQLException {
       // exemploInsert();

        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        List<Cliente> lista = dao.listar();

        lista.forEach(System.out::println);

        conexao.close();

    }

    private static void exemploDelete() throws SQLException {
        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);


        dao.deletar(UUID.fromString("a3d1b95b-644e-4bd2-bade-defe3dc67b2b"));
        conexao.close();
    }

    private static void exemploAtualizacao() throws SQLException {
        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        Cliente cliente = new Cliente();
        cliente.setCodigo(UUID.fromString("a3d1b95b-644e-4bd2-bade-defe3dc67b2b"));
        cliente.setNome("zezinho da silva");
        cliente.setSexo(TipoSexo.M);
        cliente.setCpf("15487946657");
        cliente.setIdade(36);

        dao.atualizar(cliente);
        conexao.close();
    }

    private static void exemploInsert() throws SQLException {
        Cliente cliente = new Cliente();
        cliente.setNome("mariazinha");
        cliente.setSexo(TipoSexo.F);
        cliente.setCpf("65185756188");
        cliente.setIdade(54);


        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO dao = new ClienteDAO(conexao);

        dao.inserir(cliente);

        conexao.close();
    }
}
