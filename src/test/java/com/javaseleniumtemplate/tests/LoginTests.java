package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class LoginTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;
    LoginFlows loginFlows;
    SoftAssert softAssert;

    //Tests
    @Test
    public void loginSuccessfully(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();


        //Parameters
        String usuario = "administrator";
        String senha = "adm";


        //Test
        loginFlows.signIn(usuario, senha);

        //Assert
        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());

    }

    @Test
    public void loginWithJavaScript(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();

        //Parameters
        String usuario = "administrator";
        String senha = "adm";

        //Test
        loginFlows.signInJs(usuario, senha);

        //Assert
        Assert.assertEquals(usuario, mainPage.retornaUsernameDasInformacoesDeLogin());
    }

    @Test
    public void loginWithoutAUsername(){
        //Objects instances
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();


        //Parameters
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";
        String usuario = "inexistente";
        String senha = "adm";


        //Test
        loginFlows.signIn(usuario, senha);

        //Assert
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());

    }

    @Test
    public void loginWithoutPassword(){

        //Objects instances
        loginPage = new LoginPage();


        //Parameters
        String usuario = "administrator";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";


        //Test
        loginPage.fillUser(usuario);
        loginPage.clickLogin();
        loginPage.clickLogin();

        //Assert
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());

    }

    @Test
    public void loginWithWrongPassword(){
        //region Objects instances
        loginPage = new LoginPage();
        loginFlows = new LoginFlows();
        //endregion

        //Parameters
        String usuario = "administrator";
        String senha = "senhaerrada";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";


        //Test
        loginFlows.signIn(usuario, senha);

        //Assert
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());


    }

    @Test
    public void loginWithNonExistentUser(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();


        //Parameters
        String usuario = "inexistente";
        String senha = "adm";
        String mensagemErroEsperada = "Your account may be disabled or blocked or the username/password you entered is incorrect.";


        //region Test
        loginFlows.signIn(usuario, senha);

        //Assert
        Assert.assertEquals(mensagemErroEsperada, loginPage.returnErrorMessage());

    }

    @Test
    public void logoutSuccessfully(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();


        //Parameters
        String usuario = "administrator";
        String senha = "adm";
        String pageUrl = "http://localhost:8989/login_page.php";


        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUserDropdown();
        mainPage.clickLogout();


        //Assertions
        Assert.assertEquals(pageUrl, loginPage.getCurrentUrl());
    }

    @Test
    public void validateRestrictionsUserViewer(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        softAssert = new SoftAssert();


        //Parameters
        String usuario = "viewer";
        String senha = "adm";


        //Test
        loginFlows.signIn(usuario, senha);


        //Assertions
        softAssert.assertFalse(mainPage.returnIfReportExists());
        softAssert.assertFalse(mainPage.returnIfManageExists());
        softAssert.assertAll();
    }

    @Test
    public void validateRestrictionsUserDeveloper(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        softAssert = new SoftAssert();


        //Parameters
        String usuario = "developer";
        String senha = "adm";


        //Test
        loginFlows.signIn(usuario, senha);


        //Assertions
        softAssert.assertFalse(mainPage.returnIfManageExists());
        softAssert.assertTrue(mainPage.returnIfReportExists());
        softAssert.assertAll();
    }


    @Test
    public void recoveryPasswordWithWrongEmail(){

        //Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();


        //Parameters
        String usuario = "recoverypw";
        String email = "wrong@user.com.br";
        String errorMessage = "APPLICATION ERROR #1903";


        //Test
        loginPage.fillUser(usuario);
        loginPage.clickLogin();
        loginPage.clickLostPassword();
        loginPage.fillEmail(email);
        loginPage.clickLogin();


        //Assert
        Assert.assertTrue(loginPage.returnErrorMessage().contains(errorMessage));

    }

    }