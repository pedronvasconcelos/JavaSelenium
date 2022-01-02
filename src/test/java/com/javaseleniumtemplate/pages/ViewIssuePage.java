package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuePage extends PageBase {
    //Mapping
    By filterText = By.id("filter-search-txt");
    By editButton = By.xpath("//i[@title='Edit']");
    //Actions

    public void fillFilter(String filter){
        sendKeys(filterText, filter);
    }

    public void clickEdit(){
        click(editButton);
    }


}
