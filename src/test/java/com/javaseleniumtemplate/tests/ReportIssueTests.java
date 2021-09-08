package com.javaseleniumtemplate.tests;

import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.BugReportPage;
import com.javaseleniumtemplate.pages.MainPage;
import org.testng.annotations.Test;

public class ReportIssueTests extends TestBase {
    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    BugReportPage bugReportPage;

    //Tests
    @Test
    public void cadastrarNovaIssueComSucessoInformandoSomenteCamposObrigatorios(){
        //Objects instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        bugReportPage = new BugReportPage();

        //Parameteres
        String usuario = "templateautomacao";
        String senha = "123456";
        String categoria = "[All Projects] Teste";
        String resumo = "Resumo teste automático ";
        String descricao = "Descrição teste automático";

        //Test
        loginFlows.efetuarLogin(usuario, senha);
        mainPage.clicarEmReportIssue();
        bugReportPage.selecionarCategoria(categoria);
        bugReportPage.preencherResumo(resumo);
        bugReportPage.preencherDescricao(descricao);
        bugReportPage.ClicarEmSubmitReport();
    }
}
