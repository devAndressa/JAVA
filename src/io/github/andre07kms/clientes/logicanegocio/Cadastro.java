package io.github.andre07kms.clientes.logicanegocio;

import java.util.Optional;
import java.util.UUID;

public interface Cadastro<TIPO> {
    void salvar(TIPO objetoCadastrar) throws Exception;
    Optional<TIPO> buscar(UUID codigo);
    void deletar(UUID codigo);
    void atualizar(TIPO objetoAtualizar);
    void imprimirRegistros();
}
