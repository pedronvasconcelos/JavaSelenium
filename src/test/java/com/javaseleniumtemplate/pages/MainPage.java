package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//*[@class='user-info']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");
    By manageLink = By.xpath("//a[@href='/manage_overview_page.php']");

    //Actions
    public String retornaUsernameDasInformacoesDeLogin(){
        return getText(usernameLoginInfoTextArea);
    }

    public void clickReportIssue(){
        click(reportIssueLink);
    }

    public void clickManage(){
        click((manageLink));
    }
}
