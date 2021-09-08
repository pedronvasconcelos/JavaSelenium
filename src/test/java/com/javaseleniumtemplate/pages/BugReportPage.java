package com.javaseleniumtemplate.pages;

import com.javaseleniumtemplate.bases.PageBase;
import org.openqa.selenium.By;

public class BugReportPage extends PageBase {
    //Mapping
    By categoryComboBox = By.name("category_id");
    By summaryField = By.name("summary");
    By descriptionField = By.name("description");
    By uploadFileField = By.id("ufile[]");
    By submitButton = By.xpath("//input[@type='submit']");

    //Actions
    public void selecionarCategoria(String categoria){
        comboBoxSelectByVisibleText(categoryComboBox, categoria);
    }

    public void preencherResumo(String resumo){
        sendKeys(summaryField, resumo);
    }

    public void preencherDescricao(String descricao){
        sendKeys(descriptionField, descricao);
    }

    public void InserirAnexo(String caminhoArquivo){
        sendKeysWithoutWaitVisible(uploadFileField, caminhoArquivo);
    }

    public void ClicarEmSubmitReport(){
        click(submitButton);
    }
}
