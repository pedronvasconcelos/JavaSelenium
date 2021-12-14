package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.BugReportPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.IssuePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class ReportIssueTests extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    BugReportPage bugReportPage;
    IssuePage issuePage;
    SoftAssert softAssert = new SoftAssert();

    //Tests
    @Test
    public void cadastrarNovaIssueComSucessoInformandoSomenteCamposObrigatorios(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automação";
        String categoria = "[All Projects] Automação";
        String resumo = "Resumo teste automático";
        String descricao = "Descrição teste automático";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillResume(resumo);
        bugReportPage.fillDescription(descricao);
        bugReportPage.clickInSubmitReport();
        bugReportPage.clickInViewIssue();

        //Assertions
        Assert.assertEquals(resumo, issuePage.retornaTextoBugSummary());
        Assert.assertEquals(descricao, issuePage.retornaTextoBugDescription());

    }

    @Test
    public void cadastrarNovaIssueSemSucessoSemInformarTodosCamposObrigatorios(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automação";
        String categoria = "[All Projects] Automação";
        String descricao = "Descrição teste automático";
        String alertMessage = "Please fill out this field.";


        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillDescription(descricao);
        bugReportPage.clickInSubmitReport();

        //Assertions
        Assert.assertEquals(bugReportPage.alertSummaryText(), alertMessage);
    }


}
