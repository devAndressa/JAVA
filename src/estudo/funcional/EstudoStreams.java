package estudo.funcional;

import java.util.List;
import java.util.stream.Collectors;

public class EstudoStreams {
    public static void main(String[] args) {
        List<String> nomes =
                List.of("Ana","Maria","Pedro","Elizabete","Marcos");

        nomes.stream().forEach(System.out::println);

        System.out.println("Nomes ate 5 caracteres:");
        nomes.stream().filter(nome -> nome.length() <= 5)
                .forEach(System.out::println);

        List<Character> primeirasLetras =
        nomes.stream()
                .map(nome -> nome.charAt(0))
                .collect(Collectors.toList());

        primeirasLetras.forEach(letra -> System.out.println(letra));


    }
}
