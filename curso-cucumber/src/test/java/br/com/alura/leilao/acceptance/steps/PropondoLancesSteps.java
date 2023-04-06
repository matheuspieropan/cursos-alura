package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import org.junit.Assert;

import java.math.BigDecimal;
import java.math.BigInteger;

public class PropondoLancesSteps {

    Lance lance;
    Lance lance10;
    Lance lance15;
    Leilao leilao;

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Matheus");
        lance = new Lance(usuario, BigDecimal.TEN);
        leilao = new Leilao("iPhone 14 Pro Max");
    }

    @Quando("propoe ao leilao")
    public void quando_propoe_o_lance() {
        leilao.propoe(lance);
    }

    @Entao("o lance eh aceito")
    public void entao_o_lance_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, lance.getValor());
    }

    @Dado("varios lances validos")
    public void varios_lances_validos() {
        Usuario usuario = new Usuario("Samira");
        lance10 = new Lance(usuario, new BigDecimal(BigInteger.TEN));
        Usuario usuario2 = new Usuario("Jair Bolsolula da Silva");
        lance15 = new Lance(usuario2, new BigDecimal("15.0"));
        leilao = new Leilao("iPhone 14 Pro Max");
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        leilao.propoe(lance10);
        leilao.propoe(lance15);
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assert.assertEquals(2, leilao.getLances().size());
        Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
        Assert.assertEquals(new BigDecimal("15.0"), leilao.getLances().get(1).getValor());
    }
}