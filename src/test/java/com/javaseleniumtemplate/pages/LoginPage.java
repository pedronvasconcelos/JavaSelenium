package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    //Mapping
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By emailField = By.name("email");
    By loginButton = By.xpath("//input[@type='submit']");
    By loginErroTextArea = By.xpath("//div[@class='alert alert-danger']/p");
    By successTextArea = By.xpath("//div[@class='alert alert-success center']/p[2]");
    By lostPasswordLink = By.xpath("//fieldset/a");

    //Actions
    public void fillUser(String usuario){
        sendKeys(usernameField, usuario);
    }

    public void fillPassword(String senha){
        sendKeys(passwordField, senha);
    }

    public void fillEmail(String email){
        sendKeys(emailField, email);
    }

    public void clickLogin(){
        click(loginButton);
    }

    public String returnErrorMessage(){
        return getText(loginErroTextArea);
    }

    public String returnSuccessMessage(){
        return getText(successTextArea);
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

    public void clickLostPassword(){
        click(lostPasswordLink);
    }
}
