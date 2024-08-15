package io.github.andre07kms.clientes.dominio;

import estudo.exception.CpfinvalidoException;
import io.github.andre07kms.clientes.dominio.enums.TipoSexo;
import io.github.andre07kms.clientes.logicanegocio.ValidadorCliente;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Cliente implements Comparable<Cliente>{
    private UUID codigo;
    private String nome;
    private String cpf;
    private TipoSexo sexo;
    private Integer idade;
    private Boolean ativo;
    private byte[] foto;

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Cliente() {

        this.codigo = UUID.randomUUID();
        System.out.println("Código do cliente:" + this.codigo.toString());
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoSexo getSexo() {
        return sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (!codigo.equals(cliente.codigo)) return false;
        if (!nome.equals(cliente.nome)) return false;
        if (!cpf.equals(cliente.cpf)) return false;
        return sexo == cliente.sexo;
    }

    @Override
    public int hashCode() {
        int result = codigo.hashCode();
        result = 31 * result + nome.hashCode();
        result = 31 * result + cpf.hashCode();
        result = 31 * result + sexo.hashCode();
        return result;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nome.compareTo(o.getNome());
    }

    public static class Main {
        public static void main(String[] args) {
    //        try {
    //            Cliente cliente = new Cliente();
    //            cliente.setSexo(TipoSexo.F);
    //            String descricao = cliente.getSexo().getDescricao();
    //            System.out.println(descricao);
    //        }catch (NullPointerException e) {
    //            System.out.println("O tipo sexo esta null");
    //        }
    //
    //        Cliente cliente = new Cliente();
    //        cliente.setCpf(("12054487945"));
    //        try {
    //            ValidadorCliente.validar(cliente);
    //            System.out.println("Cpf ok!");
    //        }catch (CpfinvalidoException e){
    //            System.out.println(e.getMessage());
    //        }catch (RuntimeException e){
    //            System.out.println(e.getMessage());
    //        }catch (Exception e){
    //            System.out.println("Erro inesperado!!");
    //        }finally {
    //            System.out.println("Fui executado no finally!!");
    //        }

            Scanner scanner = new Scanner(System.in);
            try{
                Cliente c = new Cliente();
                String cpf = scanner.nextLine();
                c.setCpf(cpf);
                ValidadorCliente.validar(c);
            }catch(CpfinvalidoException e){
                System.out.println("Cpf Invalido!");
            }finally {
                System.out.println("Fechando o scanner:");
                scanner.close();
                System.out.println("Scanner fechado");
            }
        }
    }
}
