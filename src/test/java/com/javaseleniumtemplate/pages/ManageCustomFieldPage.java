package com.javaseleniumtemplate.pages;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ManageCustomFieldPage extends PageBase{

    //Mapping ManageProjects
    By nameField = By.name("name");
    By newCustomButton = By.xpath("//input[@class='btn btn-primary btn-sm btn-white btn-round']");
    By sucessText = By.xpath("//*[@class='alert alert-success center']/p");
    By errorText = By.xpath("//div[@class='alert alert-danger']/p[@class='bold']");
    By typeCombobox = By.xpath("//select[@id='custom-field-type']");
    By updateButton = By.xpath("//input[@class='btn btn-primary btn-white btn-round']");



    //Actions

    public void fillNameField(String name){
        sendKeys(nameField, name);
    }

    public void clickNewCustom(){
        click(newCustomButton);
    }

    public String returnSucessText(){
        return getText(sucessText);
    }

    public void clickCustomField(String customField){
        By fieldName = By.linkText(customField);
        click(fieldName);
    }

    public void selectType(String type){
        comboBoxSelectByVisibleText(typeCombobox, type);
    }

    public void clickUpdate(){
        click(updateButton);
    }

    public String returnErrorText(){
        return getText(errorText);
    }
}
