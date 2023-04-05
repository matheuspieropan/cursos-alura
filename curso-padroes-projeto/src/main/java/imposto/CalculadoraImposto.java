package imposto;

import enums.TipoImpostoEnum;
import loja.Orcamento;
import java.math.BigDecimal;

public class CalculadoraImposto {

    public BigDecimal calcular(Orcamento orcamento, TipoImpostoEnum tipoImposto) {
        switch (tipoImposto) {
            case ICMS -> {
                return orcamento.getValor().multiply(new BigDecimal("0.1"));
            }
            case ISS -> {
                return orcamento.getValor().multiply(new BigDecimal("0.06"));
            }
            default -> {
                return BigDecimal.ZERO;
            }
        }
    }
}