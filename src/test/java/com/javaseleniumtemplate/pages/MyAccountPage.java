package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MyAccountPage extends PageBase {
    //Mapping
    By apiTokensMenu = By.xpath("//a[@href='/api_tokens_page.php']");
    By realNameField = By.id("realname");
    By tokenNameField = By.id("token_name");
    By apiTokensButton = By.xpath("//a[@href='api_tokens_page.php']");
    By createApiTokenButton = By.xpath("//*[@id='account-create-api-token-form']//button");
    By tokenText = By.xpath("//h2");
    By successMessage = By.xpath("//p[@class='bold bigger-110']");
    By updateUserButton = By.xpath("//input[@type='submit']");


    //Actions
    public void accessApiTokens(){
        click(apiTokensMenu);
    }

    public void fillTokenName(String token){
        sendKeys(tokenNameField, token);
    }

    public void clickApiTokens(){
        click(apiTokensButton);
    }

    public void fillRealName(String name){
        clearAndSendKeys(realNameField, name);
    }
    public void clickCreateApiToken(){
        click(createApiTokenButton);
    }

    public String returnTokenMessage(){
        return getText(tokenText);
    }

    public String alertApiToken(){
        return returnAlertRequired(tokenNameField);
    }

    public String returnSucessMessage(){
        return getText(successMessage);
    }

    public void clickUpdateUser(){
        click(updateUserButton);
    }

}
