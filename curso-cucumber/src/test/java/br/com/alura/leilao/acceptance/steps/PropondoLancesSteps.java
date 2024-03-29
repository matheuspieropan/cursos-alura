package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PropondoLancesSteps {

    Lance lance;
    Leilao leilao;
    List<Lance> lista;

    @Before
    public void setup() {
        this.lista = new ArrayList<>();
        leilao = new Leilao("iPhone 14 Pro Max");
    }

    @Dado("um lance valido")
    public void dado_um_lance_valido() {
        Usuario usuario = new Usuario("Matheus");
        lance = new Lance(usuario, BigDecimal.TEN);
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

    @Dado("um lance de {double} reais do usuario {string}")
    public void um_lance_de_reais_do_usuario_fulano(Double valor, String usuario) {
        Lance lance = new Lance(new Usuario(usuario), new BigDecimal(valor));
        lista.add(lance);
    }

    @Quando("propoe varios lances ao leilao")
    public void propoe_varios_lances_ao_leilao() {
        lista.forEach(lance -> leilao.propoe(lance));
    }

    @Dado("um lance invalido de {double} reais")
    public void um_lance_de_reais(Double valor) {
        this.lance = new Lance(new BigDecimal(valor));
    }

    @Entao("o lance nao eh aceito")
    public void o_lance_nao_eh_aceito() {
        Assert.assertEquals(0, leilao.getLances().size());
    }

    @Entao("os lances sao aceitos")
    public void os_lances_sao_aceitos() {
        Assert.assertEquals(this.lista.size(), leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
        Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
    }

    @Entao("o segundo nao eh aceito")
    public void o_segundo_nao_eh_aceito() {
        Assert.assertEquals(1, leilao.getLances().size());
        Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
    }

    @Dado("dois lances")
    public void dois_lances(DataTable dataTable) {
        List<Map<String, String>> valores = dataTable.asMaps();

        for (Map<String, String> map : valores) {
            String valor = map.get("valor");
            String nomeUsuario = map.get("nomeUsuario");

            Lance lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
            lista.add(lance);
        }
    }
}