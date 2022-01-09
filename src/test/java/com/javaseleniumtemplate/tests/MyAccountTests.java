package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.dbsteps.UsuariosDBSteps;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.LoginPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MyAccountTests extends TestBase {
    //Objects
    LoginPage loginPage;
    MainPage mainPage;
    LoginFlows loginFlows;
    MyAccountPage myAccountPage;

    //Tests

    @Test
    public void updateRealname(){

        //region Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();
        //endregion

        //Parameters
        String usuario = "administrator";
        String senha = "adm";
        String newName = "New Name";
        String successMessage = "Real name successfully updated";


        //region Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUserDropdown();
        mainPage.clickMyAccount();
        myAccountPage.fillRealName("New Name");
        myAccountPage.clickUpdateUser();

        //Assertions
        Assert.assertEquals(successMessage, myAccountPage.returnSucessMessage());
        Assert.assertEquals(newName, UsuariosDBSteps.returnUserName(usuario));
    }



    @Test
    public void createApiTokenSuccessfully(){

        //region Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();
        //endregion

        //region Parameters
        String usuario = "administrator";
        String senha = "adm";
        String tokenName = "Token API";
        String successMessage = "Token to use for accessing API.";
        //endregion

        //region Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUserDropdown();
        mainPage.clickMyAccount();
        myAccountPage.accessApiTokens();
        myAccountPage.fillTokenName(tokenName);
        myAccountPage.clickCreateApiToken();
        //endregion

        //Assertions
        Assert.assertEquals(successMessage, myAccountPage.returnTokenMessage());
    }

    @Test
    public void validateRequiredTokenName(){

        //region Objects instances
        loginPage = new LoginPage();
        mainPage = new MainPage();
        loginFlows = new LoginFlows();
        myAccountPage = new MyAccountPage();
        //endregion

        //region Parameters
        String usuario = "administrator";
        String senha = "adm";
        String errorMessage = "Please fill out this field.";
        //endregion

        //region Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUserDropdown();
        mainPage.clickMyAccount();
        myAccountPage.accessApiTokens();
        myAccountPage.clickCreateApiToken();
        //endregion

        //Assertions
        Assert.assertEquals(errorMessage, myAccountPage.alertApiToken());
    }


    }