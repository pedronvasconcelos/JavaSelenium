package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class ViewIssuePage extends PageBase {
    //Mapping
    By filterText = By.id("filter-search-txt");
    By editButton = By.xpath("//i[@title='Edit']");
    By filterButton = By.xpath("//input[@name='filter_submit']");
    //Actions

    public void fillFilter(String filter){
        sendKeys(filterText, filter);
    }

    public void clickEdit(){
        click(editButton);
    }

    public void clickFilter(){
        click(filterButton);
    }
}
