package br.com.alura.switchexpression;

public class Teste {

    public static void main(String[] args) {
        String nome = "João";
        switch (nome) {
            case "Renata" -> System.out.println("Não é renata!");
            case "Fernando" -> System.out.println("Não é fernando!");
            case "João" -> System.out.println("Acertou!");
            default -> System.out.println("Nenhum resultado encontrado!");
        }
    }
}
