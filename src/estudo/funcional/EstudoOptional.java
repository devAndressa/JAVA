package estudo.funcional;

import estudo.exception.CpfinvalidoException;
import io.github.andre07kms.clientes.dominio.Cliente;
import io.github.andre07kms.clientes.dominio.enums.TipoSexo;
import io.github.andre07kms.clientes.logicanegocio.Cadastro;
import io.github.andre07kms.clientes.logicanegocio.LogicaCadastroMemoria;

import java.util.Optional;
import java.util.UUID;

public class EstudoOptional {

    static Optional<Cliente> clienteVazio(){
        return Optional.empty();
    }

    static Optional<Cliente> clientePopulado(){
        var cliente = new Cliente();
        cliente.setNome("Andressa");
        cliente.setSexo(TipoSexo.F);
        cliente.setCpf("12345678912");
        cliente.setIdade(32);
        return Optional.of(cliente);
    }
    public static void main(String[] args) throws CpfinvalidoException {

        var possivelCliente = new Cliente();
       // possivelCliente.setSexo(TipoSexo.F);

      //  if(possivelCliente.isPresent()) {
     //       var cliente = possivelCliente.get();

    //            if(cliente.getSexo() != null){
      //          System.out.println(cliente.getSexo().getDescricao());
        //    }

        ///}

        var sexoCliente = Optional
                .ofNullable(possivelCliente)
                .map(cliente -> cliente.getSexo())
                .map(tipoSexo -> tipoSexo.getDescricao())
                .orElse("Não encontrado");

        System.out.println(sexoCliente);
    }

    private static void exemplosIFPresent() throws CpfinvalidoException {
        var logica = new LogicaCadastroMemoria();

        var cliente = new Cliente();
        cliente.setIdade(32);
        cliente.setNome("Fulano");
        cliente.setSexo(TipoSexo.F);
        cliente.setCpf("01234567891");
        cliente.setFoto(new byte[]{});

        var codigoParaBuscar = cliente.getCodigo();

        logica.salvar(cliente);
        System.out.println("Antes de remover:");
        logica.imprimirRegistros();

        logica.deletar(UUID.randomUUID());

        System.out.println("Depois de remover:");
        logica.imprimirRegistros();
    }

    private static void trabalhandocomOrElse() {
        Optional<Cliente> possivelCliente = clientePopulado();

        var cliente = possivelCliente.orElse(new Cliente());

        cliente = possivelCliente.orElseGet( () -> new Cliente() );

        cliente = possivelCliente
                .orElseThrow( () -> new RuntimeException("O cliente deveria estar vazio!"));

        System.out.println(cliente.getNome());
    }

    private static void exemplosBasicosOptional() {
        var cliente = new Cliente();
        cliente.setNome("Alguem");


        Optional<Cliente> possivelCliente = Optional.ofNullable(null);

        if(possivelCliente.isPresent()){
            cliente = possivelCliente.get();
            System.out.println(cliente.getNome());
        }

        var logica = new LogicaCadastroMemoria();
        var clienteEncontrado = logica.buscar(UUID.randomUUID());

        System.out.println(clienteEncontrado.get().getSexo().getDescricao());
    }
}
