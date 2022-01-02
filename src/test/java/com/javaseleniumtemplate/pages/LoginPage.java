package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.xpath("//input[@type='submit']");
    By loginErroTextArea = By.xpath("//*[@class='alert alert-danger']/p");

    //Actions
    public void fillUser(String usuario){
        sendKeys(usernameField, usuario);
    }

    public void fillPassword(String senha){
        sendKeys(passwordField, senha);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public String returnErrorMessage(){
        return getText(loginErroTextArea);
    }

    public void fillUserJs(String usuario){
        SendKeysJavaScript(usernameField, usuario);
    }

    public void fillPasswordJs(String password){
        SendKeysJavaScript(passwordField, password);
    }

    public void clickLoginJS(){
        ClickJavaScript(loginButton);
    }

    public String getCurrentUrl(){
        return getURL();
    }
}
