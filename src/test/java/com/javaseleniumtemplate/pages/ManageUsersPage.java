package com.javaseleniumtemplate.pages;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ManageUsersPage extends PageBase{

    //Mapping ManageProjects
    By createNewAccButton = By.xpath("//a[@class='btn btn-primary btn-white btn-round btn-sm']");
    By usernameField = By.id("user-username");
    By realnameField = By.id("user-realname");
    By emailField = By.id("email-field");
    By createUserButton = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    By acessLevelComboBox = By.id("user-access-level");
    By successMessage = By.xpath("//p[@class='bold bigger-110']");
    By deleteUserButton = By.xpath("//input[@value='Delete User']");
    By updateUserButton = By.xpath("//input[@value='Update User']");
    By deleteAccountButton = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");
    By errorText = By.xpath("//p[@class='bold']");
    By userFilterText = By.id("search");
    By userLink = By.cssSelector("a[href*='manage_user_edit']");
    By applyFilterButton = By.xpath("//input[@value='Apply Filter']");
    //Actions

    public void clickCreateNewAcc(){
        click(createNewAccButton);
    }

    public void fillUsernameField(String username){
        sendKeys(usernameField, username);
    }

    public void fillRealnameField(String realname){
        sendKeys(realnameField, realname);
    }

    public void fillEmailField(String email){
        clearAndSendKeys(emailField, email);
    }

    public void clickCreateUser(){
        click(createUserButton);
    }

    public String getSucessText(){
       return getText(successMessage);
    }

    public void clickUserLink(String user){
        By userLink = By.linkText(user);
        click(userLink);
    }

    public void clickDeleteUser(){
        click(deleteUserButton);
    }

    public void clickDeleteAccount(){
        click(deleteAccountButton);
    }

    public void clickUpdateAccount(){
        click(updateUserButton);
    }

    public void selectAccessLevel(String access){
        comboBoxSelectByVisibleText(acessLevelComboBox, access);
    }

    public String getErrorText(){
        return getText(errorText);
    }

    public void fillUserFilter(String user){
        sendKeys(userFilterText, user);
    }

    public String getUserLinkText(){
        return getText(userLink);
    }

    public void clickApplyFilter(){
        click(applyFilterButton);
    }
}
