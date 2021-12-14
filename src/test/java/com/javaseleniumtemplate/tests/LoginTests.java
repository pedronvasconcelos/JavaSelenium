package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;



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
        loginFlows.signIn(usuario, senha);
        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
        //endregion
    }

    @Test
    public void efetuarLoginComJavaScript(){

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
        loginFlows.signInJs(usuario, senha);
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
        String senha = "adm";
        //endregion

        //region Test
        loginFlows.signIn(usuario, senha);
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());
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
        loginPage.fillUser(usuario);
        loginPage.clickLogin();
        loginPage.clickLogin();loginPage.returnErrorMessage();
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());
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
        loginFlows.signIn(usuario, senha);
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());
        //endregion

    }

    @Test
    public void efetuarLoginComUsuarioInexistenet(){

        //region Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        //endregion

        //region Parameters
        String usuario = "inexistente";
        String senha = "adm";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        //endregion

        //region Test
        loginFlows.signIn(usuario, senha);
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());
        //endregion
    }


    }