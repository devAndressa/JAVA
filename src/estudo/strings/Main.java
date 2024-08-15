package estudo.strings;

public class Main {
    static String valor = "Maçã";

    public static void main(String[] args) {
        String hello = "Hello";

        //ignora letras maisculas de minusculas
        System.out.println("Parece com hello: " + hello.equalsIgnoreCase("hello"));

        // mostra palavras que comecem com...
        System.out.println("Comeca com He? " + hello.startsWith("He"));

        //mostra palavras que terminam com ...
        System.out.println("Termina com lo? " + hello.endsWith("lo"));

        String nomeCompleto = "Maria Andressa Monteiro";
        String[] partesDoNome = nomeCompleto.split(" ");
        System.out.println(partesDoNome[0]);
        System.out.println(partesDoNome[1]);
        System.out.println(partesDoNome[2]);
    }
    private static void tamanhoString(){
       int tamanho = valor.length();
        System.out.println("Tamanho: " + tamanho);
    }

    private static void pegarCaracteres(){
        char caractere = valor.charAt(0);
        char ultimo = valor.charAt(valor.length() - 1);
        System.out.println("Primeiro e ultimo Caracteres: " + caractere + " e " + ultimo);
    }

    private static void trabalhandoComSubstring(){
        String pedaco = valor.substring(0,1);
        System.out.println("pedaco da string: " + pedaco);
    }

    private static void exemploIndexOf(){
        int indice = valor.indexOf("r");
        System.out.println("Indice letra a: " + indice);

        String nome = "Pedro da Silva";

        //-1 -> retorna esse valor quando nao encontrado na String
        indice = nome.indexOf("Silva");

        System.out.println("Indice encontrado: " + indice);

        if(nome.indexOf("Pedro") != -1){
            System.out.println("Encontrei " + nome);
        }else{
            System.out.println("Não encontre esse nome.");
        }
    }
    private static void exemploCase(){
        String string = "Andressa";

        String caixaAlta = string.toUpperCase();
        System.out.println("Caixa alta: " + caixaAlta);

        String caixaBaixa = string.toLowerCase();
        System.out.println("Caixa alta: " + caixaBaixa);

    }

    //Remove os espaços em braco antes e depois da string.
    private static void removerEspacosEmBranco(){
        String string = " Pedro da silva       ";
        String stringSemEspacos = string.trim();
        System.out.println(stringSemEspacos.length());
        System.out.println(stringSemEspacos);
    }

    //Altera um elemento por outro
    private static void replace(){
        String novaMaca = valor
                .replace("ã", "a")
                .replace("ç","c");
        System.out.println(novaMaca);

        String cpf = "656.484.803-00";
        System.out.println(cpf
                .replace(".", "")
                .replace("-", ""));
    }
}
