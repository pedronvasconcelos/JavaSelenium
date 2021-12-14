package com.javaseleniumtemplate.pages;
import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ManageGlobalProfilePage extends PageBase{

    //Mapping ManageProjects
    By platformField = By.id("platform");
    By osField = By.id("os");
    By osVersionField = By.id("os_build");
    By addProfileBUtton = By.xpath("//button[@class='btn btn-primary btn-white btn-round']");
    By sucessText = By.xpath("//*[@class='alert alert-success center']/p");



    //Actions

    public void fillPlatformField(String platform){
        sendKeys(platformField, platform);
    }

    public void fillOsField(String os){
        sendKeys(osField, os);
    }

    public void fillOsVersion (String version){
        sendKeys(osVersionField, version);
    }

    public void clickAddProfile(){
        click(addProfileBUtton);
    }

    public String returnSucessText(){
        return getText(sucessText);
    }

    public String alertOsVersionMessage(){
      return  returnAlertRequired(osVersionField);
    }

    public String alertOsFieldMessage(){
        return  returnAlertRequired(osField);
    }

    public String alertPlatformMessage(){
        return  returnAlertRequired(platformField);
    }

}
