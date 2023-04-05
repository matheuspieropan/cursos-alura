package imposto;

import loja.Orcamento;

import java.math.BigDecimal;

public class CalculadoraImposto {
    public BigDecimal calcular(Orcamento orcamento){
        return orcamento.getValor().multiply(new BigDecimal("0.1"));
    }
}