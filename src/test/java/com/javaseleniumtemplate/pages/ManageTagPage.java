package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ManageTagPage extends PageBase{
    //Mapping
    By nameField = By.id("tag-name");
    By descriptionField = By.id("tag-description");
    By createButton = By.name("config_set");
    By updateTagButton = By.xpath("//input[@value='Update Tag']");
    By deleteTagButton = By.xpath("//input[@value='Delete Tag']");
    By nameTagText = By.xpath("//tr[2]/td[2]");
    By descriptionTagText = By.xpath("//tr[6]/td[2]");



    public void fillName(String name){
        clear(nameField);
        sendKeys(nameField, name);
    }

    public void fillDescription(String description){
        clear(descriptionField);
        sendKeys(descriptionField, description);
    }

    public void clickCreate(){
        click(createButton);
    }

    public String returnCreatedTag(String tag){
        By tagName = By.linkText(tag);
        return getText(tagName);
    }

    public void clickTag(String tag){
        By tagLink = By.linkText(tag);
        click(tagLink);
    }

    public void clickUpdateTag(){
        click(updateTagButton);
    }

    public String returnNameTag(){
        return getText(nameTagText);
    }

    public String returnDescriptionTag(){
        return getText(descriptionTagText);
    }

    public void clickDeleteTag(){
        click(deleteTagButton);
    }

    public boolean returnIfTagExists(String tag ){
        return returnIfElementExists(By.linkText(tag));
    }

}
