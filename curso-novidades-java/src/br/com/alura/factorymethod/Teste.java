package br.com.alura.factorymethod;

import java.util.HashMap;
import java.util.List;

public class Teste {

	public static void main(String[] args) {
		List<String> nomesImutavel = List.of("primeiroNome", "segundoNome", "terceiroNome");
//		 Utilizar o VAR pode ser uma opção para evitar algo do tipo: EstacionamentoGratuito estacionado = ....
//		 ficando apenas var estacionamento = ...
		var cpfPorNomes = new HashMap<String, String>();
		System.out.println(nomesImutavel);
		System.out.println(cpfPorNomes);
	}
}