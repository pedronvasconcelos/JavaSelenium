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
    By uploadFileField = By.xpath("//div[@class='dropzone center dz-clickable']");
    By submitButton = By.xpath("//input[@type='submit']");
    By viewIssueButton = By.xpath("//*[contains(text(),'View Submitted')]");
    By selectProjectButton = By.xpath("//*[@class='btn btn-primary btn-white btn-round']");
    By selectProjectCombobox = By.id("select-project-id");
    By severityCombobox = By.id("severity");
    By priorityCombobox = By.id("priority");
    By addNoteButton = By.xpath("//input[@value='Add Note']");
    By deleteButton = By.xpath("//input[@value='Delete']");
    By deleteIssuesButton = By.xpath("//input[@value='Delete Issues']");


    //Actions
    public void fillResume(String resumo){
        sendKeys(summaryField, resumo);
    }

    public void fillDescription(String descricao){
        sendKeys(descriptionField, descricao);
    }

    public void selectCategory(String category){
        comboBoxSelectByVisibleText(categoryComboBox, category);
    }

    public void clickInSubmitReport(){
        click(submitButton);
    }

    public String alertSummaryText(){
        return returnAlertRequired(summaryField);
    }

    public void clickInViewIssue(){
        click(viewIssueButton);
    }

    public void clickSelectProject(){
        click(selectProjectButton);
    }

    public void selectProject(String project){
        comboBoxSelectByVisibleText(selectProjectCombobox, project);
    }

    public void selectPriority(String priority){
        comboBoxSelectByVisibleText(priorityCombobox, priority);
    }

    public void selectSeverity(String severity){
        comboBoxSelectByVisibleText(severityCombobox, severity);
    }

    public void sendUploadFile(String file){
        uploadFileJavaScript(uploadFileField, file);
    }

    public void clickAddNote(){
        click(addNoteButton);
    }

    public void clickDelete(){
        click(deleteButton);
    }

    public void clickDeleteIssues(){
        click(deleteIssuesButton);
    }
}
