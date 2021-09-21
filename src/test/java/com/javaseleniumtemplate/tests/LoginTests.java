package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;
    LoginFlows loginFlows;

    //Tests
    @Test
    public void efetuarLoginComSucesso(){
        //region Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        //endregion

        //region Parameters
        String usuario = "administrator";
        String senha = "adm";
        //endregion

        //region Test
        loginFlows.efetuarLogin(usuario, senha);
        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
        //endregion
    }

    @Test
    public void efetuarLoginSemInformarUsuario(){
        //region Objects instances
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        //endregion

        //region Parameters
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        String usuario = "inexistente";
        String senha = "123456";
        //endregion

        //region Test
        loginFlows.efetuarLogin(usuario, senha);
        Assert.assertEquals(mensagemErroEsperada, loginPage.retornaMensagemDeErroLogin());
        //endRegion
    }

    @Test
    public void efetuarLoginSemInformarSenha(){

        //region Objects instances
        loginPage = new LoginPage();
        //endregion

        //region Parameters
        String usuario = "administrator";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        //endregion

        //region Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.clicarEmLogin();
        loginPage.clicarEmLogin();
        loginPage.retornaMensagemDeErroLogin();
        Assert.assertEquals(mensagemErroEsperada, loginPage.retornaMensagemDeErroLogin());
        //endregion
    }

    @Test
    public void efetuarLoginComSenhaErrada(){
        //region Objects instances
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        //endregion

        //region Parameters
        String usuario = "administrator";
        String senha = "senhaerrada";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        //endregion

        //region Test
        loginFlows.efetuarLogin(usuario, senha);
        Assert.assertEquals(mensagemErroEsperada, loginPage.retornaMensagemDeErroLogin());
        //endregion

    }
    @Test
    public void efetuarLoginComSucesso_SenhaRetornadaDoDB(){
        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();

        //Parameteres
        String usuario = "administrator";
        String senha = UsuariosDBSteps.retornaSenhaDoUsuarioDB(usuario);

        //Test
        loginPage.preenhcerUsuario(usuario);
        loginPage.preencherSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
    }


    }