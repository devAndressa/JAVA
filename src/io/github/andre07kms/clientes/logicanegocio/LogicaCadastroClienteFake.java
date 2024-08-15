package io.github.andre07kms.clientes.logicanegocio;

import io.github.andre07kms.clientes.dominio.Cliente;

import javax.swing.*;
import java.util.Optional;
import java.util.UUID;

public class LogicaCadastroClienteFake implements Cadastro<Cliente> {
    @Override
    public void salvar(Cliente cliente) {
        JOptionPane.showMessageDialog(null, cliente);
    }

    @Override
    public Optional<Cliente> buscar(UUID codigo) {
        return null;
    }

    @Override
    public void deletar(UUID codigo) {

    }

    @Override
    public void atualizar(Cliente objetoAtualizar) {

    }

    @Override
    public void imprimirRegistros() {

    }
}
