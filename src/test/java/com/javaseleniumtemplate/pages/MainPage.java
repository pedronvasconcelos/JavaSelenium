package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class MainPage extends PageBase {
    //Mapping
    By usernameLoginInfoTextArea = By.xpath("//*[@class='user-info']");
    By reportIssueLink = By.xpath("//a[@href='/bug_report_page.php']");
    By manageLink = By.xpath("//a[@href='/manage_overview_page.php']");
    By unassignedIssuesButton = By.xpath("//*[@id='unassigned']/div[1]/div[2]/div/a");
    By userDropdownButton = By.xpath("//span[@class='user-info']");
    By myAccountButton = By.xpath("//i[@class='fa fa-user ace-icon']");
    By logoutButton = By.xpath("//i[@class='fa fa-sign-out ace-icon']");

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

    public void clickUnassignedIssues(){
        click(unassignedIssuesButton);
    }

    public void clickUserDropdown(){
        click(userDropdownButton);
    }

    public void clickMyAccount(){
        click(myAccountButton);
    }

    public void clickLogout(){
        click(logoutButton);
    }

    public boolean returnIfReportExists(){
        return returnIfElementExists(reportIssueLink);
    }

    public boolean returnIfManageExists(){
        return returnIfElementExists(manageLink);
    }
}
