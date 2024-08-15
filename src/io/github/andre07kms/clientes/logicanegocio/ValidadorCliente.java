package io.github.andre07kms.clientes.logicanegocio;

import io.github.andre07kms.clientes.dominio.Cliente;
import estudo.exception.CpfinvalidoException;
import estudo.exception.DadoObrigatorioException;

public class ValidadorCliente {
    public static void validar(Cliente cliente) throws CpfinvalidoException{
        if(cliente.getCpf().length() != 11){
            throw new CpfinvalidoException("Cpf invalido");
        }

        validarDadosObrigatorios(cliente);
    }

    private static void validarDadosObrigatorios(Cliente cliente){
        if(cliente.getNome() == null || cliente.getNome().isBlank()){
            throw new DadoObrigatorioException("Campo nome obrigatorio!");
        }
        if(cliente.getSexo() == null){
            throw new DadoObrigatorioException("Campo sexo é obrigatorio!");
        }
        if(cliente.getFoto() == null){
            throw new DadoObrigatorioException("Foto do Cliente é obrigatoria!");
        }
    }
}
