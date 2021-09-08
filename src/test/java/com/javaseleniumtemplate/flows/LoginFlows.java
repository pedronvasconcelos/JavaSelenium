package com.javaseleniumtemplate.flows;

import com.javaseleniumtemplate.pages.LoginPage;

public class LoginFlows {
    //Objects and constructor
    LoginPage loginPage;

    public LoginFlows(){
        loginPage = new LoginPage();
    }

    //Flows
    public void efetuarLogin(String username, String password){
        loginPage.preenhcerUsuario(username);
        loginPage.clicarEmLogin();
        loginPage.preencherSenha(password);
        loginPage.clicarEmLogin();
    }
}
