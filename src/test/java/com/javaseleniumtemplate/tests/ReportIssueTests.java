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
        String resumo = "Resumo teste automático";
        String descricao = "Descrição teste automático";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        mainPage.clicarEmReportIssue();
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmSubmitReport();
        bugReportPage.clicarEmViewIssue();

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
        String descricao = "Descrição teste automático";
        String endPoint = "bug_report_page.php";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        mainPage.clicarEmReportIssue();
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.clicarEmSubmitReport();


        //Assertions

      Assert.assertTrue(bugReportPage.retornarURL().contains(endPoint));

    }

    @Test
    public void cadastrarNovaIssueComSucessoRealizandoUploadDeEvidencia(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();
        issuePage = new IssuePage();

        //Parameteres
        String usuario = "administrator";
        String senha = "adm";
        String resumo = "Teste com upload de arquivo";
        String descricao = "Teste com upload de arquivo";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        mainPage.clicarEmReportIssue();
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.inserirAnexo("./images/bug.jpg");
        bugReportPage.clicarEmSubmitReport();
        bugReportPage.clicarEmViewIssue();

        //Assertions

        Assert.assertEquals(resumo, issuePage.retornaTextoBugSummary());
        Assert.assertEquals(descricao, issuePage.retornaTextoBugDescription());

    }
}

