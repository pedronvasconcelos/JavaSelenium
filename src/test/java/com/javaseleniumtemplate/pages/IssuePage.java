package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class IssuePage extends PageBase {
    //Mapping

    By bugSummary = By.xpath("//*[@class='bug-summary']");
    By bugDescription = By.xpath("//*[@class='bug-description']");

    //Actions

    public String retornaTextoBugSummary(){
      String fullText =  getText(bugSummary);
      String summaryText = fullText.substring(9);
      return summaryText;
    }

    public String retornaTextoBugDescription(){
        return getText(bugDescription);
    }

}
