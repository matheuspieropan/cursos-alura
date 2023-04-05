import desconto.CalculadoraDesconto;
import imposto.CalculadoraImposto;
import imposto.ISS;
import loja.Orcamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("1000"), 1);
        CalculadoraImposto calculadora = new CalculadoraImposto();
        System.out.println(calculadora.calcular(orcamento, new ISS()));
        CalculadoraDesconto calculadoraDesconto = new CalculadoraDesconto();
        System.out.println( calculadoraDesconto.calcular(orcamento));
    }
}