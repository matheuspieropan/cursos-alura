package br.com.alura.streams;

import java.util.List;

public class TesteStreams {

    public static void main(String[] args) {

        // ORDENANDO POR ORDEM ALFABÉTICA
        List<String> nomes = List.of("Matheus", "Marcos", "Lucas", "João");
        nomes.stream().sorted(String::compareTo).forEach(System.out::println);
    }
}