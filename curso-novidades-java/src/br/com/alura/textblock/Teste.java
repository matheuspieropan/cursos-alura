package br.com.alura.textblock;

public class Teste {

    public static void main(String[] args) {
        String texto = "\"Lorem ipsum dolor sit amet, \n" + "consectetur adipiscing elit, sed do eiusmod tempor \n"
                + "incididunt ut labore et dolore magna aliqua. \n"
                + "Ut enim ad minim veniam, quis nostrud exercitation \n"
                + "ullamco laboris nisi ut aliquip ex ea commodo \n"
                + "consequat. Duis aute irure dolor in reprehenderit \n"
                + "in voluptate velit esse cillum dolore eu fugiat \n"
                + "nulla pariatur. Excepteur sint occaecat cupidatat \n"
                + "non proident, sunt in culpa qui officia deserunt \n" + "mollit anim id est laborum.\"";

        String textBloco = """
				"Lorem ipsum dolor sit amet,\s
				consectetur adipiscing elit, sed do eiusmod tempor\s
				incididunt ut labore et dolore magna aliqua.\s
				Ut enim ad minim veniam, quis nostrud exercitation\s
				ullamco laboris nisi ut aliquip ex ea commodo\s
				consequat. Duis aute irure dolor in reprehenderit\s
				in voluptate velit esse cillum dolore eu fugiat\s
				nulla pariatur. Excepteur sint occaecat cupidatat\s
				non proident, sunt in culpa qui officia deserunt\s
				mollit anim id est laborum."
				           """;
        System.out.println(texto);
		System.out.println();
        System.out.println(textBloco);
    }
}