package br.com.pieropan.pagamentos.dto;

import br.com.pieropan.pagamentos.enums.StatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDTO {

    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String expiracao;
    private String codigo;
    private StatusEnum status;
    private Long formaDePagamentoId;
    private Long pedidoId;
}