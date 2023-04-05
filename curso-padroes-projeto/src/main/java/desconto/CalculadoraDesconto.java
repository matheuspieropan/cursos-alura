package desconto;

import loja.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDesconto {

    public BigDecimal calcular(Orcamento orcamento){
        Desconto desconto = new DescontoMaisDeCincoItens(new DescontoMaiorQueQuinhentos(new SemDesconto()));
        return desconto.calcular(orcamento);
    }
}