package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.GlobalParameters;
import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.BugReportPage;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.IssuePage;
import com.javaseleniumtemplate.pages.ViewIssuePage;
import com.javaseleniumtemplate.utils.DataDriven;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;



public class ReportIssueTests extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    BugReportPage bugReportPage;
    IssuePage issuePage;
    ViewIssuePage viewIssuePage;
    SoftAssert softAssert;





    @Test(dataProvider="dataIssuesCSVProvider", dataProviderClass = DataDriven.class)
    public void registerNewIssueDDT(String[] dataDriven)  {
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();
        softAssert = new SoftAssert();

        //Parameteres
        String resumo = dataDriven[0];
        String descricao = dataDriven[1];
        String severity = dataDriven[2];
        String priority = dataDriven[3];
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";

        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillResume(resumo);
        bugReportPage.fillDescription(descricao);
        bugReportPage.selectPriority(priority);
        bugReportPage.selectSeverity(severity);
        bugReportPage.clickInSubmitReport();
        bugReportPage.clickInViewIssue();

        //Assertions
        softAssert.assertEquals(resumo, issuePage.returnBugSummary());
        softAssert.assertEquals(descricao, issuePage.returnBugDescription());
        softAssert.assertEquals("Automação", issuePage.returnCategory());
        softAssert.assertEquals(priority, issuePage.returnPriority());
        softAssert.assertEquals(severity, issuePage.returnSeverity());
        softAssert.assertAll();


    }
    //Tests
    @Test
    public void registerNewIssueSucessfully(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";
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
        Assert.assertEquals(resumo, issuePage.returnBugSummary());
        Assert.assertEquals(descricao, issuePage.returnBugDescription());
        Assert.assertEquals("Automação", issuePage.returnCategory());

    }



    @Test
    public void checkSummaryFieldRequired(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";
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


    @Test
    public void registerNewIssueUrgentPriority(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";
        String resumo = "High priority issue";
        String descricao = "High-risk issue";
        String priority = "high";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillResume(resumo);
        bugReportPage.fillDescription(descricao);
        bugReportPage.selectPriority(priority);
        bugReportPage.clickInSubmitReport();
        bugReportPage.clickInViewIssue();

        //Assertions
        Assert.assertEquals(resumo, issuePage.returnBugSummary());
        Assert.assertEquals(descricao, issuePage.returnBugDescription());
        Assert.assertEquals(priority, issuePage.returnPriority());
        Assert.assertEquals("Automação", issuePage.returnCategory());

    }

    @Test
    public void registerNewIssueWithFileEvidence(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";
        String resumo = "Issue com arquivo upado";
        String descricao = "Descrição arquivo upado";
        String file = GlobalParameters.FILES_PATH + "error.png";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillResume(resumo);
        bugReportPage.fillDescription(descricao);
        bugReportPage.sendUploadFile(file);
        bugReportPage.clickInSubmitReport();
        bugReportPage.clickInViewIssue();

        //Assertions
        Assert.assertEquals(resumo, issuePage.returnBugSummary());
        Assert.assertEquals(descricao, issuePage.returnBugDescription());
        Assert.assertEquals("Automação", issuePage.returnCategory());
        Assert.assertTrue(issuePage.returnFileName().contains("error.png"));

    }

    @Test
    public void uploadEvidenceLargerThanMaxSize(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String project = "Automacao";
        String categoria = "[All Projects] Automacao";
        String resumo = "Issue com arquivo upado acima do tamanho maximo";
        String descricao = "Descrição arquivo upado acima do tamanho maximo";
        String file = GlobalParameters.FILES_PATH + "bigerror.png";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickReportIssue();
        bugReportPage.selectProject(project);
        bugReportPage.clickSelectProject();
        bugReportPage.selectCategory(categoria);
        bugReportPage.fillResume(resumo);
        bugReportPage.fillDescription(descricao);
        bugReportPage.sendUploadFile(file);

        //Assert
        Assert.assertTrue(bugReportPage.getTextAlert().contains("exceed the maximum allowed file size"));
    }

    @Test
    public void uploadEvidenceInExistingIssue(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();
        viewIssuePage = new ViewIssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String projectName = "Upar Evidencia";
        String file = GlobalParameters.FILES_PATH + "error.png";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUnassignedIssues();
        viewIssuePage.fillFilter(projectName);
        viewIssuePage.clickEdit();
        issuePage.clickUpdate();
        bugReportPage.sendUploadFile(file);
        bugReportPage.clickAddNote();

        //Assert
        Assert.assertTrue(issuePage.returnFileName().contains("error.png"));

    }

    @Test
    public void deleteAIssue(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();
        viewIssuePage = new ViewIssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String projectName = "Delete This Issue";

        //Test
        loginFlows.signIn(usuario, senha);
        mainPage.clickUnassignedIssues();
        viewIssuePage.fillFilter(projectName);
        viewIssuePage.clickFilter();
        viewIssuePage.clickEdit();
        issuePage.clickUpdate();
        bugReportPage.clickDelete();
        bugReportPage.clickDeleteIssues();

        //Assert
        Assert.assertFalse(issuePage.returnIfIssueExists(projectName));

    }

}
