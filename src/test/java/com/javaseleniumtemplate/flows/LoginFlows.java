package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows(){
        loginPage = new LoginPage();
    }

    //Flows
    public void signIn(String username, String password){
        loginPage.fillUser(username);
        loginPage.clickLogin();
        loginPage.fillPassword(password);
        loginPage.clickLogin();
    }

    public void signInJs(String username, String password){
        loginPage.fillUserJs(username);
        loginPage.clickLoginJS();
        loginPage.fillPasswordJs(password);
        loginPage.clickLoginJS();
    }
}
