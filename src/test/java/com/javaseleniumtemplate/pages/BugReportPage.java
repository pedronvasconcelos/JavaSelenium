package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BugReportPage extends PageBase {
    //Mapping
    By categoryComboBox = By.id("category_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By uploadFileField = By.id("ufile[]");
    By submitButton = By.xpath("//input[@type='submit']");
    By viewIssueButton = By.xpath("//*[contains(text(),'View Submitted')]");

    //Actions


    public void preencherResumo(String resumo){
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao){
        sendKeys(descriptionField, descricao);
    }

    public void inserirAnexo(String caminhoArquivo){
        sendKeysWithoutWaitVisible(uploadFileField, caminhoArquivo);
    }

    public void clicarEmSubmitReport(){
        click(submitButton);
    }

    public void clicarEmViewIssue(){
        click(viewIssueButton);
    }



    public String retornarURL(){

        String url = driver.getCurrentUrl();
        return url;
    }
}
