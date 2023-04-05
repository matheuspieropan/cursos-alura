package desconto;

import loja.Orcamento;
import java.math.BigDecimal;

public class DescontoMaiorQueQuinhentos extends Desconto {

    public DescontoMaiorQueQuinhentos(Desconto proximo) {
        super(proximo);
    }

    public BigDecimal calcular(Orcamento orcamento) {
        if (orcamento.getValor().compareTo(new BigDecimal("500")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal("0.05"));
        }
        return proximo.calcular(orcamento);
    }
}