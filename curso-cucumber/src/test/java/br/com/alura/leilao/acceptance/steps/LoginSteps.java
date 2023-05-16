package br.com.alura.leilao.acceptance.steps;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class LoginSteps {

    private Browser browser;
    private LoginPage loginPage;
    private LeiloesPage leiloesPage;

    @Dado("o usuario valido")
    public void o_usuario_valido() {
        dadoUsuario();
    }

    @Quando("realiza login")
    public void realiza_login() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
    }

    @Entao("é redirecionado para a pagina de leiloes")
    public void é_redirecionado_para_a_pagina_de_leiloes() {
        Assert.assertTrue(leiloesPage.estaNaPaginaDeLeiloes());
        browser.clean();
    }

    @Dado("o usuario invalido")
    public void o_usuario_invalido() {
        dadoUsuario();
    }

    private void dadoUsuario() {
        browser = new Browser();
        browser.seed();
        loginPage = browser.getLoginPage();
    }

    @Quando("tenta se logar")
    public void tenta_se_logar() {
        leiloesPage = this.loginPage.realizaLoginComo("fulano", "passsss");
    }

    @Entao("continua na página de login")
    public void continua_na_página_de_login() {
        Assert.assertFalse(leiloesPage.estaNaPaginaDeLeiloes());
    }
}