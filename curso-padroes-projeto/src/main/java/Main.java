import enums.TipoImpostoEnum;
import imposto.CalculadoraImposto;
import loja.Orcamento;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new BigDecimal("100"));
        CalculadoraImposto calculadora = new CalculadoraImposto();
        System.out.println(calculadora.calcular(orcamento, TipoImpostoEnum.ICMS));
    }
}