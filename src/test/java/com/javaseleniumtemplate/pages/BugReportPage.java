package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;




public class BugReportPage extends PageBase {

    //Mapping
    By categoryComboBox = By.id("category_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By uploadFileField = By.xpath("//i[@class='fa fa-cloud-upload upload-icon ace-icon blue fa-3x']");
    By submitButton = By.xpath("//input[@type='submit']");
    By viewIssueButton = By.xpath("//*[contains(text(),'View Submitted')]");

    //Actions


    public void preencherResumo(String resumo){
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao){
        sendKeys(descriptionField, descricao);
    }

    public  void alternarFrame(By locator){
        frameIn(locator);
    }
    public void inserirAnexo(String path){

        WebElement element = driver.findElement(uploadFileField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.display='block';", element);
        sendKeys(uploadFileField, path);

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
