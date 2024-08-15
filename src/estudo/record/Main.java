package estudo.record;

public class Main {
    public static void main(String[] args) {
        var pessoa = new Pessoa("Fulano", "155115");
        String nome = pessoa.getNome();

        var pessoaRecord = new PessoaRecord("Nome", "123.465.789-00");
        String nomePessoaRecord = pessoaRecord.nome();

        //JSON -> { "id": 1, "nome": , "pessoa"}
        System.out.println(pessoaRecord.getCPFSemFormatacao());
    }
}
