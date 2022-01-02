package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class IssuePage extends PageBase {
    //Mapping

    By bugSummary = By.xpath("//*[@class='bug-summary']");
    By bugDescription = By.xpath("//*[@class='bug-description']");
    By fileNameText = By.xpath("//td[contains(text(),'File Added')]");
    By createdTag = By.xpath("//a[contains(text(),'replace')]");
    By priorityText = By.xpath("//td[@class='bug-priority']");
    By categoryText = By.xpath("//td[@class='bug-category']");
    By updateButton = By.xpath("//input[@value='Update Information']");

    //Actions

    public String returnBugSummary(){
      String fullText =  getText(bugSummary);
      String summaryText = fullText.substring(9);
      return summaryText;
    }

    public String returnFileName(){
        return getText(fileNameText);
    }

    public String returnBugDescription(){
        return getText(bugDescription);
    }

    public String returnPriority(){
        return getText(priorityText);
    }

    public String returnCategory(){
        return getText(categoryText);
    }

    public void clickUpdate(){
        click(updateButton);
    }



}
